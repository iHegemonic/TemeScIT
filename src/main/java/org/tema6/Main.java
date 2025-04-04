package org.tema6;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an expression (example: 10 km + 1m - 100 cm): ");
        String expression = scanner.nextLine();

        System.out.println("Enter the output unit (mm, cm, dm, m, km): ");
        String outputUnit = scanner.nextLine().trim().toLowerCase();

        scanner.close();

        String result = MetricDistanceCalculator.computeExpression(expression, outputUnit);
        System.out.println("Result: " + result);

    }

}