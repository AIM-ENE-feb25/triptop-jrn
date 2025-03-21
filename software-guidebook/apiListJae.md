# 🌍 Overzicht van Gekozen APIs voor Triptop

## 🗺️ API voor Kaart & Locatie
### **Google Maps API**
**Features:**
- Geocoding: Conversie van adres naar geografische coördinaten
- Maps & Places: Weergave van kaarten en interessante locaties
- Directions: Routeplanning tussen locaties

**Voordelen:**
- Uitgebreide en betrouwbare documentatie
- Real-time data en ondersteuning voor diverse integraties

**Nadelen:**
- Kosten kunnen hoog oplopen bij intensief gebruik
- Beperkingen in het aantal gratis aanvragen per maand
- Privacyzorgen vanwege gegevensverzameling

**Mogelijke Alternatieven:**
- **MapTiler**: Biedt een mapping platform voor ontwikkelaars met interactieve kaarten voor web- en mobiele applicaties.
- **OpenStreetMap**

- **Domain Model:**
    - `Location::address` (provided by end-user)
    - `Location::lat` and `Location::lng` (to be filled by the API response)

**Sample Code (JavaScript using fetch):**
```javascript
const apiKey = 'YOUR_GOOGLE_MAPS_API_KEY';
const address = '1600 Amphitheatre Parkway, Mountain View, CA'; // provided by user

fetch(`https://maps.googleapis.com/maps/api/geocode/json?address=${encodeURIComponent(address)}&key=${apiKey}`)
  .then(response => response.json())
  .then(data => {
    if(data.results.length > 0) {
      const result = data.results[0];
      const formattedAddress = result.formatted_address;
      const lat = result.geometry.location.lat;
      const lng = result.geometry.location.lng;
      console.log(`Address: ${formattedAddress}, Latitude: ${lat}, Longitude: ${lng}`);
      // Save lat, lng, formattedAddress in your application's datastore
    }
  })
  .catch(error => console.error('Error:', error));
  ```
**Mapping table Entry**

| Class::Attribuut   | API Endpoint (Input)           | API Response Field                                               | 	Supplied by End-User | To be Stored in Application |
|--------------------|--------------------------------|------------------------------------------------------------------|-----------------------|-----------------------------|
| Location::address  | Google Maps / Geocoding (GET)  | formatted_address, geometry.location.lat, geometry.location.lng  | User enters address   | Yes                         |

---

## 💳 API voor Betalingen
### **Stripe API**
**Features:**
- Verwerken van betalingen via creditcards en andere methoden
- Transactiebeheer en terugbetalingen
- Veilige en robuuste betalingsverwerking

**Voordelen:**
- Uitstekende ontwikkelaarsdocumentatie en een robuuste gratis versie
- Eenvoudige integratie en ondersteuning voor meerdere betaalmethoden

**Nadelen:**
- Beschikbaarheid kan beperkt zijn in bepaalde landen
- Transactiekosten kunnen hoger zijn dan bij sommige lokale betalingsproviders

**Mogelijke Alternatieven:**
- **Adyen**: 
- **PayPal**:
---

## 🔐 API voor Authenticatie
### **Firebase Authentication API**
**Features:**
- Gebruikersregistratie en login
- Ondersteuning voor sociale logins (Google, Facebook, etc.)
- Beveiligde authenticatie en autorisatie

**Voordelen:**
- Snelle en eenvoudige implementatie
- Uitgebreide SDK’s en voorbeelden
- Schaalbare en betrouwbare authenticatiediensten

**Nadelen:**
- Afhankelijkheid van Google-infrastructuur
- Beperkte aanpassingsmogelijkheden voor geavanceerde authenticatiescenario's

**Mogelijke Alternatieven:**
- **Auth0**
- **Okta**
---

## 🍽️ API voor Eten & Restaurants
### **Yelp Fusion API**
**Features:**
- Zoeken naar restaurants en lokale bedrijven
- Opvragen van beoordelingen, ratings en locatie-informatie
- Integratie van klantrecensies en bedrijfsgegevens

**Voordelen:**
- Bekende data en veelgebruikte endpoints
- Duidelijke en gestructureerde JSON-responses
- Flexibele zoekmogelijkheden voor lokale diensten

**Nadelen:**
- Beschikbaarheid en dekking kunnen variëren per regio
- Beperkingen in het aantal aanvragen per dag

**Mogelijke Alternatieven:**
- **Foursquare API**
- **Zomato API**
---

## ✈️ API voor Vliegtickets & Reizen
### **Skyscanner API**
**Features:**
- Zoeken en vergelijken van vluchten
- Toegang tot prijsinformatie en routegegevens
- Ondersteuning voor verschillende reisdata en bestemmingen

**Voordelen:**
- Gebruiksvriendelijke en goed gedocumenteerde endpoints
- Real-time data over prijzen en beschikbaarheid
- Eenvoudige integratie met de Triptop backend

**Nadelen:**
- Mogelijke beperkingen in API-toegang voor kleinere ontwikkelaars
- Beschikbaarheid van data kan variëren afhankelijk van luchtvaartmaatschappijen

**Mogelijke Alternatieven:**
- **Kiwi.com API**
- **Amadeus API**
---
## 🚆 API voor Openbaar Vervoer & Routeplanning
### **Navitia API**
**Features:**
- Reisinformatie: Real-time data over dienstregelingen en openbaar vervoer
- Multi-modale routeplanning: Ondersteunt bus, trein, tram, metro en andere vervoerswijzen
- Integratie van verstoringen en alternatieve routes

**Voordelen:**
- Gedetailleerde en actuele openbaar vervoergegevens voor diverse regio’s
- Flexibele integratie in apps voor reisinformatie en mobiliteit
- Basisgebruik is vaak gratis, wat voordelig is voor kleinere projecten

**Nadelen:**
- Dekking kan beperkt zijn tot bepaalde Europese regio’s
- De documentatie kan soms complex overkomen voor beginnende ontwikkelaars

**Mogelijke Alternatieven:**
- **Transport API**
- **Rome2rio API**