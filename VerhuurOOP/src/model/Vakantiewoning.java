package model;

//klasse abstract maken
public abstract class Vakantiewoning implements VrijVerhuurbaar {
    //Interface maken met boolean "isVrijVerhuurbaar" -->Check

    //Variabelen aanmaken:
    private static int lastId = 0;
    private final int id;  //aangemaakte id mag niet meer gewijzigd worden.
    private String naam;
    private int oppervlak;

    //Constructors aanmaken:
    protected Vakantiewoning(String naam, int oppervlak) {
        this.naam = naam;
        this.oppervlak = oppervlak;
        this.id = ++lastId;
    }
    //Methode bereken huurprijs maken:
    public abstract double berekenHuurprijs();

    //Getter en Setter lengte toevoegen-->Basis huurprijs


    public int getOppervlak() {
        return oppervlak;
    }

    public void setOppervlak(int oppervlak) {
        this.oppervlak = oppervlak;
    }

    //DMV toString informatie die getoond gaat worden standaardiseren:
    @Override
    public String toString() {
        return String.format("[Vakantiewoning: %d met naam: %s]", id, naam); //kijken of dit wel werkt
        //Je ziet hier dus idd die dat die %d en %s zo werken.
    }
}
