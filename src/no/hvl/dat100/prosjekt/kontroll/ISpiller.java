package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;

public interface ISpiller {
	/**
	 * Henter spillerens hånd.
	 * 
	 * @return hÂnden til spilleren
	 */
	public KortSamling getHand();

	/**
	 * Gir antall kort spilleren har på hånd.
	 * 
	 * @return antall kort spilleren har på hånd.
	 */
	public int getAntallKort();

	/**
	 * Hvem spilleren er (nord, syd).
	 * 
	 * @return hvem spilleren er.
	 */
	public Spillere hvem();

	/**
	 * Avjgør om spiller er ferdig (har ingen kort).
	 * 
	 * @return true om spilleren er ferdig, false ellers.
	 */
	public boolean erFerdig();

	/**
	 * Legger et kort til spillerens hånd.
	 * 
	 * @param kort
	 *            kortet som legges til.
	 */
	public void leggTilKort(Kort kort);

	/**
	 * Fjerner et kort fra spillerens hÂnd. Kortet skal finnes ved hjelp av
	 * equals() metoden i kort.
	 * 
	 * @param kort
	 *            som skal fjernes fra hÂnden.
	 */
	public void fjernKort(Kort kort);

	/**
	 * Fjerner alle kort fra hånden slik at man er klar for neste spill.
	 */
	public void fjernAlleKort();

	/**
	 * Trekker et kort fra bunken.
	 * 
	 * @param kort
	 *            som trekkes.
	 */
	public void trekker(Kort kort);

	/**
	 * Antall ganger spiller har trukket fra bunken mens han har vært i tur.
	 * 
	 * @return antall ganger spilleren har trukket.
	 */
	public int getAntallTrekk();

	/**
	 * Kan angi hvor mange ganger spilleren har trukket. Spesielt aktuelt for å
	 * kunne sette antall trekk til 0 (etter spilleren har spilt et kort eller
	 * sagt forbi).
	 * 
	 * @param trekk
	 *            antal ganger spilleren har trukket.
	 */
	public void setAntallTrekk(int trekk);

	/**
	 * Gir neste handling (spill et kort, trekk et kort, eller forbi).
	 * 
	 * @param topp
	 *            kortet øverst i til-bunken.
	 * @return neste handling.
	 */
	public Handling nesteHandling(Kort topp);

}
