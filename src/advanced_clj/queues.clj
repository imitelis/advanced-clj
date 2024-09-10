(ns advanced-clj.queues
  (:require '[clojure.core.async :refer [chan >! <! close!]]))

(def my-queue (clojure.lang.PersistentQueue/EMPTY))

(def my-queue (conj my-queue 1))    ; Adds 1 to the queue
(def my-queue (conj my-queue 2))    ; Adds 2 to the queue
(def my-queue (conj my-queue 3))    ; Adds 3 to the queue

(def my-queue (pop my-queue))       ; Removes the front element

(def front-element (peek my-queue)) ; Gets the front element without removing it

;; Create a channel
(def my-channel (chan))

;; Put some values into the channel
(>! my-channel 1)
(>! my-channel 2)
(>! my-channel 3)

;; Take values from the channel
(println (<! my-channel)) ; Prints 1
(println (<! my-channel)) ; Prints 2
(println (<! my-channel)) ; Prints 3

;; Close the channel
(close! my-channel)