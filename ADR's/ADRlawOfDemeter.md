# Architectuurbeslissing (ADR): Law of Demeter en Modulaire Architectuur

## Status
**Voorgesteld**

## Context
Om een goed georganiseerde en onderhoudbare codebase te garanderen, hanteren we de **Law of Demeter (LoD)**. Deze ontwerpregel stelt dat een object alleen mag communiceren met directe afhankelijkheden en niet met diep geneste objecten.

## Beslissing
We implementeren **Facades en Dependency Injection** om LoD te handhaven. Dit houdt in dat:
- **Services niet direct communiceren met onderliggende implementaties** maar via interfaces werken.
- **Controllers alleen services aanroepen** en niet de interne methoden van meerdere klassen.
- **Een TransportProviderSelector** wordt gebruikt om afhankelijkheden te beheren in plaats van een directe afhankelijkheid van API’s.

## Alternatieven Overwogen
### 1. Directe afhankelijkheden tussen alle klassen
   - ❌ Vermindert modulariteit en testbaarheid.
   - ❌ Maakt toekomstige wijzigingen moeilijker te implementeren.

### 2. Strikte Layered Architecture zonder Dependency Injection
   - ✅ Helder gestructureerde lagen.
   - ❌ Vermindert flexibiliteit bij uitbreidingen.

## Gevolgen
✅ **Voordelen**:
- **Beter testbare code door minder afhankelijkheden.**
- **Makkelijker onderhoud en uitbreidbaarheid.**
- **Duidelijke scheiding tussen lagen en verantwoordelijkheden.**

⚠️ **Aandachtspunten**:
- **Kan leiden tot meer code (extra facades en interfaces).**
- **Performance-impact bij extreme abstractie.**
