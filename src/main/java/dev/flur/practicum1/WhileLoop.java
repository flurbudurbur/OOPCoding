package dev.flur.practicum1;

public class WhileLoop {
    public static void whileLoop() {
        int i = 1;
        while (i <= 10) {
            System.out.println("Count: " + i++);
        }
    }

    public static void main(String[] args) {
        whileLoop();
    }
}
