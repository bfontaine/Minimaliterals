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

;; FIXME: we need a way to compare two regexps, see:
;;   http://stackoverflow.com/q/21894371/735926
(deftest percent-r-test
  (testing "empty list"
    (is (= "" (str (%r)))))
  (testing "one arg"
    (is (= "fo+" (str (%r fo+)))))
  (testing "multiple args"
    (is (= "a? b+ ?" (str (%r a? b+ ?))))))

(deftest percent-i-test
  (testing "empty list"
    (is (= '() (%i))))
  (testing "one arg"
    (is (= '(:foo) (%i foo))))
  (testing "multiple args"
    (is (= '(:a :b :c) (%i a b c))))
  (testing "non-letters"
    (is (= '(:1 :+ :1 := :2) (%i 1 + 1 = 2)))))
