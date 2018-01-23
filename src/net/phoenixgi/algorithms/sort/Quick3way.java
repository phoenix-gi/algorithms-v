package net.phoenixgi.algorithms.sort;

import java.util.Random;

/**
 *
 * @author phoenix-gi
 */
public class Quick3way {
    private static void sort(Comparable a[], int lo, int hi) {
        if (hi<=lo) return;
        int lt = lo;
        int i = lo+1;
        int gt = hi;
        Comparable v = a[lo];
        while(i<=gt) {
            int cmp = a[i].compareTo(v);
            if(cmp < 0) {
                Comparable b = a[lt];
                a[lt] = a[i];
                a[i] = b;
                
                lt++;
                i++;
            } else if(cmp >0) {
                Comparable b = a[gt];
                a[gt] = a[i];
                a[i]=b;
                
                gt--;
            } else {
                i++;
            }
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
    
    public static void sort(Comparable a[]) {
        sort(a,0,a.length-1);
    }
    
    public static void main(String args[]) {
        Random rnd = new Random();
        Integer[] a = new Integer[1000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(5);
        }
        sort(a);
        System.out.println(isSorted(a));
    }

    public static boolean isSorted(Comparable a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
