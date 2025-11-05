package org.example;

import java.util.*;

public class HuffmanEncoding {
    static class Node {
        char ch;
        int freq;
        Node left, right;
    }

    static Map<Character, String> codes = new HashMap<>();
    static Node root;

    static void buildTree(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            Node n = new Node();
            n.ch = e.getKey();
            n.freq = e.getValue();
            pq.add(n);
        }

        while (pq.size() > 1) {
            Node l = pq.poll(), r = pq.poll();
            Node p = new Node();
            p.ch = '-';
            p.freq = l.freq + r.freq;
            p.left = l;
            p.right = r;
            pq.add(p);
        }

        root = pq.poll();
        codes.clear();
        genCodes(root, "");
    }

    static void genCodes(Node n, String code) {
        if (n == null)
            return;
        if (n.left == null && n.right == null) {
            codes.put(n.ch, code);
            return;
        }
        genCodes(n.left, code + "0");
        genCodes(n.right, code + "1");
    }

    static String encode(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray())
            sb.append(codes.get(c));
        return sb.toString();
    }

    static String decode(String enc) {
        StringBuilder sb = new StringBuilder();
        Node c = root;
        for (char ch : enc.toCharArray()) {
            c = (ch == '0') ? c.left : c.right;
            if (c.left == null && c.right == null) {
                sb.append(c.ch);
                c = root;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        buildTree(text);
        String enc = encode(text);

        System.out.println("Huffman Codes: " + codes);
        System.out.println("Encoded: " + enc);
        System.out.println("Decoded: " + decode(enc));

        sc.close();
    }
}

// SC: O(n+k)
// TC: O(n)+O(klogk)+O(n)
