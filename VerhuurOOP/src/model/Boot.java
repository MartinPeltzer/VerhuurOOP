package model;

//klasse abstract maken
public abstract class Boot implements VrijVerhuurbaar {
    //Interface maken met boolean "isVrijVerhuurbaar" -->Check

    //Variabelen aanmaken:
    private static int lastId = 0;
    private final int id;  //aangemaakte id mag niet meer gewijzigd worden.
    private String naam;
    private int lengte;

    //Constructors aanmaken:
    protected Boot(String naam, int lengte) {
        this.naam = naam;
        this.lengte = lengte;
        this.id = ++lastId;
    }
    //Methode bereken huurprijs maken:
    public abstract double berekenHuurprijs();

    //Getter en Setter lengte toevoegen-->Basis huurprijs

    public int getLengte() {
        return lengte;
    }

    //Mogelijk kan ik deze later weghalen. Kijken hoe dat uiteindelijk met lengte invoeren gaat?
    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    //DMV toString informatie die getoond gaat worden standaardiseren:
    @Override
    public String toString() {
        return String.format("[Boot: %d met naam: %s]", id, naam); //kijken of dit wel werkt
    }
}
