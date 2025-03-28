# Architectuurbeslissing (ADR): Integratie van Externe Transport- en Vluchtservices

## Status
 **Voorgesteld**

## Context
TripTop maakt gebruik van externe APIs zoals Navitia, Google Maps en Skyscanner om transport- en vluchtgegevens te verkrijgen. Elke service biedt unieke functionaliteiten:
- **Navitia** levert openbaar vervoersinformatie.
- **Google Maps** biedt routeplanning en verkeersinformatie.
- **Skyscanner** voorziet in vluchtgegevens en prijzen.

Om een naadloze gebruikerservaring te bieden, is het essentieel om deze diverse services effectief te integreren zonder afhankelijk te zijn van hun specifieke implementaties.

## Beslissing
We implementeren een **TransportProviderSelector** die, op basis van het type transportaanvraag, de juiste externe service kiest:
- Voor lokaal openbaar vervoer wordt **Navitia** gebruikt.
- Voor routeplanning en verkeersinformatie wordt **Google Maps** ingezet.
- Voor vluchtinformatie en -boekingen wordt **Skyscanner** geraadpleegd.

Deze aanpak zorgt ervoor dat:
1. **Flexibiliteit**: Nieuwe transportproviders kunnen eenvoudig worden geïntegreerd door extra adapters te ontwikkelen die voldoen aan de **TransportProviderPort** interface.
2. **Onderhoudbaarheid**: Wijzigingen in een externe API vereisen alleen aanpassingen in de betreffende adapter, zonder impact op de kernapplicatie.
3. **Schaalbaarheid**: De applicatie kan eenvoudig uitbreiden naar nieuwe markten of regio's door lokale transportservices te integreren.

## Overwogen Alternatieven
### 1. Directe Integratie met Elke Externe Service
- ❌ **Nadelen**:
    - Strakke koppeling tussen de applicatie en externe services.
    - Hoge onderhoudskosten bij wijzigingen in externe APIs.
    - Beperkte flexibiliteit bij het toevoegen van nieuwe providers.

### 2. Gebruik van een Externe API-aggregator
- ❌ **Nadelen**:
    - Afhankelijkheid van een derde partij voor gegevensaggregatie.
    - Mogelijke beperkingen in functionaliteit en data-updates.
    - Kosten verbonden aan het gebruik van dergelijke aggregators.

## Gevolgen
✅ **Voordelen**:
- **Modulariteit**: Elke adapter fungeert als een zelfstandige module, wat het testen en onderhouden vergemakkelijkt.
- **Robuustheid**: Fouten of wijzigingen in een specifieke externe service beïnvloeden niet de gehele applicatie.
- **Gebruikerservaring**: Consistente en betrouwbare gegevenslevering door dynamische selectie van de meest geschikte provider.

⚠️ **Aandachtspunten**:
- **Complexiteit**: Extra logica is vereist voor het selecteren en beheren van meerdere adapters.
- **Monitoring**: Continue monitoring van de prestaties en beschikbaarheid van elke externe service is noodzakelijk om optimale functionaliteit te garanderen.


