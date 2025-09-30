(ns seradrev.recursive
  (:gen-class))

(defn aftellen [n]
  (if (>= n 0)
    (do
      (println n)
      (aftellen (dec n)))   ;; hier roept de functie zichzelf opnieuw aan
    nil))                   ;; basisgeval: stoppen als n < 0

(defn -main [& _]
  (println "Aftellen vanaf getal nummer cijfer 5:")
  (aftellen 5))
