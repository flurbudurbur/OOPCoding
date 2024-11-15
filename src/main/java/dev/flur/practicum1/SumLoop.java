package dev.flur.practicum1;

public class SumLoop {
    public static void sumLoop() {
        int sum = 0;
        for (int i = 0; i <= 39; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        sumLoop();
    }
}
