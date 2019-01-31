package no.hvl.dat109;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Eivin Sellevold og Cato Robstad
 *
 *Tester om terningene virker som de skal
 */
public class TestForMetoder {
	
	private static final Integer ANTALL_KAST = 1000;
	private Terning terning;
	private Runde runde;
	private Random rand = new Random();
	int ANTALL_TERNINGER = 0;

	@Before
	public void setUp() {
		terning = new Terning();
		runde = new Runde();
	}
	
	/**
	 * Tester at man får det antallet av terninger man ønsker. 
	 */
	@Test
	public void test1() {
		for(int i = 0; i < ANTALL_KAST; i++) {
			ANTALL_TERNINGER = rand.nextInt(6) + 1;
			terning.trill(ANTALL_TERNINGER);
			
			assertEquals(ANTALL_TERNINGER, terning.getTerninger().size());
		}
	}
	
	/**
	 * Tester straight-metoden
	 */
	@Test
	public void test2() {
		terning.getTerninger().add(1);
		terning.getTerninger().add(2);
		terning.getTerninger().add(3);
		terning.getTerninger().add(4);
		terning.getTerninger().add(5);
		assertEquals(true, terning.sjekkStraight(terning.getTerninger()));	
		
		terning.getTerninger().clear();
		terning.getTerninger().add(1);
		terning.getTerninger().add(1);
		terning.getTerninger().add(2);
		terning.getTerninger().add(3);
		terning.getTerninger().add(4);
		assertEquals(false, terning.sjekkStraight(terning.getTerninger()));
	}
}



















