(ns seradrev.tekstanalyse
  (:gen-class)
  (:require [clojure.string :as str])) ;; import str library van Clojuree

;; maakt tekst schoon en splitst in losse woorden
(defn woorden [text]
  (-> text
      str/lower-case                     ;; alles naar kleine letters
      (str/replace #"[^\p{L}\s]" "")     ;; alle leestekens eruithale
      (str/split #"\s+")))               ;; tekst opsplitsen op spaties

;; zoekt of een woord al in de lijst zit en geeft het aantal terug
(defn zoek-woord [woorden-en-aantallen gezocht]
  (if (empty? woorden-en-aantallen)          ;; lijst leeg? dan niks gevonden
    nil
    (let [[woord-nu aantal-nu] (first woorden-en-aantallen)] ;; pak eerste paar
      (if (= woord-nu gezocht)               ;; is dit het woord?
        aantal-nu                           ;; ja → geef aantal terug
        (zoek-woord (rest woorden-en-aantallen) gezocht))))) ;; anders verder zoeken

;; voegt een woord toe of update het aantal als het al bestaat
(defn voeg-toe-of-update [woorden-en-aantallen nieuw-woord nieuw-aantal]
  (if (empty? woorden-en-aantallen)                     ;; leeg? voeg gewoon toe
    (cons [nieuw-woord nieuw-aantal] '())
    (let [[woord-nu aantal-nu] (first woorden-en-aantallen)] ;; pak eerste paar
      (if (= woord-nu nieuw-woord)                     ;; zelfde woord?
        (cons [nieuw-woord nieuw-aantal] (rest woorden-en-aantallen)) ;; vervang aantal
        (cons [woord-nu aantal-nu] (voeg-toe-of-update (rest woorden-en-aantallen) nieuw-woord nieuw-aantal)))))) ;; anders verder

;; telt hoe vaak elk woord voorkomt
(defn tel-woorden
  ([lijst] (tel-woorden lijst '())) ;; start met lege lijst
  ([lijst woorden-en-aantallen]
   (if (empty? lijst)               ;; klaar? geef lijst terug
     woorden-en-aantallen
     (let [woord-nu (first lijst)                                 ;; pak eerste woord
           aantal-nu (zoek-woord woorden-en-aantallen woord-nu)   ;; zoek huidig aantal
           nieuw-aantal (if aantal-nu (inc aantal-nu) 1)          ;; verhoog of zet op 1
           nieuwe-lijst (voeg-toe-of-update woorden-en-aantallen woord-nu nieuw-aantal)] ;; update lijst
       (tel-woorden (rest lijst) nieuwe-lijst)))))                ;; verder met de rest

;; voegt een woord op de juiste plek toe in een gesorteerde lijst
(defn voeg-op-plek [element gesorteerd]
  (if (empty? gesorteerd)                    ;; leeg? maak nieuwe lijst
    (list element)
    (let [[[woord aantal] & rest] gesorteerd] ;; pak eerste paar
      (if (>= (second element) aantal)       ;; groter of gelijk? hier invoegen
        (cons element gesorteerd)
        (cons [woord aantal] (voeg-op-plek element rest)))))) ;; anders verder

;; sorteert de lijst van hoog naar laag
(defn sorteer-lijst [woorden-en-aantallen]
  (if (empty? woorden-en-aantallen) '()
      (voeg-op-plek (first woorden-en-aantallen) (sorteer-lijst (rest woorden-en-aantallen)))))


(defn doe-iets-met-lijst [functie lijst]
  (run! functie lijst ))
;; main :)
(defn -main [& _]
  (let [inhoud (slurp "resources/lol.txt")         ;; lees tekstbestand
        woorden-lijst (woorden inhoud)            ;; maak woordenlijst
        geteld (tel-woorden woorden-lijst)        ;; tel alle woorden
        gesorteerd (sorteer-lijst geteld)]        ;; sorteer van hoog naar laag
    (println "woord  aantal")
    (println "")
    (doe-iets-met-lijst println gesorteerd)))