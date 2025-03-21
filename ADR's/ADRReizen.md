# Architecture Decision Record (ADR)

## 1. Titel
**Routeplanning: Vergelijking tussen Navitia en Google Maps**

## 2. Status
**Voorstel**

## 3. Context
Voor de routeplanning in onze applicatie is het noodzakelijk om gebruikers meerdere reismogelijkheden te bieden (zoals auto, openbaar vervoer, fietsen en wandelen). Er zijn twee hoofdopties overwogen:

- **Google Maps API (specifiek de Google Directions API / Routes API):**  
  Bekend om zijn uitgebreide wereldwijde dekking, hoge nauwkeurigheid en uitgebreide documentatie, maar met hogere kosten bij intensief gebruik. Deze API biedt gedetailleerde routeinformatie voor verschillende vervoerswijzen, met name gericht op auto en openbaar vervoer.

- **Navitia API:**  
  Een open platform dat zich richt op multi-modale reisdata, vaak tegen lagere kosten (inclusief een gratis tier) maar met een mogelijk beperkter dekkingsgebied en minder gedetailleerde wereldwijde data.

## 4. Beslissing
Wij kiezen voor de integratie van **Navitia API** als primaire routeplanner, met de mogelijkheid om de **Google Directions API / Routes API** als fallback of aanvullende bron te gebruiken indien er specifieke, wereldwijde data nodig is. Deze beslissing is gebaseerd op de volgende overwegingen:

- **Kosten:** Navitia biedt een aantrekkelijk gratis tier en lagere instapkosten, wat ideaal is voor de initiële ontwikkelfase.
- **Multi-modale routeplanning:** Navitia is specifiek ontworpen voor routes met meerdere vervoerswijzen, wat aansluit bij onze functionele eisen.
- **Uitbreidbaarheid:** Indien we later internationale of zeer gedetailleerde route-informatie nodig hebben, kan de Google Directions API als aanvullende service worden geïntegreerd.

## 5. Consequenties

### Voordelen:
- **Navitia:**
  - Kostenefficiënt voor laag tot matig gebruik.
  - Uitstekende ondersteuning voor multi-modale routes.
  - Flexibele integratie met een duidelijke focus op openbaar vervoer en lokale routes.

- **Google Directions API / Routes API (als fallback):**
  - Hoogwaardige en nauwkeurige data met wereldwijde dekking.
  - Uitgebreide documentatie en ondersteuning.

### Nadelen:
- **Navitia:**
  - Beperkte wereldwijde dekking vergeleken met Google Maps.
  - Mogelijk minder gedetailleerde data in sommige regio’s.

- **Google Directions API / Routes API:**
  - Hogere kosten bij intensief gebruik.
  - Complexere prijsstructuur en quota-beperkingen.

## 6. Alternatieven Overwogen

| Kenmerk                         | Navitia                                                          | Google  Routes API                                                                                  |
|---------------------------------|------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| **Kosten**                      | Laag/Gratis tier                                                 | Duurder (betaal per gebruik)                                                                        |
| **Multi-modale routeplanning**  | Uitstekend, specifiek gericht op openbaar vervoer, fietsen, etc. | Ondersteuning voor auto en openbaar vervoer, maar minder gespecialiseerd in multi-modale integratie |
| **Wereldwijde dekking**         | Regionaal sterk, maar beperkt buiten Europa                      | Uitgebreide wereldwijde dekking                                                                     |
| **Nauwkeurigheid en details**   | Goed, met focus op openbaar vervoer                              | Zeer gedetailleerd en accuraat                                                                      |
| **Documentatie & Support**      | Voldoende, maar minder uitgebreid dan Google Maps                | Uitgebreide en robuuste documentatie en ondersteuning                                               |



---

**Datum:** 21-03-2025  
**Auteur:** Jae Dreijling
