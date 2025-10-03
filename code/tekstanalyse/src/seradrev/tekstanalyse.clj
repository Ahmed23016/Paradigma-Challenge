(ns seradrev.tekstanalyse
  (:gen-class))

;; bestand lezen en printen
(defn -main [& _]
  (let [inhoud (slurp "resources/lol.txt")]  ;; lees tekstbestand als string. het variabel heet inhoud
    (println "inhoud van variabel inhoud :):")
    (println inhoud)))                       ;; print inhoud
