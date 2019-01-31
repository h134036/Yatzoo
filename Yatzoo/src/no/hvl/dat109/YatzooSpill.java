package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;

public class YatzooSpill {

	
	/**
	 * Legger til spillere
	 */
	private List<Spiller> spillere = new ArrayList<>();
	{
		spillere.add(new Spiller("Eivin"));
		spillere.add(new Spiller("Cado"));
		spillere.add(new Spiller("Bonn"));
	}

	/**
	 * Starter spillet med gitt antall runder
	 */
	public void start() {
		for (int i = 1; i < 13; i++) {
			spillRunde(i);
		}
	}

	/**
	 * Spiller runde for alle spillerne
	 * 
	 * @param int runde som er rundeNr.
	 */
	private void spillRunde(int runde) {
		for (Spiller spiller : spillere) {
			spiller.spillTrekk(runde);
		}
		/**
		 * skriver ut resultat for hver runde for alle spillerne
		 */
		for (int k = 0; k < spillere.size(); k++) {
			System.out.println("Runde " + runde + ": " + spillere.get(k).getNavn() + " fikk "
					+ spillere.get(k).getPoengListe().get(runde - 1) + " poeng, og har " + spillere.get(k).getSumPoeng()
					+ " poeng til sammen");
		}

		System.out.println();
	}

}
