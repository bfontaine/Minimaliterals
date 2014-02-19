(ns minimaliterals.core
  (:require [clojure.string :as cs]))

(defmacro %w
  "strings list litteral, e.g.: (%w a b c) => '(\"a\" \"b\" \"c\")"
  [& els]
  `(map str '~els))

(defmacro %q
  "string litteral, e.g.: (%q a b c) => \"a b c\""
  [& els]
  `(cs/join " " '~els))
