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
  `(re-pattern (%q ~@els)))

(defmacro %i
  "keywords list litteral, e.g.: (%i foo bar qux) => '(:foo :bar :qux)"
  [& els]
  ;; we need to first transform to string because (keyword '1) is nil
  `(map keyword (%w ~@els)))
