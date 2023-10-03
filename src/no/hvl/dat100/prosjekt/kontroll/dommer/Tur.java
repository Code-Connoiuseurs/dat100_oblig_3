package no.hvl.dat100.prosjekt.kontroll.dommer;

import java.util.Random;

import no.hvl.dat100.prosjekt.kontroll.Spiller;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;

public class Tur {

	private static Spillere aktiv = Spillere.INGEN;

	public static Spillere tur() {
		
		return aktiv;
		
	}

	public static void velgSpiller() {
		
		Random mont = new Random();

		if (mont.nextInt(2) == 0) {
			aktiv = Spillere.NORD;
		} else {
			aktiv = Spillere.SYD;
		}

	}

	public static void skiftSpiller() {
		
		switch (aktiv) {
		
		case SYD:
			aktiv = Spillere.NORD;
			break;
		case NORD:
			aktiv = Spillere.SYD;
			break;
		default:
			aktiv = Spillere.INGEN;
			break;

		}
	}

	// TODO: kanskje flyttes til kontroll og implementer som ferdig når en av
	// spillere er tom
	public static void ferdig() {
		
		aktiv = Spillere.INGEN;
		
	}

	public static boolean erTur(Spiller spiller) {
		
		return (spiller.hvem() == aktiv);
		
	}

	public static boolean erSydTur() {
		
		return (aktiv == Spillere.SYD);
		
	}

	public static boolean erNordTur() {
		
		return (aktiv == Spillere.NORD);
		
	}
}
