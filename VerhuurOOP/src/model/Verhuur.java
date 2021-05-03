package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Verhuur {
    //Variabelen aanmaken
    private Klant klant;
    private ArrayList<Boot> boten;
    private LocalDate startDatum;
    private int aantalDagen;

    //Constructor
    public Verhuur(Klant klant, LocalDate datum, int aantalDagen) {
        this.klant = klant;
        this.startDatum = datum;
        this.aantalDagen = aantalDagen;
        boten = new ArrayList<>();
    }

    //Methode om boten toe te voegen
    public void voegBootToe(Boot boot) {
        if (magVerhuurd(boot) ) {
            boten.add(boot);
        } else {
            System.out.println(boot + " mag niet verhuurd! Toevoegen mislukt.\n");
        }
    }

    //Methode magVerhuurd aanmaken
    public boolean magVerhuurd(Boot boot) {
        return !boot.isVaarbewijsPlichtig() || klant.isVaarVaardig();
    }

    //Methode om het huurbedrag te berekenen
    public double berekenHuurBedrag() {
        double totaalPrijsBoten = 0.0;
        for (Boot boot : boten) {
            totaalPrijsBoten += boot.berekenHuurprijs();
        }
        return aantalDagen * totaalPrijsBoten;
    }

    //Output maken met toString()
    @Override
    public String toString() {
        if (boten.isEmpty()) {
            return String.format("De verhuur aan %s op %s is mislukt, geen boten toegevoegd.\n", klant, startDatum);
        }
        String result;
        result = String.format("De verhuur aan %s van %s tot %s kost %.2f euro:\n", klant, startDatum, startDatum.plusDays(aantalDagen - 1), berekenHuurBedrag());
        for (Boot boot : boten) {
            result += boot + "\n";
        }
        return result;
    }
}
