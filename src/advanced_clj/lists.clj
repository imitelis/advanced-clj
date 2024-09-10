(ns advanced-clj.lists)

(def my-list '(1 2 3 4))

(def my-list (list 1 2 3 4 5))

(first my-list) ; => 1
(rest my-list)  ; => (2 3 4 5)
(nth my-list 2) ; => 3

(conj my-list 6) ; => (6 1 2 3 4 5)
(rest my-list) ; => (2 3 4 5)
(butlast my-list) ; => (1 2 3 4)
(last my-list) ; => 5
(reverse my-list) ; => (5 4 3 2 1)
(sort my-list) ; => (1 2 3 4 5) (if `my-list` is already sorted)
(map inc my-list) ; => (2 3 4 5 6)
(filter odd? my-list) ; => (1 3 5)
(reduce + my-list) ; => 15

(concat '(1 2) '(3 4)) ; => (1 2 3 4)
(apply concat '((1 2) (3 4) (5 6))) ; => (1 2 3 4 5 6)
(some even? my-list) ; => 2
(remove even? my-list) ; => (1 3 5)

(def numbers '(1 2 3 4 5))

(map #(* % 2) numbers) ; => (2 4 6 8 10)
(filter odd? numbers) ; => (1 3 5)
(reduce + numbers)    ; => 15

(apply + numbers) ; => 15

