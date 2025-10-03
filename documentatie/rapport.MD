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
Ik heb voor deze opdracht gekozen om een tekstanalyseprogramma te maken, omdat dit een uitdaging is waarbij je veel belangrijke functionele concepten kunt toepassen. Vooral het werken met recursieve functies en het opbouwen van logica zonder loops leek me interessant.

De programmeertaal die ik heb gebruikt is Clojure. Dit is een moderne, functionele taal die draait op de Java Virtual Machine (JVM). Clojure is ontworpen met eenvoud, data-gericht denken en functionele zuiverheid als uitgangspunt. Hieronder beschrijf ik de belangrijkste functionele concepten en hoe die in Clojure werken en in mijn project zijn toegepast.

### Zuiverheid (pure functions)
In het tweede jaar van mijn studie heb ik geleerd wat pure functies zijn. Een pure functie is een functie die altijd dezelfde output geeft bij dezelfde input en geen bijwerkingen heeft. In Clojure is dit een centraal principe: functies veranderen geen globale variabelen, schrijven niets naar files en werken niet direct met externe toestand.

In mijn code zijn functies zoals `woorden`, `zoek-woord` en `voeg-toe-of-update`  zuiver. Ze nemen input (bijv. een lijst of een woord) en geven daar een nieuw resultaat voor terug, zonder iets anders te beïnvloeden. Dit zorgt ervoor dat de logica betrouwbaar is en makkelijk te testen. [Hier](../code/tekstanalyse/src/seradrev/pure.clj) is een bestand war ik mee ging oefenen om te oefenen met pure functies in clojure. Ik maakte een plus functie zoals we leerden in vorig jaar. Hier kon ik oefenen met de prefix notatie zoals we die leerden in de APP lessen. 

### First-Class Functions
First class functions betekent dat functies worden behandeld als gewonen waarden, zoals ints, strings en lijsten. Je kunt er mee doen wat je met andere waarden ook doet. Je kan:
- functie opslaan in een variabele
- functie als argument meegeven aan andere functie
- retourneren als resultaat van andere functie

In Clojure zijn functies first-class citizens. Dat betekent dat functies net als waarden behandeld worden: je kunt ze meegeven als argument, teruggeven als resultaat of opslaan in een datastructuur. Om er mee te oefenen heb ik een codebestand gemaakt waar ik een functie meegeef als parameter. Dat is [hier](./../code/tekstanalyse/src/seradrev/firstclass.clj) te vinden.

### Algoritmes:
 - Recursie
 - Higher-Order-Functions



## Bronnen
1.
https://github.com/casselc/clj-msi/releases/tag/v1.12.2.1565

2.
https://kimh.github.io/clojure-by-example/#about-this-page
