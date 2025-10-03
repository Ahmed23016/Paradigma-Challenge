(ns seradrev.tekstanalyse
  (:gen-class)
  (:require [clojure.string :as str]))

;; maakt tekst schoon en splitst in losse woorden
(defn woorden [text]
  (-> text
      str/lower-case                     ;; alles naar kleine letters
      (str/replace #"[^\p{L}\s]" "")     ;; leestekens verwijderen
      (str/split #"\s+")))               ;; splitsen op spaties

;; leest bestand en maakt array(vector) van
(defn -main [& _]
  (let [inhoud (slurp "resources/lol.txt")  ;; tekstbestand lezen
        woordenlijst (woorden inhoud)]      ;; woordenlijst maken
    (println "woorden in het bestand")
    (println woordenlijst)))
