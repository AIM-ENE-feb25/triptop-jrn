
# Architectuurbeslissing (ADR): TransportProviderSelector in plaats van een Hardcoded Switch

## Status
**Voorgesteld**


## Context
Om een flexibele en uitbreidbare architectuur te waarborgen, willen we niet hardcoded bepalen welke transportprovider wordt gebruikt. Dit zou de code inflexibel maken en aanpassingen tijdrovend.

## Beslissing
We implementeren een **TransportProviderSelector**, een centrale klasse die bepaalt welke transportprovider wordt gebruikt op basis van beschikbaarheid en prestaties. Dit wordt dynamisch beheerd via configuratie en health checks.

## Alternatieven Overwogen
### 1. Hardcoded switch statements in de businesslogica
- ❌ Vereist codewijzigingen bij elke nieuwe transportprovider.
- ❌ Geen flexibiliteit bij provider-uitval.

### 2. Dynamisch configuratiebestand zonder selector
- ✅ Flexibel, maar vereist nog handmatige updates.
- ❌ Geen automatische fallback bij provider-uitval.

## Gevolgen
✅ **Voordelen**:
- **Flexibel beheer van transportproviders.**
- **Makkelijk uitbreidbaar zonder codewijzigingen.**
- **Automatische fallback bij provider-uitval.**

⚠️ **Aandachtspunten**:
- **Noodzaak voor real-time monitoring van providerbeschikbaarheid.**
- **Kan extra configuratiecomplexiteit toevoegen.**


