package model;

public class Appartement extends Vakantiewoning {
    private final static int PRIJS_GRENS = 7;
    private final static double PRIJS_LAAG = 40.0;
    private final static double PRIJS_HOOG = 70.0;
    private final static int OPPERVLAK_GRENS = 15;

    //All arg constructor; trekt de variabelen binnen via de super
    public Appartement(String naam, int oppervlak) {
        super(naam, oppervlak);
    }

    //Interface voor vaarbewijsplichtigheid
    public boolean HondToegestaan() {
        return getOppervlak() > OPPERVLAK_GRENS;
    }

    //Methode berekenHuurprijs die ook gelijk extend naar Boot:
    public double berekenHuurprijs() {
        double prijs;
        if (getOppervlak() < PRIJS_GRENS) {
            prijs = PRIJS_LAAG;
        } else {
            prijs = PRIJS_HOOG;
        }
        return prijs;
    }
}

//Nu stap 1 + 2 testen
