package no.hvl.dat100.prosjekt.utsyn;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Lyder {

	private Clip clip;

	private static String lydfil = "resources/error.wav";

	public Lyder() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(lydfil).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Feil med innlesing av lyd:" + ex);
		}
	}

	public void spillLyd() {
		clip.loop(1);
	}
}
