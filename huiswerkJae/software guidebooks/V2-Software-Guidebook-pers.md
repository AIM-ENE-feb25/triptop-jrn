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
*Acceptatiecriteria: Integratie van real-time data van API’s zoals Google Maps en Navitia voor routeplanning en openbaar vervoer.*

#### 3.1.2 Reis boeken
Als gebruiker wil ik de samengestelde reis (of delen daarvan) kunnen boeken en betalen, zodat ik mijn reis zonder extra tussenkomst kan bevestigen.  
*Acceptatiecriteria: Betalingsverwerking via Stripe of alternatieve betalings-API’s en bevestigingsmail met boekingsdetails.*

#### 3.1.3 Reis cancelen
Als gebruiker wil ik een geboekte reis, of onderdelen daarvan, kunnen annuleren en een terugbetaling ontvangen, zonder tussenkomst van een derde partij.  
*Acceptatiecriteria: Mogelijkheid om boekingen te annuleren met automatische terugbetaling via de betalings-API.*

#### 3.1.4 Reisstatus bewaren
Als gebruiker wil ik mijn reisstatus kunnen opslaan zonder extra accountregistratie, zodat ik mijn reisvoortgang eenvoudig kan volgen.  
*Acceptatiecriteria: Gebruiksvriendelijke opslag van reisstatus en gemakkelijke toegang via unieke, tijdelijke sessies.*

#### 3.1.5 Bouwstenen flexibel uitbreiden
Als gebruiker wil ik extra bouwstenen kunnen toevoegen aan mijn reis (bijvoorbeeld aanvullende providers of hotels), zodat ik de reis volledig naar mijn wensen kan aanpassen.  
*Acceptatiecriteria: Een modulair systeem waarbij nieuwe bouwstenen eenvoudig kunnen worden geïntegreerd via API-koppelingen.*

### 3.2 Domain Stories
De domeinverhalen geven een overzicht van de reisboekingsprocessen, zowel in de huidige situatie (AS IS) als in de gewenste toekomstige situatie (TO BE).

#### 3.2.1 Domain Story Reis Boeken (AS IS)
![Domain Story Reis Boeken AS IS](../opdracht-diagrammen/reis-boeken-asis-coursegrained_2024-06-11.egn.svg)

#### 3.2.2 Domain Story Reis Boeken (TO BE)
![Domain Story Reis Boeken TO BE](../opdracht-diagrammen/reis-boeken-tobe-coursegrained_2024-06-11.egn.svg)

### 3.3 Domain Model
![Domain Model](../opdracht-diagrammen/Domain%20Model.png)

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
- **Juridisch:** Voldoen aan gegevensbescherming (GDPR) en privacyregels, met name bij het gebruik van externe API’s zoals Google Maps en Firebase.
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

### 7.1 Containers
Triptop bestaat uit de volgende containers:
- **Web Client:** Gebruikersinterface (React, Angular, of Vue).
- **API Gateway:** Centrale routering en authenticatie.
- **Backend Services:** Microservices voor reisplanning, boeking, betalingsverwerking en gebruikersbeheer.
- **Externe API Integraties:** Modules die verbinding maken met externe services zoals Google Maps, Stripe, Navitia, etc.

*Zie het bijgevoegde Container Diagram en dynamische scenario-diagrammen voor meer details.*

### 7.2 Components
Elke container is verder opgedeeld in componenten:
- **Frontend Components:** UI modules, formulieren, en dataweergave.
- **Backend Components:** Reisplanner, boekingsbeheer, betalingsafhandeling, en notificaties.
- **Integratie Modules:** Specifieke componenten voor het koppelen van externe API’s.  
  *Voorbeeld: Een module die Google Maps aanroept voor locatiegegevens, en een andere die Stripe gebruikt voor betalingsverwerking.*

### 7.3 Design & Code
Per ontwerpvraag is een Class Diagram en Sequence Diagram opgesteld:
- **Class Diagram:** Geeft de structuur van de backend, inclusief entiteiten zoals Reis, Gebruiker, Boekingsdetails en Transacties.
- **Sequence Diagram:** Beschrijft scenario’s zoals ‘Reis plannen’ en ‘Reis boeken’, inclusief interacties met externe API’s en interne services.

*Zie bijgevoegde diagrammen voor een gedetailleerde uitleg.*

---

## 8. Architectural Decision Records

### 8.1. ADR-001: Keuze voor Stripe API voor Betalingsverwerking
#### Context
Er was behoefte aan een betrouwbare, flexibele betalingsoplossing die meerdere betaalmethoden ondersteunt en een robuuste documentatie biedt.
#### Considered Options
- **Stripe API:** Uitstekende documentatie, flexibele integratie, maar hogere transactiekosten.
- **PayPal API:** Grotere consumentenbekendheid, maar minder flexibel in integratie.
#### Decision
We kiezen voor de Stripe API vanwege de uitgebreide ontwikkelaarsdocumentatie en de flexibiliteit in integratie.
#### Status
Accepted
#### Consequences
Verhoogde ontwikkelsnelheid, maar de transactiekosten moeten nauwlettend gemonitord worden.

### 8.2. ADR-002: Gebruik van Firebase Authentication voor Gebruikersauthenticatie
#### Context
Er is behoefte aan een snelle en veilige oplossing voor gebruikersregistratie en sociale login-integratie.
#### Considered Options
- **Firebase Authentication:** Snelle implementatie, uitgebreide SDK’s, afhankelijk van Google.
- **Auth0:** Meer flexibiliteit, maar complexer en mogelijk kostbaarder.
#### Decision
Firebase Authentication wordt gekozen voor snelle implementatie en goede integratie binnen het Google-ecosysteem.
#### Status
Accepted
#### Consequences
Afhankelijkheid van Google-infrastructuur, maar snelle implementatie en betrouwbare authenticatie.

### 8.3. ADR-003: Integratie van Externe API’s via een API Gateway
#### Context
Het is noodzakelijk om een uniforme toegang tot alle externe API’s te bieden.
#### Considered Options
- Directe integratie in elke service versus een centrale API Gateway.
#### Decision
Een centrale API Gateway wordt geïmplementeerd om consistentie, beveiliging en monitoring van alle API-aanroepen te waarborgen.
#### Status
Accepted
#### Consequences
Makkelijker beheer van API-aanroepen, maar extra complexiteit in de infrastructuur.

---

## 9. Deployment, Operation and Support

### 9.1 Deployment
- **CI/CD Pipeline:** Automatische tests en deployments via tools zoals Jenkins, GitLab CI of GitHub Actions.
- **Containerisatie:** Gebruik van Docker en Kubernetes voor schaalbare en betrouwbare deployments.
- **Configuratiebeheer:** Gebruik van Infrastructure as Code (IaC) tools zoals Terraform of Ansible.

### 9.2 Operation
- **Monitoring en Logging:** Integratie van tools als Prometheus, Grafana en ELK-stack voor continue monitoring en loganalyse.
- **Foutafhandeling:** Implementatie van circuit breakers en fallback-mechanismen voor externe API’s.

### 9.3 Support
- **Ondersteuningsplan:** Documentatie van incident-respons procedures, contactkanalen en updatecycli.
- **Onderhoud:** Regelmatige updates en beveiligingspatches worden ingepland volgens een vastgesteld onderhoudsproces.

---
