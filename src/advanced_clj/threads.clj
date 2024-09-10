(ns advanced-clj.threads)

(def my-thread
  (Thread. (fn []
             (dotimes [i 5]
               (println "Running in thread:" i)))))

(.start my-thread)

(.join my-thread)

(def my-future
  (future
    (dotimes [i 5]
      (println "Running in future:" i)
      (Thread/sleep 1000))))

(println "Result of future:" @my-future)

(def my-future
  (future
    (dotimes [i 5]
      (println "Running in future:" i)
      (Thread/sleep 1000))))

;; Do some other work
(dotimes [i 5]
  (println "Doing other work:" i)
  (Thread/sleep 500))

;; Get the result of the future
(println "Result of future:" @my-future)

(def my-agent (agent 0))

(send my-agent + 1)

(await my-agent)

(def my-agent (agent 0))

(send my-agent + 5)
(send my-agent + 10)

;; Wait for updates to complete
(await my-agent)

(println "Final state of agent:" @my-agent)
