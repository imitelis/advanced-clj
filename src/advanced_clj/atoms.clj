(ns advanced-clj.atoms)


;; Define an atom with an initial value of 0
(def counter (atom 0))

;; Define a function to increment the counter
(defn increment-counter []
  (swap! counter inc))

;; Increment the counter
(increment-counter)

;; Read the current value of the counter
(println @counter) ;; Outputs: 1

