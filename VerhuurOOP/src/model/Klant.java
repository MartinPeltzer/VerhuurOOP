package model;

public class Klant {
	private String naam;
	private String emailadres;
	private boolean vaarVaardig;


	public boolean isVaarVaardig() {
		return vaarVaardig;
	}

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

