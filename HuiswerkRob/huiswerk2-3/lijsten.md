interfaces{

RestaurantPort{
String naam;
Object Data;
formatData(String name, object Data);
}

activiteitenBoekerPort{
String activiteit;
Location location;
float Prijs;
formatData(String actviteit, object Location, float Prijs);
}


#onduidelijkheden:
Wat is de returnwaarde van een Adapter?
Wat hebben we nodig voor de API call?

#fouten:
geen nummering in dynamic diagram


#mogelijk ADR
- beste vorm van dataverwerking van externe api's
1.hexagonaal
2. switch case per inkomende data
3. geen vervorming, meerdere vormen van doorgeven.



- Waarom gebruik template method pattern
1. gebruik van 

- (uitzoeken voor andere / slechtere opties of alternative)    ----
- waarom laat je de data formateren in de adapter? kan dit ergens anders of zijn hier andere laternatieve voor?     ---- alternatief is het formateren in de serive of je neemt de data zoals hij komt en verwerkt deze op je website
- Hoe zou je anders externe systemen kunnen implementeren?

todo:

adr, nieuwe pattern en princiepes en uitleg waarom
feedback aanpassing in SGB
toelichting op ontwerpvraag en toelichting
