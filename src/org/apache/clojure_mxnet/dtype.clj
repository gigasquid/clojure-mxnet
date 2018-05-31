(ns org.apache.clojure-mxnet.dtype
  (:import (org.apache.mxnet DType)))


(def UINT8 (DType/UInt8))
(def INT32 (DType/Int32))
(def FLOAT16 (DType/Float16))
(def FLOAT32 (DType/Float32))
(def FLOAT64 (DType/Float64))

