(defproject gan "0.1.0-SNAPSHOT"
  :description "GAN MNIST with MXNet"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.apache.clojure-mxnet/clojure-mxnet "0.1.1-SNAPSHOT"]
                 [nu.pattern/opencv "2.4.9-7"]]
  :main gan.gan-mnist)
