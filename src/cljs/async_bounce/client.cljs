(ns async-bounce.client)

(defn ^:export init
  []
  (.write js/document "Hello, world!"))
