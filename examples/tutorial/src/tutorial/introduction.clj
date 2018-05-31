(ns tutorial.introduction
  (:require [org.apache.clojure-mxnet.ndarray :as ndarray]))

;; MXNet supports the Clojure programming language. The MXNet Clojure package brings flexible and efficient GPU computing and state-of-art deep learning to Clojure. It enables you to write seamless tensor/matrix computation with multiple GPUs in Clojure. It also lets you construct and customize the state-of-art deep learning models in Clojure, and apply them to tasks, such as image classification and data science challenges.

;; You can perform tensor or matrix computation in pure Clojure:

(def arr (ndarray/ones [2 3]))

arr  ;=> #object[ml.dmlc.mxnet.NDArray 0x482401ab "ml.dmlc.mxnet.NDArray@d8902656"]

(ndarray/shape-vec arr) ;=>  [2 3]

(-> (ndarray/* arr 2)
    (ndarray/->vec)) ;=> [2.0 2.0 2.0 2.0 2.0 2.0]

(ndarray/shape-vec (ndarray/* arr 2)) ;=> [2 3]
