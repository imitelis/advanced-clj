(ns advanced-clj.functions)

(def add (fn [x y] (+ x y)))
(add 2 3)  ;; => 5

(def add #(+ %1 %2))
(add 2 3)  ;; => 5

(def add-five (partial + 5))
(add-five 10)  ;; => 15

(defn apply-fn [f x]
  (f x))

(apply-fn inc 5)  ;; => 6

(map inc [1 2 3])        ;; => (2 3 4)
(filter even? [1 2 3 4]) ;; => (2 4)
(reduce + [1 2 3 4])    ;; => 10

(def double (comp #(* 2 %) inc))
(double 5)  ;; => 12

(apply + [1 2 3 4])  ;; => 10

(defmulti my-fn class)

(defmethod my-fn String [s] (str "String: " s))
(defmethod my-fn Number [n] (* n 2))

(my-fn "Hello")  ;; => "String: Hello"
(my-fn 10)       ;; => 20

(def fib (memoize (fn [n]
                    (if (<= n 1)
                      n
                      (+ (fib (dec n)) (fib (- n 2)))))))

(fib 10)  ;; => 55

(defn print-person [{:keys [name age]}]
  (println "Name:" name ", Age:" age))

(print-person {:name "Alice" :age 30})  ;; => Name: Alice , Age: 30

(defn greet [name]
  (str "Hello, " name "!"))

(greet "Bob")  ;; => "Hello, Bob!"

(defn area [length width]
  (let [area (* length width)]
    (str "Area: " area)))

(area 5 3)  ;; => "Area: 15"
