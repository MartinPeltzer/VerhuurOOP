package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Verhuur {
    //Variabelen aanmaken
    private Klant klant;
    private ArrayList<Vakantiewoning> vakantiewoningen;
    private LocalDate startDatum;
    private int aantalDagen;

    //Constructor
    public Verhuur(Klant klant, LocalDate datum, int aantalDagen) {
        this.klant = klant;
        this.startDatum = datum;
        this.aantalDagen = aantalDagen;
        vakantiewoningen = new ArrayList<>();
    }

    //Methode om boten toe te voegen
    public void voegVakantiewoningToe(Vakantiewoning vakantiewoning) {
        if (magVerhuurd(vakantiewoning) ) {
            vakantiewoningen.add(vakantiewoning);
        } else {
            System.out.println(vakantiewoning + " mag niet verhuurd! Toevoegen mislukt.\n");
        }
    }

    //Methode magVerhuurd aanmaken
    public boolean magVerhuurd(Vakantiewoning vakantiewoning) {
        return !vakantiewoning.HondToegestaan() || klant.isHeeftHond();
    }

    //Methode om het huurbedrag te berekenen
    public double berekenHuurBedrag() {
        double totaalPrijsVakantiewoningen = 0.0;
        for (Vakantiewoning vakantiewoning : vakantiewoningen) {
            totaalPrijsVakantiewoningen += vakantiewoning.berekenHuurprijs();
        }
        return aantalDagen * totaalPrijsVakantiewoningen;
    }

    //Output maken met toString()
    @Override
    public String toString() {
        if (vakantiewoningen.isEmpty()) {
            return String.format("De verhuur aan %s op %s is mislukt, geen vakantiewoningen toegevoegd.\n", klant, startDatum);
        }
        String result;
        result = String.format("De verhuur aan %s van %s tot %s kost %.2f euro:\n", klant, startDatum, startDatum.plusDays(aantalDagen - 1), berekenHuurBedrag());
        for (Vakantiewoning vakantiewoning : vakantiewoningen) {
            result += vakantiewoning + "\n";
        }
        return result;
    }
}
