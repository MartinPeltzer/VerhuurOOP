package model;

public class Huisje extends Vakantiewoning {
    private int minTuinGrootte;
    private final static int PRIJS_GRENS = 10;
    private final static double PRIJS_LAAG = 60.0;
    private final static double PRIJS_HOOG = 90.0;
    private final static int OPPERVLAK_GRENS = 15;
    private final static int TUIN_GRENS = 20;

    public Huisje(String naam, int oppervlak, int tuinGrootte) {
        super(naam, oppervlak);
        this.minTuinGrootte = tuinGrootte;
    }

    public boolean HondToegestaan() {
        return getOppervlak() > OPPERVLAK_GRENS || minTuinGrootte > TUIN_GRENS;

    }

    //Implement abstract method 'berekenHuurprijs()' in Boot!!! hierdoor kopelt (extends) hij aan "Boot"
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
