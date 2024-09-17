(ns advanced-clj.lambdas)

(fn [x] (* x x)) ; This creates a lambda function that squares its input
(fn [a b] (+ a b)) ; This creates a lambda function that adds two numbers

(map (fn [x] (* x 2)) [1 2 3 4]) ; => (2 4 6 8)
(filter (fn [x] (even? x)) [1 2 3 4 5]) ; => (2 4)
(reduce (fn [acc x] (+ acc x)) 0 [1 2 3 4]) ; => 10

#(* % %) ; The `%` represents the single parameter
#(+ %1 %2) ; `%1` and `%2` represent the first and second parameters
(map #(* % 2) [1 2 3 4]) ; => (2 4 6 8)
(filter #(even? %) [1 2 3 4 5]) ; => (2 4)

#(+ %1 %2) ; `%1` and `%2` for the first and second parameters
(fn [x y] (+ x y)) ; A lambda function with two named parameters

(sort (fn [a b] (compare (second a) (second b))) [[:a 3] [:b 1] [:c 2]])
; => ([[:b 1] [:c 2] [:a 3]])
(map (fn [x] (str "Number: " x)) [1 2 3]) ; => ("Number: 1" "Number: 2" "Number: 3")
