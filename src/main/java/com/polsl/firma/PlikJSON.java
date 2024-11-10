/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.firma;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author piotr
 */
public class PlikJSON {

    public void zapisz(List<Pojazd> pojazdy) {

        try {
            FileWriter fileWriter = null;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonStr = gson.toJson(pojazdy);
            fileWriter = new FileWriter("pojazdy.json");
            fileWriter.write(jsonStr);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(PlikJSON.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public List<Pojazd> odczytaj() {

        List<Pojazd> pojazdy = null;
        FileReader fileReader = null;
        try {

            Gson gson = new Gson();
            fileReader = new FileReader("pojazdy.json", Charset.forName("UTF-8"));
            pojazdy = gson.fromJson(fileReader, new TypeToken<List<Pojazd>>() {}.getType());

        } catch (FileNotFoundException ex) {
            pojazdy = new ArrayList<Pojazd>();
        } catch (IOException ex) {
            Logger.getLogger(PlikJSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pojazdy;
    }
}
