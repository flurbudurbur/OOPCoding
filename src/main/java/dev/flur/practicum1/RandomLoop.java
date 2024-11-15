package dev.flur.practicum1;

public class RandomLoop {
    public static void randomLoop() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random() * 10);
        }
    }

    public static void main(String[] args) {
        randomLoop();
    }
}
