(ns org.apache.clojure-mxnet.profiler
  (:import (org.apache.mxnet Profiler))
  (:require [org.apache.clojure-mxnet.util :as util]))

(defn profiler-set-config
  " Set up the configure of profiler.
   -mode, optional Indicting whether to enable the profiler, can
    be symbolic or all. Default is symbolic.
   -fileName, optional The name of output trace file. Default is profile.json."
  [kwargs]
  (Profiler/profilerSetConfig
   (util/convert-io-map kwargs) ))

(defn profiler-set-state
  "Set up the profiler state to record operator.
   -state, optional
   - Indicting whether to run the profiler, can
     be stop or run. Default is stop."
  ([state]
   (Profiler/profilerSetState state))
  ([]
   (profiler-set-state false)))

(defn dump-profile
  " Dump profile and stop profiler. Use this to save profile
   in advance in case your program cannot exit normally."
  ([finished]
   (Profiler/dumpProfile (int finished)))
  ([]
   (dump-profile 1)))
