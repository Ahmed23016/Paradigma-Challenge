(ns seradrev.tekstanalyse
  (:gen-class))

(defn countdown
  [n]
  (when (>= n 0)
    (println n)
    (when (> n 0)
      (countdown (dec n)))))

(defn -main
  [& _]
  ;; bestand lezen
  (let [content (slurp "resources/lol.txt")
        words   (clojure.string/split content #"\s+")
        count   (count words)]
    (println "Bestandsinhoud:")
    (println content)
    (println words)
    (println "\nAantal woorden:" count)
    (println "\nCountdown vanaf aantal woorden:")
    (countdown count)))
