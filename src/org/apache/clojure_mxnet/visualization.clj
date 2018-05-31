(ns org.apache.clojure-mxnet.visualization
  (:require [org.apache.clojure-mxnet.util :as util]
            [org.apache.clojure-mxnet.shape :as mx-shape])
  (:import (org.apache.mxnet Visualization)))



(defn plot-network
  "convert symbol to Dot object for visualization
   -  symbol symbol to be visualized
   -  title title of the dot graph
   -  shape-map Map of shapes, str -> shape, given input shapes
   - node-attrs Map of node's attributes
                  for example: {:shape \"oval\" :fixedsize \"false\"}

   - hide-weight      if true (default) then inputs with names like `*_weight`
                  or `*_bias` will be hidden
   returns Dot object of symbol"
  ([sym shape-map {:keys [title node-attrs hide-weights] :as opts
                   :or {title "plot"
                        hide-weights true}}]
   (Visualization/plotNetwork sym
                              title
                              (->> shape-map
                                   (map (fn [[k v]] [k (mx-shape/->shape v)]))
                                   (into {})
                                   (util/convert-map))
                              (util/convert-map node-attrs)
                              hide-weights))
  ([sym shape-map]
   (plot-network sym shape-map {})))


(defn render
  " Render file with Graphviz engine into format.
    - dot the dot file from plot-network function
    - engine The layout commmand used for rendering ('dot', 'neato', ...).
    - format The output format used for rendering ('pdf', 'png', ...).
    - filename Name of the DOT source file to render.
    -  path Path to save the Dot source file.
    "
  ([dot engine format filename path]
   (doto dot
     (.render engine format filename path)))
  ([dot filename path]
   (render dot "dot" "pdf" filename path)))
