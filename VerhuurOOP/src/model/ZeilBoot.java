package model;

public class ZeilBoot extends Boot {
    private final static int PRIJS_GRENS = 7;
    private final static double PRIJS_LAAG = 40.0;
    private final static double PRIJS_HOOG = 70.0;
    private final static int LENGTE_GRENS = 15;

    //All arg constructor; trekt de variabelen binnen via de super
    public ZeilBoot(String naam, int lengte) {
        super(naam, lengte);
    }

    //Interface voor vaarbewijsplichtigheid
    public boolean isVaarbewijsPlichtig() {
        return getLengte() > LENGTE_GRENS;
    }

    //Methode berekenHuurprijs die ook gelijk extend naar Boot:
    public double berekenHuurprijs() {
        double prijs;
        if (getLengte() < PRIJS_GRENS) {
            prijs = PRIJS_LAAG;
        } else {
            prijs = PRIJS_HOOG;
        }
        return prijs;
    }
}

//Nu stap 1 + 2 testen
