package no.hvl.dat100.prosjekt.modell;

//import java.util.Collections;
//import java.util.Random;

public class KortUtils {
	public static void sorter(KortSamling kortSamling) {
		if (kortSamling.erTom()) return;
		
		Kort[] samling = kortSamling.getSamling();
		int antallKort = kortSamling.getAntalKort();
		
		for (int i = 0; i < antallKort - 1; i++) {
			for (int j = 0; j < antallKort - i; j++) {
				Kort erkort = samling[j+1];
				
				if (erkort == null)  {
					continue;
				}
				
				if (samling[j].compareTo(samling[j+1]) > 0) {
					Kort temp = samling[j];
					samling[j] = samling[j+1];
					samling[j+1] = temp;
				}
			}
		}
		return;
	}
	
	public static void stokk(KortSamling kortSamling) {
		Kort[] samling = kortSamling.getSamling();
		int antallKort = kortSamling.getAntalKort();
		
		for (int i = antallKort - 1; i >= 0; i--) {							// stokker fra høyest index til start index
			int tilfeldigIndeks = (int)(Math.random() * antallKort - 1);	// (i + 1) (i >= 0 i loopen) er grensene til den randomiserte indexen
			Kort temp = samling[i];											// Math.random er selve randomiseren ofc
			samling[i] = samling[tilfeldigIndeks];
			samling[tilfeldigIndeks] = temp;
		}
		return;
	}
}
