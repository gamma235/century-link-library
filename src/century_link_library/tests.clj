(ns century-link-library.tests
  (:require [century-link-library.core :as core])
  (:use clojure.test))

;; defining stub data: should total 3900
(def sample-graph {:manager {:manager {:manager [:developer :developer :qa :qa]}}})

;; should total 7800
(def sample-graph-long [{:manager {:manager {:manager [:developer :developer :qa :qa]}}},
                        {:manager {:manager [:qa :qa :qa]}},
                        {:manager [:developer :qa]}])

;; begin tests
(deftest single-manager-total
  (is (= 3900 (core/total-for-manager sample-graph))))

(deftest multiple-manager-totals
  (is (= '(3900 2100 1800) (core/totals-for-managers sample-graph-long))))

(deftest multiple-managers-sum
  (is (= 7800 (core/sum-total-for-managers sample-graph-long))))

(run-tests)
