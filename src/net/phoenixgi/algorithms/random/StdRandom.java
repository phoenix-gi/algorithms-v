package net.phoenixgi.algorithms.random;

import java.util.Random;

/**
 *
 * @author phoenix-gi
 */
public class StdRandom {
    private static Random random = new Random();
    public static void shuffle(Object a[]) {
        for(int i=0;i<a.length;i++) {
            int k = i+random.nextInt(a.length-i); //from i to n-i
            Object t = a[i];
            a[i]=a[k];
            a[k]=t;
        }
    }
}
