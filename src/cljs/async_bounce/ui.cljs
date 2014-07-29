(ns async-bounce.ui
  (:require [cljs.core.async :refer (chan put!)]
            [domina.events :refer (listen!)]
            [domina :as dom]))

(def canvas
  (dom/by-id "foreground"))

(def context
  (.getContext canvas "2d"))

(defn clear-canvas
  []
  (.save context)
  (.setTransform context 1 0 0 1 0 0)
  (.clearRect context 0 0 500 500)
  (.reastore context))

(defn draw-circle [obj]
  (let [{:keys [x y r c]} obj]
    (when-not (nil? obj)
      '())

(defn get-coords [evt]
  {:x (:clientX evt) 
   :y (:clientY evt)})

(defn click-chan
  []
  (let [ch (chan)]
    (listen! js/document
             :click
             #(put! ch (get-coords %)))
    ch))
