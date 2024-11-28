package dev.flur.practicum3;

/**
 * BEREDENERING
 * De applicatie zal tijdens het uitvoeren stoppen omdat de
 * Exception class de code exit met het doorgegeven bericht.
 */

public class Cirkel {
    private int radius;
    private int xPositie;
    private int yPositie;

    public Cirkel(int rad, int x, int y) {
        if (rad != 0) this.radius = rad;
        else throw new IllegalArgumentException("Radius moet groter dan 0 zijn!");
        this.xPositie = x;
        this.yPositie = y;
    }

    @Override
    public String toString() {
        return "cirkel (" + xPositie + "," + yPositie + ") met radius: " + radius;
    }
}
