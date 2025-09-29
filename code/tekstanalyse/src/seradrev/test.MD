Hier zijn **uitgebreide notities en uitleg** van de video, duidelijk gestructureerd zodat je een goed overzicht hebt:

---

## 1. Wat is Software Architecture?

* **Definitie (SEI – Software Engineering Institute):**
  *“De softwarearchitectuur van een systeem is een set structuren die nodig zijn om over het systeem te redeneren, bestaande uit software-elementen, de relaties daartussen en hun eigenschappen.”*
* Belangrijk: architectuur is een **deelverzameling van softwaredesign**, gericht op de *essentiële keuzes* die direct te maken hebben met risico’s en mogelijke fouten.

---

## 2. Relatie tussen **Software Design** en **Architecture**

* **Software design:** alle details die nodig zijn om het volledige systeem te bouwen.
* **Software architecture:** subset van die details – enkel die keuzes die direct verband houden met het vermijden of beheersen van risico’s.

---

## 3. Waarom niet *alles* ontwerpen of alle fouten voorkomen?

Er zijn drie beperkingen:

1. **Complexiteit:** software is te groot/complex om volledig te begrijpen.
2. **Beperkte tijd:** je kunt niet alles uitwerken of alle scenario’s doorlopen.
3. **Onmogelijkheid:** je kunt simpelweg niet elke mogelijke fout voorspellen (crashes, slechte output, performanceproblemen, enz.).

---

## 4. De rol van **Modellen**

* Oplossing: gebruik een **model** dat de werkelijkheid vereenvoudigt.
* Dit is in andere ingenieursdisciplines normaal (bruggenbouw, vliegtuigontwerp, etc.), maar in software vaak ongewoon.
* Het model richt zich enkel op de **belangrijkste risico’s** (niet op alle details).
* Je kiest dus:

  * Welke risico’s relevant zijn voor jouw systeem.
  * Welke details nodig zijn om die risico’s te begrijpen en vermijden.

### Voorbeelden:

* **Websoftware:** risico’s zoals *security* en *verkeerspieken* → model focust hierop.
* **Embedded software (thermostaat):** risico’s zoals *geheugenlekken* en *hardwareportabiliteit* → model richt zich daarop.

---

## 5. Wat maakt een detail “architecturaal”?

* Een **detail is architecturaal als en alleen als** het te herleiden is tot het vermijden van een risico.
* Details die nodig zijn om de code te schrijven maar niet helpen bij het begrijpen van risico’s = **niet-architecturaal**.
* Voorbeeld:

  * **Architecturaal:** keuze voor *load balancer* om verkeerpieken op te vangen.
  * **Niet-architecturaal:** kleur van de knoppen in de UI.

---

## 6. Kern van Software Architecture

* **Architect = modelbouwer** → bouwt modellen van het systeem.
* Het model helpt je:

  1. Redeneren over risico’s.
  2. Kwetsbare ontwerpen uitsluiten.
  3. Bewuste keuzes maken die succes van het systeem bevorderen.

---

## 7. Samenvatting: Verschil tussen Architecture en Design

* **Design = alles.**
* **Architecture = enkel die designkeuzes die helpen bij het vermijden/beheersen van risico’s.**
* Een ontwerpkeuze is *architecturaal* als het direct verband houdt met het minimaliseren van risico’s (performance, security, reliability, enz.).

---

## 8. Conclusie

* **Software Architecture** = het maken van **modellen** die gericht zijn op risico’s en mogelijke faalpunten van een systeem.
* **Software Design** = alle details om het systeem te bouwen.
* Het onderscheid: **architectuur gaat om essentiële keuzes die het succes of falen van het systeem bepalen.**
* Architectuur = *selectie van cruciale ontwerpdetails die terug te voeren zijn op risico’s*.

---

Wil je dat ik dit in een **compact schema** zet (verschillen, voorbeelden, kernpunten) zodat je het in één oogopslag kunt leren, of wil je een **uitgebreide tekstsamenvatting** die je als naslag kunt bewaren?


### To Reason
Synoniemen: redeneren, analyseren, logisch nadenken, beredeneren.

Antoniemen: gokken, aannemen, blind uitvoeren, impulsief handelen.

Voorbeeld: Je redeneert: “Als ik geen caching toevoeg, gaat de site traag worden bij veel bezoekers.”