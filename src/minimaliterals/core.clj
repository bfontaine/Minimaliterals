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

(defmacro %r
  "regexp litteral, e.g.: (%r fo+ .*) => #\"fo+ .*\""
  [& els]
  `(re-pattern (cs/join " " '~els)))
