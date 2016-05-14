;; private helper functions for library
;; _____________________________

(ns century-link-library.utils)

;; walk the tree for an individual manager, and recursively flatten it
(defn get-underlings [employee-graph]
  (loop [graph employee-graph
         underlings []]
    (if (== (count graph) 0) underlings
      (cond (= clojure.lang.PersistentVector (type (:manager graph)))
              (recur (dissoc graph :manager) (into (conj underlings :manager) (:manager graph)))
            (= clojure.lang.PersistentArrayMap (type (:manager graph)))
              (recur (:manager graph) (conj underlings :manager))))))

;; take a flattened tree and return a list of appropriate values
(defn set-values [employee-vector]
  (map #(cond (= % :manager)   300
              (= % :developer) 1000
              (= % :qa)        500) employee-vector))

;; reduce +
(defn total-value [value-vector]
  (reduce + value-vector))
