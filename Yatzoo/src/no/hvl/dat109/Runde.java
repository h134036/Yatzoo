package no.hvl.dat109;

import java.util.List;
import java.util.ArrayList;

public class Runde {

	private Terning terning = new Terning();
	private int a;
	private int b;
	private int c;
	private int d;
	private int e;
	private int f;
	private int g;
	private int h;

	public Runde() {

	}

	/**
	 * Metode som brukes for å finne poengene når man skal finne like symboler. Brukes for 3 like, 4 like og 5 like.
	 * 
	 * @param tall man ønsker sjekke like av.
	 * @return int som er tallet man setter inn i metoden.
	 */
	public int like(int tall) {

		int antall = 5;

		terning.trill(antall);
		if (terning.sjekk(tall)) {
			return tall;
		} // mindre enn 3 like
		a = terning.antallAvFlestDyr(); // antall av flest like dyr
		b = terning.dyrDetErFlestAv(a); // Nr. på det dyret det er flest av

		terning.trill(antall - a); // triller andre gang
		if (terning.sjekk(tall)) {
			return tall;
		} // mindre enn 3 like
		c = terning.antallAvFlestDyr(); // antall flest like dyr
		d = terning.dyrDetErFlestAv(c); // Nr. på det dyret det er flest av
		e = terning.hvorMangeDyr(b); // Hvor mange dyr det ble på trillet av de som jeg har tatt til siden
		if (b != d) { // de til siden er ulik de det er mest av i andre trill
			if (a + e >= c) { // de til siden + de samme i trillet er mer eller lik enn de det er mest av i
								// trillet
				if (a + e >= tall) {
					return tall;
				} else {
					terning.trill(antall - a - e); // tredje trill
					if (terning.sjekk(tall)) {
						return tall;
					}
					h = terning.hvorMangeDyr(b);

					if (a + e + h >= tall) {
						return tall;
					} else {
						return 0;
					}
				}
			} else {
				terning.trill(antall - c); // tredje trill
				if (terning.sjekk(tall)) {
					return tall;
				}
				int i = terning.antallAvFlestDyr();
				int j = terning.dyrDetErFlestAv(i);
				int k = terning.hvorMangeDyr(d);

				if (c + k >= tall) {
					return tall;
				} else {
					return 0;
				}
			}
		} else {
			if (a + c >= tall) {
				return tall;
			} else {
				terning.trill(antall - a - c);
				if (terning.sjekk(tall)) {
					return tall;
				}
				int l = terning.antallAvFlestDyr();
				int m = terning.dyrDetErFlestAv(l);
				int n = terning.hvorMangeDyr(b);

				if (a + c + n >= tall) {
					return tall;
				} else {
					return 0;
				}

			}
		}
	}

	/**
	 * Finner hvor mange poeng man skal ha utifra hvilket rundeNr man er i.
	 * 
	 * @param rundeNr spilleren er i.
	 * @return poeng man skal ha i runden.
	 */
	public int getPoengRunde(int rundeNr) {

		int antall = 5;
		int poeng = 0;

		// Runde 1-6, der man skal ha så mange like som mulig av de forskjellige dyrene.
		if (rundeNr == 1 || rundeNr == 2 || rundeNr == 3 || rundeNr == 4 || rundeNr == 5 || rundeNr == 6) {

			terning.trill(antall);
			int a = terning.hvorMangeDyr(rundeNr);
			terning.trill(antall - a);
			int b = terning.hvorMangeDyr(rundeNr);
			terning.trill(antall - a - b);
			int c = terning.hvorMangeDyr(rundeNr);

			poeng = a + b + c;
			return poeng;
		}

		// Tre like
		else if (rundeNr == 7) {
			return like(3);
		}
		// Fire like
		else if (rundeNr == 8) {
			return like(4);
		}
		// Fem like
		else if (rundeNr == 12) {
			if (like(5) == 5) {
				return 10;
			} else {
				return 0;
			}
		}

		// To par
		else if(rundeNr == 9) { 
			terning.trill(antall); // 1. trill
			if (terning.sjekk(2)) {
				f = terning.antallAvFlestDyr();
				g = terning.dyrDetErFlestAv(f);
				terning.remove(g);
				int x = terning.antallAvFlestDyr();
				int y = terning.dyrDetErFlestAv(x);
				if (terning.sjekk(2) && y != g) {
					return 4;
				}
				terning.trill(antall - 2);
				if (terning.sjekk(2)) { // 2. trill
					return 4;
				}
				terning.trill(antall - 2); // 3. trill
				if (terning.sjekk(2)) {
					return 4;
				}
			}
			terning.trill(antall); // 2. trill. Triller på nytt pga. ingen like på første trill
			if (terning.sjekk(2)) {
				f = terning.antallAvFlestDyr();
				g = terning.dyrDetErFlestAv(f);
				terning.remove(g);
				int x = terning.antallAvFlestDyr();
				int y = terning.dyrDetErFlestAv(x);
				if (terning.sjekk(2) && y != g) {
					return 4;
				}
				terning.trill(antall - 2);
				if (terning.sjekk(2)) { // 3. trill
					return 4;
				}
			}
			terning.trill(antall); // 3. trill. Ingen like ved 1. og 2. trill.
			if (terning.sjekk(2)) {
				f = terning.antallAvFlestDyr();
				g = terning.dyrDetErFlestAv(f);
				terning.remove(g);
				int x = terning.antallAvFlestDyr();
				int y = terning.dyrDetErFlestAv(x);
				if (terning.sjekk(2) && y != g) {
					return 4;
				}
			}
			return 0;
		}
		
		// Hus. 2 like, 3 like 
		else if(rundeNr == 10) {
			terning.trill(antall); // 1.trill
			if(terning.sjekk(3)) {
				f = terning.antallAvFlestDyr();
				g = terning.dyrDetErFlestAv(f);
				terning.remove(g);
				int x = terning.antallAvFlestDyr();
				int y = terning.dyrDetErFlestAv(x); 
				if(terning.sjekk(2) && g != y) {
					return 5;
				}
				terning.trill(antall-3);// 2. trill
				int xx = terning.antallAvFlestDyr();
				int yy = terning.dyrDetErFlestAv(xx);
				if(terning.sjekk(2) && g != yy) {
					return 5;
				}
				terning.trill(antall-3); // 3. trill
				int xxx = terning.antallAvFlestDyr();
				int yyy = terning.dyrDetErFlestAv(xxx);
				if(terning.sjekk(2) && g != yy) {
					return 5;
				}
			} // ferdig med 3 like eller meir på første trill
			
			if(terning.sjekk(2)) {
				f = terning.antallAvFlestDyr();
				g = terning.dyrDetErFlestAv(f);
				terning.remove(g);
				int x = terning.antallAvFlestDyr();
				int y = terning.dyrDetErFlestAv(x); 
				if(terning.sjekk(2) && g != y) {
					terning.remove(y);
					terning.trill(antall-4); // 2. trill. Nå trenger vi enten eit dyr av type g eller y.
					int xx = terning.antallAvFlestDyr();
					int yy = terning.dyrDetErFlestAv(xx);
					if(yy == g || yy == y) {
						return 5;
					}
					terning.trill(antall-4); // 3. trill. Nå trenger vi enten eit dyr av type g eller y.
					int xxx = terning.antallAvFlestDyr();
					int yyy = terning.dyrDetErFlestAv(xxx);
					if(yyy == g || yyy == y) {
						return 5;
					}
				}
				terning.trill(antall-2); // 2. trill
				int xx = terning.antallAvFlestDyr();
				int yy = terning.dyrDetErFlestAv(xx);
				if(terning.sjekk(3) && yy != g) {
					return 5;
				}
				if(terning.sjekk(2) && yy != g) {
					terning.trill(antall-1); // 3. trill. Nå trenger vi enten eit dyr av type g eller yy.
					int xxx = terning.antallAvFlestDyr();
					int yyy = terning.dyrDetErFlestAv(xxx);
					if(yyy == g || yyy == yy) {
						return 5;
					}
				}
				terning.trill(antall-2); // 3. trill. Må ha 3 like på disse te terningene.
				int xxx = terning.antallAvFlestDyr();
				int yyy = terning.dyrDetErFlestAv(xxx);
				if(terning.sjekk(3) && yyy != g) {
					return 5;
				}
			} // ferdig med 2 like på første trill
			
			terning.trill(antall); // 2. trill. Ingen like på første trill
			if(terning.sjekk(3)) {
				f = terning.antallAvFlestDyr();
				g = terning.dyrDetErFlestAv(f);
				terning.remove(g);
				int x = terning.antallAvFlestDyr();
				int y = terning.dyrDetErFlestAv(x); 
				if(terning.sjekk(2) && g != y) {
					return 5;
				}
				terning.trill(antall-3);// 3. trill
				int xx = terning.antallAvFlestDyr();
				int yy = terning.dyrDetErFlestAv(xx);
				if(terning.sjekk(2) && g != yy) {
					return 5;
				}
			}
			if(terning.sjekk(2)) {
				f = terning.antallAvFlestDyr();
				g = terning.dyrDetErFlestAv(f);
				terning.remove(g);
				int x = terning.antallAvFlestDyr();
				int y = terning.dyrDetErFlestAv(x); 
				if(terning.sjekk(2) && g != y) {
					terning.remove(y);
					terning.trill(antall-4); // 3. trill. Nå trenger vi enten eit dyr av type g eller y.
					int xx = terning.antallAvFlestDyr();
					int yy = terning.dyrDetErFlestAv(xx);
					if(yy == g || yy == y) {
						return 5;
					}
				}
			}
			terning.trill(antall); // 3. trill uten nokon like på dei 2 første
			if(terning.sjekk(3)) {
				f = terning.antallAvFlestDyr();
				g = terning.dyrDetErFlestAv(f);
				terning.remove(g);
				int x = terning.antallAvFlestDyr();
				int y = terning.dyrDetErFlestAv(x); 
				if(terning.sjekk(2) && g != y) {
					return 5;
				}
			}
			return 0;
		} // siste for 10
		
		// Straight
		else {
			List<Integer> tilSide = new ArrayList<>();
			terning.trill(antall); // 1.
			terning.overfør(tilSide);
			if(terning.sjekkStraight(tilSide)) {
				return 5;
			} 
			terning.trill(antall-tilSide.size()); // 2.
			terning.overfør(tilSide);
			if(terning.sjekkStraight(tilSide)) {
				return 5;
			}
			terning.trill(antall-tilSide.size()); // 3.
			terning.overfør(tilSide);
			if(terning.sjekkStraight(tilSide)) {
				return 5;
			}
			return 0;
		}	
	}
}











