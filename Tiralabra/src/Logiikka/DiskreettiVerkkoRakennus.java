/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import Tietorakenteet.Kordinaatti;
import Tietorakenteet.Monikulmio;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Serafim
 */
public class DiskreettiVerkkoRakennus {

    private Set<Monikulmio> monikulmiot;
    private double xMax;
    private double xMin;
    private double yMax;
    private double yMin;
    private double ruudunpituus;
    private Kordinaatti alku;
    private Kordinaatti loppu;
    private int safety;

    public DiskreettiVerkkoRakennus(Set<Monikulmio> monikulmiot, double pituus, Kordinaatti alku, Kordinaatti loppu) {
        this.monikulmiot = monikulmiot;
        this.ruudunpituus = pituus;
        this.alku = alku;
        this.loppu = loppu;
        this.safety = 3;
    }

    public void alusta() {
        etsiRajat();
        

    }
    
    public boolean sisaltaa (Kordinaatti test, Monikulmio monikulmio) {
      ArrayList<Kordinaatti> points = monikulmio.palautaKulmat();
      int i;
      int j;
      boolean result = false;
      for (i = 0, j = points.size() - 1; i < points.size(); j = i++) {
        if ((points.get(i).palautaY() > test.palautaY()) != (points.get(j).palautaY() > test.palautaY()) &&
            (test.palautaX() < (points.get(j).palautaX() - points.get(i).palautaX()) * (test.palautaY() - points.get(i).palautaY()) / (points.get(i).palautaY()-points.get(j).palautaY()) + points.get(i).palautaX())) {
          result = !result;
         }
      }
      return result;
    }

    public void etsiRajat() {

        this.xMax = Math.max(alku.palautaX(), loppu.palautaX());
        this.xMin = Math.min(alku.palautaX(), loppu.palautaX());
        this.yMax = Math.max(alku.palautaY(), loppu.palautaY());
        this.yMin = Math.min(alku.palautaY(), loppu.palautaY());
        for (Monikulmio m : this.monikulmiot) {
            for (Kordinaatti k : m.palautaKulmat()) {

                if (k.palautaX() > this.xMax) {
                    this.xMax = k.palautaX();
                }
                if (k.palautaX() < this.xMin) {
                    this.xMin = k.palautaX();
                }
                if (k.palautaY() < this.yMin) {
                    this.yMin = k.palautaY();
                }
                if (k.palautaY() > this.yMax) {
                    this.yMax = k.palautaY();

                }

            }

        }
        this.xMax = this.xMax + this.ruudunpituus * this.safety;
        this.yMax = this.yMax + this.ruudunpituus * this.safety;
        this.xMin = this.xMin - this.ruudunpituus * this.safety;
        this.yMin = this.yMin - this.ruudunpituus * this.safety;

    }

}