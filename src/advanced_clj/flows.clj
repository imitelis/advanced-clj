(ns advanced-clj.flows
  (:require [clojure.core.async :refer [<! >! go close! pipeline-async] :as async]))

(def my-channel (async/chan))

(async/go
  (let [result (<! my-channel)] ; Receive a value from the channel
    (println "Received:" result)))

(async/go
  (async/>! my-channel "Hello World")) ; Send a value to the channel

(async/go
  (let [msg (<! my-channel)] ; Receive a value from the channel
    (println "Message received:" msg)))

(def buf-chan (async/chan 10)) ; Channel with a buffer size of 10
(def unbuf-chan (async/chan))
(async/close! my-channel)


(defn producer [ch]
  (async/go
    (doseq [i (range 5)]
      (async/>! ch i) ; Put values into the channel
      (Thread/sleep 1000)) ; Simulate work
    (async/close! ch))) ; Close the channel when done

(defn consumer [ch]
  (async/go
    (loop []
      (when-let [value (<! ch)] ; Take values from the channel
        (println "Received:" value)
        (recur)))))

(def my-channel (async/chan))

(producer my-channel)
(consumer my-channel)

(def input (async/chan))
(def output (async/chan))

(pipeline-async
 4 ; Number of parallel processes
 output
 (fn [v]
   (go
     (Thread/sleep 500) ; Simulate some processing
     (>! output (str "Processed " v)))) ; Send processed value to output
 input) ; The input channel

(go
  (dotimes [i 10]
    (>! input i))
  (close! input)) ; Close the input channel after sending all items

(go
  (loop []
    (when-let [result (<! output)]
      (println result)
      (recur))))
