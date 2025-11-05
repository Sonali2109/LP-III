package org.example;

import java.util.*;

public class FractionalKnapsack {
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

        // Sort by value/weight ratio (descending)
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));

        double totalValue = 0.0;
        int remaining = cap;

        for (Item item : items) {
            if (remaining == 0) break;

            if (item.weight <= remaining) { // Take whole item
                totalValue += item.value;
                remaining -= item.weight;
            } else { // Take fraction
                totalValue += item.value * ((double)remaining / item.weight);
                remaining = 0;
            }
        }

        System.out.println("Maximum value = " + totalValue);
        sc.close();
    }
}

/*
Time Complexity:	O(n log n)
Space Complexity:	O(n)
*/