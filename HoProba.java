package homero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import homero.Homerseklet.Mertekegyseg;

public class HoProba {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		File file_kiir = new File("homersekletek.txt");
		File file_beolvas = new File("datas.txt");
		ArrayList<String> readedData= new ArrayList<String>(readFromFile(file_beolvas));
		
		Homerseklet homerseklet1 = new Homerseklet(ellenorzott_beolvas_hom_ertek(), ellenorzott_beolvas_hom_mertekegyseg());
		Homerseklet homerseklet2 = new Homerseklet(ellenorzott_beolvas_hom_ertek(), ellenorzott_beolvas_hom_mertekegyseg());
		Homerseklet homerseklet3 = new Homerseklet(Double.parseDouble(readedData.get(0)), Mertekegyseg.valueOf(readedData.get(1)));
		Homerseklet homerseklet4 = new Homerseklet(Double.parseDouble(readedData.get(2)), Mertekegyseg.valueOf(readedData.get(3)));

		ArrayList<Homerseklet> tomb = new ArrayList<Homerseklet>();
		tomb.addAll(Arrays.asList(homerseklet1, homerseklet2, homerseklet3, homerseklet4));

		System.out.println("---------------");
		kiir(tomb);
		System.out.println("---------------");
		
		System.out.println(homerseklet1.konvertalas(homerseklet1.getHomerseklet_ertek(), homerseklet1.getMertekegyseg()));
		System.out.println(homerseklet2.konvertalas(homerseklet2.getHomerseklet_ertek(), homerseklet2.getMertekegyseg()));
		
		System.out.println(atlag(tomb));
		writeInFile(file_kiir, tomb);
		Collections.sort(tomb, new Comparator<Homerseklet>() {
			public int compare(Homerseklet h1, Homerseklet h2) {
				return (int) (h1.getHomerseklet_ertek() - h2.getHomerseklet_ertek());
				// ha stringet hasonlítunk
				// return h1.getNev().compareTo(h2.getNev());
			}
		});
		
		System.out.println("----------------");
		kiir(tomb);
		System.out.println("");
	}

	//készíts egy metódust, ami egy tömböt kap paraméterbe, megszámolja mennyi elemet tartalmaz és visszaadja visszatérési értékként
	
	private static ArrayList<String> readFromFile(File file) {
		ArrayList<String> tomb = new ArrayList<String>();
		String line;
		try (FileReader filereader = new FileReader(file); BufferedReader reader = new BufferedReader(filereader)) {
			while((line = reader.readLine()) != null) {
				tomb.add(line);
			}
		} catch (Exception e) {
			System.out.println("Hiba történt a fájl olvasása közben: " + e.getMessage());
		}
		
		return tomb;
	}

	private static void writeInFile(File file_kiir, ArrayList<Homerseklet> tomb) {
		try (FileWriter filewriter = new FileWriter(file_kiir)) {
			for(Homerseklet homerseklet : tomb) {
				filewriter.write(homerseklet + "\n");
			}
			filewriter.flush();
		} catch (Exception e) {
			System.out.println("Fileba íráskor hiba keletkezett..." + e.getMessage());
		}
		
	}

	public static double ellenorzott_beolvas_hom_ertek() {
		int ertek = 0;
		do {
			System.out.println("Kerunk egy szamot 0 - 1000 kozott!");
			while (!scanner.hasNextInt()) {
				System.out.println("Ez nem szam! Adjon meg ujra valamit!");
				scanner.next();
			}
			ertek = scanner.nextInt();
		} while (ertek > 1000 || ertek <= 0); // 0 és 1000 között
		return ertek;
	}

	public static Mertekegyseg ellenorzott_beolvas_hom_mertekegyseg() {
		Boolean ok = false;
		Mertekegyseg result = null;
		do {
			System.out.println("Adjon meg egy mertekegyseget! (CELSIUS, KELVIN)");
			String input = scanner.next();
			try {
				result = Mertekegyseg.valueOf(input.toUpperCase());
				ok = true;
			} catch (IllegalArgumentException e) {
				System.out.println("Rossz erteket adott meg!");
			}
		} while (!ok);
		return result;
	}

	public static double random_szam() {
		return (Math.random() * (100 - 0)) + 0;
	}

	public static void kiir(ArrayList<Homerseklet> tomb) {
		for (Homerseklet homerseklet : tomb) {
			System.out.println(homerseklet);
		}
	}

	public static double atlag(ArrayList<Homerseklet> tomb) {
		double atlag = 0;
		for (Homerseklet homerseklet : tomb) {
			if(homerseklet.getMertekegyseg().equals(Mertekegyseg.CELSIUS)) {
				atlag += homerseklet.konvertalas(homerseklet.getHomerseklet_ertek(), homerseklet.getMertekegyseg());
			}else {
				atlag += homerseklet.getHomerseklet_ertek();
			}
			
		}
		return atlag/4;
	}
	
}
