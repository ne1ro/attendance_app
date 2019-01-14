(ns attendance-app.api)

; TODO: get from config
(def host "http://10.0.2.2:3000/")

(defn- handle-response [resp success-handler]
  (->
   resp
   .json
   (.then (fn [data] (success-handler (js->clj data :keywordize-keys true))))))

(defn- api-get [url success-handler err-handler]
  (->
   host
   (str url)
   (js/fetch (clj->js {:method "GET" :headers {"Content-Type" "application/json"}}))
   (.then #(handle-response % success-handler))
   (.catch (fn [err] (-> err .-message err-handler)))))

(defn list-attendants [day success-handler err-handler]
  (-> "attendances/" (str day) (api-get success-handler err-handler)))
