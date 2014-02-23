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
    (is (= '("1" "+" "1" "=" "2") (%w 1 + 1 = 2))))
  (testing "nil"
    (is (= '("nil") (%w nil))))
  (testing "nested parentheses"
    (is (= '("(here are parentheses)") (%w (here are parentheses))))))

(deftest percent-q-test
  (testing "empty list"
    (is (= "" (%q))))
  (testing "one arg"
    (is (= "foo" (%q foo))))
  (testing "multiple args"
    (is (= "a b c" (%q a b c))))
  (testing "non-letters"
    (is (= "1 + 1 = 2" (%q 1 + 1 = 2)))))

(deftest percent-r-test
  (testing "empty list"
    (is (= "" (str (%r)))))
  (testing "one arg"
    (is (= "fo+" (str (%r fo+)))))
  (testing "multiple args"
    (is (= "a? b+ ?" (str (%r a? b+ ?)))))
  (testing "nested parentheses"
    (is (= "(?:xo)" (str (%r (?:xo)))))))

(deftest percent-i-test
  (testing "empty list"
    (is (= '() (%i))))
  (testing "one arg"
    (is (= '(:foo) (%i foo))))
  (testing "multiple args"
    (is (= '(:a :b :c) (%i a b c))))
  (testing "non-letters"
    (is (= '(:1 :+ :1 := :2) (%i 1 + 1 = 2)))))
