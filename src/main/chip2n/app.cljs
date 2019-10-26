(ns chip2n.app
  (:require [reagent.core :as r]))

(defonce click-count (r/atom 0))

(defn stateful-component []
  [:div {:on-click #(swap! click-count inc)}
   "I have been clicked on " @click-count " times."])

(defn render-app []
  (r/render [stateful-component]
            (.getElementById js/document "root")))

(defn init []
  (println "Initialization complete.")
  (render-app))

(defn ^:dev/after-load start []
  (println "================ Loaded application =================")
  (render-app))

(defn ^:dev/before-load stop []
  (println "=============== Reloading application ==============="))
