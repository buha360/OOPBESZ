package myPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import myPackage.Szoftver.Style;

public class Main {

	// valamiert ide ki kellett rakni idk miert
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		ArrayList<Szoftver> tomb = new ArrayList<Szoftver>();
		Szoftver sz1 = beolvas();
		tomb.add(sz1);
		Szoftver sz2 = beolvas();
		tomb.add(sz2);
		
		kiir(tomb);
		tomb = compareMain(tomb);
		kiir(tomb);
	}

	public static void compareMain(ArrayList<Szoftver> tomb) {
		Collections.sort(tomb, new Comparator<Szoftver>() {
			public int compare(Szoftver h1, Szoftver h2) {
				return (int) (h1.getAr() - h2.getAr());
				// ha stringet hasonlítunk
				// return h1.getNev().compareTo(h2.getNev());
			}
		});
	}
	
	public static void kiir(ArrayList<Szoftver> tomb) {
		for (Szoftver szoftver : tomb) {
			System.out.println(szoftver);
		}
	}

	public static Szoftver beolvas() {
			int ar = 0;
			String nev = null;
			Style stílus;
			ArrayList<String> tamogatottOS;
			int korhatar = 0;
			
			do {
				System.out.println("Kerek egy szamot 10.000 - 100.000 kozott!");
				while (!scanner.hasNextInt()) {
					System.out.println("Ez nem szam!");
					scanner.next();
				}
				ar = scanner.nextInt();
			} while (ar < 10000 || ar > 100000);
			
			do {
				System.out.println("Adja meg a szoftver nevet!");
				while (!scanner.hasNext()) {
					System.out.println("Nem helyes a nev!");
					scanner.next();
				}
				nev = scanner.next();
			} while (nev.isEmpty());

			do {
				System.out.println("Adja meg a szoftver tipusat (1 - IRODAI, 2 - JATEK, 3 - MEDIA)!");
				while (!scanner.hasNextInt()) {
					System.out.println("Ez nem szam!");
					scanner.next();
				}
				int stílusValue = scanner.nextInt();
				switch (stílusValue) {
				case 1:
					stílus = Style.IRODAI;
					break;
				case 2:
					stílus = Style.JATEK;
					break;
				case 3:
					stílus = Style.MEDIA;
					break;
				default:
					stílus = Style.IRODAI;
					break;
				}
			} while (stílus == null);

			if (stílus == Style.JATEK) {
				do {
					System.out.println("Kerem adja meg a korhatart (6-18)!");
					while (!scanner.hasNextInt()) {
						System.out.println("Ez nem szam! Adjon meg ujra valamit!");
						scanner.next();
					}
					korhatar = scanner.nextInt();
				} while (korhatar > 18 || korhatar < 6);
			}
			
			scanner.nextLine(); // Újsor karakter beolvasása
			
	        System.out.println("Adja meg a tamogatott operacios rendszerek listajat (vesszovel elvalasztva)!");
	        String tamogatottOSString = scanner.nextLine();
	        tamogatottOS = new ArrayList<>();
	        if (!tamogatottOSString.isEmpty()) {
	            String[] osArray = tamogatottOSString.split(",");
	            for (String os : osArray) {
	                tamogatottOS.add(os.trim());
	            }
	        }
			
			LocalDate datum = LocalDate.now();

			if (stílus == Style.JATEK) {
				JatekSzoftver jatekSzoftver = new JatekSzoftver(nev, ar, stílus, tamogatottOS, datum, korhatar);
				return jatekSzoftver;
			} else {
				Szoftver szoftver = new Szoftver(nev, ar, stílus, tamogatottOS, datum);
				return szoftver;
			}
		}

}
