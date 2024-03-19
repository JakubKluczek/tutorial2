import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź swój wiek: ");
        int wiek = scanner.nextInt();
        System.out.println("Czy jesteś mieszkańcem Warszawy? (tak/nie): ");
        boolean jestRezydentem = scanner.next().equalsIgnoreCase("tak");
        System.out.println("Czy bilet jest kupowany w czwartek? (tak/nie): ");
        boolean czwartek = scanner.next().equalsIgnoreCase("tak");
        double cenaBiletu = kalkulatorCenyBiletow(wiek, jestRezydentem, czwartek);
        String rabat = wypisywanInfoRabat(wiek, jestRezydentem, czwartek, cenaBiletu);
        System.out.println("Dane klienta:");
        System.out.println("Wiek: " + wiek);
        System.out.println("Mieszkaniec Warszawy: " + (jestRezydentem ? "tak" : "nie"));
        System.out.println("Zakup w czwartek: " + (czwartek ? "tak" : "nie"));
        System.out.println(rabat);
        System.out.println("Cena biletu po rabacie: " + cenaBiletu + " zł");
    }
    public static double kalkulatorCenyBiletow(int wiek, boolean jestRezydentem, boolean czwartek) {
        double cenaBiletu = 40.0;
        if (wiek < 10 || czwartek) {
            cenaBiletu = 0;
        } else {
            if (wiek >= 10 && wiek <= 18) {
                cenaBiletu *= 0.5;
            }
            if (jestRezydentem) {
                cenaBiletu *= 0.9;
            }
        }
        return cenaBiletu;
    }
    public static String wypisywanInfoRabat(int wiek, boolean jestRezydentem, boolean czwartek, double cenaBiletu) {
        String rabat = "Zniżki: ";
        boolean zaDarmo = cenaBiletu == 0;
        if (wiek < 10 || czwartek) {
           rabat += "wstęp bezpłatny, ";
        } else {
            if (wiek >= 10 && wiek <= 18) {
                rabat += "50% zniżki za wiek, ";
            }
            if (jestRezydentem) {
               rabat += "10% zniżki dla mieszkańca Warszawy, ";
            }
        }
        if (!zaDarmo) {
            rabat = rabat.substring(0, rabat.length() - 2);
        } else {
            rabat += "100% zniżki";
        }
        return rabat;
    }
}