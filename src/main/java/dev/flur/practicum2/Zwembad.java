package dev.flur.practicum2;

public class Zwembad {
    private double breedte;
    private double lengte;
    private double diepte;

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public void setDiepte(double diepte) {
        this.diepte = diepte;
    }

    public void setBreedte(double breedte) {
        this.breedte = breedte;
    }

    public double getDiepte() {
        return diepte;
    }

    public double getLengte() {
        return lengte;
    }

    public double getBreedte() {
        return breedte;
    }

    public double inhoud() {
        return breedte * lengte * diepte;
    }

    public Zwembad() {
        this(0.0, 0.0, 0.0);
    }

    public String toString() {
        return "Dit zwembad is " + breedte + " meter breed, " + lengte + " meter lang, en " + diepte + " meter diep";
    }

    public Zwembad(double breedte, double lengte, double diepte) {
        this.breedte = breedte;
        this.lengte = lengte;
        this.diepte = diepte;
    }
}
