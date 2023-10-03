package no.hvl.dat100.prosjekt.utsyn;

import javax.swing.ImageIcon;

import no.hvl.dat100.prosjekt.modell.*;

public class KortIkoner {

	public static int ANTALL_FARGE = 13;
	static String IKON_MAPPE = "resources/";

	private static char KLOVER = 'c';
	private static char SPAR = 's';
	private static char HJERTER = 'h';
	private static char RUTER = 'd';

	private static ImageIcon[] ruter, hjerter, klover, spar;

	public KortIkoner() {
		spar = new ImageIcon[ANTALL_FARGE];
		hjerter = new ImageIcon[ANTALL_FARGE];
		klover = new ImageIcon[ANTALL_FARGE];
		ruter = new ImageIcon[ANTALL_FARGE];
	}

	public void lesInn() {
		lesInnFarge(SPAR, spar);
		lesInnFarge(HJERTER, hjerter);
		lesInnFarge(RUTER, ruter);
		lesInnFarge(KLOVER, klover);
	}

	private void lesInnFarge(char c, ImageIcon[] ikoner) {
		for (int i = 1; i <= ANTALL_FARGE; i++) {
			ikoner[i - 1] = new ImageIcon(IKON_MAPPE + i + c + ".gif");
		}
	}

	public static ImageIcon hentIkon(Kort kort) {
		ImageIcon ikon = null;

		int i = kort.getVerdi();
		Kortfarge farge = kort.getFarge();

		if (i >= 1 && i <= ANTALL_FARGE) {
			switch (farge) {
			case Hjerter:
				ikon = hjerter[i - 1];
				break;
			case Spar:
				ikon = spar[i - 1];
				break;
			case Ruter:
				ikon = ruter[i - 1];
				break;
			case Klover:
				ikon = klover[i - 1];
				break;
			default:
				break;

			}
		} else {
			System.out.println("hentIkon - index " + i + "ikke gyldig");
		}

		return ikon;
	}
}
