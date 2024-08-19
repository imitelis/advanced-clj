(ns advanced-clj.maps)

(def my-map {:a 1, :b 2, :c 3})

(def my-map (hash-map :a 1 :b 2 :c 3))

(get my-map :b)  ; Returns 2
(my-map :b)      ; Also returns 2

(def updated-map (assoc my-map :d 4))
; updated-map is now {:a 1, :b 2, :c 3, :d 4}

(def new-value-map (assoc my-map :b 20))
; new-value-map is now {:a 1, :b 20, :c 3}

(def reduced-map (dissoc my-map :c))
; reduced-map is now {:a 1, :b 2}

(contains? my-map :a)  ; Returns true
(contains? my-map :z)  ; Returns false

(some #(= 2 (val %)) my-map) ; Returns {:b 2}

(keys my-map) ; Returns (:a :b :c)

(vals my-map) ; Returns (1 2 3)

(map (fn [[k v]] [k (* v 2)]) my-map)
; Returns ([:a 2] [:b 4] [:c 6])

(reduce (fn [acc [k v]] (+ acc v)) 0 my-map)
; Returns 6 (1 + 2 + 3)

(def nested-map {:a {:x 1, :y 2}, :b {:z 3}})
(get-in nested-map [:a :x])  ; Returns 1

(def updated-nested (assoc-in nested-map [:a :y] 20))
; updated-nested is now {:a {:x 1, :y 20}, :b {:z 3}}

(merge {:a 1} {:b 2} {:c 3})
; Returns {:a 1, :b 2, :c 3}

(select-keys my-map [:a :b])
; Returns {:a 1, :b 2}

(update my-map :b inc)
; Returns {:a 1, :b 3, :c 3}
