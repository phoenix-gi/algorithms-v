package net.phoenixgi.algorithms.sort;

import java.util.Random;
import javax.swing.JPanel;
import net.phoenixgi.visualization.MergeSortStepPainter;

/**
 *
 * @author phoenix-gi
 */
public class MergeBU {

    private static void merge(Comparable a[], Comparable aux[], int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) > 0) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void sort(Comparable a[]) {
        int N = a.length;
        Comparable aux[] = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }
    
    public static void stepSort(Comparable a[], MergeSortStepPainter mssp, JPanel panel) {
        int N = a.length;
        Comparable aux[] = new Comparable[a.length];
        for(int sz=1;sz<N;sz=sz+sz) {
            for(int lo = 0;lo<N-sz;lo+=sz+sz) {
                merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
                mssp.stepStay();
                panel.repaint();
                try {
                    Thread.sleep(100l);
                } catch (InterruptedException ex) {
                    
                }
            }
        }
    }
    
    public static void main(String args[]) {
        Random rnd = new Random();
        Integer[] a = new Integer[1000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(100);
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
