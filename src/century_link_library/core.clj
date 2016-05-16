;; forward facing library API
;; __________________________
(ns century-link-library.core
  (:require [century-link-library.utils :as utils]))

;; gives total cost for input
(defn total-for-manager [manager-graph]
  (->> manager-graph
       utils/walk
       utils/set-values
       utils/total-value))

;; returns vector of total costs for multiple managers
(defn totals-for-managers [multiple-manager-graph]
  (map #(total-for-manager %) multiple-manager-graph))

;; returns the sum of all costs for multiple managers
(defn sum-total-for-managers [multiple-manager-graph]
  (reduce + (totals-for-managers multiple-manager-graph)))
