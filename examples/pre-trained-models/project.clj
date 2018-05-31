(defproject pre-trained-models "0.1.0-SNAPSHOT"
  :description "Example of using pre-trained models with MXNet"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.apache.clojure-mxnet/clojure-mxnet "0.1.0-SNAPSHOT"]
                 [net.mikera/imagez "0.12.0"]
                 [thinktopic/think.image "0.4.16"]]
  :main pre-trained-models.fine-tune)
