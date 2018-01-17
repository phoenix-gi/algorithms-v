package net.phoenixgi.algorithms.sort;

import java.util.Random;
import javax.swing.JPanel;
import net.phoenixgi.visualization.InsertionSortStepPainter;

/**
 *
 * @author phoenix-gi
 */
public abstract class Insertion {

    public static void sort(Comparable o[]) {

        for (int i = 0; i < o.length; i++) {
            for (int j = i; j > 0; j--) {
                if (o[j].compareTo(o[j - 1]) < 0) {
                    //change
                    Comparable a = o[j];
                    o[j] = o[j - 1];
                    o[j - 1] = a;
                } else {
                    break;
                }
            }
        }
    }

    public static void stepSort(Comparable o[], InsertionSortStepPainter issp, JPanel panel) {
        for (int i = 0; i < o.length; i++) {
            for (int j = i; j > 0; j--) {
                if (o[j].compareTo(o[j - 1]) < 0) {
                    //change
                    Comparable a = o[j];
                    o[j] = o[j - 1];
                    o[j - 1] = a;
                    issp.stepExchange(i, j - 1);
                    panel.repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {

                    }
                } else {
                    break;
                }
            }
        }
        issp.stepStay();
        panel.repaint();
    }

    public static void main(String args[]) {
        Random rnd = new Random();
        Integer[] a = new Integer[20];
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
    }
}
