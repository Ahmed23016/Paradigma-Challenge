(ns seradrev.functies
  (:gen-class))

(defn begroet [naam]
  (println (str "Hallo, " naam "!")))

(defn optellen [a b]
  (+ a b))

(defn keer [eerstecoolegetal tweedecoolegetal]
  (* eerstecoolegetal tweedecoolegetal))

(defn zonderParameters []
  (println "geen parameters"))

(defn -main [& _]
  (begroet "Ahmed")
  (println "5 + 7 =" (optellen 5 7))
  (println "10 keer 5= " (keer 10 5))
  (zonderParameters))


;;clj -M -m seradrev.functies