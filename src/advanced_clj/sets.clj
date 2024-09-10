(ns advanced-clj.sets)

(def my-set #{1 2 3 4})

(conj my-set 5)       ; => #{1 2 3 4 5}
(disj my-set 2)       ; => #{1 3 4}

(contains? my-set 3) ; => true
(contains? my-set 5) ; => false
