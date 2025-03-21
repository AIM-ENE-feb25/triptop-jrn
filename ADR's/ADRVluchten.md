# Architecture Decision Record (ADR)

## 1. Titel
**Integratie van de Skyscanner API voor Vluchtinformatie**

## 2. Context
Onze applicatie moet vluchtinformatie kunnen ophalen voor het plannen van reizen. Skyscanner API biedt uitgebreide vluchtdata. Alternatieven, zoals Kiwi.com of niet-publieke oplossingen zoals Google Flights, zijn minder geschikt voor onze toepassing.

## 3. Beslissing
Wij kiezen voor de Skyscanner API vanwege:
- **Uitgebreide data:** Betrouwbare en actuele vluchtinformatie.
- **Toegankelijkheid:** Eenvoudige integratie met de API.
- **Focus op reisdata:** Specifiek ontworpen voor vluchtzoekopdrachten.

## 4. Consequenties

### Voordelen:
- Kwalitatieve en gedetailleerde vluchtinformatie.
- Eenvoudige API-integratie binnen de Spring Boot applicatie.
- Ondersteuning voor meerdere datapunten zoals prijs en luchtvaartmaatschappij.

### Nadelen:
- Mogelijke beperkingen in verzoeken afhankelijk van het contract.
- Afhankelijkheid van externe data voor kritieke functionaliteit.

## 5. Alternatieven Overwogen

| Kenmerk                  | Skyscanner  | Kiwi.com | 
|--------------------------|-------------|----------|
| **Data Nauwkeurigheid**  | ++          | +        | 
| **Toegankelijkheid**     | ++          | +        | 
| **Documentatie**         | ++          | +        | 
| **Kosten/Kwota**         | +           | ?        |

## 6. Status
**Voorstel**

---

**Datum:** 21-03-2025  
**Auteur:** Jae Dreijling
