package dev.flur.practicum2;

public class Voetbalclub {
    private String naam;
    private int aantalGewonnen;
    private int aantalGelijk;
    private int aantalVerloren;
    private int score;

    public Voetbalclub(String naam) {
        this.naam = naam;
    }

    public Voetbalclub() {
        this.naam = "FC";
    }

    public void verwerkResultaat(char rslt) {
        switch (rslt) {
            case 'w':
                this.aantalGewonnen++;
                this.score += 3;
                break;
            case 'v':
                this.aantalVerloren++;
                break;
            case 'g':
                this.aantalGelijk++;
                this.score++;
                break;
        }
    }

    public int getAantalVerloren() {
        return aantalVerloren;
    }

    public int getAantalGelijk() {
        return aantalGelijk;
    }

    public int getAantalGewonnen() {
        return aantalGewonnen;
    }

    public String getNaam() {
        return this.naam;
    }

    public int aantalPunten() {
        return this.score;
    }

    public int aantalGespeeld() {
        return aantalVerloren + aantalGelijk + aantalGewonnen;
    }

    public String toString() {
        return naam + " " + aantalGespeeld() + " " + aantalGewonnen + " " + aantalGelijk + " " + aantalVerloren + " " + aantalPunten();
    }
}
