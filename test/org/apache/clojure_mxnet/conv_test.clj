(ns org.apache.clojure-mxnet.conv-test
  (:require [clojure.java.io :as io]
            [clojure.java.shell :refer [sh]]
            [clojure.test :refer :all]
            [org.apache.clojure-mxnet.eval-metric :as eval-metric]
            [org.apache.clojure-mxnet.io :as mx-io]
            [org.apache.clojure-mxnet.module :as m]
            [org.apache.clojure-mxnet.optimizer :as optimizer]
            [org.apache.clojure-mxnet.symbol :as sym]
            [clojure.reflect :as r]))

(def data-dir "data/")
(def batch-size 100)
(def num-epoch 1)

(when-not (.exists (io/file (str data-dir "train-images-idx3-ubyte")))
  (sh "./scripts/get_mnist_data.sh"))

;;; Load the MNIST datasets
(def train-data (mx-io/mnist-iter {:image (str data-dir "train-images-idx3-ubyte")
                                   :label (str data-dir "train-labels-idx1-ubyte")
                                   :label-name "softmax_label"
                                   :data-shape [1 28 28]
                                   :label-shape [1 1 10]
                                   :batch-size batch-size
                                   :shuffle true
                                   :flat false
                                   :silent false
                                   :seed 10}))

(def test-data (mx-io/mnist-iter {:image (str data-dir "t10k-images-idx3-ubyte")
                                  :label (str data-dir "t10k-labels-idx1-ubyte")
                                  :data-shape [1 28 28]
                                  :batch-size batch-size
                                  :flat false
                                  :silent false}))
(defn get-symbol []
  (as-> (sym/variable "data") data

    (sym/convolution "conv1" {:data data :kernel [3 3] :num-filter 32 :stride [2 2]})
    (sym/batch-norm "bn1" {:data data})
    (sym/activation "relu1" {:data data :act-type "relu"})
    (sym/pooling "mp1" {:data data :kernel [2 2] :pool-type "max" :stride [2 2]}) (sym/convolution "conv2" {:data data :kernel [3 3] :num-filter 32 :stride [2 2]})
    (sym/batch-norm "bn2" {:data data})
    (sym/activation "relu2" {:data data :act-type "relu"})
    (sym/pooling "mp2" {:data data :kernel [2 2] :pool-type "max" :stride [2 2]})

    (sym/flatten "fl" {:data data})
    (sym/fully-connected "fc2" {:data data :num-hidden 10})
    (sym/softmax-output "softmax" {:data data})))

(deftest test-conv []
  (let [mod (m/module (get-symbol))]
    ;;; note only one function for training
    (m/fit mod {:train-data train-data :eval-data test-data :num-epoch num-epoch
                :fit-params (m/fit-params {:optimizer (optimizer/sgd {:learning-rate 0.1
                                                                      :momentum 0.9
                                                                      :wd 0.0001})})})

    ;;high level predict (just a dummy call but it returns a vector of results
    (m/predict mod {:eval-data test-data})

    ;;;high level score (returs the eval values)
    (let [score (m/score mod {:eval-data test-data :eval-metric (eval-metric/accuracy)})]
      (println "Score" score)
      (is (< 0.92 (last score))))))

(comment

  (require '[clojure.reflect :as r])
  (r/reflect train-data))
