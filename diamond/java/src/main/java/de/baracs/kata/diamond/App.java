package de.baracs.kata.diamond;

import de.baracs.kata.diamond.usecases.CreateDiamond;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter letter: ");
        String letter = scanner.next();
        scanner.close();

        CreateDiamond diamondUseCase = new CreateDiamond();
        String result = diamondUseCase.createDiamond(letter.charAt(0));

        System.out.println("Here is your diamond: ");
        System.out.println(result);
    }
}
