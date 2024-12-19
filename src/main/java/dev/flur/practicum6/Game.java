package dev.flur.practicum6;

import java.time.LocalDate;

public class Game {

    private String naam;
    private int releaseJaar;
    private double nieuwPrijs;

    public Game(String nm, int j, double nwpr) {
        this.naam = nm;
        this.releaseJaar = j;
        this.nieuwPrijs = nwpr;
    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        int years = LocalDate.now().getYear() - releaseJaar;
        double currentPrice = nieuwPrijs;
        for (int i = 0; i < years; i++) {
            currentPrice *= 0.7;
        }
        return currentPrice;
    }

    @Override
    public boolean equals(Object andereGame) {
        if (andereGame instanceof Game game && andereGame != null) {
            return this.naam.equals(game.naam)
                    && this.releaseJaar == game.releaseJaar;
        }
        return false;
    }


    @Override
    public String toString() {
        return naam + ", uitgegeven in " + releaseJaar + "; nieuwprijs: €" + String.format("%.2f", nieuwPrijs) + " nu voor: €" + String.format("%.2f", huidigeWaarde());
    }
}
