(ns hsx-example.views
  (:require ["react" :as react]
            [hsx-example.subs]
            [io.factorhouse.rfx.core :as rfx :refer [use-dispatch]]))

(defn todo-item [{:keys [todo]}]
  (let [{:keys [id text completed]} todo
        dispatch (use-dispatch)]
    [:div {:class "flex items-center gap-3 p-3 bg-white rounded-lg border border-gray-200 hover:shadow-sm transition-shadow"}
     [:input {:type "checkbox"
              :checked completed
              :onChange #(dispatch [:toggle-todo id])
              :class "w-4 h-4 text-primary-600 rounded"}]
     [:span {:class (if completed
                      "flex-1 text-gray-500 line-through"
                      "flex-1 text-gray-900")}
      text]
     [:button {:onClick #(dispatch [:delete-todo id])
               :class "text-red-500 hover:text-red-700 text-sm font-medium"}
      "Delete"]]))

(defn todo-input []
  (let [input-ref (react/useRef nil)
        dispatch (use-dispatch)]
    [:div {:class "mb-6"}
     [:div {:class "flex gap-2"}
      [:input {:ref input-ref
               :type "text"
               :placeholder "Add a new todo..."
               :class "input flex-1"
               :onKeyDown (fn [e]
                            (when (= (.-key e) "Enter")
                              (let [text (.-value (.-current input-ref))]
                                (when (not= text "")
                                  (dispatch [:add-todo text])
                                  (set! (.-value (.-current input-ref)) "")))))}]
      [:button {:class "btn btn-primary"
                :onClick (fn []
                           (let [text (.-value (.-current input-ref))]
                             (when (not= text "")
                               (dispatch [:add-todo text])
                               (set! (.-value (.-current input-ref)) ""))))}
       "Add Todo"]]]))

(defn filter-buttons []
  (let [current-filter (rfx/use-sub [:filter])
        dispatch (use-dispatch)]
    [:div {:class "flex gap-2 mb-6"}
     (for [filter [:all :active :completed]]
       [:button {:key (name filter)
                 :class (str "btn "
                             (if (= filter current-filter)
                               "btn-primary"
                               "btn-secondary"))
                 :onClick #(dispatch [:set-filter filter])}
        (case filter
          :all "All"
          :active "Active"
          :completed "Completed")])]))

(defn todo-list []
  (let [todos (rfx/use-sub [:visible-todos])]
    [:div {:class "space-y-2"}
     (if (empty? todos)
       [:div {:class "text-center py-8 text-gray-500"}
        "No todos to display"]
       (for [todo todos]
         ^{:key (:id todo)}
         [todo-item {:key (:id todo)
                     :todo todo}]))]))

(defn app []
  [:div {:class "min-h-screen bg-gray-50 py-8"}
   [:div {:class "max-w-2xl mx-auto px-4"}
    [:h1 {:class "text-3xl font-bold text-gray-900 mb-8 text-center"}
     "HSX Todo List"]
    [todo-input]
    [filter-buttons]
    [todo-list]]])
