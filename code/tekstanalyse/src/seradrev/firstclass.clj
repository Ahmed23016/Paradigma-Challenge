(ns seradrev.firstclass
  (:gen-class))

(defn kwadraat [x]
  (* x x))

;; functie als argument
(defn firstclass [functie-die-je-meekrijgt waarde]
  (functie-die-je-meekrijgt waarde))



(defn -main [& _]
  ;; voorbeeld 1: functie doorgeven
  (println (firstclass kwadraat 5))    ;; => 25
  )