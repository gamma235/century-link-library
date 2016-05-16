(ns century-link-library.utils)

;; Uses tail call recursion to walk and flatten tree, so JVM will blow stack on deeply nested inputs
(defn walk [x]
  {:pre [(or (coll? x) (keyword? x))]
   :post [(every? keyword? %)]}
  (if (coll? x) (mapcat walk x) [x]))

;; Takes a flattened tree and return a list of appropriate values
(defn set-values [employee-vector]
  (map #(cond (= % :manager)   300
              (= % :developer) 1000
              (= % :qa)        500) employee-vector))

;; reduce +
(defn total-value [value-vector]
  (reduce + value-vector))
