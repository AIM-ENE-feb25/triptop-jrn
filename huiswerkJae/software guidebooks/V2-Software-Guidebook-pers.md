# Software Guidebook Triptop

## 1. Introduction
Triptop is een innovatieve reisapplicatie die gebruikers in staat stelt hun reis volledig zelfstandig samen te stellen, boeken en beheren. Dit document geeft een overzicht van de applicatie, inclusief:
- Vereisten, beperkingen en principes
- Software-architectuur met hoog-niveau technologiekeuzes en structuur
- Ontwerp- en codebeslissingen
- Infrastructuurarchitectuur en installatie-instructies

Triptop richt zich op individuele reizigers en kleine reisorganisaties die flexibiliteit en gemak zoeken bij het plannen en boeken van reizen.

---

## 2. Context
Dit hoofdstuk beschrijft de context waarin Triptop opereert. Het bevat een overzicht van de belangrijkste functionaliteiten, de primaire gebruikers en de integratie met externe systemen.

### 2.1 System Context Diagram
![Context diagram Triptop algemeen](../../opdracht-diagrammen/ContextDiagram.puml)

**Toelichting:**
- **Functionaliteit:** Triptop biedt functies zoals reisplanning, boeking, annulering en statusbewaking.
- **Gebruikers:** De primaire gebruikers zijn individuele reizigers en kleine reisorganisaties.
- **Externe systemen:** De applicatie integreert met externe API’s (bijv. Google Maps, Stripe, Navitia, Yelp Fusion en Skyscanner) voor kaart- en locatiegegevens, betalingsverwerking, openbaar vervoer, restaurantinformatie en vliegticketvergelijking.

---

## 3. Functional Overview
Dit hoofdstuk beschrijft de kernfunctionaliteiten van Triptop aan de hand van user stories, domain stories en het domeinmodel.

### 3.1 User Stories

#### 3.1.1 Reis plannen
Als gebruiker wil ik een reis samenstellen op basis van diverse variabelen (duurzaamheid, budget, reistijden, etc.), zodat ik zonder tussenkomst van een reisbureau mijn perfecte vakantie kan samenstellen.  
*Concept Acceptatiecriteria: Integratie van real-time data van API’s zoals Google Maps/Navitia voor routeplanning en openbaar vervoer.*

#### 3.1.2 Reis boeken
Als gebruiker wil ik de samengestelde reis (of delen daarvan) kunnen boeken en betalen, zodat ik mijn reis zonder extra tussenkomst kan bevestigen.  
*ConceptAcceptatiecriteria: Betalingsverwerking via Stripe/paypal API en bevestigingsmail met boekingsdetails.*

#### 3.1.3 Reis cancelen
Als gebruiker wil ik een geboekte reis, of onderdelen daarvan, kunnen annuleren en een terugbetaling ontvangen, zonder tussenkomst van een derde partij.  
*ConceptAcceptatiecriteria: Mogelijkheid om boekingen te annuleren met automatische terugbetaling via de betalings-API.*

#### 3.1.4 Reisstatus bewaren
Als gebruiker wil ik mijn reisstatus kunnen opslaan zonder extra accountregistratie, zodat ik mijn reisvoortgang eenvoudig kan volgen.  
*Concept Acceptatiecriteria: Gebruiksvriendelijke opslag van reisstatus en gemakkelijke toegang via unieke, tijdelijke sessies.*

#### 3.1.5 Bouwstenen flexibel uitbreiden
Als gebruiker wil ik extra bouwstenen kunnen toevoegen aan mijn reis (bijvoorbeeld aanvullende providers of hotels), zodat ik de reis volledig naar mijn wensen kan aanpassen.  
*Concept Acceptatiecriteria: Een modulair systeem waarbij nieuwe bouwstenen eenvoudig kunnen worden geïntegreerd via API-koppelingen.*

### 3.2 Domain Stories
De domeinverhalen geven een overzicht van de reisboekingsprocessen, zowel in de huidige situatie (AS IS) als in de gewenste toekomstige situatie (TO BE).

#### 3.2.1 Domain Story Reis Boeken (AS IS)
![Domain Story Reis Boeken AS IS](../../opdracht-diagrammen/reis-boeken-asis-coursegrained_2024-06-11.egn.svg)

#### 3.2.2 Domain Story Reis Boeken (TO BE)
![Domain Story Reis Boeken TO BE](../../opdracht-diagrammen/reis-boeken-tobe-coursegrained_2024-06-11.egn.svg)

### 3.3 Domain Model
![Domain Model](../../opdracht-diagrammen/Domain%20Model.png)

---

## 4. Quality Attributes
De volgende ISO 25010 kwaliteitsattributen zijn als belangrijkste aangeduid:

- **Compatibility / Interoperability:** Systeemcomponenten kunnen informatie uitwisselen met externe API’s (Google Maps, Stripe, Navitia, etc.).
- **Reliability / Fault Tolerance:** Het systeem functioneert correct ondanks eventuele hardware- of softwarestoringen. Bijvoorbeeld: foutafhandeling en fallback-mechanismen bij API-uitval.
- **Maintainability / Modularity:** De software is opgebouwd uit discrete componenten, zodat wijzigingen in één onderdeel minimale impact hebben op andere onderdelen.
- **Maintainability / Modifiability:** Het systeem kan efficiënt aangepast worden zonder bestaande functionaliteit te breken.
- **Security / Integrity:** Gegevens en systeemstatus worden beschermd tegen ongeautoriseerde wijzigingen.
- **Security / Confidentiality:** Toegang tot gevoelige data is strikt beperkt tot geautoriseerde gebruikers. Compliance met GDPR en andere relevante regelgeving is gewaarborgd.

*Voorbeeld KPI: Routeaanvragen via Google Maps moeten binnen 2 seconden worden verwerkt.*

---

## 5. Constraints
De ontwikkeling en implementatie van Triptop kent de volgende beperkingen:
- **Budget:** Beperkingen voor API-kosten en infrastructuuruitgaven.
- **Performance:** Externe API-limieten en responstijden hebben invloed op de gebruikerservaring.
- **Juridisch:** Voldoen aan gegevensbescherming (GDPR(General Data protection Regulation)) en privacyregels, met name bij het gebruik van externe API’s zoals Google Maps en Firebase.
- **Technisch:** Afhankelijkheid van derde partijen voor real-time data en betalingsverwerking.

---

## 6. Principles
Triptop is gebaseerd op de volgende architecturale en design principes:
- **Modulariteit en herbruikbaarheid:** Gebruik van losse, goed gedefinieerde componenten.
- **Simplicity (KISS):** Eenvoudige en duidelijke oplossingen waar mogelijk.
- **Consistency en DRY (Don't Repeat Yourself):** Vermijden van duplicatie in code en ontwerp.
- **Veiligheid:** Ingebouwde beveiligingsmaatregelen voor authenticatie, autorisatie en dataprivacy.
- **Robuuste integratiepatronen:** Gebruik van circuit breakers en fallback-mechanismen voor externe API-integraties.

---

## 7. Software Architecture

###     7.1. Containers

> [!IMPORTANT]
> Voeg toe: Container Diagram plus een Dynamic Diagram van een aantal scenario's inclusief begeleidende tekst.

###     7.2. Components

> [!IMPORTANT]
> Voeg toe: Component Diagram plus een Dynamic Diagram van een aantal scenario's inclusief begeleidende tekst.

###     7.3. Design & Code

> [!IMPORTANT]
> Voeg toe: Per ontwerpvraag een Class Diagram plus een Sequence Diagram van een aantal scenario's inclusief begeleidende tekst.

---

## 8. Architectural Decision Records

### 8.1. ADR-001: Keuze API voor Betalingsverwerking (voorbeeld)
#### Context
Er was behoefte aan een betrouwbare, flexibele betalingsoplossing die meerdere betaalmethoden ondersteunt en een robuuste documentatie biedt.
#### Considered Options
- **Stripe API:** Uitstekende documentatie, flexibele integratie, maar hogere transactiekosten.
- **PayPal API:** Grotere consumentenbekendheid, maar minder flexibel in integratie.
#### Decision
Empty

#### Status
Open

#### Consequences
Verhoogde ontwikkelsnelheid, maar de transactiekosten moeten nauwlettend gemonitord worden.

### 8.5. ADR-005 TITLE

> [!TIP]
> These documents have names that are short noun phrases. For example, "ADR 1: Deployment on Ruby on Rails 3.0.10" or "ADR 9: LDAP for Multitenant Integration". The whole ADR should be one or two pages long. We will write each ADR as if it is a conversation with a future developer. This requires good writing style, with full sentences organized into paragraphs. Bullets are acceptable only for visual style, not as an excuse for writing sentence fragments. (Bullets kill people, even PowerPoint bullets.)

#### Context

> [!TIP]
> This section describes the forces at play, including technological, political, social, and project local. These forces are probably in tension, and should be called out as such. The language in this section is value-neutral. It is simply describing facts about the problem we're facing and points out factors to take into account or to weigh when making the final decision.

#### Considered Options

> [!TIP]
> This section describes the options that were considered, and gives some indication as to why the chosen option was selected.

#### Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

#### Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

#### Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

---

## 9. Deployment, Operation and Support
> [!TIP]
> Zelf beschrijven van wat je moet doen om de software te installeren en te kunnen runnen.
### 9.1 Deployment

### 9.2 Operation

### 9.3 Support

---
