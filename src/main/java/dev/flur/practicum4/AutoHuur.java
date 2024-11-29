package dev.flur.practicum4;

public class AutoHuur {
    private int aantalDagen;
    private Klant huurder;
    private Auto gehuurdeAuto;

    public AutoHuur() {
        this.aantalDagen = 0;
    }

    public void setAantalDagen(int aD) {
        this.aantalDagen = Math.max(aD, 0);
    }

    public int getAantalDagen() {
        return this.aantalDagen;
    }

    public void setGehuurdeAuto(Auto gA) {
        this.gehuurdeAuto = gA;
    }

    public Auto getGehuurdeAuto() {
        return this.gehuurdeAuto;
    }

    public void setHuurder(Klant k) {
        this.huurder = k;
    }

    public Klant getHuurder() {
        return this.huurder;
    }

    public double totaalPrijs() {
        if (this.gehuurdeAuto == null) return 0.0;
        double korting = (this.huurder != null) ? this.huurder.getKorting() : 0.0;
        return this.gehuurdeAuto.getPrijsPerDag() * this.aantalDagen * ((100 - korting ) / 100);
    }

    @Override
    public String toString() {
        String autoString = (this.gehuurdeAuto != null) ? this.gehuurdeAuto.toString() : "er is geen auto bekend";
        String huurderString = (this.huurder != null) ? this.huurder.toString() : "er is geen huurder bekend";
        return "  " + autoString + "\n" +
                "  " + huurderString + "\n" +
                "  aantal dagen: " + this.aantalDagen + " en dat kost " + this.totaalPrijs();
    }
}
