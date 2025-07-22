(ns hsx-example.subs
  (:require [io.factorhouse.rfx.core :as rfx]))

(rfx/reg-sub
 :todos
 (fn [db _]
   (:todos db)))

(rfx/reg-sub
 :filter
 (fn [db _]
   (:filter db)))

(rfx/reg-sub
 :visible-todos
 (fn [{:keys [todos filter]} _]
   (case filter
     :active (filter #(not (:completed %)) todos)
     :completed (filter :completed todos)
     todos)))
