package org.example;

import java.util.*;

public class Knapsack01 {
    static class Item {
        int value, weight;
        Item(int v, int w) {
            value = v;
            weight = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        System.out.print("Enter knapsack capacity: ");
        int cap = sc.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Value and Weight of item " + (i + 1) + ": ");
            int v = sc.nextInt(), w = sc.nextInt();
            items[i] = new Item(v, w);
        }

        int[][] dp = new int[n + 1][cap + 1];

        // DP logic
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= cap; w++) {
                if (items[i - 1].weight <= w)
                    dp[i][w] = Math.max(items[i - 1].value + dp[i - 1][w - items[i - 1].weight], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        System.out.println("Maximum value = " + dp[n][cap]);
        sc.close();
    }
}

/*
Time Complexity:	O(n × capt)
Space Complexity:	O(n × cap)
*/