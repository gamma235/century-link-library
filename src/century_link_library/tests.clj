(ns century-link-library.tests
  (:require [century-link-library.core :as core])
  (:use clojure.test))

;; stub data:
;;___________

;;should total 7200
(def sample-graph {:manager {:manager {:manager [:developer {:manager [:developer :developer :qa :qa]} :developer :qa :qa]}}})

;; should total 11,100
(def sample-graph-long [{:manager {:manager {:manager [:developer :developer :qa :qa]}}},
                        {:manager {:manager [:qa {:manager [:developer :developer :qa :qa]} :qa :qa]}},
                        {:manager [:developer :qa]}])

;; begin tests
;;____________

(deftest single-manager-total
  (is (= 7200 (core/total-for-manager sample-graph))))

(deftest single-not-multiple-manager-total
  (is (try (core/total-for-manager sample-graph-long)
        (catch java.lang.AssertionError e true))))

(deftest multiple-manager-totals
  (is (= '(3900 5400 1800) (core/totals-for-managers sample-graph-long))))

(deftest multiple-not-single-manager-total
  (is (try (core/totals-for-managers sample-graph)
        (catch java.lang.AssertionError e true))))

(deftest multiple-managers-sum
  (is (= 11100 (core/sum-total-for-managers sample-graph-long))))

;; uncomment below expr and and evaluate to run tests
(run-tests)
