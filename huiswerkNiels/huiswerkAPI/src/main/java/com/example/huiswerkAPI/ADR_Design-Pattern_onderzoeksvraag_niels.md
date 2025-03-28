# Design Pattern

## Status

> Voorstel

## Context

> Voor het vinden van de beste oplossing voor het consistent toepassen van authorisatie en authenticatie moet een design pattern bepaald worden.

## Beslissing

> De gekozen design pattern is het adapter pattern. Dit is flexibel voor het toevoegen van nieuwe APIs en zorgt ervoor dat klasses één verantwoordelijkheid hebben

## Alternatieven

| **Criteria**             | **State Pattern** | **Strategy Pattern** | **Adapter Pattern** | **Facade Pattern** | **Factory Method Pattern** |
|--------------------------|-------------------|-----------------------|----------------------|---------------------|----------------------------|
| **Flexibiliteit**         | +                 | ++                    | ++                   | +                   | +                          |
| **Onderhoudbaarheid**     | ++                | ++                    | ++                   | ++                  | ++                         |
| **Schaling**              | +                 | +                     | ++                   | +                   | ++                         |
| **Complexiteit**          | ++                | +                     | -                    | 0                   | +                          |
| **Beveiliging**           | 0                 | 0                     | ++                   | 0                   | 0                          |

## Gevolgen

### Positief:

- Uitbreidbaar. Makkelijk om nieuwe APIs toe te voegen.
- Single Responsibility Principle. Elke adapter zorgt voor het omzetten voor één API.
- Separation of Concerns. De adapters zorgen voor specifieke interactie met de APIs.
- Open/Closed Principle. De applicatie staat open voor uitbreiding maar gesloten voor wijziging.
- Consistentie. De adapters zorgen voor een gelijke manier om te communiceren met APIs.

### Negatief:

- De code wordt complex doordat er steeds nieuwe interfaces en klasses gemaakt moeten worden.

