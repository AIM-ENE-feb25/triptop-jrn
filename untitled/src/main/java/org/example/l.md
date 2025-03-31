# Single Responsibility Principle
Een klasse zou slechts **één reden tot verandering** moeten hebben
### Design property
- **Hoge cohesie**: Heeft een hoge cohesie door ervoor te zorgen dat alle methoden en attributen van een klasse bijdragen aan een enkele, goed gedefinieerde taak.
- **Lage koppeling**: Door klassen met een enkele verantwoordelijkheid te maken, vermindert de afhankelijkheid tussen klassen.

### Consequenties
- + Verbeterde leesbaarheid en onderhoudbaarheid
- + Beter testbaar
- + Code is gemakkelijker te begrijpen en voorspelbaarder
- + Betere herbruikbaarheid

### Voorbeeld
##### Zonder SRP
```java
public class RapportGenerator {
    public void verzamelGegevens() {
        // Logica om gegevens te verzamelen
    }

    public void genereerRapport() {
        // Logica om rapport te genereren
    }

    public void printRapport() {
        // Logica om rapport te printen
    }
}
```
> meerdere verantwoordelijkheden:
> - gegevens verzamelen
> - rapport genereren
> - rapport printen

##### Met SRP
```java
public class GegevensVerzamelaar {
    public void verzamelGegevens() {
        // Logica om gegevens te verzamelen
    }
}

public class RapportGenerator {
    public void genereerRapport() {
        // Logica om rapport te genereren
    }
}

public class RapportPrinter {
    public void printRapport() {
        // Logica om rapport te printen
    }
}

```
> Elke klasse heeft zijn eigen verantwoordelijkheid