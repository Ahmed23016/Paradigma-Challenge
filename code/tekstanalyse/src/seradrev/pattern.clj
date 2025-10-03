(ns seradrev.pattern
  (:gen-class))

(defn beschrijf [x]
  (cond
    (= x 20) "twintugg"
    (= x 33) "drie en dertig"
    (= x 7) "zeven"
    :else   "anders"))

(defn -main [& _]
  (println (beschrijf 20))  ;; => "twintig"
  (println (beschrijf 33))  ;; => "drie en dertig"
  (println (beschrijf 5))) ;; => "anders"
