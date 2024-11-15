package dev.flur.practicum1;

public class SawLoop {
    public static void sawLoop() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i%2 == 0 ? "S" : "SS");
        }
    }

    public static void main(String[] args) {
        sawLoop();
    }
}
