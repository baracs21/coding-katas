package de.baracs.kata.diamond;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter letter: ");
        String letter = scanner.next();

        int start = 65;
        int end = letter.charAt(0);
        int difference = 1;

        int spaces = end - start;

        System.out.println("\n");
        for (int i = start; i <= end; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            System.out.print((char) i);
            if (i != end)
                spaces--;
            if (i != start) {
                for (int j = 0; j < difference; j++) {
                    System.out.print(" ");
                }
                System.out.print((char)i);
                if (i != end) {
                    difference+=2;
                }
            }
            System.out.print("\n");
        }

        for (int i = end-1; i >= start; i--) {
            for (int j = 0; j < spaces+1; j++) {
                System.out.print(" ");
            }
            System.out.print((char) i);
            spaces++;
            if (i != start) {
                for (int j = 0; j < difference-2; j++) {
                    System.out.print(" ");
                }
                System.out.print((char)i);
                difference-=2;
            }
            System.out.print("\n");
        }


    }
}
