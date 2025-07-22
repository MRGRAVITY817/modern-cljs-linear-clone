(ns hsx-example.events
  (:require [io.factorhouse.rfx.core :as rfx]
            [hsx-example.db :as db]))

(rfx/reg-event-db
 :initialize-db
 (fn [_ _]
   db/default-db))

(rfx/reg-event-db
 :add-todo
 (fn [db [_ text]]
   (-> db
       (update :todos conj {:id (:next-id db)
                            :text text
                            :completed false})
       (update :next-id inc))))

(rfx/reg-event-db
 :toggle-todo
 (fn [db [_ id]]
   (update db :todos
           (fn [todos]
             (mapv #(if (= (:id %) id)
                      (update % :completed not)
                      %)
                   todos)))))

(rfx/reg-event-db
 :delete-todo
 (fn [db [_ id]]
   (update db :todos
           (fn [todos]
             (filterv #(not= (:id %) id) todos)))))

(rfx/reg-event-db
 :set-filter
 (fn [db [_ filter]]
   (assoc db :filter filter)))
