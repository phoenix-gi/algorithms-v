package net.phoenixgi.algorithms.sort;

import java.util.Random;

/**
 *
 * @author phoenix-gi
 */
public abstract class Selection {

    public static void sort(Comparable o[]) {
        int m = 0;
        
        for (int i = 0; i < o.length; i++) {
            //search min
            for (int j = i; j < o.length; j++) {
                if (o[j].compareTo(o[m]) < 0) {
                    m = j;
                }
            }
            //change
            Comparable a = o[i];
            o[i]=o[m];
            o[m]=a;
        }
    }

    public static void main(String args[]) {
        Random rnd = new Random();
        Integer[] a = new Integer[20];
        for(int i=0;i<a.length;i++) {
            a[i] = rnd.nextInt(100);
        }
        for(int e:a) {
            System.out.print(e+" ");
        }
        System.out.println();
        sort(a);
        for(int e:a) {
            System.out.print(e+" ");
        }
    }
}
