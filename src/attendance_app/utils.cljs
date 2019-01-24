(ns attendance-app.utils
  (:require [cljs-time.core :as time]
            [cljs-time.format :as time-format]))

; TODO: make it co-effect
(defn current-day [fmt] (time-format/unparse (time-format/formatter fmt) (time/now)))

(defn ->clj [js-obj] (js->clj js-obj :keywordize-keys true))
