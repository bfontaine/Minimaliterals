(ns minimaliterals.core)

(defmacro %w
  "strings list litteral, e.g.: (%w a b c) => '(\"a\" \"b\" \"c\")"
  [& els]
  `(map str '~els))
