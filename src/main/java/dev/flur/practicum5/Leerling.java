package dev.flur.practicum5;

public class Leerling {

    private String naam;
    private double cijfer;

    public Leerling(String nm) {
        this.naam = nm;
    }

    public String getNaam() {
        return this.naam;
    }

    public double getCijfer() {
        return this.cijfer;
    }

    public void setCijfer(double c) {
        this.cijfer = Math.max(0, c);
    }

    @Override
    public String toString() {
        return "";
    }
}
