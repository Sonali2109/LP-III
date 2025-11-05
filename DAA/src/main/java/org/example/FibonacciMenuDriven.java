package org.example;

import java.util.Scanner;

public class FibonacciMenuDriven {

    // ----------------- RECURSIVE METHOD -----------------
    // Prints Fibonacci series and returns nth Fibonacci number
    public static int fibRecursive(int n) {
        System.out.print("Recursive Series: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibRec(i) + " ");
        }
        System.out.println("\nResult (Recursive nth term): " + fibRec(n));
        return fibRec(n);
    }

    // Helper for recursion (to avoid reprinting multiple times)
    private static int fibRec(int n) {
        if (n <= 1)
            return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    // ----------------- ITERATIVE METHOD -----------------
    // Prints Fibonacci series and returns nth Fibonacci number
    public static int fibIterative(int n) {
        System.out.print("Iterative Series: ");

        if (n == 0) {
            System.out.println("0");
            System.out.println("Result (Iterative nth term): 0");
            return 0;
        }

        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        System.out.println("\nResult (Iterative nth term): " + b);
        return b;
    }

    // ----------------- MAIN (MENU) -----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, n;

        while (true) {
            System.out.println("\n===== Fibonacci Menu =====");
            System.out.println("1. Recursive Fibonacci");
            System.out.println("2. Iterative Fibonacci");
            System.out.println("3. Both (Recursive + Iterative)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Exiting program...");
                break;
            }

            System.out.print("Enter n (position of Fibonacci number): ");
            n = sc.nextInt();

            switch (choice) {
                case 1:
                    fibRecursive(n);   // prints series + result
                    break;
                case 2:
                    fibIterative(n);   // prints series + result
                    break;
                case 3:
                    System.out.println("\n=== Fibonacci Series (Both Methods) ===");
                    fibRecursive(n);
                    fibIterative(n);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
