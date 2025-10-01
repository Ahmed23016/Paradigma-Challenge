(ns seradrev.arrays
  (:gen-class))


;; seq is functie om te checken of de collectie empty is. (not(empty?)) kann ook maar visual studio code geeft warning syntax erop omdat seq beter is
(defn print-woorden [woorden]
  (when (seq woorden)                              ;; controleer of er nog elementen zijn
    (println "Woord:" (first woorden))            ;; print het eerste woord
    (print-woorden (rest woorden))))              ;; roep opnieuw aan met de rest
 
;; Recursieve functie om de lengte van een vector te tellen
(defn mijn-count [lijst]
  (if (empty? lijst)
    0
    (inc (mijn-count (rest lijst)))))

(defn -main [& _]
  (let [woorden ["appel" "peer" "banaan" "dadel"]]
    (let [dingetje "hallo"]
    (println "Er zitten" (mijn-count woorden) "woorden in de lijst. " dingetje) ; variabels zijn alleen bereikbaar binnen die ()
    (print-woorden woorden))))
