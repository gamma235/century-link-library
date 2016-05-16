;; private helper functions for library
;; _____________________________

(ns century-link-library.utils
  (:require [clojure.walk :as walk]))

;; walk the tree and recursively flatten it
(defn walk [graph]
  (let [state (atom [])]
    (walk/postwalk #(when (keyword? %) (swap! state conj %)) graph)
    @state))

;; take a flattened tree and return a list of appropriate values
(defn set-values [employee-vector]
  (map #(cond (= % :manager)   300
              (= % :developer) 1000
              (= % :qa)        500) employee-vector))

;; reduce +
(defn total-value [value-vector]
  (reduce + value-vector))
