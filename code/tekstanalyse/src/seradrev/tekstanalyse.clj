(ns seradrev.tekstanalyse
  (:gen-class)
  (:require [clojure.string :as str]))

;; maakt de tekst schoon en splitst het in losse woorden
(defn woorden [text]
  (-> text
      str/lower-case                     ;; alles naar kleine letters
      (str/replace #"[^\p{L}\s]" "")     ;; alle leestekens eruithale
      (str/split #"\s+")))               ;; tekst opsplitsen op spaties

;; zoekt handmatig een waarde op in een lijst van paren
(defn mijn-get [freq-lijst gezocht-woord]
  (if (empty? freq-lijst)                ;; als de lijst leeg is stoppe we hier
    nil                                  ;; dan is het woord nie gevonden
    (let [[huidig-woord huidig-aantal] (first freq-lijst)]  ;; pak het eerste woord en aantal uit de lijst
      (if (= huidig-woord gezocht-woord)  ;; check of dit het woord is dat we zoeken
        huidig-aantal                     ;; als dat zo is geef het aantal terug
        (mijn-get (rest freq-lijst) gezocht-woord))))) ;; anders zoeken we verder in de rest van de lijst

;; voegt handmatig een (woord aantal)-paar toe of vervangt het als het er al is
(defn mijn-assoc [freq-lijst nieuw-woord nieuw-aantal]
  (if (empty? freq-lijst)                ;; als de lijst leeg is doen we gewoon het eerste element erin
    (cons [nieuw-woord nieuw-aantal] '()) ;; voeg dit woord en aantal als eerst toe
    (let [[huidig-woord huidig-aantal] (first freq-lijst)] ;; pak het eerste woord en aantal uit de lijstt
      (if (= huidig-woord nieuw-woord)   ;; check of dit het woord is dat we wille update
        (cons [nieuw-woord nieuw-aantal] (rest freq-lijst)) ;; vervang het met het nieuwe aantal dat we nu hebben
        (cons [huidig-woord huidig-aantal] (mijn-assoc (rest freq-lijst) nieuw-woord nieuw-aantal)))))) ;; anders laten we dit woord staan en gaan verder zo door

;; telt hoe vaak elk woord voorkomt in de tekst
(defn frequentie
  ([woorden-lijst] (frequentie woorden-lijst '())) ;; start met lege frequentielijst want we hebben nog niks
  ([woorden-lijst freq-lijst]
   (if (empty? woorden-lijst)            ;; als er geen woorden meer zijn dan zijn we klaar
     freq-lijst                          ;; dan geven we de lijst terug
     (let [huidig-woord (first woorden-lijst) ;; pak het eerste woord uit de lijst zodat we ermee kunnen werken
           bestaand-aantal (mijn-get freq-lijst huidig-woord) ;; check of dit woord al eerder is getelt
           nieuw-aantal (if bestaand-aantal (inc bestaand-aantal) 1) ;; verhoog het aantal of zet het op 1 als het nieuw woord is
           bijgewerkte-freq (mijn-assoc freq-lijst huidig-woord nieuw-aantal)] ; voeg dit nieuwe aantal toe aan de lijst zodat het klopt
       (frequentie (rest woorden-lijst) bijgewerkte-freq))))) ;; doe hetzelfde voor de rest van de woorden. recursief en herhaal tot klaar :)

;; leest het bestand, maakt array(vector) van woorden en telt frequentie
(defn -main [& _]
  (let [inhoud (slurp "resources/lol.txt")         ;; lees de tekst uit het bestand (zorg dat het bestaat)
        woorden-lijst (woorden inhoud)            ;; maak een lijst van alle woorden die we hebben
        frequentie-lijst (frequentie woorden-lijst)] ;; tel hoe vaak elk woord voorkommt in de tekst
    (println "woordfrequentie in de tekst")      
    (println frequentie-lijst)))                 
