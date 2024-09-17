(ns advanced-clj.sets 
  (:require [clojure.set :as set]))

(def my-set #{1 2 3 4})

(def my-set (hash-set 1 2 3 4 5))

(conj my-set 5)       ; => #{1 2 3 4 5}
(disj my-set 2)       ; => #{1 3 4}

(contains? my-set 3) ; => true
(contains? my-set 5) ; => false

(contains? #{1 2 3} 2) ; => true
(contains? #{1 2 3} 4) ; => false

(count #{1 2 3 4}) ; => 4

(empty? #{}) ; => true
(empty? #{1 2}) ; => false

(set/union #{1 2 3} #{3 4 5}) ; => #{1 2 3 4 5}
(set/intersection #{1 2 3} #{2 3 4}) ; => #{2 3}
(set/difference #{1 2 3} #{2 3 4}) ; => #{1}

(set/subset? #{1 2} #{1 2 3}) ; => true
(set/subset? #{1 2 4} #{1 2 3}) ; => false

(set/superset? #{1 2 3} #{1 2}) ; => true
(set/superset? #{1 2 3} #{1 2 4}) ; => false

(map inc #{1 2 3}) ; => (2 3 4)
(filter odd? #{1 2 3 4 5}) ; => (1 3 5)
(set (for [x (range 5) :when (even? x)] x)) ; => #{0 2 4}

(set [1 2 2 3 4 4 4]) ; => #{1 2 3 4}
(set/intersection (set [1 2 3]) (set [2 3 4])) ; => #{2 3}