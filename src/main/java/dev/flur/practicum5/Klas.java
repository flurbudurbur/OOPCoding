package dev.flur.practicum5;

import java.util.ArrayList;

public class Klas {

    private String klasCode;
    private ArrayList<Leerling> deLeerling = new ArrayList<Leerling>();

    public Klas(String kC) {
        this.klasCode = kC;
    }

    public void voegLeerlingToe(Leerling l) {
        this.deLeerling.add(l);
    }

    public void wijzigCijfer(String nm, double nweCijfer) {
        this.deLeerling.forEach(leerling -> {
            if (leerling.getNaam().equals(nm)) leerling.setCijfer(nweCijfer);
        });
    }

    public int aantalLeerlingen() {
        return this.deLeerling.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("In klas ").append(klasCode).append(" zitten de volgende leerlingen: \n");
        this.deLeerling.forEach(leerling -> {
            sb.append(leerling.getNaam()).append(" heeft cijfer: ").append(leerling.getCijfer()).append("\n");
        });

        return sb.toString();
    }
}
