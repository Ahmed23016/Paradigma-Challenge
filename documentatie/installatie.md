
# Installatie

## 1. Vereisten

Voor je aan de slag gaat met Clojure in Visual Studio Code, heb je het volgende nodig:

* **Java 17+** – Clojure draait op de JVM
* **Clojure CLI tools** – om `clj` en `clojure` commando’s te kunnen gebruiken :)
* **VS Code** – als editor
* **Calva** extensie – voor REPL, evaluatie en linting in VS Code

---

## 2. Installatie van Clojure CLI

### Windows / Linux / macOS

Download en installeer de Clojure CLI via de officiële site:
👉 [https://clojure.org/guides/getting_started](https://clojure.org/guides/getting_started)

Controleer daarna installatie

```bash
clj -M -e "(println (+ 1 2 3))"
```

Output hoort dit te zijn

```
6
```

---

## 3. VS Code instellen

1. Open **VS Code**
2. Ga naar **Extensions (Ctrl+Shift+X)**
3. Installeer **Calva** 

---

## 4. Nieuw Clojure-project aanmaken

### Stap 1 – Installeer `clj-new`

Om een nieuw project te genereren, moet je de tool **clj-new** installeren.

Gebruik deze veilige en up-to-date manier:

```bash
clojure -Ttools install-latest :lib com.github.seancorfield/clj-new :as clj-new
```

Dit installeert automatisch de nieuwste versie van `clj-new`.



### Stap 2 – Maak een nieuw project

Een projectnaam moet een geldige namespace zijn. Gebruik bijvoorbeeld je GitHub-naam of een meerdelige naam:

```bash
clojure -Tclj-new app :name seradrev/tekstanalyse
```

Dit maakt een projectstructuur aan:

```
tekstanalyse/
├─ deps.edn
├─ src/
│  └─ seradrev/
│     └─ tekstanalyse.clj
└─ test/
```

---

## 5. Project openen 
vanaf de root doe je het volgende
```bash
cd code/tekstanalyse
```

## 6. Programma uitvoeren

### Via command line (CLI)

Run je `-main` functie vanuit de terminal:

```bash
clojure -M -m seradrev.tekstanalyse 
```


