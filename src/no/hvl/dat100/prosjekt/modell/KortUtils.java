package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {


	public static void sorter(KortSamling samling) {
		Kort[] kortArray = samling.getSamling();
		int length = samling.getAntalKort();
		
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i; j++) {
				Kort erKort = kortArray[j + 1];
				
				if (erKort == null)  {
					continue;
				}
				if( kortArray[j].compareTo(kortArray[j + 1]) > 0) {
					Kort temp = kortArray[j];
					kortArray[j] = kortArray[j +1];
					kortArray[j +1] = temp;
				}
			}
		}
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		
		// TODO - START
		
		throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}
	
}
