package net.phoenixgi.structures;

import java.util.Random;

public class MaxPQ { //Max PQ on Binary Heap
    private Comparable a[];
    private int count;

    public MaxPQ(int size) {
        a = new Comparable[size + 1];
        count = 0;
    }

    public void insert(Comparable b) {
        a[++count] = b;
        swim(count);
    }

    public Comparable max() {
        return a[1];
    }

    public Comparable delMax() {
        Comparable max = a[1];
        Comparable t = a[1];
        a[1] = a[count];
        a[count--] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    private void swim(int k) {
        while (k > 1 && a[k].compareTo(a[k / 2]) > 0) {
            Comparable t = a[k];
            a[k] = a[k / 2];
            a[k / 2] = t;
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= count) {
            int j = k * 2;
            if (j < count && a[j].compareTo(a[j + 1]) < 0) {
                j++;
            }
            if (a[k].compareTo(a[j]) > 0) {
                break;
            }
            Comparable t = a[k];
            a[k] = a[j];
            a[j] = t;
            k = j;
        }
    }

    public static void main(String args[]) {
        MaxPQ pq = new MaxPQ(64);
        Random rnd = new Random();
        for (int i = 0; i < 64; i++) {
            int b = rnd.nextInt(90) + 10;
            pq.insert(b);
            System.out.print(b+" ");
        }
        System.out.println();
        while(pq.size()>0) {
            System.out.print(pq.delMax()+" ");
        }
        System.out.println();

    }

}