(ns century-link-library.core
  (:require [century-link-library.utils :as utils]))

(defn total-for-manager
  "Gives total cost for input"
  [manager-graph]
  {:pre [(map? manager-graph)]
   :post [(number? %)]}
  (->> manager-graph utils/walk utils/set-values utils/total-value))

(defn totals-for-managers
  "Returns list of total costs for multiple managers"
  [multiple-manager-graph]
  {:pre [(and (> (count multiple-manager-graph) 1) (every? map? multiple-manager-graph))]
   :post [(and (every? number? %) (seq? %))]}
  (map #(total-for-manager %) multiple-manager-graph))

(defn sum-total-for-managers
  "returns sum value for multiple managers"
  [multiple-manager-graph]
  {:pre [(and (> (count multiple-manager-graph) 1) (every? map? multiple-manager-graph))]
   :post [(number? %)]}
  (reduce + (totals-for-managers multiple-manager-graph)))
