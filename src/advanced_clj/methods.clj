(ns advanced-clj.methods)

; (defmulti my-method dispatch-fn)

; (defmethod my-method :key1 [args]
;   (do-something-for-key1 args))

; (defmethod my-method :key2 [args]
;   (do-something-for-key2 args))

;; Define the multi-method
(defmulti greet (fn [person] (:type person)))

;; Define the implementations
(defmethod greet :adult [person]
  (str "Hello, " (:name person) "!"))

(defmethod greet :child [person]
  (str "Hi, " (:name person) "!"))

;; Test the multi-method
(greet {:type :adult :name "John"}) ; => "Hello, John!"
(greet {:type :child :name "Jane"}) ; => "Hi, Jane!"

(defmulti process type)

(defmethod process String [s]
  (str "String: " s))

(defmethod process Number [n]
  (str "Number: " n))

(defmulti categorize (fn [x] (cond
                               (string? x) :string
                               (number? x) :number
                               :else :unknown)))

(defmethod categorize :string [s]
  (str "This is a string: " s))

(defmethod categorize :number [n]
  (str "This is a number: " n))

(defmethod categorize :unknown [x]
  (str "Unknown type: " x))
