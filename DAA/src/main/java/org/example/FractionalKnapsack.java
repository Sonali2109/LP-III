package org.example;

import java.util.*;

public class FractionalKnapsack {
    static class Item {
        int value, weight, index;
        double ratio;

        Item(int v, int w, int i) {
            value = v;
            weight = w;
            index = i;
            ratio = (double) v / w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of items: ");
        int n = sc.nextInt();
        System.out.print("Knapsack capacity: ");
        int cap = sc.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            int v = sc.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            int w = sc.nextInt();
            items[i] = new Item(v, w, i);
        }

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        double total = 0;
        int rem = cap;
        System.out.println("\nItems taken:");
        for (Item item : items) {
            if (rem == 0)
                break;
            if (item.weight <= rem) {
                total += item.value;
                rem -= item.weight;
                System.out.println(
                        "Item " + (item.index + 1) + " fully taken (V:" + item.value + ", W:" + item.weight + ")");
            } else {
                double f = (double) rem / item.weight;
                total += item.value * f;
                System.out.println("Item " + (item.index + 1) + " partially taken (" + f + " fraction, V:"
                        + (item.value * f) + ", W:" + rem + ")");
                rem = 0;
            }
        }
        System.out.println("\nMaximum profit = " + total);
        sc.close();
    }
}

//Time Complexity:	O(n log n)
//Space Complexity:	O(n)