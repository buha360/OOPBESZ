package homero;

public class Homerseklet {
	
	enum Mertekegyseg {
		CELSIUS, KELVIN
	}
	
	private double homerseklet_ertek;
	private Mertekegyseg mertekegyseg;
	
	public Homerseklet(double homerseklet_ertek, Mertekegyseg mertekegyseg) {
		super();
		this.homerseklet_ertek = homerseklet_ertek;
		this.mertekegyseg = mertekegyseg;
	}

	public Homerseklet(double homerseklet_ertek) {
		super();
		this.homerseklet_ertek = homerseklet_ertek;
		this.mertekegyseg = Mertekegyseg.CELSIUS;
	}
	
	public double getHomerseklet_ertek() {
		return homerseklet_ertek;
	}

	public void setHomerseklet_ertek(double homerseklet_ertek) {
		this.homerseklet_ertek = homerseklet_ertek;
	}

	public Mertekegyseg getMertekegyseg() {
		return mertekegyseg;
	}

	public void setMertekegyseg(Mertekegyseg mertekegyseg) {
		this.mertekegyseg = mertekegyseg;
	}

	@Override
	public String toString() {
		return "Homerseklet [homerseklet_ertek=" + homerseklet_ertek + ", mertekegyseg=" + mertekegyseg + "]";
	}

	public double konvertalas (double homerseklet_ertek, Mertekegyseg mertekegyseg) {
		double konvertalt_ertek_celsius = homerseklet_ertek - 273.15;
		double konvertalt_ertek_kelvin = homerseklet_ertek + 275.15;
		
		if(mertekegyseg.equals(Mertekegyseg.CELSIUS)) {
			return konvertalt_ertek_kelvin;
		}else {
			return konvertalt_ertek_celsius;
		}
	}
	
	
}
