(ns org.apache.clojure-mxnet.initializer
  (:import (org.apache.mxnet Uniform Normal Xavier)))

(defn uniform
 "Initialize the weight with uniform [-scale, scale]
   scale - The scale of uniform distribution"
  ([scale]
   (new Uniform (float scale)))
  ([]
   (uniform 0.07)))

(defn normal
  "Initialize the weight with normal(0, sigma)
   sigma -  Standard deviation for gaussian distribution."
  ([sigma]
   (new Normal (float sigma)))
  ([]
   (normal 0.01)))

(defn xavier
  "Initialize the weight with Xavier or similar initialization scheme
  rand-type - 'gaussian' or 'uniform'
  factor-type - 'avg' 'in' or 'out'
  magnitude - scale of random number range "
  ([{:keys [rand-type factor-type magnitude :as opts]
      :or {rand-type "uniform"
           factor-type "avg"
           magnitude 3}}]
   (new Xavier rand-type factor-type (float magnitude)))
  ([]
   (xavier {})))

(defn apply [initializer name arr]
  (let [r (.apply initializer name arr)]
    arr))

(defn init-weight [initializer name arr]
  (doto initializer
    (.initWeight name arr)))
