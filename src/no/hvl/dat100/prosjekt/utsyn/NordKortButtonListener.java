package no.hvl.dat100.prosjekt.utsyn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.hvl.dat100.prosjekt.kontroll.spill.Kontroll;

public class NordKortButtonListener implements ActionListener {

	private Utsyn utsyn;

	public NordKortButtonListener(Utsyn utsyn) {
		this.utsyn = utsyn;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		utsyn.getLogger().info("");

		Kontroll kontroll = utsyn.getKontroll();
		if (kontroll.erNordTur()) {
			kontroll.handlingNord();
			utsyn.oppdater();

		} else {
			utsyn.spillLyd();
		}
	}

}
