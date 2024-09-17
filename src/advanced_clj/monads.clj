(ns advanced-clj.monads
 (:require '[cats.monad.option :as opt]))

(defn double [x] (* 2 x))

;; Using Option monad
(def maybe-value (opt/just 5))
(def doubled (opt/map double maybe-value)) ; => (just 10)


(defn add [x y] (+ x y))

(def value1 (opt/just 5))
(def value2 (opt/just 10))

(def result (opt/ap (opt/just add) value1 value2)) ; => (just 15)


(defn safe-divide [x y]
  (if (zero? y)
    (opt/nothing)
    (opt/just (/ x y))))

(def result (opt/flat-map (safe-divide 10 2) #(opt/just (* % 2)))) ; => (just 10)


(defn safe-div [x y]
  (if (zero? y)
    (opt/nothing)
    (opt/just (/ x y))))

(println (safe-div 10 2)) ; => (just 5)
(println (safe-div 10 0)) ; => (nothing)


(defn parse-int [s]
  (try
    (opt/just (Integer. s))
    (catch NumberFormatException _ (opt/nothing))))

(defn safe-divide [x y]
  (if (zero? y)
    (opt/nothing)
    (opt/just (/ x y))))

(def result
  (opt/flat-map
   (parse-int "10")
   (fn [x]
     (opt/flat-map
      (parse-int "2")
      (fn [y]
        (safe-divide x y))))))

(println result) ; => (just 5)