# Paradigma Challenge

|   |  |
|------------------|---------------|
|Student| Ahmed Ammoura|
|Studenten nummer| 2130051|
|Datum| 03/10/2025|
|Docent| Dennis Breuker|
|Course| APP (Algoritmes, Paradigma's en Programmeertalen)|
|Klas| ITA-CNI-A-s|



## Inleiding

Voor de course APP (Algoritmes, Paradigma's en Programmeertalen) ben ik bezig geweest met de paradigma challenge. Ik ben bezig gegaan met de opdracht om het aantal woorden te analyseren in een tekstbestand. Ik zal dat doen met de taal Clojure.


## Onderzoek
Ik heb voor de opdracht gekozen om een tekstanalyseprogramma te maken.
De programmeertaal die ik heb gebruikt is Clojure. Ik heb deze niet gekozen d.m.v onderzoek. Mij interesserde het me niet echt welke taal ik zou gebruiken, dus ik besloot aan AI te vragen welke taal het beste past bij de opdracht.(bron in bronnenlijst). Het antwoord dat eruit kwam was Clojure, omdat het de beste keuze is als je wilt focusen op recursie en higher order functies. Dat leek mij een goede keuze en is hem geworden. Clojure is een moderne, functionele taal die draait op de Java Virtual Machine (JVM).

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

Dit maakt je code flexibeler, omdat je functies kunt combineren en dynamisch kunt gebruiken.

Voorbeeld (een functie opslaan en aanroepen):

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

Een eenvoudig voorbeeld in clojure:

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

Pattern matching is een manier om te controleren op verschillende vormen van data. Clojure heeft geen echte pattern matching, maar gebruikt iets wat daar sterk op lijkt: `destructuring`. Daarmee kun je elementen uit een lijst, vector of map direct “uitpakken” zonder steeds first, second of get te gebruiken.


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

Het verschil met echte pattern matching is dat dat proces daar automatisch gecombineerd wordt. Het herkent vorm + inhoud tegelijk en geeft meteen namen aan onderdelen zonder aparte if-checks.

## Opdracht

De opdracht die ik heb gekozen is om een tekstanalyse programma te schrijven. Het bestand krijgt een tekstbestand als input en print dan welke woorden voorkomen en de frequentie ervan. Ik heb hiervoor gekozen omdat het me interessant leek om te werken met recursieve functies, omdat ik het in de lessen een interessant concept vond en het lastig vond om goede recursieve functies te schrijven zonder dat ze bijvoorbeeld oneindig blijven doorgaan. Ik heb in mijn studie alleen gewerkt met for en while loops dus vond dit een goede opdracht. Ik heb ook besloten om aan de opdracht toe te voegen dat de lijst met woorden van hoogste naar laagste frequentie wordt geprint, zodat ik meteen kon oefenen met het schrijven van een sorteeralgoritme in Clojure.

## Implementatie
Zie [hier](./../code/tekstanalyse/src/seradrev/tekstanalyse.clj)

## Reflectie

Hieronder een overzicht van de belangrijkste functionele concepten die in mijn programma terugkomen:



#### Zuiverheid (pure functions)

Bijna alle functies in mijn programma zijn **zuiver**. Dat betekent dat ze geen bijwerkingen hebben en altijd dezelfde output geven bij dezelfde input.
Voorbeelden zijn:

* `woorden` – neemt een tekst en geeft altijd dezelfde lijst van woorden terug.
* `zoek-woord` – krijgt een lijst en een woord en geeft altijd hetzelfde resultaat.
* `voeg-toe-of-update` – verandert de originele lijst niet, maar geeft een nieuwe versie terug.

Hierdoor blijft de logica van het programma voorspelbaar en testbaar. 

---

#### Immutability

Immutability is ook in de code. Data wordt nooit aangepast, maar er wordt steeds een nieuwe versie van gemaakt.
Bijvoorbeeld in `voeg-toe-of-update`: in plaats van een bestaand (woord, aantal)-paar te wijzigen, maak ik een nieuwe lijst met het bijgewerkte paar.

```clojure
(cons [nieuw-woord nieuw-aantal] (rest woorden-en-aantallen))
```

Ook bij het tellen van woorden (`tel-woorden`) wordt elke stap uitgevoerd op een nieuwe versie van de lijst. Het was wel wennen om `cons` te gebruiken als ik data wil toevoegen aan een lijst en zou het steeds vergeten als ik data wou toevoegen. 


#### Recursie

Recursie is belangrijk voor mijn programma, omdat het voorkomt in bijna al mijn functies. Omdat Clojure geen traditionele `for` of `while` heeft, moest ik herhaling oplossen met functies die zichzelf opnieuw aanroepen.
Voorbeelden:

* `tel-woorden` – telt woorden door zichzelf opnieuw aan te roepen met `(rest lijst)`.
* `voeg-op-plek` – zoekt recursief naar de juiste plek om een element in te voegen.
* `print-lijst` – print recursief elk element van de lijst.

Ik merkte dat recursie in combinatie met linked lists heel natuurlijk aanvoelt. Omdat een lijst uit een “kop” en “rest” bestaat, is het logisch om bij elke stap alleen naar de rest te kijken en de functie opnieuw aan te roepen. Het was wel nog steeds lastig in het begin en ook bij het implementeren van het sorteeralgoritme. Ik moest eerst op papier schrijven en tekenen hoe ik van plan was het uberhaupt uit te programmeren. Vooral bij functies zoals voeg-op-plek moest ik goed nadenken over hoe de recursie precies zou verlopen. wanneer moet een element ingevoegd worden, wat gebeurt er als de lijst leeg is en hoe geef ik de rest van de lijst correct mee?


#### Linked Lists en datarepresentatie

Wat ik niet wist was dat Clojure standaard linked lists gebruikt.
Functies zoals `first` en `rest` werken in O(1), maar toegang tot een element op index 5 kost O(n). Daarom is recursie efficiënter dan index-gebaseerde loops.

Bijvoorbeeld:

```clojure
(first '(1 2 3)) ;; 1
(rest '(1 2 3))  ;; (2 3)
```

Ook `cons` past goed bij deze structuur omdat het een element vooraan toevoegt, wat bij linked lists heel fijn is.


#### Higher-order functions

In mijn project heb ik dit toegepast door een aparte functie te maken die een andere functie uitvoert op een hele lijst. In dit voorbeeld krijgt `doe-iets-met-lijst` een functie (`functie`) en een lijst mee, en past die functie toe op elk element van de lijst:

```clojure
(defn doe-iets-met-lijst [functie lijst]
  (run! functie lijst))
```

In de `-main` functie roep ik dit dan zo aan:

```clojure
(doe-iets-met-lijst println gesorteerd)
```

Hier geef ik `println` mee als parameter. Dat betekent dat `doe-iets-met-lijst` zelf niet weet wat hij moet doen met elk element — dat gedrag wordt pas bepaald op het moment dat je de functie aanroept.

Zo gebruik ik dus higher-order functions om mijn code dynamischer en herbruikbaarder te maken. Als ik in plaats van `println` bijvoorbeeld een andere functie meegeef (zoals eentje die de woorden in hoofdletters zet), zou de hele functionaliteit veranderen zonder dat ik `doe-iets-met-lijst` hoef aan te passen.

#### Proces
Ik begon dit project niet meteen met het bouwen van het uiteindelijke programma, maar eerst met kleine oefenbestanden om de taal beter te begrijpen. Ik maakte bijvoorbeeld een bestand om alleen te printen (`printen.clj`), één om te oefenen met functies en parameters (`functies.clj`), één om te leren hoe vectors en lijsten werken (`arrays.clj`), en één om recursie te oefenen (`recursive.clj`). Door deze kleine stappen kon ik de basis van Clojure beter begrijpen voordat ik aan het grotere project begon.

In het begin vond ik het vooral lastig dat Clojure er heel anders uitziet dan talen zoals Java of JavaScript. Alles staat tussen haakjes en de functie komt altijd als eerste, gevolgd door de parameters. Ook dat je parameters niet tussen haakjes zet maar gewoon achter elkaar schrijft, was even wennen. Bijvoorbeeld:

```clojure
(defn optellen [a b]
  (+ a b))

(optellen 3 5) ;; 8
```

Daarnaast moest ik wennen aan de prefixnotatie: de operator staat vooraan in plaats van tussen de waarden. In plaats van `3 + 5` schrijf je `( + 3 5 )`. Dit was wel wat lastiger dan hoe in het java kan. Vooral bij sommen zoals dit `(+ (* 2 3) 5)`. Ook vond ik het raar hoe je variabels maakt binnen functies. je moet ze binnen haakjes maken en ze alleen beschikbaar binnen die haakjes, dus dat was ook nieuw. 

Met de oefenbestanden kon ik een goed oefenen hoe clojure werkt en een goede basis leggen.

Toen ik begon met het echte programma begon ik met het kunnen uitlezen van het tekstbestand. Er was al een resource folder aangemaakt in het project dus ik had daar mijn tekstbestand in gestopt. Het uitlezen van een bestand doe je met `slurp`. Een ingebouwde functie van clojure die een bestand uit leest. Daarna begon ik om van het tekstbestand de woorden op te splitsen en in een array te stoppen. Ik had ook besloten om eerst alle worden om te zetten naar lower case zodat ik alleen controleer op de woorden straks en niet op of het een grote of kleine letter is. Ik heb hiervoor een library van clojure moeten importeren om te filteren met strings. 

Hierna begon ik aan het tellen van hoe vaak elk woord voorkomt. Dit deed ik met de functie `tel-woorden`, waarin ik recursie gebruikte in plaats van loops. Deze functie doorloopt de lijst van woorden en gebruikt `zoek-woord` en `voeg-toe-of-update` om de frequentie bij te houden. Dit is een voorbeeld van immutability, omdat de oorspronkelijke lijst niet wordt aangepast, maar er telkens een nieuwe lijst met bijgewerkte waarden wordt gemaakt. Ik vond dit wel lastig en vooral met het bijhouden van al die haakjes en het maken van nieuwe lijsten als ik data wou aanpassen. 

Clojure gebruikt standaard een linked list-structuur voor lijsten. Elke lijst bestaat uit een element en een verwijzing naar de rest van de lijst. Dit betekent dat functies zoals first en rest heel efficiënt zijn (O(1)). Daarom is werken met recursie en cons ideaal in Clojure, omdat je dan steeds met de kop en staart van de lijst werkt in plaats van indexen te gebruiken zoals in arrays. In mijn recursieve functies waarin ik werk met lijsten roep ik dezelfde functie aan met de lijst en `rest` wat de lijst meegeeft behalve het eerste item. Ik vond het fijn om te werken met een linked list omdat ik er nog mee wou oefenen, sinds ik er alleen mee had kunnen oefenen tijdens de lessen bij APP. Het is wel wennen, maar ook fijn voor als je het gebruikt bij recursieve functies.

Vervolgens wilde ik dat de resultaten gesorteerd werden van hoog naar laag. Hiervoor schreef ik een eigen sorteeralgoritme met de functies voeg-op-plek en sorteer-lijst. Dit algoritme werkt op een vergelijkbare manier als insertion sort. Elk element wordt op de juiste plek in een al gesorteerde lijst ingevoegd. Het voordeel hiervan is dat de implementatie relatief simpel is met recursie en goed past bij linked lists. Het nadeel is dat de tijdcomplexiteit O(n²) is, wat minder efficiënt is bij heel grote datasets. 

Ten slotte schreef ik `print-lijst` om de resultaten één voor één uit te printen. Ook dit gebeurde recursief.



Wat ik vooral lastig vond aan functioneel programmeren was dat het anders was zoals bij Java en JS. het leren van die talen ging makkelijker, omdat sommige concepten op elkaar leken. Hier moest ik anders over nadenken en vooral met het retourneren van waarden en het maken van loops. De code is uiteindelijk wel overzichtelijker geworden nu ik begrijp wat alle onderdelen betekenen, maar het aanleren van deze manier van programmeren vond ik wel moeilijker dan bij talen zoals JavaScript.


Het meest uitdagende onderdeel was het schrijven van de functies voor het tellen en sorteren van woorden zonder ingebouwde functies zoals `assoc` of `sort`. Ik moest alles zelf bouwen, zoals een functie die een waarde toevoegt aan een lijst of een functie die de juiste plek voor een element zoekt bij het sorteren.



## Conclusie
In deze opdracht heb ik een tekstanalyseprogramma gebouwd dat woorden uit een tekstbestand telt, hun frequentie bijhoudt, de resultaten sorteert en ze uiteindelijk gesorteerd uitprint. Daarbij heb ik alle belangrijke functionele concepten toegepast: zuivere functies, immutability, recursie en higher-order functions.

Het was in het begin lastig om op een functionele manier te denken, vooral omdat ik gewend was aan talen zoals Java en JavaScript. Het werken met recursie in plaats van loops en het steeds opnieuw creëren van nieuwe lijsten in plaats van bestaande data te veranderen, was een grote verandering. Toch heeft dit project me geholpen om die manier van denken te begrijpen. Recursief programmeren voelt nu veel natuurlijker aan, en ik merk dat ik beter kan nadenken over de logica van mijn programma voordat ik begin met coderen. Het vooraf uitdenken van algoritmes in mijn hoofd helpt me nu veel meer bij het schrijven van duidelijke en werkende oplossingen.



## Bronnen

1. Cassel, C. (2023, 14 november). *Clojure MSI Release v1.12.2.1565*. GitHub. Geraadpleegd op 22 September 2025, van [https://github.com/casselc/clj-msi/releases/tag/v1.12.2.1565](https://github.com/casselc/clj-msi/releases/tag/v1.12.2.1565)
2. Kimh. (z.j.). *Clojure by Example*. Geraadpleegd op 22 September 2025, van [https://kimh.github.io/clojure-by-example/#about-this-page](https://kimh.github.io/clojure-by-example/#about-this-page)
3. Clojuredocs. (z.j.). *ClojureDocs*. Geraadpleegd op 22 September 2025, van [https://clojuredocs.org/](https://clojuredocs.org/)
4. (2021, 12 maart). *YouTube-video over Clojure fundamentals* [Video]. YouTube. Geraadpleegd op 22 September 2025, van [https://youtu.be/ciGyHkDuPAE?si=KRbRVXH7GHFNMDte](https://youtu.be/ciGyHkDuPAE?si=KRbRVXH7GHFNMDte)
5. AIM CNI. (z.j.). *Clojure Tutorial*. Geraadpleegd op 22 September 2025, van [https://aim-cni.github.io/app/docs/Paradigma%20challenge/opdracht_functioneel_programmeren#tekstanalyse](https://aim-cni.github.io/app/docs/Paradigma%20challenge/opdracht_functioneel_programmeren#tekstanalyse)
6. AIM CNI. (z.j.). *Lesprogramma – Week 2, les 1*. Geraadpleegd op 25 september 2025, van [https://aim-cni.github.io/app/docs/Week%202/Les%201/Lesprogramma](https://aim-cni.github.io/app/docs/Week%202/Les%201/Lesprogramma)
7. Wikipedia. (z.j.). *Insertion sort*. Geraadpleegd op 1 oktober 2025, van [https://en.wikipedia.org/wiki/Insertion_sort](https://en.wikipedia.org/wiki/Insertion_sort)
8. AIM CNI. (z.j.). *Lesprogramma – Week 2, les 3*. Geraadpleegd op 25 september 2025, van [https://aim-cni.github.io/app/docs/Week%202/Les%203/Lesprogramma](https://aim-cni.github.io/app/docs/Week%202/Les%203/Lesprogramma)

9. AIM CNI. (z.j.). *Lesprogramma – Week 1, les 3*. Geraadpleegd op 25 september 2025, van [https://aim-cni.github.io/app/docs/Week%201/Les%203/Lesprogramma](https://aim-cni.github.io/app/docs/Week%201/Les%203/Lesprogramma) 

10.OpenAI. (2025, 1 september). *ChatGPT. Antwoord op vrag welke taal beste is voor de tekstanalyse opdracht*. ChatGPT. https://chatgpt.com/share/68dfca78-c66c-800e-b9b7-941b0a178368

11.Moldstud. (z.j.). *What is Clojure and why is it popular among developers*. Geraadpleegd op 9 september 2025, van [https://moldstud.com/articles/p-what-is-clojure-and-why-is-it-popular-among-developers](https://moldstud.com/articles/p-what-is-clojure-and-why-is-it-popular-among-developers)
12.The Knowledge Academy. (z.j.). *What is Clojure?*. Geraadpleegd op 9 september 2025, van [https://www.theknowledgeacademy.com/blog/what-is-clojure/](https://www.theknowledgeacademy.com/blog/what-is-clojure/)


### AI
Voor sommige informatie die ik niet wist die ik niet makkelijk kon vinden heb ik gebruik gemaakt van AI. Ik maakte gebruik van `duck.ai`. De vragen die ik stelde waren meestal over de concepten zoals, wat is pattern matching en vooral theorie. Ik vroeg nooit om code stukken behalve in de beginfase toen ik nog ging oefenen met clojure. Ik zou vragen hoe functies eigenlijk werken en hoe je iets retourneert. Ik zou AI vragen voor opdrachten om te oefenen en zou ze dan maken en dan terugsturen zodat ik kon weten of het goed was. Tijdens het maken van de opdracht heb ik er geen gebruik van gemaakt. Voor het rapport heb ik er ook geen gebruik van gemaakt behalve voor het vragen of de spelling goed is. Sinds ik `duck.ai` heb gebruikt kan ik de chats niet delen en heb ik er geen toegang tot sinds ik geen account heb. Dit is achteraf gezien niet handig geweest, maar ik kan er nu tijdens het schrijven niet veel aandoen :( . Excuses