(defproject neural-style "0.1.0-SNAPSHOT"
  :description "Neural Style Transfer with MXNet"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.apache.clojure-mxnet/clojure-mxnet "0.1.1-SNAPSHOT"]
                 [net.mikera/imagez "0.12.0"]
                 [thinktopic/think.image "0.4.16"]]
  :main neural-style.core
)
