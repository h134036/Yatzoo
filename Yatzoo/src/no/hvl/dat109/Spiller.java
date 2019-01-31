package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;

public class Spiller {

private Runde runde = new Runde();
private String navn;
private int poeng;
private int sumPoeng;
private List<Integer> poengListe = new ArrayList<>();

public Spiller(String navn) {
	this.navn = navn;
	this.sumPoeng = 0;
}

public void setSumPoeng(int sumPoeng) {
	this.sumPoeng = sumPoeng;
}

/**
 * Spiller ett trekk og legger til poeng i sumPoeng, og legger til poeng i poengListe.
 * 
 * @param int a som er rundeNr.
 */
public void spillTrekk(int a) {
	poeng = runde.getPoengRunde(a);
	sumPoeng += poeng;
	poengListe.add(poeng);
}

public List<Integer> getPoengListe() {
	return poengListe;
}

public void setPoengListe(List<Integer> poengListe) {
	this.poengListe = poengListe;
}

public String getNavn() {
	return navn;
}

public void setNavn(String navn) {
	this.navn = navn;
}

public int getSumPoeng() {
	return sumPoeng;
}

public void setPoeng(int poeng) {
	this.poeng = poeng;
}
	



}
