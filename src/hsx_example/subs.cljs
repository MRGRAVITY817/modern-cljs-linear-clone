(ns hsx-example.subs
  (:require [io.factorhouse.rfx.core :as rfx]))

(rfx/reg-sub
 :todos
 (fn [db _]
   (:todos db)))

(rfx/reg-sub
 :todo-filter
 (fn [db _]
   (:todo-filter db)))

(rfx/reg-sub
 :visible-todos
 (fn [{:keys [todos todo-filter] :as db} _]
   (case todo-filter
     :active (filter #(not (:completed %)) todos)
     :completed (filter :completed todos)
     todos)))
