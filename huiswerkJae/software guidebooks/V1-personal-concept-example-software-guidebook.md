# API Prototypes and Domain Mapping

## 1. Google Maps API Prototype

### Use Case
Retrieve geolocation data based on an address provided by the user.

### Domain Mapping Example
**Domain Model:**
- `Location::address` (provided by end-user)
- `Location::lat` and `Location::lng` (filled by the API response)

### Sample Code (JavaScript using fetch)
```javascript
const apiKey = 'YOUR_GOOGLE_MAPS_API_KEY';
const address = '1600 Amphitheatre Parkway, Mountain View, CA'; // provided by user

fetch(`https://maps.googleapis.com/maps/api/geocode/json?address=${encodeURIComponent(address)}&key=${apiKey}`)
  .then(response => response.json())
  .then(data => {
    if (data.results.length > 0) {
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

### Mapping Table Entry
| Class::Attribuut  | API Endpoint (Input)         | API Response Field                                           | Supplied by End-User | To be Stored in Application |
|-------------------|------------------------------|---------------------------------------------------------------|----------------------|-----------------------------|
| Location::address | Google Maps / Geocoding (GET)| formatted_address, geometry.location.lat, geometry.location.lng | User enters address  | Yes                         |

---

## 2. Stripe API Prototype

### Use Case
Process a payment.

### Domain Mapping Example
**Domain Model:**
- `Payment::amount` (provided by user)
- `Payment::currency` (set by the application)
- `Payment::cardDetails` (collected securely from the user)
- `Payment::chargeId` and `Payment::status` (filled by API response)

### Sample Code (CURL)
```bash
curl https://api.stripe.com/v1/charges \
  -u sk_test_yourSecretKey: \
  -d amount=5000 \
  -d currency=usd \
  -d source=tok_visa \
  -d description="Trip Payment"
```

### Mapping Table Entry
| Class::Attribuut  | API Endpoint (Input)         | API Response Field      | Supplied by End-User (or UI) | To be Stored in Application |
|-------------------|------------------------------|-------------------------|------------------------------|-----------------------------|
| Payment::amount   | Stripe / Create Charge (POST)| id (chargeId), status, amount | Payment amount and card details | Yes                         |

---

## 3. Firebase Authentication API Prototype

### Use Case
Register a new user (reiziger).

### Domain Mapping Example
**Domain Model:**
- `Reiziger::email` and `Reiziger::password` (supplied by end-user)
- `Reiziger::uid` and `Reiziger::token` (populated by the API response)

### Sample Code (CURL)
```bash
curl 'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=YOUR_FIREBASE_API_KEY' \
  -H 'Content-Type: application/json' \
  -d '{
    "email": "user@example.com",
    "password": "userPassword",
    "returnSecureToken": true
  }'
```

### Mapping Table Entry
| Class::Attribuut  | API Endpoint (Input)             | API Response Field        | Supplied by End-User        | To be Stored in Application |
|-------------------|-----------------------------------|---------------------------|-----------------------------|-----------------------------|
| Reiziger::email   | Firebase Auth / Sign Up (POST)    | localId (uid), idToken, email | User enters email and password | Yes                    |

---

## 4. Yelp Fusion API Prototype

### Use Case
Search for restaurants as part of an excursion.

### Domain Mapping Example
**Domain Model:**
- `Excursie::restaurantName` (can be provided as a search query or selected by the user)
- `Excursie::rating` and `Excursie::location` (populated by the API response)

### Sample Code (CURL)
```bash
curl -H "Authorization: Bearer YOUR_YELP_API_KEY" \
  "https://api.yelp.com/v3/businesses/search?location=Amsterdam&term=restaurants"
```

### Mapping Table Entry
| Class::Attribuut        | API Endpoint (Input)               | API Response Field        | Supplied by End-User/Query | To be Stored in Application |
|-------------------------|------------------------------------|---------------------------|----------------------------|-----------------------------|
| Excursie::restaurantName| Yelp Fusion / Business Search (GET)| name, rating, location    | User selects or queries restaurant | Yes                  |

---

## 5. Skyscanner API Prototype

### Use Case
Search for flights.

### Domain Mapping Example
**Domain Model:**
- `Trip::departureDate`, `Trip::returnDate`, `Trip::destination` (provided by user)
- `Trip::price`, `Trip::airline` (populated by the API response)

### Sample Code (CURL)
```bash
curl --request GET \
  --url 'https://partners.api.skyscanner.net/apiservices/browseroutes/v1.0/US/USD/en-US/SFO-sky/NYC-sky/2025-04-01?apiKey=YOUR_SKYSCANNER_API_KEY'
```

### Mapping Table Entry
| Class::Attribuut    | API Endpoint (Input)          | API Response Field     | Supplied by End-User    | To be Stored in Application |
|---------------------|-------------------------------|------------------------|-------------------------|-----------------------------|
| Trip::departureDate | Skyscanner / Flight Search (GET)| departureDate, price, airline | User provides date and route | Yes                    |

---

## Addressing Missing Data

In each case, our domain model might not include every field that the API expects (e.g., API keys, authentication tokens, or specific query parameters). Our team should:

1. **Identify Gaps:** Compare the domain model with the API documentation to list missing fields.
2. **Plan Data Augmentation:** Decide whether these fields should be hardcoded (e.g., default currency), derived from user input (e.g., travel dates), or fetched dynamically.
3. **Document in the Guidebook:** For each API, note what additional data is required and how you plan to supply it (e.g., using environment variables, prompting the user, or default values).

---

## Consolidated Mapping Table Example

| Class::Attribuut        | Is input voor API+Endpoint            | Wordt gevuld door API+Endpoint                         | Wordt geleverd door eindgebruiker | Moet worden opgeslagen in de applicatie |
|-------------------------|--------------------------------------|--------------------------------------------------------|-----------------------------------|-----------------------------------------|
| Location::address       | Google Maps / Geocoding (GET)         | formatted_address, lat, lng                            | x (user enters address)           | x                                       |
| Payment::amount         | Stripe / Create Charge (POST)         | chargeId, status, amount                               | x (user inputs payment details)   | x                                       |
| Reiziger::email         | Firebase Auth / Sign Up (POST)        | uid, token, email                                      | x (user provides credentials)     | x                                       |
| Excursie::restaurantName| Yelp Fusion / Business Search (GET)   | name, rating, location                                 | x (user selects restaurant)       | x                                       |
| Trip::departureDate     | Skyscanner / Flight Search (GET)      | departureDate, price, airline                          | x (user provides travel dates)    | x                                       |

