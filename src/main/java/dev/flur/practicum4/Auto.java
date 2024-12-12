package dev.flur.practicum4;

public class Auto {

    private String type;
    private double prijsPerDag;

    public Auto(String tp, double prPd) {
        this.type = tp;
        this.prijsPerDag = prPd;
    }

    public void setPrijsPerDag(double prPd) {
        this.prijsPerDag = prPd;
    }

    public double getPrijsPerDag() {
        return this.prijsPerDag;
    }

    @Override
    public String toString() {
        return this.type + " met prijs per dag: " + this.getPrijsPerDag();
    }
}
