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

(deftest percent-q-test
  (testing "empty list"
    (is (= "" (%q))))
  (testing "one arg"
    (is (= "foo" (%q foo))))
  (testing "multiple args"
    (is (= "a b c" (%q a b c))))
  (testing "non-letters"
    (is (= "1 + 1 = 2" (%q 1 + 1 = 2)))))
