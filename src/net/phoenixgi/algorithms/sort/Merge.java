package net.phoenixgi.algorithms.sort;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import net.phoenixgi.visualization.MergeSortStepPainter;

/**
 *
 * @author phoenix-gi
 */
public class Merge {

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
            } else if (aux[j].compareTo(aux[i]) < 0) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static void sort(Comparable a[], Comparable aux[], int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable a[]) {
        Comparable aux[] = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
    
    public static void stepSort(Comparable a[], MergeSortStepPainter mssp ,JPanel panel) {
        Comparable aux[] = new Comparable[a.length];
        stepSort(a,aux,0,a.length-1,mssp,panel);
        mssp.stepStay();
        panel.repaint();
    }
    
    private static void stepSort(Comparable a[], Comparable aux[], int lo, int hi, MergeSortStepPainter mssp, JPanel panel) {
        if(hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        stepSort(a,aux,lo,mid,mssp,panel);
        mssp.stepStay();
        panel.repaint();
        try {
            Thread.sleep(25);
        } catch (InterruptedException ex) {
            
        }
        stepSort(a,aux,mid+1,hi,mssp,panel);
        mssp.stepStay();
        panel.repaint();
        try {
            Thread.sleep(25);
        } catch (InterruptedException ex) {
            
        }
        merge(a,aux,lo,mid,hi);
    }

    public static void main(String args[]) {
        Random rnd = new Random();
        Integer[] a = new Integer[1000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(100);
        }
        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println();
        sort(a);
        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println(isSorted(a));
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
