package no.hvl.dat100.prosjekt.utsyn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import no.hvl.dat100.prosjekt.kontroll.spill.Kontroll;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;

public class Utsyn extends JFrame {

	static final long serialVersionUID = 42;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static String NORD_STR = "Nord";
	private static String NUL_ANTALL_STR = "0";
	private static String BORD_STR = "Bord";
	private static String SYD_STR = "Syd";

	private static String START_ICON = "startknapp.png";
	private static String SPILL_ICON = "autospill.png";
	private static String CARDBLANK_ICON = "blanktkort.png";
	private static String CARDDOWN_ICON = "bakside.gif";

	private static String SYD_ICON = "spiller.png";
	private static String NORD_ICON = "cardhand.png";
	private static String VINNER_ICON = "vinner.png";

	private static String PILNED_ICON = "button_arrow_green_down.png";
	private static String PILOPP_ICON = "button_arrow_green_up.png";

	private Kontroll kontroll;

	// elementer i grensesnitt
	private JButton nordhand;
	private JLabel nordantal;

	private JButton autospill;
	private JButton bunkefra;
	private JLabel bunkefraantal, bunketilantal;
	private JLabel bunketil;

	private JButton startspill, tur, sydhand;
	private JPanel syd;

	private ImageIcon carddown, cardblank, nordikon;
	private ImageIcon vinnerikon, sydikon;
	private ImageIcon startikon, autoikon, pilopp, pilned;

	private Lyder lyd;
	private ArrayList<GUIKort> guikort;

	public Utsyn(Kontroll kontroll) {
		super("vri-\u00e5tte");

		this.kontroll = kontroll;

		// layout for hovedvindue
		setLayout(new BorderLayout());

		lastinnIkoner();

		lyd = new Lyder();

		setoppNord();
		settoppBord();
		setoppSyd();

		// action listeners
		nordhand.addActionListener(new NordKortButtonListener(this));
		bunkefra.addActionListener(new FraBunkeButtonListener(this));
		startspill.addActionListener(new StartButtonListener(this));
		sydhand.addActionListener(new SydButtonListener(this));
		tur.addActionListener(new TurButtonListener(this));
		autospill.addActionListener(new AutospillButtonListener(this));

		// start vinduet
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

		// start spillet
		kontroll.startSpill();
		oppdater();
	}

	public Logger getLogger() {
		return LOGGER;
	}

	private void setoppSyd() {
		// gui elementer for syd
		syd = new JPanel();
		syd.setBorder(new TitledBorder(new EtchedBorder(), SYD_STR));
		syd.setSize(230, 600);

		JScrollPane kort = new JScrollPane(syd);

		sydhand = new JButton(sydikon);
		sydhand.setMargin(new Insets(0, 0, 0, 0));

		syd.add(sydhand);

		syd.setBackground(Color.WHITE);
		add(kort, BorderLayout.SOUTH);
	}

	private void settoppBord() {
		// gui elementer for bordet
		JPanel bord = new JPanel();
		bord.setBorder(new TitledBorder(new EtchedBorder(), BORD_STR));

		startspill = new JButton(startikon);
		startspill.setMargin(new Insets(0, 0, 0, 0));

		bunkefra = new JButton(cardblank);
		bunkefra.setMargin(new Insets(0, 0, 0, 0));
		bunkefraantal = new JLabel(NUL_ANTALL_STR);

		bunketil = new JLabel(cardblank);
		bunketilantal = new JLabel(NUL_ANTALL_STR);

		tur = new JButton(pilopp);

		autospill = new JButton(autoikon);
		autospill.setMargin(new Insets(0, 0, 0, 0));

		bord.add(startspill);
		bord.add(tur);

		bord.add(bunkefra);
		bord.add(bunkefraantal);

		bord.add(bunketilantal);
		bord.add(bunketil);

		bord.add(autospill);

		bord.setBackground(Color.WHITE);
		add(bord, BorderLayout.CENTER);
	}

	private void setoppNord() {
		// gui elementer for nord
		JPanel nord = new JPanel();
		nord.setBorder(new TitledBorder(new EtchedBorder(), NORD_STR));

		nordhand = new JButton(nordikon);
		nordhand.setMargin(new Insets(0, 0, 0, 0));

		nordantal = new JLabel(NUL_ANTALL_STR);

		nord.add(nordhand);
		nord.add(nordantal);

		nord.setBackground(Color.WHITE);
		add(nord, BorderLayout.NORTH);
	}

	private void lastinnIkoner() {

		// opprett og les inn ikoner for alle kort
		KortIkoner ikoner = new KortIkoner();
		ikoner.lesInn();

		// last inn alle ikoner for knapper
		carddown = new ImageIcon(KortIkoner.IKON_MAPPE + CARDDOWN_ICON);
		cardblank = new ImageIcon(KortIkoner.IKON_MAPPE + CARDBLANK_ICON);

		nordikon = new ImageIcon(KortIkoner.IKON_MAPPE + NORD_ICON);
		sydikon = new ImageIcon(KortIkoner.IKON_MAPPE + SYD_ICON);
		vinnerikon = new ImageIcon(KortIkoner.IKON_MAPPE + VINNER_ICON);

		pilopp = new ImageIcon(KortIkoner.IKON_MAPPE + PILOPP_ICON);
		pilned = new ImageIcon(KortIkoner.IKON_MAPPE + PILNED_ICON);

		startikon = new ImageIcon(KortIkoner.IKON_MAPPE + START_ICON);
		autoikon = new ImageIcon(KortIkoner.IKON_MAPPE + SPILL_ICON);
	}

	public Kontroll getKontroll() {
		return kontroll;
	}

	public JLabel getOverste() {
		return bunketil;
	}

	public JPanel getSyd() {
		return syd;
	}

	public void setSyd(JPanel syd) {
		this.syd = syd;
	}

	public void visNordAntall(int i) {
		nordantal.setText(Integer.toString(i));
	}

	public void visBunkeFraAntall(int i) {
		bunkefraantal.setText(Integer.toString(i));
	}

	public void visBunkeTilAntall(int i) {
		bunketilantal.setText(Integer.toString(i));
	}

	public void visOverste(Kort kort) {
		bunketil.setIcon(KortIkoner.hentIkon(kort));
	}

	public void setBunkeAktiv() {
		bunkefra.setIcon(carddown);
	}

	public void setSpillerTur(Spillere spiller) {
		switch (spiller) {
		case NORD:
			tur.setIcon(pilopp);
			break;
		case SYD:
			tur.setIcon(pilned);
			break;
		case INGEN:
			break;
		}
	}

	public void visKortSyd(Kort kort) {
		JButton etkort = new JButton(KortIkoner.hentIkon(kort));
		etkort.setMargin(new Insets(0, 0, 0, 0));

		etkort.addActionListener(new SydKortButtonListener(kort, this));

		guikort.add(new GUIKort(kort, etkort));

		syd.add(etkort);
		syd.repaint();
	}

	public void visAlleKortSyd() {
		syd.removeAll();
		// TODO: implementer så eksisterende elementer genbrukes
		// og der blott skiftes ikon på det.

		sydhand = new JButton(sydikon);
		sydhand.setMargin(new Insets(0, 0, 0, 0));
		sydhand.addActionListener(new SydButtonListener(this));

		syd.add(sydhand);

		Kort[] kortspiller = kontroll.kortSyd();

		guikort = new ArrayList<GUIKort>();

		for (Kort k : kortspiller) {
			visKortSyd(k);
		}

		syd.validate();
		syd.repaint();
	}

	// oppdater gui to matche tilstand i kontroller
	public void oppdater() {

		// oppdater for nord
		visNordAntall(kontroll.antallNord());

		// oppdater bunker
		setBunkeAktiv();

		visBunkeTilAntall(kontroll.antallBunkeTil());
		visBunkeFraAntall(kontroll.antallBunkeFra());

		if (!kontroll.bunketilTom()) {
			visOverste(kontroll.hentOverste());
		}

		// oppdater icon for neste spiller
		setSpillerTur(kontroll.aktivSpiller());

		// oppdater kort for syd
		visAlleKortSyd();

		// sjekk om en spiller har vunnet
		switch (kontroll.vinner()) {
		case NORD:
			nordhand.setIcon(vinnerikon);
			break;
		case SYD:
			sydhand.setIcon(vinnerikon);
			break;
		case INGEN:
			sydhand.setIcon(sydikon);
			nordhand.setIcon(nordikon);
			break;
		}

		this.repaint();
	}

	void spillLyd() {
		lyd.spillLyd();
	}

	void fremhevKort(Kort kort) {

		Iterator<GUIKort> it = guikort.iterator();

		boolean funnet = false;

		while (it.hasNext() && !funnet) {
			GUIKort etguikort = it.next();

			if (etguikort.getKort().lik(kort)) {
				etguikort.fremhev();
				funnet = true;
			}
		}

	}

	public void visMelding(String melding) {
		JOptionPane.showMessageDialog(this, melding);
	}
}
