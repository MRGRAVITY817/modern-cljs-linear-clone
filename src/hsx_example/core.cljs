(ns hsx-example.core
  (:require
   ["react-dom/client" :refer [createRoot]]
   [hsx-example.db :as db]
   [hsx-example.events]
   [hsx-example.subs]
   [hsx-example.views :as views]
   [io.factorhouse.hsx.core :as hsx]
   [io.factorhouse.rfx.core :as rfx]))

(defonce todo-context
  (rfx/init {:initial-value db/default-db}))

(defonce root
  (createRoot (.getElementById js/document "app")))

(defn init []
  (.render root
           (hsx/create-element
            [:> rfx/RfxContextProvider #js {"value" todo-context}
             [views/app]])))

