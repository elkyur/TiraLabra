/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabrafix;

import Algoritmit.Atahtialgoritmi;
import Algoritmit.Janaleikkaus;
import Suorituskyky.ATahtiSuorituskykytestaus;
import Tietorakenteet.Abstraktisolmu;
import Tietorakenteet.DiskreettiSolmu;
import Tietorakenteet.DiskreettiVerkko;
import Tietorakenteet.Keko;
import Tietorakenteet.Kordinaatti;
import Tietorakenteet.Verkko;
import java.util.ArrayList;

/**
 *
 * @author Serafim
 */
public class TiraLabraFix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       suorituskyky();
    }

    public static void AtahtiTestaus() {
        DiskreettiVerkko verkko = new DiskreettiVerkko(1);
        DiskreettiSolmu[] solmuvektori = new DiskreettiSolmu[4];
        solmuvektori[0] = new DiskreettiSolmu(0, 0);
        solmuvektori[1] = new DiskreettiSolmu(0, 1);
        solmuvektori[2] = new DiskreettiSolmu(1, 0);
        solmuvektori[3] = new DiskreettiSolmu(1, 1);
        Atahtialgoritmi alg = new Atahtialgoritmi(verkko, 100);
        alg.asetaPisteet(solmuvektori[0], solmuvektori[3]);
        verkko.Lisaa(solmuvektori);
        alg.laske();
        for (int i = 0; i < 4; i++) {

            System.out.println(solmuvektori[i].palautaSolmuMuisti().palautaEdellinen());

            DiskreettiSolmu solmu = (DiskreettiSolmu) solmuvektori[i].palautaSolmuMuisti().palautaEdellinen();
            if (solmu != null) {
                System.out.println(solmu.palautaX() + solmu.palautaY());
                solmuvektori[i].palautaSolmuMuisti().palautaEdellinen();
            }

        }
    }

    public static void ATahtiTestausOsa2() {
        DiskreettiSolmu solmuvektori[] = new DiskreettiSolmu[9];
        solmuvektori[0] = new DiskreettiSolmu(0, 0);
        solmuvektori[1] = new DiskreettiSolmu(0, 1);
        solmuvektori[2] = new DiskreettiSolmu(1, 0);
        solmuvektori[3] = new DiskreettiSolmu(1, 1);
        solmuvektori[4] = new DiskreettiSolmu(0, 2);
        solmuvektori[5] = new DiskreettiSolmu(2, 0);
        solmuvektori[6] = new DiskreettiSolmu(1, 2);
        solmuvektori[7] = new DiskreettiSolmu(2, 1);
        solmuvektori[8] = new DiskreettiSolmu(2, 2);
        DiskreettiVerkko verkko = new DiskreettiVerkko(1);
        verkko.Lisaa(solmuvektori);
        Atahtialgoritmi alg = new Atahtialgoritmi(verkko, 100);
        alg.asetaPisteet(solmuvektori[0], solmuvektori[8]);
        alg.laske();
        for (int i = 0; i < 9; i++) {

            DiskreettiSolmu d = (DiskreettiSolmu) solmuvektori[i].palautaSolmuMuisti().palautaEdellinen();
            if (d != null) {
                System.out.println(i + " : " + d.palautaX() + "," + d.palautaY());

            }

        }

    }

    public static void polkurakennusdebuggaus() {
        DiskreettiVerkko verkko = new DiskreettiVerkko(1);
        DiskreettiSolmu[] solmuvektori = new DiskreettiSolmu[9];
        solmuvektori[0] = new DiskreettiSolmu(0, 0);
        solmuvektori[1] = new DiskreettiSolmu(0, 1);
        solmuvektori[2] = new DiskreettiSolmu(1, 0);
        solmuvektori[3] = new DiskreettiSolmu(1, 1);
        solmuvektori[4] = new DiskreettiSolmu(0, 2);
        solmuvektori[5] = new DiskreettiSolmu(2, 0);
        solmuvektori[6] = new DiskreettiSolmu(1, 2);
        solmuvektori[7] = new DiskreettiSolmu(2, 1);
        solmuvektori[8] = new DiskreettiSolmu(2, 2);
        Atahtialgoritmi alg = new Atahtialgoritmi(verkko, 100);

        verkko.Lisaa(solmuvektori);
        alg.asetaPisteet(solmuvektori[0], solmuvektori[8]);
        alg.laske();
        alg.rakennapolku();
        ArrayList<Abstraktisolmu> solmut = alg.palautapolku();
        for (Abstraktisolmu s : solmut) {
            DiskreettiSolmu a = (DiskreettiSolmu) s;
            System.out.println(a.palautaKordinaatit().palautaX() + "," + a.palautaKordinaatit().palautaY());

        }

    }

    public static void leikkausdebuggaus() {

        Kordinaatti k1 = new Kordinaatti(0, 1);
        Kordinaatti k2 = new Kordinaatti(2, 1);
        Kordinaatti k3 = new Kordinaatti(1, 0);
        Kordinaatti k4 = new Kordinaatti(1, 2);
        Janaleikkaus leikkaaja = new Janaleikkaus();
        System.out.println(leikkaaja.leikkaako(k1, k2, k3, k4));
    }

    public static void suorituskyky() {
        ATahtiSuorituskykytestaus testaus = new ATahtiSuorituskykytestaus();
        testaus.suorita(4);

    }

    public static void matricetest() {
        int[][] matrice = new int[10][2];
        System.out.println(matrice.length);
        System.out.println(matrice[0].length);
    }

    public static void aTahtiDebuggaus() {
        DiskreettiVerkko verkko = new DiskreettiVerkko(1);
        DiskreettiSolmu[] solmuvektori = new DiskreettiSolmu[4];
        solmuvektori[0] = new DiskreettiSolmu(0, 0);
        solmuvektori[1] = new DiskreettiSolmu(0, 1);
        solmuvektori[2] = new DiskreettiSolmu(1, 0);
        solmuvektori[3] = new DiskreettiSolmu(1, 1);
        Atahtialgoritmi alg = new Atahtialgoritmi(verkko, 100);
        alg.asetaPisteet(solmuvektori[0], solmuvektori[3]);
        verkko.Lisaa(solmuvektori);
        alg.laske();
    }

}