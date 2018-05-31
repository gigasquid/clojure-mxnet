(ns org.apache.clojure-mxnet.shape
  (:require [t6.from-scala.core :refer [$] :as $])
  (:import (org.apache.mxnet Shape)))


(defn ->shape [v]
  (new Shape (apply $/immutable-list (map int v))))

(defn ->vec [shape-obj]
  (-> shape-obj
      .toArray
      vec))

(defn length [shape-obj]
  (.length shape-obj))

(defn product [shape]
  (.product shape))
