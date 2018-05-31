(ns org.apache.clojure-mxnet.callback
  (:import (org.apache.mxnet Callback$Speedometer)))


;;; used to track status during epoch

(defn speedometer
  ([batch-size frequent]
   (new Callback$Speedometer (int batch-size) (int frequent)))
  ([batch-size]
   (speedometer batch-size 50)))

(defn invoke [callback epoch nbatch metric]
  (doto callback
    (.invoke (int epoch) (int nbatch) metric)))
