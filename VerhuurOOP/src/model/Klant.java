package model;

public class Klant {
	private String naam;
	private String emailadres;
	private boolean vaarVaardig;

	//all arg constructor
	public Klant() {
		this("onbekend"); //netter zo.
	}

	//Constructor alleen naam bekend, email onbekend, klant bezit vaarbewijs; de derde is nodig om de tweede te laten werken
	public Klant(String naam) {
		this(naam, "onbekend", false);
	}
	public Klant(String naam, String emailadres, boolean vaarVaardig) {
		this.naam = naam;
		this.emailadres = emailadres;
		this.vaarVaardig = vaarVaardig;
	}

	public boolean isVaarVaardig() { return vaarVaardig; }


	@Override
	public String toString() {
		return "Klant " + getNaam();
	}

	public String getNaam() {
		return naam;
	}

	public String getEmailadres() {
		return emailadres;
	}
}

