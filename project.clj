(defproject org.apache.clojure-mxnet/clojure-mxnet "0.1.1-SNAPSHOT"
  :description "Clojure package for MXNet"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [t6/from-scala "0.3.0"]
                 ;; Choose the right dependency for your system
                 [org.apache.mxnet/mxnet-full_2.11-osx-x86_64-cpu "1.2.0"]
                 ;[org.apache.mxnet/mxnet-full_2.11-linux-x86_64-cpu "1.2.0"]
                 ;[org.apache.mxnet/mxnet-full_2.11-linux-x86_64-gpu "1.2.0"]
                 [org.clojure/tools.logging "0.4.0"]
                 [org.apache.logging.log4j/log4j-core "2.8.1"]
                 [org.apache.logging.log4j/log4j-api "2.8.1"]
                 [org.slf4j/slf4j-log4j12 "1.7.25" :exclusions [org.slf4j/slf4j-api]]]
  :pedantic? :skip
  :plugins [[lein-codox "0.10.3" :exclusions [org.clojure/clojure]]]
  :codox {:namespaces [#"^org\.apache\.clojure-mxnet\.(?!gen).*"]}
  :aliases {"generate-code" ["run" "-m" "dev.generator"]})
