package net.phoenixgi.algorithms.sort;

import java.util.Random;

public class BinaryHeap {
    public static void sort(Comparable a[]) {
        int count = a.length;
        for (int k = count / 2; k >= 1; k--) {
            sink(a, k, count);
        }
        while (count > 1) {
            exch(a, 1, count);
            sink(a, 1, --count);
        }
    }

    private static void sink(Comparable a[], int k, int count) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j < count && less(a, j, j + 1)) {
                j++;
            }
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable a[], int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    private static void exch(Comparable a[], int i, int j) {
        Comparable t = a[j - 1];
        a[j - 1] = a[i - 1];
        a[i - 1] = t;
    }

    public static void main(String[] args) {
        Comparable a[] = new Comparable[40];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(90) + 10;
            System.out.print(a[i] + " ");
        }
        System.out.println();
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}