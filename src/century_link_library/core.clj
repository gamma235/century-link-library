(ns century-link-library.core
  (:require [century-link-library.utils :as utils]))

(defn total-for-manager [manager-graph]
  "Gives total cost for input"
  (->> manager-graph
       utils/walk
       utils/set-values
       utils/total-value))

(defn totals-for-managers [multiple-manager-graph]
  "Returns list of total costs for multiple managers"
  (map #(total-for-manager %) multiple-manager-graph))

(defn sum-total-for-managers [multiple-manager-graph]
  "Same as calling total-for-manager, but more readable when applied to graph of multiple managers"
  (total-for-manager multiple-manager-graph))
