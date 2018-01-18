package net.phoenixgi.algorithms.sort;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import net.phoenixgi.visualization.ShellSortStepPainter;

/**
 *
 * @author phoenix-gi
 */
public abstract class Shell {

    public static void sort(Comparable o[]) {
        final int N = o.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (o[j].compareTo(o[j - h]) < 0) {
                        Comparable a = o[j];
                        o[j] = o[j - h];
                        o[j - h] = a;
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }
    }
    
    public static void stepSort(Comparable o[],ShellSortStepPainter sssp,JPanel panel) {
        int N = o.length;
        int h = 1;
        while (h<N/3) h=h*3+1;
        while(h>=1) {
            for(int i=h;i<N;i++) {
                for(int j=i;j>=h;j-=h) {
                    if(o[j].compareTo(o[j-h])<0) {
                        Comparable a = o[j];
                        a=o[j];
                        o[j] = o[j-h];
                        o[j-h] = a;
                        sssp.stepExchange(j, j-h);
                        panel.repaint();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            
                        }
                    } else {
                        break;
                    }
                }
            }
            h=h/3;
        }
        sssp.stepStay();
        panel.repaint();
    }

    public static void main(String args[]) {
        Random rnd = new Random();
        Integer[] a = new Integer[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(100)-50;
        }
        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println();
        sort(a);
        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
