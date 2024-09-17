(ns advanced-clj.schemas 
  (:require [schema.core :as s]))

(s/defschema Person
  {:name s/Str
   :age s/Int})

(s/validate Person {:name "Alice" :age 30})  ;; Valid data
;; => {:name "Alice", :age 30}

(s/validate Person {:name "Bob" :age "thirty"})  ;; Invalid data
;; Throws an exception because :age should be an integer

(s/defschema Address
  {:street s/Str
   :city s/Str
   :zipcode s/Str})

(s/defschema Person
  {:name s/Str
   :age s/Int
   :address Address})

(s/defschema Person
  {:name s/Str
   :age (s/optional s/Int)
   :address (s/optional Address)})

(s/defschema Person
  {:name s/Str
   :age (s/optional s/Int)
   :address (s/optional Address)})

(defn even? [x]
  (zero? (mod x 2)))

(s/defschema EvenNumber (s/pred even? 'EvenNumber))

(s/validate EvenNumber 4)  ;; Valid
;; => 4

(s/validate EvenNumber 5)  ;; Invalid
;; Throws an exception because 5 is not an even number

(try
  (s/validate Person {:name "Alice" :age "not-a-number"})
  (catch Exception e
    (println "Validation error:" (.getMessage e))))
