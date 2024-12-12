package dev.flur.practicum6;

import java.util.ArrayList;

public class Persoon {

    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames = new ArrayList<Game>();

    public Persoon(String nm, double dub) {
        this.naam = nm;
        this.budget = Math.max(0, dub);
    }

    public double getBudget() {
        return this.budget;
    }

    public boolean koop(Game g) {
        if (g.huidigeWaarde() > budget || mijnGames.contains(g)) return false;
        budget -= g.huidigeWaarde();
        mijnGames.add(g);
        return true;
    }

    public boolean verkoop(Game g, Persoon koper) {
        if (!mijnGames.contains(g) ||
                koper.getBudget() < g.huidigeWaarde() ||
                koper.mijnGames.contains(g))
            return false;
        koper.mijnGames.add(g);
        mijnGames.remove(g);
        budget += g.huidigeWaarde();
        koper.budget -= g.huidigeWaarde();
        return true;
    }

    public Game zoekGameOpNaam(String gameNaam) {
        for (Game g : mijnGames) {
            if (g.getNaam().equals(gameNaam)) return g;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(naam)
                .append(" heeft een budget van €")
                .append(String.format("%.2f", budget))
                .append(" en bezit de volgende games:");

        if (!mijnGames.isEmpty()) sb.append("\n");

        for (int i = 0; i < mijnGames.size(); i++) {
            sb.append(mijnGames.get(i).toString());
            if (i < mijnGames.size() - 1) sb.append("\n");
        }

        return sb.toString();
    }
}
