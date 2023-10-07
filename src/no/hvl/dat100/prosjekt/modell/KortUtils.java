package no.hvl.dat100.prosjekt.modell;

import java.util.Collections;
import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {


	public static void sorter(KortSamling samling) {
		Kort[] kortarray = samling.getSamling();
		int length = samling.getAntalKort();
		
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i; j++) {
				Kort erkort = kortarray[j + 1];
				
				if (erkort == null)  {
					continue;
				}
				if( kortarray[j].compareTo(kortarray[j + 1]) > 0) {
					Kort temp = kortarray[j];
					kortarray[j] = kortarray[j +1];
					kortarray[j +1] = temp;
				}
			}
		}
	}
	
	public static void stokk(KortSamling samling) {
		Kort[] kortarray = samling.getSamling();
		int length = samling.getAntalKort();
		
			for (int i = length - 1; i > 0; i--) {				// stokker fra høyest index til start index
				int randomise = (int)(Math.random()*(i + 1));	// (i + 1) (i > 0 i loopen) er grensene til den randomiserte indexen
				Kort temp = kortarray[i];						// Math.random er selve randomiseren ofc
				kortarray[i] = kortarray[randomise];
				kortarray[randomise] = temp;
			}	
		}
	}
