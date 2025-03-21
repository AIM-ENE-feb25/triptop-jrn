# Architecture Decision Record (ADR)

## 1. Titel
**Betalingen bij externe partijen via PayPal Wallet**

## 2. Context
Om bij bepaalde bedrijven of bureaus producten of diensten te kunnen bestellen, moet er een betaalmogelijkheid zijn.

## 3. Beslissing
Om betalingen zo soepel mogelijk te laten verlopen, hebben wij gekozen voor een centrale betaalfunctie binnen Triptop zelf.

We hebben iDEAL, PayPal en bankoverschrijvingen overwogen en gekozen voor **PayPal** vanwege de wereldwijde beschikbaarheid. PayPal ondersteunt betalingen met creditcards, het koppelen van bankrekeningen en biedt bovendien de mogelijkheid om je PayPal Wallet op te waarderen met iDEAL. Hierdoor kunnen ook gebruikers zonder creditcard internationaal betalen.

## 4. Betalingsopties vergelijking

| Kenmerk          | iDEAL | PayPal | Bank |
|-----------------|:-----:|:------:|:----:|
| **Beschikbaarheid** | -   | ++     | 0    |
| **Creditcards**     | --  | ++     | ++   |
| **Betrouwbaarheid** | ++  | +      | ++   |
| **Extra kosten**    | ?   | +      | +    |

## 5. Consequenties

### **Voordelen:**
- Betalingen in de wallet kunnen worden opgewaardeerd via iDEAL.
- Ondersteunt creditcards en het koppelen van bankrekeningen.
- Wereldwijd bruikbaar.

### **Nadelen:**
- PayPal is opgericht door Elon Musk en heeft in het verleden kritiek gekregen op beleid en kosten.
- Externe API vereist integratie en communicatie met andere API’s.
- Niet alle bedrijven accepteren PayPal.

## 6. Alternatieven overwogen

### **Geen betalingen via Triptop**
- **Voordeel:** Eenvoudigere integratie, geen extra betalingslogica nodig.
- **Nadeel:** Gebruikers kunnen mogelijk niet betalen met hun gewenste betaalmethode.

### **iDEAL**
- **Voordeel:** Veelgebruikte betaalmethode in Nederland.
- **Nadeel:** Werkt alleen in Nederland en ondersteunt geen buitenlandse valuta.

### **Bankoverschrijvingen**
- **Voordeel:** Werkt (bijna) overal en is een directe manier van betalen.
- **Nadeel:** Vereist directe bankgegevens en extra beveiligingsmaatregelen.

## 7. Status
**Voorstel**

---

**Datum:** 21-03-2025  
**Auteur:** Rob  
