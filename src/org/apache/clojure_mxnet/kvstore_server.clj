(ns org.apache.clojure-mxnet.kvstore-server
  (:require [clojure.spec.alpha :as spec]
            [org.apache.clojure-mxnet.util :as util]
            [clojure.spec.alpha :as s])
  (:import (org.apache.mxnet KVStoreServer)))


(s/def ::env-map (s/map-of string? string?))

(defn init [env-map]
  (util/validate! ::env-map env-map "Invalid environment map")
  (KVStoreServer/init (util/convert-map env-map)))


(s/def ::die-if-others-go-out-timeout int?)

(defn start
  ([die-if-others-go-out-timeout]
   (util/validate! ::die-if-others-go-out-timeout die-if-others-go-out-timeout "Invalid setting")
   (KVStoreServer/start die-if-others-go-out-timeout))
  ([]
   (start 0)))
