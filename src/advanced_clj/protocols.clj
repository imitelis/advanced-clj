(ns advanced-clj.protocols)

(defprotocol ProtocolName
  (function1 [this arg] "Description of function1")
  (function2 [this] "Description of function2"))

(defprotocol Shape
  (area [this] "Calculates the area of the shape")
  (perimeter [this] "Calculates the perimeter of the shape"))

(defrecord Rectangle [width height])
(defrecord Circle [radius])

(extend-type Rectangle
  Shape
  (area [this] (* (:width this) (:height this)))
  (perimeter [this] (* 2 (+ (:width this) (:height this)))))

(extend-type Circle
  Shape
  (area [this] (* Math/PI (Math/pow (:radius this) 2)))
  (perimeter [this] (* 2 Math/PI (:radius this))))

(def rect (->Rectangle 3 4))
(def circ (->Circle 5))

(area rect) ; => 12
(perimeter rect) ; => 14

(area circ) ; => 78.53981633974483
(perimeter circ) ; => 31.41592653589793

(extend-type clojure.lang.PersistentArrayMap
  Shape
  (area [this] (* (:width this) (:height this)))
  (perimeter [this] (* 2 (+ (:width this) (:height this)))))

(def rect-map {:width 3 :height 4})

(area rect-map) ; => 12
(perimeter rect-map) ; => 14

(defprotocol Animal
  (make-sound [this]))

(defrecord Dog []
  Animal
  (make-sound [this] "Woof!"))

(defrecord Cat []
  Animal
  (make-sound [this] "Meow!"))

(def dog (->Dog))
(def cat (->Cat))

(make-sound dog) ; => "Woof!"
(make-sound cat) ; => "Meow!"
