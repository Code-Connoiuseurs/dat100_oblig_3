package no.hvl.dat100.prosjekt.utsyn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.hvl.dat100.prosjekt.kontroll.spill.Kontroll;

public class AutospillButtonListener implements ActionListener {

	private Utsyn utsyn;

	public AutospillButtonListener(Utsyn utsyn) {
		this.utsyn = utsyn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		utsyn.getLogger().info("");

		Kontroll kontroll = utsyn.getKontroll();

		kontroll.spillAuto();
		utsyn.oppdater();
	}

}
