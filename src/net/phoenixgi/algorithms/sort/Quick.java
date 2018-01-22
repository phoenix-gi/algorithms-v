package net.phoenixgi.algorithms.sort;

import java.util.Random;
import javax.swing.JPanel;
import net.phoenixgi.algorithms.random.StdRandom;
import net.phoenixgi.visualization.QuickSortStepPainter;

/**
 *
 * @author phoenix-gi
 */
public class Quick {
    
    private static int partition(Comparable a[], int lo, int hi) {
        int i = lo;
        int j = hi+1;
        while(true) {
            while(a[++i].compareTo(a[lo])<0) {
                if(i==hi) break;
            }
            while(a[lo].compareTo(a[--j])<0) {
                if(j==lo) break;
            }
            if(i>=j) {
                break;
            }
            Comparable b = a[j];
            a[j] = a[i];
            a[i] = b;
        }
        Comparable b = a[j];
        a[j] = a[lo];
        a[lo] = b;
        return j;
    }
    
    private static void sort(Comparable a[], int lo, int hi) {
        if(lo>=hi) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    
    public static void sort(Comparable a[]) {
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    
    
    private static int stepPartition(Comparable[] a, int lo, int hi, QuickSortStepPainter qssp, JPanel panel) {
        int i=lo;
        int j=hi+1;
        while(true) {
            while(a[++i].compareTo(a[lo])<0) {
                qssp.stepPartition(i, j);
                panel.repaint();
                try {
                    Thread.sleep(50);
                } catch(InterruptedException e) {
                }
                if(i==hi) break;
            }
            while(a[lo].compareTo(a[--j])<0) {
                qssp.stepPartition(i, j);
                panel.repaint();
                try {
                    Thread.sleep(50);
                } catch(InterruptedException e) {
                }
                if(j==lo) break;
            }
            
            if(i>=j)break;
            
            qssp.stepExchange(j, i);
            panel.repaint();
            try {
                Thread.sleep(50);
            } catch(InterruptedException e) {
            }
            Comparable b = a[j];
            a[j] = a[i];
            a[i] = b;
            
            qssp.stepExchange(i, j);
            panel.repaint();
            try {
                Thread.sleep(50);
            } catch(InterruptedException e) {
            }
        }
        
        qssp.stepExchange(lo, j);
        panel.repaint();
        try {
            Thread.sleep(50);
        } catch(InterruptedException e) {
        }
        Comparable b = a[j];
        a[j] = a[lo];
        a[lo] = b;
        qssp.stepExchange(j, lo);
        panel.repaint();
        try {
            Thread.sleep(50);
        } catch(InterruptedException e) {
        }
        qssp.stepPartitionEnd(j);
        panel.repaint();
        try {
            Thread.sleep(50);
        } catch(InterruptedException e) {
        }
        return j;
    }
    
    private static void stepSort(Comparable a[],int lo, int hi,QuickSortStepPainter qssp, JPanel panel) {
        if(lo>=hi) return;
        int j = stepPartition(a,lo,hi,qssp,panel);
        stepSort(a,lo,j-1,qssp,panel);
        
        stepSort(a,j+1,hi,qssp,panel);
    }
    
    public static void stepSort(Comparable a[],QuickSortStepPainter qssp, JPanel panel) {
        qssp.stepStay();
        panel.repaint();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            
        }
        StdRandom.shuffle(a);
        qssp.stepStay();
        panel.repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            
        }
        stepSort(a,0,a.length-1,qssp,panel);
        
        qssp.stepStay();
        panel.repaint();
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
