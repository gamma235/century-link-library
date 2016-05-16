(ns century-link-library.utils
  (:require [clojure.walk :as walk]))

;; Walk the tree and recursively flatten it
;; Assertions added for type guarantees on input and output
(defn walk [graph]
  {:pre  [(coll? graph)]
   :post [(every? keyword? %)]}
  (let [state (atom [])]
    (walk/postwalk #(when (keyword? %) (swap! state conj %)) graph)
    @state))

;; Takes a flattened tree and return a list of appropriate values
(defn set-values [employee-vector]
  (map #(cond (= % :manager)   300
              (= % :developer) 1000
              (= % :qa)        500) employee-vector))

;; reduce +
(defn total-value [value-vector]
  (reduce + value-vector))
