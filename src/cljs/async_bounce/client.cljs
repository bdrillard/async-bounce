(ns async-bounce.client
  (:require [async-bounce.ui :as ui]
            [cljs.core.async :refer (<!)])
  (:require-macros [cljs.core.async.macros :refer (go-loop)]))

(defn ^:export init
  []
  (let [input (ui/click-chan)]
    (go-loop [ev (<! input)]
             (.log js/console (str "Click at:" (:x ev) ", " (:y ev)))
             (ui/draw-circle {:x (:x ev) :y (:y ev) :r 10 :c "00ee00"})
             (recur (<! input)))))
