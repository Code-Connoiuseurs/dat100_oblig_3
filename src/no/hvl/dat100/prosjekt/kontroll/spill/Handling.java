package no.hvl.dat100.prosjekt.kontroll.spill;

import no.hvl.dat100.prosjekt.modell.Kort;

public class Handling {

	private HandlingsType type;
	private Kort kort;

	public Handling(HandlingsType t, Kort k) {
		type = t;
		kort = k;
	}

	public HandlingsType getType() {
		return type;
	}

	public void setType(HandlingsType status) {
		this.type = status;
	}

	public Kort getKort() {
		return kort;
	}

	public void setKort(Kort kort) {
		this.kort = kort;
	}

	public boolean skifteTur() {
		return (type == HandlingsType.LEGGNED) || (type == HandlingsType.FORBI);
	}

	@Override
	public String toString() {

		String str = null;

		switch (type) {
		case TREKK:
			str = "trekker fra bunke";
			break;
		case FORBI:
			str = "melder forbi";
			break;
		case LEGGNED:
			str = "legger ned " + kort.toString();
			break;
		default:
			break;
		}

		return str;
	}
}
