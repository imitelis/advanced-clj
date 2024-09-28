(ns advanced-clj.recursions)

(defn factorial [n]
  (if (<= n 1)
    1
    (* n (factorial (dec n)))))

(factorial 5)  ;; => 120

(defn tail-rec-factorial [n]
  (let [fact-helper (fn [n acc]
                      (if (<= n 1)
                        acc
                        (recur (dec n) (* n acc))))]
    (fact-helper n 1)))

(tail-rec-factorial 5)  ;; => 120

(defn sum [coll]
  (let [sum-helper (fn [coll acc]
                     (if (empty? coll)
                       acc
                       (recur (rest coll) (+ acc (first coll)))))]
    (sum-helper coll 0)))

(sum [1 2 3 4 5])  ;; => 15

(defn sum-nested [nested]
  (if (number? nested)
    nested
    (reduce + (map sum-nested nested))))

(sum-nested [1 [2 3] [4 [5 6]]])  ;; => 21

(defn my-filter [pred coll]
  (if (empty? coll)
    []
    (if (pred (first coll))
      (cons (first coll) (my-filter pred (rest coll)))
      (my-filter pred (rest coll)))))

(my-filter odd? [1 2 3 4 5])  ;; => (1 3 5)

(defn tail-rec-fib [n]
  (let [fib-helper (fn [n a b]
                     (if (zero? n)
                       a
                       (recur (dec n) b (+ a b))))]
    (fib-helper n 0 1)))

(tail-rec-fib 10)  ;; => 55

(defn iterative-fib [n]
  (loop [a 0 b 1 count n]
    (if (zero? count)
      a
      (recur b (+ a b) (dec count)))))

(iterative-fib 10)  ;; => 55
