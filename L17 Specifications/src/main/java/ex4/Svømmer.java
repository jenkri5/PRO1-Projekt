package ex4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Svømmer {
    private String navn;
    private String klub;
    private LocalDate fødselsdag;
    private ArrayList<Double> tider;

    /**
     * Initialiserer en ny svømmer med navn, fødselsdag, klub og tider.
     * Pre: Svømmeren har mindst 2 tider.
     */
    public Svømmer(String navn, String klub, LocalDate fødselsdag, ArrayList<Double> tider) {
     this.navn = navn;
     this.klub = klub;
     this.fødselsdag = fødselsdag;
     for (Double tid : tider) {
         this.tider.add(tid);
     }
    }

    /**
     * Returnerer den hurtigste tid svømmeren har opnået.
     * Pre: Svømmeren har mindst 2 tider.
     */
    public double bedsteTid() {
        double max = 0;
        for (Double tid : tider) {
            max = Math.max(max, tid);
        }
        return max;
    }

    /**
     * Returnerer gennemsnittet af de tider svømmeren har opnået.
     * Pre: Svømmeren har mindst 2 tider.
     * .
     */
    public double gennemsnitsTid() {
        double gennemsnit = 0;
        for (Double tid : tider)
            gennemsnit += tid;
        gennemsnit /= tider.size();
        return gennemsnit;
    }

    /**
     * Returnerer gennemsnittet af de tider svømmeren har
     * opnået, idet den langsomste tid ikke er medregnet.
     * Pre: Svømmeren har mindst 2 tider.
     */
    public double snitUdenDårligste() {
        return 0;
    }
}
