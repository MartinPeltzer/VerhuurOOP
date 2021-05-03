package controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

 import database.DBaccess;
 import database.KlantDAO;
 import model.Vakantiewoning;
 import model.Klant;
 import model.Huisje;
 import model.Verhuur;
 import model.Appartement;

public class VerhuurLauncher {
	final static int AANTAL_SCHAKELBUNGALOWS = 5;  //nodig bij stap 5b (zie onder)

	public static void main(String[] args) {
		//Hier een openingszin
		System.out.println("Dit is het Verhuur oefenprogramma in java met OOP op 3 mei 2021");

		// Tests voor het maken van Klant en MotorBoot objecten met Verhuur.
		//Toevoeging om te pushen

		// Stap 1 en 2 Boten
		// Let wel: Bovenaan ook de bijbehorende import uncommenten.
		System.out.println("-------- Stap 1 en 2 Vakantiewoningen --------");
		System.out.println("Huisjes:");
		Vakantiewoning hattem = new Huisje("Hattem", 6, 18);
		System.out.println(hattem);
		Vakantiewoning garmisch = new Huisje("Garmisch", 11, 21);
		System.out.println(garmisch);
		System.out.println();
		//Testen ZeilBoot
		System.out.println("Appartementen:");
		Vakantiewoning london = new Appartement("London", 11);
		System.out.println(london);
		System.out.println();

		// Stap 3 Klanten
		System.out.println("-------- Stap 3 Klanten --------");
		Klant jan = new Klant("Tessa");
		System.out.println(jan);
		Klant tarik = new Klant("Esther", "estherdb@gmail.com", true);
		System.out.println(tarik);
		System.out.println();

		// Stap 4 Verhuur
		System.out.println("-------- Stap 4 Verhuur --------");
		Verhuur eersteVerhuur = new Verhuur(jan, LocalDate.of(2019, 12, 6), 5);
		eersteVerhuur.voegVakantiewoningToe(hattem);
		System.out.println(eersteVerhuur);
		Verhuur tweedeVerhuur = new Verhuur(tarik, LocalDate.of(2019, 12, 5), 3);
		tweedeVerhuur.voegVakantiewoningToe(garmisch);
		System.out.println(tweedeVerhuur);
		System.out.println();

		// Stap 5a Verhuur van meerdere boten aan een Klant.
		// Klant en array van zeilboten om te verhuren klaarzetten
		System.out.println("-------- Stap 5 Verhuur nul vakantiewoningen --------");
		Verhuur mislukteVerhuur = new Verhuur(jan, LocalDate.of(2019, 12, 3), 2);
		mislukteVerhuur.voegVakantiewoningToe(garmisch);
		System.out.println(mislukteVerhuur);
		System.out.println("-------- Stap 5b Verhuur meerdere vakantiewoningen --------");
		Klant schakelbungalowHuurder = new Klant("Kluin");
		Appartement[] schakelbungalows = new Appartement[AANTAL_SCHAKELBUNGALOWS];
		for (int schakelbungalowNummer = 0; schakelbungalowNummer < AANTAL_SCHAKELBUNGALOWS; schakelbungalowNummer++) {
			schakelbungalows[schakelbungalowNummer] = new Appartement("schakelbungalow" + (schakelbungalowNummer + 1), 6);
		}
		Verhuur schakelbungalowVerhuur = new Verhuur(schakelbungalowHuurder, LocalDate.of(2019,12,10), 7);;

		for (int schakelbungalowNummer = 0; schakelbungalowNummer < AANTAL_SCHAKELBUNGALOWS; schakelbungalowNummer++) {
			schakelbungalowVerhuur.voegVakantiewoningToe(schakelbungalows[schakelbungalowNummer]);
		}
		schakelbungalowVerhuur.voegVakantiewoningToe(garmisch);
		schakelbungalowVerhuur.voegVakantiewoningToe(hattem);
		System.out.println(schakelbungalowVerhuur);


		// Stap 6: Leest de klanten uit het bestand Klanten.csv in de folder Resources
		// Print de lijst naar de console.
		//Dit doe je dus hier:
		System.out.println("-------- Stap 6 Lees de klanten uit het bestand Klanten.csv in de folder Resources--------");
		ArrayList<Klant> klantenLijst = new ArrayList<>();
		try {
			File klantenBestand = new File("VerhuurOOP/resources/Klanten.csv"); //"verhuurOOP" moest ervoor idd.
			Scanner leesFile = new Scanner(klantenBestand);
			while (leesFile.hasNextLine()) {
				String[] klantSplit = leesFile.nextLine().split(",");
				Klant nieuweKlant = new Klant(klantSplit[0], klantSplit[1], false);
				klantenLijst.add(nieuweKlant);
			}
		} catch (FileNotFoundException fout) {
			System.out.println("Bestand niet gevonden.");
		}
		System.out.println(klantenLijst);


		// Stap 7: Maak een connectie met de database Boten en sla klanten op.
		// Nog toevoegen: het opslaan van klanten in de database
		// Test eerst de connectie door hieronder de code te uncommenten.
		// Let op: Ook de import bovenaan uncommenten.
		//In src-->database-->KlantDAO maken

		//Code om de klanten uit het Klanten.csv bestand op te slaan in een SQL database
		//System.out.println("-------- Stap 7 Maak een connectie met de database Boten en sla klanten op --------");
		//DBaccess dBaccess = new DBaccess("boten", "userBoten", "userBotenPW");
		//dBaccess.openConnection();
		//KlantDAO kdao = new KlantDAO(dBaccess);
		//for (Klant klant : klantenLijst) {
		//	kdao.storeKlant(klant);
		//}
		//kdao.storeKlant(jan);

		//dBaccess.closeConnection();
	}


}
