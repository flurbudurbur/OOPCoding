package dev.flur.practicum2;

public class Voetbalclub {
    private String naam;
    private int aantalGewonnen = 0;
    private int aantalGelijk = 0;
    private int aantalVerloren = 0;
    private int score = 0;

    public Voetbalclub(String naam) {
        this.naam = naam;
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
