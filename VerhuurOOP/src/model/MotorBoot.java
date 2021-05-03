package model;

public class MotorBoot extends Boot {
    private int maxSnelheid;
    private final static int PRIJS_GRENS = 10;
    private final static double PRIJS_LAAG = 60.0;
    private final static double PRIJS_HOOG = 90.0;
    private final static int LENGTE_GRENS = 15;
    private final static int SNELHEID_GRENS = 20;

    public MotorBoot(String naam, int lengte, int snelheid) {
        super(naam, lengte);
        this.maxSnelheid = snelheid;
    }

    public boolean isVaarbewijsPlichtig() {
        return getLengte() > LENGTE_GRENS || maxSnelheid > SNELHEID_GRENS;

    }

    //Implement abstract method 'berekenHuurprijs()' in Boot!!! hierdoor kopelt (extends) hij aan "Boot"
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
