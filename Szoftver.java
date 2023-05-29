package myPackage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Szoftver {

	enum Style {
		IRODAI, JATEK, MEDIA
	}
	
	private String nev;
	private int ar;
	private Style stilus;
	private ArrayList<String> tamogatottOS;
	private LocalDate datum;
	
	public Szoftver(String nev, int ar, Style stilus, ArrayList<String> tamogatottOS, LocalDate datum) {
		super();
		this.nev = nev;
		this.ar = ar;
		this.stilus = stilus;
		this.tamogatottOS = tamogatottOS;
		this.datum = datum;
	}

	public Szoftver(String nev, ArrayList<String> tamogatottOS) {
	    this(nev, (int)(Math.random() * (20000 - 10000) + 10000), Style.IRODAI, tamogatottOS, LocalDate.now());
	}

	public String getNev() {
		return nev;
	}
	public int getAr() {
		return ar;
	}
	public void setAr(int ar) {
		this.ar = ar;
	}
	public Style getStilus() {
		return stilus;
	}
	public void setStilus(Style stilus) {
		this.stilus = stilus;
	}
	public ArrayList<String> getTamogatottOS() {
		return tamogatottOS;
	}
	public void setTamogatottOS(ArrayList<String> tamogatottOS) {
		this.tamogatottOS = tamogatottOS;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	
	@Override
	public String toString() {
		return "Szoftver [nev=" + nev + ", ar=" + ar + ", stilus=" + stilus + ", tamogatottOS=" + tamogatottOS
				+ ", datum=" + datum + "]";
	}

	public static Szoftver compare (Szoftver sz1, Szoftver sz2) {
		if(sz1.getAr() > sz2.getAr()) {
			return sz1;
		}else {
			return sz2;
		}
	}
	
}
