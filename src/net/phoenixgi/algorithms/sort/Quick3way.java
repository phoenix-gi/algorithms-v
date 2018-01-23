package net.phoenixgi.algorithms.sort;

import java.util.Random;
import javax.swing.JPanel;
import net.phoenixgi.visualization.QuickSortStepPainter;

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
    
    private static void stepSort(Comparable a[], int lo, int hi,QuickSortStepPainter qssp, JPanel panel) {
        if (hi<=lo) return;
        int lt = lo;
        int i = lo+1;
        int gt = hi;
        Comparable v = a[lo];
        while(i<=gt) {
            int cmp = a[i].compareTo(v);
            if(cmp < 0) {
                qssp.stepExchange(i, lt);
                panel.repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    
                }
                Comparable b = a[lt];
                a[lt] = a[i];
                a[i] = b;
                qssp.stepExchange(lt, i);
                panel.repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    
                }
                lt++;
                i++;
            } else if(cmp >0) {
                qssp.stepExchange(i, gt);
                panel.repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    
                }
                Comparable b = a[gt];
                a[gt] = a[i];
                a[i]=b;
                qssp.stepExchange(gt, i);
                panel.repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    
                }
                gt--;
            } else {
                i++;
            }
        }
        stepSort(a,lo,lt-1,qssp,panel);
        stepSort(a,gt+1,hi,qssp,panel);
    }
    
    
    public static void stepSort(Comparable a[],QuickSortStepPainter qssp, JPanel panel) {
        stepSort(a,0,a.length-1,qssp,panel);
        qssp.stepStay();
        panel.repaint();
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
