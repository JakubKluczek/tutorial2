import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź swój wiek: ");
        int wiek = scanner.nextInt();
        System.out.println("Czy jesteś mieszkańcem Warszawy? (tak/nie): ");
        String miasto = scanner.next();
        System.out.println("Czy bilet jest kupowany w czwartek? (tak/nie): ");
        String czwartak = scanner.next();
        double cenaBiletu = 40.0;
        boolean zaDarmo = false;
        String rabatInfo = "Zniżki: ";
        if (wiek < 10 || czwartak.equalsIgnoreCase("tak")) {
            cenaBiletu = 0;
            zaDarmo = true;
            rabatInfo += "wstęp bezpłatny, ";
        } else {
            if (wiek >= 10 && wiek <= 18) {
                cenaBiletu *= 0.5;
                rabatInfo += "50% zniżki za wiek, ";
            }
            if (miasto.equalsIgnoreCase("tak")) {
                cenaBiletu *= 0.9;
                rabatInfo += "10% zniżki dla mieszkańca Warszawy, ";
            }
        }

        if (!zaDarmo) {
            rabatInfo = rabatInfo.substring(0, rabatInfo.length() - 2);
        } else {
            rabatInfo += "100% zniżki";
        }

        System.out.println("Dane klienta:");
        System.out.println("Wiek: " + wiek);
        System.out.println("Mieszkaniec Warszawy: " + (miasto.equalsIgnoreCase("tak") ? "tak" : "nie"));
        System.out.println("Zakup w czwartek: " + (czwartak.equalsIgnoreCase("tak") ? "tak" : "nie"));
        System.out.println(rabatInfo);
        System.out.println("Cena biletu po rabacie: " + cenaBiletu + " zł");
    }
}
