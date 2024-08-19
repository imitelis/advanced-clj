(ns advanced-clj.vectors)

(def my-vector [1 2 3 4 5])

(def my-vector (vec '(1 2 3 4 5)))

(nth my-vector 2)    ;; => 3
(get my-vector 2)    ;; => 3

(def updated-vector (conj my-vector 6))
; updated-vector is now [1 2 3 4 5 6]

(def updated-vector (assoc my-vector 2 10))
; updated-vector is now [1 2 10 4 5]

(def smaller-vector (subvec my-vector 0 4))
; smaller-vector is now [1 2 3 4]

(def shorter-vector (pop my-vector))
; shorter-vector is now [1 2 3 4]

(count my-vector)  ; Returns 5

(def sliced-vector (subvec my-vector 1 4))
; sliced-vector is now [2 3 4]

(map inc my-vector)     ; Returns (2 3 4 5 6)
(filter odd? my-vector) ; Returns (1 3 5)
(reduce + my-vector)    ; Returns 15

(def nested-vector [[1 2 3] [4 5 6] [7 8 9]])
(get (get nested-vector 1) 2) ; Returns 6

(def vector-a [1 2 3])
(def vector-b [4 5 6])
(def concatenated-vector (into vector-a vector-b))
; concatenated-vector is now [1 2 3 4 5 6]

(vec '(1 2 3)) ; Returns [1 2 3]

(nth my-vector 3) ; Returns 4

(first my-vector)   ; Returns 1
(rest my-vector)    ; Returns (2 3 4 5)
(last my-vector)    ; Returns 5
(butlast my-vector) ; Returns [1 2 3 4]
