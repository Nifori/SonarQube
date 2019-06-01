package tests;

import main.Zahlenraten;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ZahlenratenTest {

    @Test
    void getNewRandomZahl() {
        Scanner scanner = new Scanner(System.in);
        Zahlenraten raten = new Zahlenraten(scanner);
        int zahl = raten.getNewRandomZahl();
        assertTrue(zahl > -1);
        assertTrue(zahl < 101);
    }

    @Test
    void rateRunde() {
        String input = "50";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        Zahlenraten raten = new Zahlenraten(scanner);
        raten.rateRunde();
        byte[] byteArray = baos.toByteArray();
        assertEquals("Deine geratene Zahl 50 ist zu hoch!" + System.lineSeparator() +
                "Gebrauchte Versuche: 1" + System.lineSeparator(), new String(byteArray));
    }
}