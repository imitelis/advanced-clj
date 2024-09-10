(ns advanced-clj.thread-macros
  (:require [clojure.string :as str]))

(-> x
    (f1)
    (f2)
    (f3))

(-> 5
    (+ 1)       ; Increment: 5 + 1 = 6
    (* 2)       ; Double: 6 * 2 = 12
    str)        ; Convert to string: "12"

(defn concat-with-prefix [prefix s]
  (str prefix s))

(-> "world"
    (concat-with-prefix "Hello, ")) ; "Hello, world"

(require '[clojure.string :as str])

(->> [1 2 3]
     (str/join ", ")) ; "1, 2, 3"

(->> (range 1 5)                      ; (1 2 3 4)
     (map #(* % 2))                   ; (2 4 6 8)
     (filter odd?)                    ; (3 5)
     (sort))                         ; (3 5)

(def data [{:name "Alice" :age 30}
           {:name "Bob" :age 25}
           {:name "Carol" :age 27}])

(->> data
     (map :age)
     (filter #(> % 26))
     (sort))
