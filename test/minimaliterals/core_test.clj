(ns minimaliterals.core-test
  (:require [clojure.test :refer :all]
            [minimaliterals.core :refer :all]))

(deftest percent-w-test
  (testing "empty list"
    (is (= '() (%w))))
  (testing "one arg"
    (is (= '("foo") (%w foo))))
  (testing "multiple args"
    (is (= '("a" "b" "c") (%w a b c))))
  (testing "non-letters"
    (is (= '("1" "+" "1" "=" "2") (%w 1 + 1 = 2)))))
