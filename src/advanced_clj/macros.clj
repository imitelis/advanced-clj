(ns advanced-clj.macros)

(defmacro unless [test then]
  `(if (not ~test)
     ~then))

(unless true
        (println "This will not print"))

(unless false
        (println "This will print"))

(macroexpand '(unless true (println "This will not print")))

(if (not true) (println "This will not print"))

(defmacro defmulti-fn [name & clauses]
  `(defn ~name
     [x]
     (cond
       ~@(apply concat (map (fn [[test body]]
                              [test body])
                            (partition 2 clauses))))))

(defmulti-fn my-function
  true "Yes"
  false "No")

(my-function true)  ; => "Yes"
(my-function false) ; => "No"

(defmacro with-unique-name [expr]
  (let [unique-name (gensym "temp-")]
    `(let [~unique-name ~expr]
       ~unique-name)))

(with-unique-name (+ 1 2))  ; => 3
