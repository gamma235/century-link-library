;; forward facing library API
;; __________________________
(ns century-link-library.core
  (:require [century-link-library.utils :as utils]))

;; gives total cost for a manager and his workers
(defn total-for-manager [employee-graph]
  (->> employee-graph
       utils/get-underlings
       utils/set-values
       utils/total-value))

;; returns vector of total costs for multiple managers
(defn totals-for-managers [multiple-manager-graph]
  (map total-for-manager multiple-manager-graph))

;; returns the sum of all costs for multiple managers
(defn sum-total-for-managers [multiple-manager-graph]
  (reduce + (totals-for-managers multiple-manager-graph)))
