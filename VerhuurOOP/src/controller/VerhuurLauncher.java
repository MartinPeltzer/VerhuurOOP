package controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

 import database.DBaccess;
 import database.KlantDAO;
 import model.Boot;
 import model.Klant;
 import model.MotorBoot;
 import model.Verhuur;
 import model.ZeilBoot;

public class VerhuurLauncher {
	final static int AANTAL_VALKEN = 5;  //nodig bij stap 5b (zie onder)

	public static void main(String[] args) {
		//Hier een openingszin
		System.out.println("Dit is het Verhuur oefenprogramma in java met OOP op 3 mei 2021");

		// Tests voor het maken van Klant en MotorBoot objecten met Verhuur.
		//Toevoeging om te pushen

		// Stap 1 en 2 Boten
		// Let wel: Bovenaan ook de bijbehorende import uncommenten.
		System.out.println("-------- Stap 1 en 2 Boten --------");
		System.out.println("Motorboten:");
		Boot engel = new MotorBoot("De Engel", 6, 18);
		System.out.println(engel);
		Boot susy = new MotorBoot("Suzy Q", 11, 21);
		System.out.println(susy);
		System.out.println();
		//Testen ZeilBoot
		System.out.println("Zeilboten:");
		Boot iselin = new ZeilBoot("Iselin", 11);
		System.out.println(iselin);
		System.out.println();

		// Stap 3 Klanten
		System.out.println("-------- Stap 3 Klanten --------");
		Klant jan = new Klant("Jan");
		System.out.println(jan);
		Klant tarik = new Klant("Tarik", "tarik@gmail.com", true);
		System.out.println(tarik);
		System.out.println();

		// Stap 4 Verhuur
		System.out.println("-------- Stap 4 Verhuur --------");
		Verhuur eersteVerhuur = new Verhuur(jan, LocalDate.of(2019, 12, 6), 5);
		eersteVerhuur.voegBootToe(engel);
		System.out.println(eersteVerhuur);
		Verhuur tweedeVerhuur = new Verhuur(tarik, LocalDate.of(2019, 12, 5), 3);
		tweedeVerhuur.voegBootToe(susy);
		System.out.println(tweedeVerhuur);
		System.out.println();

		// Stap 5a Verhuur van meerdere boten aan een Klant.
		// Klant en array van zeilboten om te verhuren klaarzetten
		System.out.println("-------- Stap 5 Verhuur nul  boten --------");
		Verhuur mislukteVerhuur = new Verhuur(jan, LocalDate.of(2019, 12, 3), 2);
		mislukteVerhuur.voegBootToe(susy);
		System.out.println(mislukteVerhuur);
		System.out.println("-------- Stap 5b Verhuur meerdere boten --------");
		Klant valkHuurder = new Klant("Van der Valk");
		ZeilBoot[] valken = new ZeilBoot[AANTAL_VALKEN];
		for (int valkNummer = 0; valkNummer < AANTAL_VALKEN; valkNummer++) {
			valken[valkNummer] = new ZeilBoot("valk" + (valkNummer + 1), 6);
		}
		Verhuur valkVerhuur = new Verhuur(valkHuurder, LocalDate.of(2019,12,10), 7);;

		for (int valkNummer = 0; valkNummer < AANTAL_VALKEN; valkNummer++) {
			valkVerhuur.voegBootToe(valken[valkNummer]);
		}
		valkVerhuur.voegBootToe(susy);
		valkVerhuur.voegBootToe(engel);
		System.out.println(valkVerhuur);


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
		System.out.println("-------- Stap 7 Maak een connectie met de database Boten en sla klanten op --------");
		DBaccess dBaccess = new DBaccess("boten", "userBoten", "userBotenPW");
		dBaccess.openConnection();
		KlantDAO kdao = new KlantDAO(dBaccess);
		for (Klant klant : klantenLijst) {
			kdao.storeKlant(klant);
		}
		kdao.storeKlant(jan);

		dBaccess.closeConnection();
	}


}
