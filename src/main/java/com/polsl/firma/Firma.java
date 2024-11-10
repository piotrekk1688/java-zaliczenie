/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.polsl.firma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author piotr
 */
public class Firma {

    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        PlikJSON js = new PlikJSON();
        List<Pojazd> pojazdy = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String wybor;

        pojazdy.add(new SamochodOsobowy("BMW", "M3", sdf.parse("01.04.2001"), 1234f, true));
        pojazdy.add(new SamochodOsobowy("Audi", "A4", sdf.parse("01.04.2011"), 1234f, false));
        pojazdy.add(new SamochodOsobowy("Citroen", "C6", sdf.parse("11.12.2008"), 1234f, true));
        pojazdy.add(new SamochodOsobowy("Citroen", "C3", sdf.parse("08.09.19998"), 1234f, false));
        
        pojazdy.add(new SamochodCiezarowy("Opel", "Combo", sdf.parse("01.10.2009"), 1234f, 1290));
        pojazdy.add(new SamochodCiezarowy("Opel", "Combo", sdf.parse("01.10.2009"), 1234f, 1299));
        pojazdy.add(new SamochodCiezarowy("Opel", "Combo", sdf.parse("01.10.2009"), 1234f, 1200));
        pojazdy.add(new SamochodCiezarowy("Opel", "Combo", sdf.parse("01.10.2009"), 1234f, 1300));
        
        do {
            System.out.println("Program przechowujacy liste pojazdow w firmie.");
            System.out.println("Wybierz 1 aby wyswietlic pojazdy naszej firmy.");
            System.out.println("Wybierz 2 aby dodac pojazd.");
            System.out.println("Wybierz 3 aby zapisac aktualny stan pojazdow.");
            System.out.println("Wybierz 4 aby zaladowac stan pojazdow z pliku.");
            System.out.println("Wybierz 5 aby posortowac samochody po marce pojazdu.");
            System.out.println("Wybierz 6 aby zakonczyc dzialanie programu.");

            wybor = reader.readLine();

            switch (wybor) {
                case "1":
                    System.out.println("Wybierz 1 aby wyswietlic samochody osobowe.");
                    System.out.println("Wybierz 2 aby wyswietlic samochody ciezarowe.");
                    System.out.println("Wybierz 3 aby wyswietlic samochody osobowe z klimatyzacja.");
                    System.out.println("Wybierz 4 aby wyswietlic wszystkie pojazdy.");

                    wybor = reader.readLine();

                    switch (wybor) {
                        case "1":

                            for (Pojazd pojazd : pojazdy) {
                                if (pojazd instanceof SamochodOsobowy) {
                                    System.out.println((SamochodOsobowy) pojazd);
                                }
                            }

                            break;
                        case "2":

                            for (Pojazd pojazd : pojazdy) {
                                if (pojazd instanceof SamochodCiezarowy) {
                                    System.out.println((SamochodCiezarowy) pojazd);
                                }
                            }

                            break;
                        case "3":
                            
                            for (Pojazd pojazd : pojazdy) {
                                if (pojazd instanceof SamochodOsobowy) {
                                    if (((SamochodOsobowy)pojazd).isKlimatyzacja()) {
                                        System.out.println((SamochodOsobowy) pojazd);
                                    }
                                }
                            }
                            
                            break;
                        case "4":

                            for (Pojazd pojazd : pojazdy) {
                                if (pojazd instanceof SamochodCiezarowy) {
                                    System.out.println((SamochodCiezarowy) pojazd);
                                } else {
                                    System.out.println((SamochodOsobowy) pojazd);
                                }
                            }

                            break;
                        default:
                            System.out.println("Zla opcja. Sprobuj jeszcze raz.");
                            continue;
                    }
                    break;
                case "2":
                    String marka, model, data;
                    Float przebieg;
                    
                    System.out.println("Wybierz 1 aby dodac samochod osobowy.");
                    System.out.println("Wybierz 2 aby dodac samochod ciezarowy.");

                    wybor = reader.readLine();

                    switch (wybor) {
                        case "1":
                            boolean klima;
                            System.out.println("Marka: ");
                            marka = reader.readLine();
                            
                            System.out.println("Model: ");
                            model = reader.readLine();
                            
                            System.out.println("Data: ");
                            data = reader.readLine();
                            
                            System.out.println("Przebieg: ");
                            przebieg = Float.parseFloat(reader.readLine());
                            
                            System.out.println("Klimatyzacja(tak/nie): ");
                            klima = reader.readLine().toLowerCase() == "tak";
                            
                            pojazdy.add(new SamochodOsobowy(marka, model, sdf.parse(data), przebieg, klima));
                            break;
                        case "2":
                            int maxZaladunek;
                            System.out.println("Marka: ");
                            marka = reader.readLine();
                            
                            System.out.println("Model: ");
                            model = reader.readLine();
                            
                            System.out.println("Data: ");
                            data = reader.readLine();
                            
                            System.out.println("Przebieg: ");
                            przebieg = Float.parseFloat(reader.readLine());
                            
                            System.out.println("Klimatyzacja(tak/nie): ");
                            maxZaladunek = Integer.parseInt(reader.readLine());
                            
                            pojazdy.add(new SamochodCiezarowy(marka, model, sdf.parse(data), przebieg, maxZaladunek));

                            break;
                        default:
                            System.out.println("Zla opcja. Sprobuj jeszcze raz.");
                            continue;
                    }
                    break;
                case "3":
                    js.zapisz(pojazdy);
                    break;
                case "4":
                    pojazdy = js.odczytaj();
                    break;
                case "5":
                    pojazdy.sort(Comparator.comparing(Pojazd::getMarka)
                        .thenComparing(obj -> {
                        if (obj instanceof SamochodCiezarowy) {
                            return ((SamochodCiezarowy) obj).getMaxZaladunek();
                        } else {
                            return Integer.MAX_VALUE;
                        }}));
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Zla opcja. Sprobuj jeszcze raz.");
                    continue;
            }
        } while (true);
    }
}
