/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 *
 * Tämä luokka on luotu helpottamaan yleistä rakennetta ja samalla nyt on
 * mahdollista verrata HashMappeja Kordinaatin perusteella
 */
public class Kordinaatti implements Iteroitava {

    private double x;
    private double y;
    private int sijaintikeossa;
    private Kordinaatti vasen;
    private Kordinaatti oikea;

    /**
     * Asetttaa kordinaatit
     */
    public Kordinaatti(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Palauttaa X kordinaatin
     */
    public double palautaX() {
        return this.x;
    }

    /**
     * Palauttaa Y kordinaatin
     */
    public double palautaY() {
        return this.y;
    }

    /**
     * Overraidaa hashcoden
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    /**
     * Overraidaa equalsin
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kordinaatti other = (Kordinaatti) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public void asetaArvo(double d) {
    }

    @Override
    public int vertausoperaatio(Iteroitava toinen) {
        Kordinaatti o = (Kordinaatti) toinen;
        if (this.x > o.x) {
            return 1;
        } else if (this.x == o.x) {
            if (this.y > o.y) {
                return 1;
            } else if (this.y == o.y) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @Override
    public int sijaintiKeossa() {
        return this.sijaintikeossa;
    }

    @Override
    public void asetaSijainti(int i) {
        this.sijaintikeossa = i;
    }

    public boolean vertaa(Kordinaatti k) {
        if ((this.x == k.palautaX()) && (this.y == k.palautaY())) {
            return true;

        }
        return false;
    }

    public String tulosta() {
        String k = "X: " + this.x + ", Y: " + this.y;
        return k;
    }

    public void asetaOikea(Kordinaatti k) {
        this.oikea = k;
    }

    public void asetaVasen(Kordinaatti k) {
        this.vasen = k;
    }
    public Kordinaatti palautaOikea()
    {
    return this.oikea;
    }
    public Kordinaatti palautaVasen()
    {
    return this.vasen;
    }

}
