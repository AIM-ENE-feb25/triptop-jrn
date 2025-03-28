# API Gateway

## Status

> Voorstel

## Context

> Omdat er met meerdere externe APIs (zoals Booking.com en TripAdvisor) wordt gecommuniceert, is het belangrijk om een consistente en veilige manier te hebben om authenticatie en autorisatie toe te passen. Elke API past dit op zijn eigen manier toe (bijvoorbeeld API key, secret, of wachtwoord), waardoor dit ingewikkeld is.

## Beslissing

> We kiezen ervoor om een API Gateway te gebruiken. De API Gateway zal verantwoordelijk zijn voor:
> 
- Het centraliseren van authenticatie en autorisatie.
- Het gelijkmaken van API-aanroepen ongeacht de verschillen tussen de externe APIs.

## Alternatieven

| Criteria                 | API Gateway | Directe API-aanroepen | Switch-Case Statement |
|--------------------------|------------|----------------------|-----------------------|
| Consistente security     | ++         | --                   | +                     |
| Beheerbaarheid           | ++         | --                   | +                     |
| Flexibiliteit            | ++         | --                   | +                     |
| Complexiteit             | -          | ++                   | 0                     |

## Gevolgen

### Voordelen

- **Eenvoudiger beheer:** Authenticatie en autorisatie worden op één centrale plek afgehandeld.
- **Schaalbaarheid:** Het systeem kan makkelijker worden uitgebreid met nieuwe externe APIs zonder aanpassingen.

### Nadelen

- **Single point of failure:** Als de API Gateway werkt, werkt de rest ook niet.
- **Complexiteit:** Door een API Gateway toe te voegen heb je extra code waarmee je rekening moet houden.
