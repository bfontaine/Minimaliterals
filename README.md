# minimaliterals

**minimaliterals** is an experimental library which brings Ruby-like %-literals
to Clojure. This is only for fun with macros, use it at your own risk!

The array below summarizes the syntax:

| Ruby          | Clojure        | Result           |
|---------------|----------------|------------------|
| `%w[foo bar]` | `(%w foo bar)` | `'("foo" "bar")` |
| `%q[foo bar]` | `(%q foo bar)` | `"foo bar"`      |
| `%r[fo+]`     | `(%r fo+)`     | `#"fo+"`         |
| `%i[foo bar]` | `(%i foo bar)` | `'(:foo :bar)`   |

Due to the use of `%`, using these macros in short-form anonymous functions
won’t work.

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

Note: no interpolation is done, this means that the following code

```clj
(let [x "yo"]
  (%w x y z))
```

would give `'("x" "y" "z")` and not `'("yo" "y" "z")`.

## License

Copyright © 2014 Baptiste Fontaine

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
