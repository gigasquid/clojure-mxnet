(defproject imclassification "0.1.0-SNAPSHOT"
  :description "Clojure examples for image classification"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.apache.clojure-mxnet/clojure-mxnet "0.1.1-SNAPSHOT"]]
  :main imclassification.train-mnist
  :pedantic? :skip)
