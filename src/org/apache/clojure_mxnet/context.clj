(ns org.apache.clojure-mxnet.context
  (:import (org.apache.mxnet Context)))


(defn cpu
  ([device-id]
   (new Context "cpu" device-id))
  ([]
   (cpu 0)))

(defn gpu
  ([device-id]
   (new Context "gpu" device-id))
  ([]
   (gpu 0)))

(defn cpu-context []
  (cpu))

(defn default-context [] (cpu-context))

(defn device-type [context]
  (.deviceType context))

(defn device-id [context]
  (.deviceId context))
