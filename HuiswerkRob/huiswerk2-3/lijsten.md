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
- Alternatieve voor het gebruik van port of adapters                ---- Rechtstreeks in de service of niet formateren en gewoon op de website mikken als een soort switch statement.
- Waarom gebruik template method pattern (uitzoeken voor andere / slechtere opties of alternative)    ----
- waarom laat je de data formateren in de adapter? kan dit ergens anders of zijn hier andere laternatieve voor?     ---- alternatief is het formateren in de serive of je neemt de data zoals hij komt en verwerkt deze op je website
- Hoe zou je anders externe systemen kunnen implementeren?

todo:
adr, nieuwe pattern en princiepes en uitleg waarom
feedback aanpassing in SGB
statsch component diagram
dianamisch compenent diagram en uitleg
toelichting op ontwerpvraag en toelichting
klassediagram en toelichten
