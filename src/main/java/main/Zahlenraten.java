package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Zahlenraten {

    public Scanner scanner = null;
    public int zahlZuRaten = 0;
    boolean fertig = false;
    int versuche = 0;
    int startid = (int)(System.currentTimeMillis()%10000000);
    Statement statement = null;

    public Zahlenraten(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getNewRandomZahl() {
        int zahlZuRaten = (int) (Math.random() * 100);
        return zahlZuRaten;
    }

    public void starteSpiel() {
        fertig = false;
        zahlZuRaten = getNewRandomZahl();
        System.out.println("Starte Spiel");

        System.out.println("Name eingeben:");
        String name = scanner.next();

        System.out.println("Rate zahl von 0 - 100");
        while (!fertig) {
            rateRunde();
        }

        try {
            addUserToDatabase(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void rateRunde() {
        versuche++;
        int gerateneZahl = scanner.nextInt();
        if (gerateneZahl < zahlZuRaten) {
            System.out.println("Deine geratene Zahl " + gerateneZahl + " ist zu niedrig!");
            System.out.println("Gebrauchte Versuche: " + versuche);
        }
        if (gerateneZahl > zahlZuRaten) {
            System.out.println("Deine geratene Zahl " + gerateneZahl + " ist zu hoch!");
            System.out.println("Gebrauchte Versuche: " + versuche);
        }
        if (gerateneZahl == zahlZuRaten) {
            System.out.println("Deine geratene Zahl " + gerateneZahl + " ist korrekt!");
            System.out.println("Gebrauchte Versuche: " + versuche);
            fertig = true;
        }
    }

    public void addUserToDatabase(String name) throws SQLException {
        startid++;
        statement.executeUpdate("Insert into zahlenraten.gewinner (id, name, passwort, punkte) values (" + startid + ", '" + name + "', 'pass', "+ versuche +")");
    }

    public void verbindeZuDatenbank() {
        String mySQLUrl = "jdbc:mysql://127.0.0.1:3306";
        String dbUser = "zahlenUser";
        String dbPassword = "zahlenPasswort";

        try {
            Connection conn = DriverManager.getConnection(mySQLUrl, dbUser, dbPassword);
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
