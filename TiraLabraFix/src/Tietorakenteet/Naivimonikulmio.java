/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

import Tietorakenteet.Jono.Jono;
import Tietorakenteet.Jono.Jonoiteroitava;

/**
 *
 * Tämä on Naivinmonikulmion luokka
 */
public class Naivimonikulmio implements Monikulmio {

    private Jono kulmat;
    private double maxX;
    private double minX;
    private double maxY;
    private double minY;
    private Kordinaatti[][] vektori;

    /**
     *
     * Luo uuden monikulmion parametreinä kordinaattien lista.
     *
     * @param kordinaatit
     */
    public Naivimonikulmio(Jono kordinaatit) {
        this.kulmat = kordinaatit;
        if ((this.kulmat != null) && (this.kulmat.palautaKoko() > 0)) {
         LaskeVirittavaNelio();
        }
        laskeJanat();
    }

    /**
     *
     * Palauttaakulmat
     *
     * @return ArrayList<Kordinaatti> kordinaatit
     */
    @Override
    public Jono palautaKulmat() {
        return this.kulmat;
    }

    /**
     *
     * Palauttaaa virittavannelion
     *
     * @return Palauttaa virittavannelion kordinaatit Kordinaatti[] oliona
     */
    @Override
    public Kordinaatti[] palautaVirittavaNelio() {
        Kordinaatti[] k = new Kordinaatti[4];
        k[0] = new Kordinaatti(this.minX, this.maxY);
        k[1] = new Kordinaatti(this.maxX, this.maxY);
        k[2] = new Kordinaatti(this.minX, this.minY);
        k[3] = new Kordinaatti(this.minX, this.maxY);
        return k;

    }

    /**
     *
     * Laskee virittavannelion
     */
    @Override
    public void LaskeVirittavaNelio() {
        Kordinaatti k = (Kordinaatti) this.kulmat.palautaEnsimmainen().palautaObjekti();
        this.maxX = k.palautaX();
        this.minY = k.palautaY();
        this.maxY = k.palautaY();
        this.minX = k.palautaX();
        Jonoiteroitava iteroitava = this.kulmat.palautaEnsimmainen();
        while (iteroitava != null) {
            k = (Kordinaatti) iteroitava.palautaObjekti();
            double x = k.palautaX();
            double y = k.palautaY();
            if (x > maxX) {
                maxX = x;
            }
            if (x < minX) {
                minX = x;
            }
            if (y > maxY) {
                maxY = y;
            }
            if (y < minY) {
                minY = y;
            }
            iteroitava = iteroitava.palautaSeuraava();
        }

    }

    /**
     *
     * Laskee janat
     */
    @Override
    public void laskeJanat() {
        this.vektori = new Kordinaatti[this.kulmat.palautaKoko()][2];
        int i = 0;
        Jonoiteroitava iter = this.kulmat.palautaEnsimmainen();
        while (iter != this.kulmat.palautaViimeinen()) {
            Kordinaatti k = (Kordinaatti) iter.palautaObjekti();
            Kordinaatti k2 = (Kordinaatti) iter.palautaSeuraava().palautaObjekti();
            vektori[i][0] = k;
            vektori[i][1] = k2;

            i++;
            iter = iter.palautaSeuraava();
        }
        vektori[i][0] = (Kordinaatti) this.kulmat.palautaViimeinen().palautaObjekti();
        vektori[i][1] = (Kordinaatti) this.kulmat.palautaEnsimmainen().palautaObjekti();

    }

    /**
     *
     * Palauttaa janat Kordinaatti[][] oliona
     *
     * @return Palauttaa janat Kordinaatti[][] oliona
     */
    @Override
    public Kordinaatti[][] PalautaJanat() {
        return this.vektori;
    }

    /**
     *
     * Tulostaa monikulmion String muodossa
     *
     * @return String tulostus
     */

    @Override
    public String tulosta() {
        String k = "";
        Jonoiteroitava iter = this.kulmat.palautaEnsimmainen();
        while (iter != null) {
            Kordinaatti d = (Kordinaatti) iter.palautaObjekti();
            if (iter.palautaSeuraava() == null) {
                k = k + d.palautaX() + "," + d.palautaY();
            } else {
                k = k + d.palautaX() + "," + d.palautaY() + ";";
            }
            iter = iter.palautaSeuraava();
        }

        return k;
    }

}
