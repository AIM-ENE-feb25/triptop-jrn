## 1. Titel
**Het makkelijk uitbreiden van de applicatie met nieuwe externe API's**

## 2. Status
**`Voorstel`**

## 3. Context
Momenteel werkt de applicatie met verschillende externe API's. In de toekomst is het mogelijk dat er nieuwe of andere API's moeten worden geïntegreerd om de applicatie verder uit te breiden en goed te onderhouden. Op dit moment is er geen eenduidige en eenvoudige manier om nieuwe API's toe te voegen of bestaande te wisselen zonder de bestaande code te veel aan te passen.

## 4. Beslissing
We hebben besloten om het hexagonaal ontwerp te gebruiken binnen de applicatie. Dit betekent dat we **ports en adapters** zullen gebruiken om externe API's makkelijk en snel te integreren.

Door abstractie toe te passen, kunnen we een **open/closed** codebase behouden. Dit stelt ons in staat om API's toe te voegen of te wijzigen zonder de bestaande code te hoeven aanpassen. Nieuwe functionaliteiten of API's vereisen enkel een nieuwe **port** en **adapter** om snel en eenvoudig werkend te zijn. Afhankelijk van de nieuwe functionaliteit kan het nodig zijn om een nieuwe **Controller** en **Service** te creëren.

## 5. Alternatieven overwogen
Tijdens de zoektocht naar een oplossing hebben we de volgende alternatieven overwogen:

**1. Hexagonaal ontwerp (Ports en Adapters)**  
Het gebruik van ports en adapters waarbij we een interface implementeren die de manier waarop de service de data ontvangt garandeert, en de adapter zorgt voor het omzetten van de data naar een leesbaar formaat voor de service.

**2. Switch-case voor afhandeling data abstractie**  
Binnen de service wordt een switch-case gebruikt om alle inkomende datatypes per API te verwerken. De code wordt geformatteerd naar een voor de frontend bruikbare vorm binnen de switch-case.

**3. Facade door API-Gateway**  
Eén centrale plek waar alle API-calls worden afgehandeld en de data wordt omgezet naar de DTO's die de service verwacht.

**De opties zijn bekeken en hieruit is de volgende tabel gekomen:**

| **Optie**                                                       | **Impact op onderhoudbaarheid** | **Impact op testbaarheid** | **Impact op schaalbaarheid** | **Impact op leesbaarheid** | **Impact op Betrouwbaarheid** |
|-----------------------------------------------------------------|--------------------------------|----------------------------|------------------------------|----------------------------|-------------------------------|
| **1. Hexagonaal ontwerp (Ports en Adapters)**                   | ++                             | ++                         | ++                           | -                          | ++                            |
| **2. Gebruik van een switch-case voor verschillende datatypes** | -                              | -                          | -                            | +                          | -                             |
| **3. Facade Door API-Gateway**                                  | -                              | +                          | -                            | +                          | ++                            |

### **Hexagonaal ontwerp (Ports en Adapters)**

**Voordelen:**
- Het maakt de code **open/closed** en uitbreidbaar.
- Goede **Separation of Concerns**, waardoor de code beter georganiseerd is.
- Door **programming for an interface** kan de service makkelijk met nieuwe API's communiceren.

**Nadelen:**
- Door de abstractie kan de code moeilijker leesbaar zijn, vooral voor ontwikkelaars die minder bekend zijn met dit ontwerp.
- Er is een steilere leercurve dan bij eenvoudigere oplossingen, zoals de switch-case.

### **Switch-case voor afhandeling data abstractie**

**Voordelen:**
- **Leesbaarheid** is beter omdat alle logica op één plek staat.

**Nadelen:**
- **Schaalbaarheid** is beperkt. Voor elke API moet er een nieuwe switch-case worden toegevoegd.
- De switch-cases kunnen erg groot worden voor grotere API's.
- De service wordt verantwoordelijk voor te veel taken, wat **Separation of Concerns** schendt.

### **API-GateWay**

**Voordelen:**
- Eén plek waar alle API-calls worden afgehandeld
- Goed overzicht van welke api's er allemaal aangeroepen worden.

**Nadelen:**
- Niet open/closed
- Is verantwoordelijk  voor alle datavervorming uit alle api's. geen **Separation of Concerns**.
- Veel bloatcode

## 6. Onderbouwing
De keuze voor het **hexagonaal ontwerp** levert de beste resultaten op het gebied van onderhoudbaarheid, testbaarheid en schaalbaarheid. Het gebruik van abstractie en het ontwerpen op basis van interfaces maakt het mogelijk om de code uit te breiden zonder bestaande functionaliteiten te breken. Dit ondersteunt drie belangrijke principes uit SOLID: **Separation of Concerns**, **Open/Closed principle** en **Programming for an Interface**.

Hoewel het gebruik van een hexagonaal ontwerp een hogere leercurve met zich meebrengt, is de lange termijnwinst veel groter dan de korte termijnkosten. De tijd die nodig is om deze architectuur te begrijpen en toe te passen is verwaarloosbaar in vergelijking met de tijd die verloren zou gaan door het onderhoud van complexe switch-cases en de risico's van fouten bij wijzigingen.

Hoewel een API Gateway een goed alternatief leek, hebben we ervoor gekozen om het adapter pattern te gebruiken vanwege het gebrek aan Separation of Concerns en de hoeveelheid extra code die een API Gateway met zich meebrengt.
Door interfaces te gebruiken, verbeteren we de **testbaarheid** aanzienlijk: voor elke nieuwe API hoeft alleen de implementatie van de interface getest te worden, niet de hele structuur.