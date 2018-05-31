(ns org.apache.clojure-mxnet.lr-scheduler
  (:import (org.apache.mxnet FactorScheduler)))


(defn factor-scheduler
  "Assume the weight has been updated by n times, then the learning rate will
    be base_lr * factor^^(floor(n/step))
   - step int, schedule learning rate after n updates
   - factor number, the factor for reducing the learning rate"
  [step factor]
  (new FactorScheduler (int step) (float factor)))
