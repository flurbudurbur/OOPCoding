package dev.flur.practicum4;

public class Persoon {

    private String naam;
    private int leeftijd;

    public Persoon(String nm, int lft) {
        this.naam = nm;
        this.leeftijd = lft;
    }

    public String toString() {
        return this.naam + "; leeftijd " + this.leeftijd + " jaar";
    }
}
