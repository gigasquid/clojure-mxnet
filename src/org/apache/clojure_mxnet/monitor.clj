(ns org.apache.clojure-mxnet.monitor
  (:require [org.apache.clojure-mxnet.util :as util])
  (:import (org.apache.mxnet Monitor)))


(defmacro monitor
  "Monitor outputs, weights, and gradients for debugging.
  -  interval Number of batches between printing.
  -  stat-func A function that computes statistics of tensors.
                   Takes a NDArray and returns a NDArray. defaults
                   to mean absolute value |x|/size(x). Function must be in the form of clojure (fn [x])"
  [interval stat-fun]
  `(new Monitor (int ~interval) (util/scala-fn ~stat-fun)))

(defn tic
  "Start collecting stats for current batch.
   Call before forward"
  [monitor]
  (doto monitor
    (.tic)))

(defn toc
  "End collecting for current batch and return results.
   Call after computation of current batch."
  [monitor]
  (map util/tuple->vec (util/scala-vector->vec (.toVector (.toc monitor)))))
