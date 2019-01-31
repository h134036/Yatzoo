package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Eivin Sellevold og Cato Robstad
 *
 */

public class Terning {

	private Random rand = new Random();
	private List<Integer> terninger = new ArrayList<>();

	public Terning() {

	}

	public List<Integer> getTerninger() {
		return terninger;
	}

	public void setTerninger(List<Integer> terninger) {
		this.terninger = terninger;
	}

	/**
	 * Triller antall terninger
	 * 
	 * @param antall
	 *            terninger som skal trilles
	 */
	public void trill(int antall) {
		terninger.clear();
		if (terninger.isEmpty()) {
			for (int i = 1; i < antall + 1; i++) {
				int r = rand.nextInt(6) + 1;
				terninger.add(r);
			}
		}
	}

	/**
	 * Dette er en metode for straight-runden. Tar en tabell(heklo) som tar inn
	 * tallene fra når man triller, som IKKE allerede er i tabellen.
	 * 
	 * @param Liste heklo
	 */
	public void overfør(List<Integer> heklo) {
		for (int i = 1; i < 7; i++) {
			if (terninger.contains(i) && !heklo.contains(i)) {
				heklo.add(i);
			}
		}
	}

	/**
	 * Tar inn en liste og sjekker om vi har straight.
	 * 
	 * @param heklo
	 * @return boolean viHarStraight
	 */
	public boolean sjekkStraight(List<Integer> heklo) {
		boolean viHarStraight = true;
		int p = 0;
		for (int i = 1; i < 7; i++) {
			if (hvorMangeDyr(i) == 1) {
				p++;
			}
		}
		if (p < 5) {
			viHarStraight = false;
		}
		return viHarStraight;
	}

	/**
	 * Fjerner dyr man ønsker sette til side etter ett trill.
	 * 
	 * @param int som er nr. på dyret man vil fjerne
	 */
	public void remove(int dyr) {
		for (int i = 0; i < terninger.size(); i++) {
			if (terninger.get(i) == dyr) {
				terninger.remove(i);
			}
		}
	}

	/**
	 * Sjekker om terningene viser like dyr som er like mange som, eller flere, enn
	 * input a
	 * 
	 * @param antall
	 *            a man ønsker sjekke
	 * @return boolean riktig
	 */

	public boolean sjekk(int a) {

		List<Integer> mest = new ArrayList<>();

		int en = 0;
		int to = 0;
		int tre = 0;
		int fire = 0;
		int fem = 0;
		int seks = 0;

		for (int i = 0; i < terninger.size(); i++) {
			if (terninger.get(i) == 1) {
				en++;
			}
			if (terninger.get(i) == 2) {
				to++;
			}
			if (terninger.get(i) == 3) {
				tre++;
			}
			if (terninger.get(i) == 4) {
				fire++;
			}
			if (terninger.get(i) == 5) {
				fem++;
			}
			if (terninger.get(i) == 6) {
				seks++;
			}
		}

		mest.add(en);
		mest.add(to);
		mest.add(tre);
		mest.add(fire);
		mest.add(fem);
		mest.add(seks);

		boolean riktig = false;
		for (int j = 0; j < mest.size(); j++) {
			if (mest.get(j) >= a) {
				riktig = true;
			}
		}
		return riktig;

	}

	/**
	 * Finner antallet(1-5) av mest like dyr. Om det er like mange av flere dyr blir
	 * det det dyret som kommer først i rekken, dvs. dyr1 = løve, dyr2 = slange osv.
	 * 
	 * @return int storst
	 */
	public int antallAvFlestDyr() {

		List<Integer> mest = new ArrayList<>();
		int storst = 0;

		int en = 0;
		int to = 0;
		int tre = 0;
		int fire = 0;
		int fem = 0;
		int seks = 0;

		for (int i = 0; i < terninger.size(); i++) {
			if (terninger.get(i) == 1) {
				en++;
			}
			if (terninger.get(i) == 2) {
				to++;
			}
			if (terninger.get(i) == 3) {
				tre++;
			}
			if (terninger.get(i) == 4) {
				fire++;
			}
			if (terninger.get(i) == 5) {
				fem++;
			}
			if (terninger.get(i) == 6) {
				seks++;
			}
		}

		mest.add(en);
		mest.add(to);
		mest.add(tre);
		mest.add(fire);
		mest.add(fem);
		mest.add(seks);

		for (int j = 0; j < mest.size(); j++) {
			if (mest.get(j) > storst) {
				storst = mest.get(j);
			}
		}
		return storst;
	}

	/**
	 * Finner nummer på dyret det er flest av. Løve = 1, Slange = 2, Panda = 3, Gris = 4, Elefant = 5, Kval = 6.
	 * 
	 * @param putter inn int storst, der storst er antallet på dyret det er mest av. Int-en storst finner eg av metoden antallAvFlestDyr.
	 * @return int dyNrDetErMestAv som er nummeret på dyret det er mest av.
	 */
	public int dyrDetErFlestAv(int storst) {

		List<Integer> listeStorst = new ArrayList<>();
		int dyrNrDetErMestAv = 0;

		int en = 0;
		int to = 0;
		int tre = 0;
		int fire = 0;
		int fem = 0;
		int seks = 0;

		for (int i = 0; i < terninger.size(); i++) {
			if (terninger.get(i) == 1) {
				en++;
			}
			if (terninger.get(i) == 2) {
				to++;
			}
			if (terninger.get(i) == 3) {
				tre++;
			}
			if (terninger.get(i) == 4) {
				fire++;
			}
			if (terninger.get(i) == 5) {
				fem++;
			}
			if (terninger.get(i) == 6) {
				seks++;
			}
		}

		listeStorst.add(en);
		listeStorst.add(to);
		listeStorst.add(tre);
		listeStorst.add(fire);
		listeStorst.add(fem);
		listeStorst.add(seks);

		for (int j = 0; j < listeStorst.size(); j++) {
			if (listeStorst.get(j) == storst) {
				dyrNrDetErMestAv = j + 1;
				break;
			}
		}
		return dyrNrDetErMestAv;
	}

	/**
	 * Finner hvor mange dyr man har i trillet av det man leter etter.
	 * 
	 * @param dyr(1-6), som er nummer på det dyret man ønsker antall av.
	 * @return int antall
	 */
	public int hvorMangeDyr(int dyr) {

		int en = 0;
		int to = 0;
		int tre = 0;
		int fire = 0;
		int fem = 0;
		int seks = 0;

		for (int i = 0; i < terninger.size(); i++) {
			if (terninger.get(i) == 1) {
				en++;
			}
			if (terninger.get(i) == 2) {
				to++;
			}
			if (terninger.get(i) == 3) {
				tre++;
			}
			if (terninger.get(i) == 4) {
				fire++;
			}
			if (terninger.get(i) == 5) {
				fem++;
			}
			if (terninger.get(i) == 6) {
				seks++;
			}
		}

		if (dyr == 1) {
			return en;
		}
		if (dyr == 2) {
			return to;
		}
		if (dyr == 3) {
			return tre;
		}
		if (dyr == 4) {
			return fire;
		}
		if (dyr == 5) {
			return fem;
		} else {
			return seks;
		}
	}
}
