package org.example;

import java.util.*;

public class Knapsack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of items: ");
        int n = sc.nextInt();
        System.out.print("Knapsack capacity: ");
        int cap = sc.nextInt();

        int[] val = new int[n], wt = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            val[i] = sc.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            wt[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i <= n; i++)
            for (int w = 1; w <= cap; w++)
                dp[i][w] = (wt[i - 1] <= w) ? Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w])
                        : dp[i - 1][w];

        System.out.println("\nMaximum Profit = " + dp[n][cap]);

        System.out.println("\nDP Table:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= cap; w++)
                System.out.print(dp[i][w] + "\t");
            System.out.println();
        }

        sc.close();
    }
}

/*
Time Complexity:	O(n × cap)
Space Complexity:	O(n × cap)
 */