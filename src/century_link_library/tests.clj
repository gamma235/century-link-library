(ns century-link-library.tests
  (:require [century-link-library.core :as core])
  (:use clojure.test))

;; Unit Tests
(deftest single-manager-total
  (let [sample-graph {:manager {:manager {:manager
                        [:developer {:manager [:developer :developer :qa :qa]} :developer :qa :qa]}}}]
    (is (= 7200 (core/total-for-manager sample-graph)))))

(deftest single-not-multiple-manager-total
  (let [sample-graph-long [{:manager {:manager {:manager [:developer :developer :qa :qa]}}},
                           {:manager {:manager [:qa {:manager [:developer :developer :qa :qa]} :qa :qa]}},
                           {:manager [:developer :qa]}]]
    (is (try (core/total-for-manager sample-graph-long)
          (catch AssertionError e true)))))

(deftest multiple-manager-totals
  (let [sample-graph-long [{:manager {:manager {:manager [:developer :developer :qa :qa]}}},
                           {:manager {:manager [:qa {:manager [:developer :developer :qa :qa]} :qa :qa]}},
                           {:manager [:developer :qa]}]]
    (is (= '(3900 5400 1800) (core/totals-for-managers sample-graph-long)))))

(deftest multiple-not-single-manager-total
  (let [sample-graph {:manager {:manager {:manager
                        [:developer {:manager [:developer :developer :qa :qa]} :developer :qa :qa]}}}]
    (is (try (core/totals-for-managers sample-graph)
          (catch AssertionError e true)))))

(deftest multiple-managers-sum
  (let [sample-graph-long [{:manager {:manager {:manager [:developer :developer :qa :qa]}}},
                           {:manager {:manager [:qa {:manager [:developer :developer :qa :qa]} :qa :qa]}},
                           {:manager [:developer :qa]}]]
    (is (= 11100 (core/sum-total-for-managers sample-graph-long)))))

;; uncomment below expr and and evaluate to run tests
;;(run-tests)
