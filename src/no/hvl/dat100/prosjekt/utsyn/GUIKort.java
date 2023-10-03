package no.hvl.dat100.prosjekt.utsyn;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import no.hvl.dat100.prosjekt.modell.Kort;

public class GUIKort {
	private Kort kort;
	private JButton button;

	public GUIKort(Kort kort, JButton button) {
		this.kort = kort;
		this.button = button;
	}

	public Kort getKort() {
		return kort;
	}

	public void setKort(Kort kort) {
		this.kort = kort;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public void fremhev() {
		button.setBorder(new LineBorder(Color.GREEN, 5));
	}
}
