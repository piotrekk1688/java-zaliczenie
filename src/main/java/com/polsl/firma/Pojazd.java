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
public class Pojazd {

    private String marka;
    private String model;
    private Date rocznik;
    private Float przebieg;

    public Pojazd(String marka, String model, Date rocznik, Float przebieg) {
        this.marka = marka;
        this.model = model;
        this.rocznik = rocznik;
        this.przebieg = przebieg;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getRocznik() {
        return rocznik;
    }

    public void setRocznik(Date rocznik) {
        this.rocznik = rocznik;
    }

    public Float getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(Float przebieg) {
        this.przebieg = przebieg;
    }

    @Override
    public String toString() {
        return "Pojazd{" + "marka=" + marka + ", model=" + model + ", rocznik=" + rocznik + ", przebieg=" + przebieg + '}';
    }

}
