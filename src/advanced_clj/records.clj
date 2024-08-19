(ns advanced-clj.records
  (:require [clojure.string :as str]))

(defrecord Person [name age])

(def alice (->Person "Alice" 30))

(def alice (Person. "Alice" 30))

(:name alice)  ;; => "Alice"
(:age alice)   ;; => 30

(.name alice)  ;; => "Alice"
(.age alice)   ;; => 30

(def older-alice (assoc alice :age 31))

(defprotocol Greetable
  (greet [this] "Return a greeting message"))

(extend-type Person
  Greetable
  (greet [this] (str "Hello, " (:name this) "!")))

(greet alice)  ;; => "Hello, Alice!"

(defrecord Person [name age]
   Object
   (toString [this]
     (str "Person[name=" name ", age=" age "]")))

(def alice (->Person "Alice" 30))

(println alice)  ;; => Person[name=Alice, age=30]

;; Define a record
(defrecord Person [name age])

;; Create instances
(def alice (->Person "Alice" 30))
(def bob (Person. "Bob" 25))

;; Access fields
(println (:name alice))  ;; => "Alice"
(println (.age bob))     ;; => 25

;; Update a record
(def older-alice (assoc alice :age 31))
(println (:age older-alice))  ;; => 31

;; Define and implement a protocol
(defprotocol Greetable
  (greet [this]))

(extend-type Person
  Greetable
  (greet [this] (str "Hello, " (:name this) "!")))

;; Use the protocol
(println (greet alice))  ;; => "Hello, Alice!"
