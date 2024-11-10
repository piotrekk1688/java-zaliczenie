/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.firma;

import java.util.Date;

/**
 *
 * @author piotr
 */
public class SamochodOsobowy extends Pojazd {

    private boolean klimatyzacja;

    public SamochodOsobowy(String marka, String model, Date rocznik, Float przebieg, boolean klimatyzacja) {
        super(marka, model, rocznik, przebieg);
        this.klimatyzacja = klimatyzacja;
    }

    @Override
    public String toString() {
        return super.toString() + " SamochodOsobowy{" + "klimatyzacja=" + klimatyzacja + '}';
    }

    public boolean isKlimatyzacja() {
        return klimatyzacja;
    }

    public void setKlimatyzacja(boolean klimatyzacja) {
        this.klimatyzacja = klimatyzacja;
    }
}
