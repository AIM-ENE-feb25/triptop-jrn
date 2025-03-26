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
