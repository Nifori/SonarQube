import main.Zahlenraten;

import java.util.Scanner;

public class ZahlenratenMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zahlenraten raten = new Zahlenraten(scanner);
        raten.verbindeZuDatenbank();
        raten.starteSpiel();
    }
}
