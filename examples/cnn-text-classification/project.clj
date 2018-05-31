(defproject cnn-text-classification "0.1.0-SNAPSHOT"
  :description "CNN text classification with MXNet"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.apache.clojure-mxnet/clojure-mxnet "0.1.0-SNAPSHOT"]]
  :main cnn-text-classification.classifier
  :pedantic? :skip)
