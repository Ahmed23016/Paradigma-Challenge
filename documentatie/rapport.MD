# Paradigma Challenge

|   |  |
|------------------|---------------|
|Student| Ahmed Ammoura|
|Studenten nummer| 2130051|
|Datum| 03/10/2025|
|Docent| Dennis Breuker|
|Course| APP (Algoritmes, Paradigma's en Programmeertalen)|



## Inleiding

Voor de course APP (Algoritmes, Paradigma's en Programmeertalen) ben ik bezig geweest met de paradigma challenge. Ik ben bezig gegaan met de opdracht om het aantal woorden te analyseren in een tekstbestand. Ik zal dat doen met de taal clojure.


## Onderzoek
Ik heb voor deze opdracht gekozen om een tekstanalyseprogramma te maken.
De programmeertaal die ik heb gebruikt is Clojure. Dit is een moderne, functionele taal die draait op de Java Virtual Machine (JVM). Clojure is ontworpen met eenvoud, data-gericht denken en functionele zuiverheid als uitgangspunt. Hieronder beschrijf ik de belangrijkste functionele concepten en hoe die in Clojure werken en in mijn project zijn toegepast.

### Basisconcepten van Clojure

Voordat ik functionele concepten ga uitleggen, leg ik eerst de basisconcepten uit die ik belangrijk vond. 

#### def

Maak een binding naar een waarde (immutabel).

```clojure
(def naam "Ahmed") 
(println naam) ;; Ahmed
```

#### defn

Definieer een functie (naam, parameters, body).

```clojure
(defn begroet [persoon]
  (println "Hallo" persoon))

(begroet "wereld") ;; Hallo wereld
```

#### printen

Schrijf naar de console.

```clojure
(println "Hallo wereld")
```

#### functies aanroepen

Prefix-notatie: eerst de functie, dan de argumenten.

```clojure
(println (+ 3 4)) ;; 7
```

#### cons, first, rest

* `cons` voegt een element vooraan toe
* `first` pakt het eerste element
* `rest` geeft de rest van de lijst

```clojure
(def lijst '(1 2 3))
(first lijst)      ;; 1
(rest lijst)       ;; (2 3)
(cons 0 lijst)     ;; (0 1 2 3)
```

#### let

Lokale bindings binnen een blok of functie.

```clojure
(let [a 5 b 3]
  (println (+ a b))) ;; 8
```
### Functionele concepten

#### Zuiverheid (pure functions)
In het tweede jaar van mijn studie heb ik geleerd wat pure functies zijn. Een pure functie is een functie die altijd dezelfde output geeft bij dezelfde input en geen bijwerkingen heeft. In Clojure is dit een belangrijk concept. Functies veranderen geen globale variabelen, schrijven niets naar files en werken niet direct met externe toestand.

In Clojure werk je bijna altijd met pure functies, omdat data standaard immutabel is en functies geen toestand buiten zichzelf mogen aanpassen.

Voorbeeld van een pure functie:

```clojure
(defn optellen [a b]
  (+ a b))

(println (optellen 3 4)) ;; 7
(println (optellen 3 4)) ;; 7 (altijd hetzelfde resultaat ;))
```

Elke keer dat je deze functie aanroept met dezelfde argumenten, krijg je exact dezelfde uitkomst. De functie doet verder niets anders dan rekenen.

Voorbeeld van een niet-pure functie:

```clojure
(def teller 0)

(defn verhoog []
  (def teller (inc teller))) ;; verandert een globale variabele

(verhoog)
(println teller) ;; resultaat hangt af van vorige aanroepen
```

Hier verandert de functie een globale variabele. Dat betekent dat het resultaat niet meer alleen afhangt van de input, maar ook van wat er eerder is gebeurd. Dit maakt je programma moeilijker te begrijpen en te testen.


 [Hier](../code/tekstanalyse/src/seradrev/pure.clj) is een bestand waar ik mee ging oefenen om te oefenen met pure functies in clojure. Ik maakte een optel functie zoals we leerden in vorig jaar. Hier kon ik ook oefenen met de prefix notatie zoals we die leerden in de APP lessen. 

#### First-Class Functions

First-class betekent dat functies in Clojure worden behandeld als gewone waarden, net zoals getallen, strings of lijsten. Je kunt er dus hetzelfde mee doen als met andere waarden.

Je kunt:

* een functie opslaan in een variabele
* een functie meegeven als argument aan een andere functie
* een functie teruggeven als resultaat van een andere functie

Dit maakt je code flexibeler en krachtiger, omdat je functies kunt combineren en dynamisch kunt gebruiken.

Voorbeeld – een functie opslaan en aanroepen:

```clojure
(defn keer-twee [x]
  (* 2 x))

(def mijn-functie keer-twee)

(println (mijn-functie 5)) ;; 10
```

In Clojure is het een basisprincipe.
 Om er mee te oefenen heb ik een codebestand gemaakt waar ik een functie meegeef als parameter. Dat is [hier](./../code/tekstanalyse/src/seradrev/firstclass.clj) te vinden.

#### Higher-order functions

Een higher-order functie is een functie die of een andere functie als argument neemt, of een functie teruggeeft als resultaat.
Higher-order functies zijn heel belangrijk in functioneel programmeren, omdat ze het mogelijk maken om logica te schrijven zonder herhaling.

Voorbeeld :

```clojure
(defn pas-toe-op-lijst [f lijst]
  (map f lijst)) ;; map voert de functie f uit op elk element

(pas-toe-op-lijst inc [1 2 3]) ;; (2 3 4)
```

Hier wordt `inc` (een ingebouwde functie die +1 doet) doorgegeven aan `pas-toe-op-lijst`, die hem toepast op elk element van de lijst. `map` is zelf ook een higher-order functie, omdat hij een andere functie verwacht.

Higher-order functies worden in Clojure vaak gebruikt met standaardfuncties zoals `map`, `filter`, `reduce` en `sort-by`. Deze nemen allemaal andere functies als argument, waardoor je complexe operaties kunt uitvoeren zonder loops te schrijven.



#### Immutability

Immutability betekent dat data niet meer verandert nadat het is aangemaakt. In plaats van een waarde direct te wijzigen, maak je in functionele programmeertalen altijd een nieuwe versie van die waarde met de aanpassing erin. Dit zorgt ervoor dat je programma voorspelbaarder en stabieler wordt, omdat er geen onverwachte veranderingen in data optreden.

In Clojure is immutability standaard: alle basisdatastructuren zoals lijsten, vectors en maps zijn onveranderbaar. Als je iets “wijzigt”, krijg je eigenlijk een nieuwe datastructuur terug met de aanpassing, terwijl het origineel hetzelfde blijft.

Voorbeeld:

```clojure
(def woorden '("appel" "peer"))
(def nieuwe-woorden (cons "banaan" woorden)) ;; cons wordt gebruikt om data in lijst te stoppen. 

(println woorden)        ;; ("appel" "peer")
(println nieuwe-woorden) ;; ("banaan" "appel" "peer")
```

Hier voeg je `"banaan"` toe aan de lijst, maar de originele lijst `woorden` blijft gewoon hetzelfde. Je krijgt een nieuwe versie terug in `nieuwe-woorden`.



#### Recursie

Recursie betekent dat een functie zichzelf opnieuw aanroept om een probleem stap voor stap op te lossen. In functionele programmeertalen zoals Clojure is dit een belangrijk concept, omdat traditionele loops zoals `for` en `while` niet bestaan. Als je iets meerdere keren wilt herhalen, moet je dat dus doen via recursieve functies.

Bij recursie geef je steeds een “kleinere” versie van het probleem door aan dezelfde functie, totdat je een base case bereikt. Die base case zorgt ervoor dat de recursie stopt en je geen oneindige herhaling krijgt.

Een eenvoudig voorbeeld:

```clojure
(defn aftellen [n]
  (if (>= n 0)                         ;; base case: stop als n kleiner is dan 0
    (do
      (println n)                      ;; print huidige waarde
      (aftellen (dec n)))))           ;; roep dezelfde functie opnieuw aan met n - 1 (dat is wat dec doet)

(aftellen 5)
```

Uitvoer:

```
5
4
3
2
1
0
```

Hier roept de functie `aftellen` zichzelf elke keer opnieuw aan met een kleinere waarde van `n`, totdat `n` kleiner is dan 0 en het programma stopt.



#### Lazy Evaluation
Lazy evaluation betekent dat Clojure berekeningen pas uitvoert op het moment dat het resultaat echt nodig is. De taal rekent dus niet meteen alles uit, maar wacht totdat je het resultaat daadwerkelijk gebruikt. Dit zorgt ervoor dat je efficiënt kunt omgaan met grote hoeveelheden data of zelfs oneindige reeksen, omdat niet alles tegelijk in het geheugen geladen hoeft te worden  en voorkom je ook fouten doordat sommige berekeningen pas worden gedaan als dat veilig is.

Een simpel voorbeeld laat dit goed zien:

```clojure
(def cijfers (range))            ;; maakt een oneindige reeks: 0, 1, 2, 3, ...
(println (take 5 cijfers))       ;; alleen de eerste 5 worden berekend
```

Hoewel `range` hier een oneindige reeks maakt, berekent Clojure maar vijf elementen, omdat `take` alleen de eerste vijf nodig heeft. Zonder lazy evaluation zou dit programma vastlopen of enorm veel geheugen gebruiken.

Lazy evaluation voorkomt ook fouten doordat bepaalde berekeningen pas uitgevoerd worden als dat veilig is. Bijvoorbeeld:

```clojure
(when (and (< 3 5) (< (nth [1 2 3] 2) 5))
  (println "werkt"))
```

In dit voorbeeld wordt `nth` (die een element uit een lijst haalt) alleen uitgevoerd als de eerste vergelijking `(< 3 5)` waar is. Zonder lazy evaluation zou `nth` altijd uitgevoerd worden, ook als dat onnodig of zelfs fout zou zijn (bijvoorbeeld out of bounds error).


Lazy evaluation is standaard ingebouwd in veel functies in Clojure zoals `map`, `filter`, `take`, `drop` en `range`.

[Hier](./../code/tekstanalyse/src/seradrev/lazy.clj) heb ik nog wat code geschreven om het te tonen. Ik heb ook het voorbeeld uit de [les](https://aim-cni.github.io/app/docs/Week%204/Les%202/Lesprogramma#lazy-evaluation-voorbeeld) omgeschreven naar Clojure om te tonen dat lazy evaluation ook werkt in Clojure.

#### Pattern Matching

Pattern matching is een manier om te controleren op verschillende vormen van data. Clojure heeft geen echte pattern matching zoals Haskell, maar gebruikt iets wat daar sterk op lijkt: destructuring. Daarmee kun je elementen uit een lijst, vector of map direct “uitpakken” zonder steeds first, second of get te gebruiken.


``` clojure
(let [[woord aantal] ["appel" 3]]     ;; hier halen we het eerste en tweede element uit de vector
  (println "woord is:" woord)
  (println "aantal is:" aantal))

  ;;output:
  ;; woord is appel
  ;; aantal is 3
  ```
Hier zie je destructuring. woord krijgt de waarde "appel" en aantal krijgt 3. 
Pattern matching lijkt een beetje op wat je in Java doet met instanceof, waar je eerst controleert van welk type een object is voordat je ermee werkt.
``` java
Object vorm = new Cirkel();

if (vorm instanceof Cirkel c) {
    System.out.println("Straal: " + c.getStraal());
} else if (vorm instanceof Vierkant v) {
    System.out.println("Breedte: " + v.getBreedte());
}
```

Hier controleer je eerst het type en pak je daarna de bijbehorende data eruit.

Het verschil met echte pattern matching is dat dat proces daar automatisch gecombineerd wordt: het herkent vorm + inhoud tegelijk en geeft meteen namen aan onderdelen zonder aparte if-checks.

## Opdracht

De opdracht die ik heb gekozen is om een tekstanalyse programma te schrijven. Het bestand krijgt een tekstbestand als input en print dan welke woorden voorkomen en de frequentie ervan. Ik heb hiervoor gekozen omdat het me interessant leek om te werken met recursieve functies, omdat ik het in de lessen een interessant concept vond en het lastig vond om goede recursieve functies te schrijven zonder dat ze bijvoorbeeld oneindig blijven doorgaan. Ik heb in mijn studie alleen gewerkt met for en while loops dus vond dit een goede opdracht. Ik heb ook besloten om aan de opdracht toe te voegen dat de lijst met woorden van hoogste naar laagste frequentie wordt geprint, zodat ik meteen kon oefenen met het schrijven van een sorteeralgoritme in Clojure.

## Implementatie
Zie [hier](./../code/tekstanalyse/src/seradrev/tekstanalyse.clj)

## Reflectie

Ik begon dit project niet meteen met het bouwen van het uiteindelijke programma, maar eerst met kleine oefenbestanden om de taal beter te begrijpen. Ik maakte bijvoorbeeld een bestand om alleen te printen (`printen.clj`), één om te oefenen met functies en parameters (`functies.clj`), één om te leren hoe vectors en lijsten werken (`arrays.clj`), en één om recursie te oefenen (`recursive.clj`). Door deze kleine stappen kon ik de basis van Clojure beter begrijpen voordat ik aan het grotere project begon.

In het begin vond ik het vooral lastig dat Clojure er heel anders uitziet dan talen zoals Java of JavaScript. Alles staat tussen haakjes en de functie komt altijd als eerste, gevolgd door de parameters. Ook dat je parameters niet tussen haakjes zet maar gewoon achter elkaar schrijft, was even wennen. Bijvoorbeeld:

```clojure
(defn optellen [a b]
  (+ a b))

(optellen 3 5) ;; 8
```

Daarnaast moest ik wennen aan de prefixnotatie: de operator staat vooraan in plaats van tussen de waarden. In plaats van `3 + 5` schrijf je `( + 3 5 )`. Dit was wel wat lastiger dan hoe in het java kan. Vooral bij sommen zoals dit `(+ (* 2 3) 5)`.

Tijdens het maken van de oefenbestanden begon ik ook de functionele concepten beter te begrijpen. Bijvoorbeeld:

* **Zuiverheid:** In Clojure schrijf je automatisch veel pure functies. In mijn oefenbestand met optellen merkte ik dat dezelfde input altijd dezelfde output geeft en er geen onverwachte bijwerkingen zijn.
* **Immutability:** In het bestand waarin ik met vectors werkte (`arrays.clj`), leerde ik dat data nooit verandert. Als je iets “aanpast”, maak je eigenlijk een nieuwe lijst. Dat is anders dan in Java, waar je een lijst gewoon kunt wijzigen.
* **Recursie:** Loops bestaan niet, dus moest ik leren denken in recursieve stappen. In mijn bestand `recursive.clj` oefende ik dat door een functie te maken die aftelt van een getal naar nul. Later gebruikte ik hetzelfde principe om woorden te tellen en lijsten te sorteren.
* **Higher-order functions:** In `functies.clj` experimenteerde ik met het meegeven van functies als argument. Daardoor begreep ik beter hoe functies net als waarden werken en hoe dat krachtig kan zijn in grotere programma’s.
* **Pattern matching (destructuring):** Bij het werken met lijsten en paren vond ik destructuring handig. Het maakte de code veel leesbaarder, omdat ik niet steeds `first` en `rest` hoefde te gebruiken.

Wat ik vooral heb geleerd is dat functioneel programmeren je dwingt om anders te denken. Je kunt niet zomaar variabelen veranderen of met loops werken, maar moet oplossingen bouwen met pure functies, recursie en immutabele data. In het begin voelde dat beperkend, maar gaandeweg merkte ik dat het mijn code overzichtelijker, voorspelbaarder en makkelijker te testen maakte.

Het meest uitdagende onderdeel was het schrijven van de functies voor het tellen en sorteren van woorden zonder ingebouwde functies zoals `assoc` of `sort`. Ik moest alles zelf bouwen, zoals een functie die een waarde toevoegt aan een lijst of een functie die de juiste plek voor een element zoekt bij het sorteren. Hierdoor begreep ik beter hoe zulke functies “onder de motorkap” werken en waarom ze in functionele talen vaak op recursie zijn gebaseerd.

Terugkijkend heb ik veel geleerd over hoe functioneel programmeren verschilt van imperatief denken. Vooral het idee van immutability en het werken met recursie heeft mijn manier van programmeren veranderd. Hoewel het in het begin wat moeilijk was om om te schakelen, merkte ik dat het me uiteindelijk hielp om beter gestructureerde en betrouwbaardere code te schrijven.


## Conclusie

## Bronnen
1.
https://github.com/casselc/clj-msi/releases/tag/v1.12.2.1565

2.
https://kimh.github.io/clojure-by-example/#about-this-page
