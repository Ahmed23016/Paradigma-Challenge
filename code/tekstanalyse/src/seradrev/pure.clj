(ns seradrev.pure
  (:gen-class))

(defn plus [a b]
  (+ a b))

(defn -main [& _]
  (println (plus 2 5)))
;;;;;;; clj -M -m seradrev.pure   