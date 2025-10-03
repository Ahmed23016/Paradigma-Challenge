(ns seradrev.lazy
  (:gen-class))
(def cijfers (range))

(defn -main [& _]
  (let [a [1 2 3]]
    (loop [i 0]
      (when (and (< i (count a)) (< (nth a i) 5)) ;; nth zodat ik element uit vector kan pakken met index
        (recur (inc i)))) ;;recursief maar zonder het zelf te doen. in built functie . 
    (println "Klaar")))
    ;; (println cijfers) hier zou die oneindig printen
    (println (take 7 cijfers)) ; pakt alleen eerste 7 cijfers en de rest word niet berekend. efficient :)
