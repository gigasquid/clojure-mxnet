(ns org.apache.clojure-mxnet.random
  (:require [org.apache.clojure-mxnet.shape :as mx-shape])
  (:import (org.apache.mxnet Random)))

(defn uniform
  "Generate uniform distribution in [low, high) with shape.
    low: The lower bound of distribution.
    high: The upper bound of distribution.
    shape-vec: vector shape of the ndarray generated.
    opts-map {
      ctx: Context of output ndarray, will use default context if not specified.
      out: Output place holder}
    returns: The result ndarray with generated result./"
  ([low high shape-vec {:keys [ctx out] :as opts}]
   (Random/uniform (float low) (float high) (mx-shape/->shape shape-vec) ctx out))
  ([low high shape-vec]
   (uniform low high shape-vec {})))

(defn normal
    "Generate normal(Gaussian) distribution N(mean, stdvar^^2) with shape.
    loc: The standard deviation of the normal distribution
    scale: The upper bound of distribution.
    shape-vec: vector shape of the ndarray generated.
    opts-map {
      ctx: Context of output ndarray, will use default context if not specified.
      out: Output place holder}
    returns: The result ndarray with generated result./"
  ([loc scale shape-vec {:keys [ctx out] :as opts}]
   (Random/normal (float loc) (float scale) (mx-shape/->shape shape-vec) ctx out))
  ([loc scale shape-vec]
   (normal loc scale shape-vec {})))


(defn seed
  " Seed the random number generators in mxnet.
    This seed will affect behavior of functions in this module,
    as well as results from executors that contains Random number
    such as Dropout operators.

   seed-state: The random number seed to set to all devices.
   note: The random number generator of mxnet is by default device specific.
         This means if you set the same seed, the random number sequence
         generated from GPU0 can be different from CPU."
  [seed-state]
  (Random/seed (int seed-state)))
