# Eten

## Status
> Voorgesteld

## Context
> Voor de TripTop applicatie is er een externi api nodig voor het vinden van bestellen van eten/drinken.

## ALternatieven

- Uber Eats Scraper API
- The Fork The Spoon
- Tripadvisor
- Restaurants
- Red Flower Business Data

| **Criteria**        | **Uber Eats Scraper API**                                                                | **The Fork The Spoon**                                      | **Tripadvisor**                                                                      | **Restaurants**                                   | **Red Flower Business Data**                                    |
|---------------------|------------------------------------------------------------------------------------------|-------------------------------------------------------------|--------------------------------------------------------------------------------------|---------------------------------------------------|-----------------------------------------------------------------|
| **Gebied**          | ++ Globaal, maar vooral gericht op bepaalde regio's                                      | ++ Globaal                                                  | ++ Globaal                                                                           | ++ Globaal                                        | ++ Globaal                                                      |
| **Bruikbaarheid**   | -- Biedt niet de mogelijkheden die wij nodig hebben voor de applicatie(geen mogelijkheid tot zoeken op locatie) | -- Geeft foutmelding bij het meegeven van de voorbeeld code | 0 Zeer uitgebreid. Je kan makkelijk een lijst aan restaurants krijgen via locationId | - Maakt geen gebruik van JSON                     | - Geeft lege arrays terug als je bepaalde locaties zoekt        |
| **Soorten**         | ++ Veel verschillende soorten restaurants, zoals fastfood, snackbars, cafés, fine dining | + Meer gericht op restaurants en specifieke eetgelegenheden | -- Beperkte soorten en vaak gefocust op grotere ketens                               | -- Beperkt tot algemene restaurant- of eetlocaties | + Diverse eetgelegenheden, met een focus op de lokale markten.  |

## Beslissing

> Voor de applicatie blijkt Tripadvisor het beste te zijn. TripAdvisor biedt de mogelijkheid om restaurants te vinden op basis van een megegeven locatie. Dit is nodig voor de applicatie. Tripdadvisor haalt alleen bekende restaurants op, maar dit is voldoende voor de applicatie de gebouwd wordt.

## Gevolgen

### Positieve gevolgen

- Bij het ophalen van een restaurant wordt veel informatie opgehaald. Hierdoor kan je de gebruiker extra informatie geven en zijn er veel opties voor filteren.
- TripAdviser haalt wereldwijd restaurants op. Zo kunnen over restaurant opties worden weergegeven.
- Betrouwbaarheid van gegevens. Tripadvisor heeft een 100% Service Level. Ook is Tripadvisor een bekend bedrijf waardoor je betrouwbare informatie kan verwachten.
- Tripadvisor biedt ook de mogelijkheid om vliegvelden, vluchten, autoverhuur en hotels. Hierdoor heb je eventueel geen andere API's hiervoor nodig.
### Negatieve gevolgen

- Bij het ophalen van een restaurant wordt veel informatie opgehaald. Deze informatie is vaak niet allemaal nodig waardoor je eigenlijk te veel gegevens ophaald.
- Voor het vinden van restaurants moet je een locationId meegeven. Hierdoor moet je twee GET requests doen. Eén voor het ophalen van de locationId en één voor het ophalen van de restaurants in die omgeving.
- Het is afhankelijk van een locationId. Hierdoor moet je precies weten waar de gebruiker wilt zoeken en kan je niet algemeen zoeken zoals een land of regio.


