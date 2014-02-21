# minimaliterals

[![Build Status](https://travis-ci.org/bfontaine/Minimaliterals.png)](https://travis-ci.org/bfontaine/Minimaliterals)
[![Coverage Status](https://coveralls.io/repos/bfontaine/Minimaliterals/badge.png)](https://coveralls.io/r/bfontaine/Minimaliterals)

**minimaliterals** is an experimental library which brings Ruby-like
[%-literals][1] to Clojure. This is only for fun with macros, use it at your
own risk!

[1]: https://en.wikibooks.org/wiki/Ruby_Programming/Syntax/Literals#The_.25_Notation

The table below summarizes the syntax:

| Ruby          | Clojure        | Result           |
|---------------|----------------|------------------|
| `%w[foo bar]` | `(%w foo bar)` | `'("foo" "bar")` |
| `%q[foo bar]` | `(%q foo bar)` | `"foo bar"`      |
| `%r[fo+ ?]`   | `(%r fo+ ?)`   | `#"fo+ ?"`       |
| `%i[foo bar]` | `(%i foo bar)` | `'(:foo :bar)`   |

Due to the use of `%`, using these macros in short-form anonymous functions
won’t work (e.g. `#(identity (%w a b c))` will throw an error at compile-time).

## Usage

Add it as a dependency:

```clj
[minimaliterals "0.1.0"]
```

Then use it:

```clj
(ns your-namespace
  ; ...
  (:use minimaliterals.core))

; ...

(def names (%w henry james jayne))
```

## Caveats

No interpolation is done, this means that the following code:

```clj
(let [x "yo"]
  (%w x y z))
```

would give `'("x" "y" "z")` and not `'("yo" "y" "z")`.

## License

Copyright © 2014 Baptiste Fontaine

Distributed under the Eclipse Public License either version 1.0 or any later
version.
