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
public class SamochodCiezarowy extends Pojazd {
    private int maxZaladunek;

    public SamochodCiezarowy(String marka, String model, Date rocznik, Float przebieg, int maxZaladunek) {
        super(marka, model, rocznik, przebieg);
        this.maxZaladunek = maxZaladunek;
    }

    @Override
    public String toString() {
        return super.toString() + " SamochodCiezarowy{" + "maxZaladunek=" + maxZaladunek + '}';
    }

    public int getMaxZaladunek() {
        return maxZaladunek;
    }

    public void setMaxZaladunek(int maxZaladunek) {
        this.maxZaladunek = maxZaladunek;
    }
    
}
