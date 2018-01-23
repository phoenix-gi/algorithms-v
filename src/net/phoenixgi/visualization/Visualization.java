package net.phoenixgi.visualization;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import net.phoenixgi.algorithms.sort.Insertion;
import net.phoenixgi.algorithms.sort.Merge;
import net.phoenixgi.algorithms.sort.MergeBU;
import net.phoenixgi.algorithms.sort.Quick;
import net.phoenixgi.algorithms.sort.Quick3way;
import net.phoenixgi.algorithms.sort.Selection;
import net.phoenixgi.algorithms.sort.Shell;

/**
 *
 * @author phoenix-gi
 */
public class Visualization extends JFrame {

    final static int arraySize = 100;
    BufferedImage currentFrame = null;
    JPanel panel = null;

    public Visualization(String name, int width, int height) {
        super(name);
        Toolkit t = Toolkit.getDefaultToolkit();
        setBounds(t.getScreenSize().width / 2 - width / 2, t.getScreenSize().height / 2 - height / 2, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(createJMenuBar());
        setLayout(new BorderLayout());
        setResizable(false);
        panel = createJPanel();
        add(panel, BorderLayout.CENTER);
        setVisible(true);

        int iwidth = panel.getWidth();
        int iheight = panel.getHeight();
        currentFrame = new BufferedImage(iwidth, iheight, BufferedImage.TYPE_INT_RGB);
        currentFrame.getGraphics().setColor(Color.white);
        currentFrame.getGraphics().fillRect(0, 0, currentFrame.getWidth(), currentFrame.getHeight());
    }

    private JMenuBar createJMenuBar() {
        JMenuBar m = new JMenuBar();
        JMenu sortMenu = new JMenu("Sort");
        JMenuItem selectionSortMenu = new JMenuItem("Selection");
        selectionSortMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Random rnd = new Random();
                Integer[] a = new Integer[arraySize];
                for (int i = 0; i < a.length; i++) {
                    a[i] = rnd.nextInt(90) + 10;
                }
                SelectionSortStepPainter sssp = new SelectionSortStepPainter(currentFrame, a);
                sssp.stepCurrentState(0);
                //sssp.stepExchange(10,15);
                panel.repaint();

                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Selection.stepSort(a, sssp, panel);
                    }
                });
                th.start();
            }
        });
        JMenuItem insertionSortMenu = new JMenuItem("Insertion");
        insertionSortMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Random rnd = new Random();
                Integer[] a = new Integer[arraySize];
                for (int i = 0; i < a.length; i++) {
                    a[i] = rnd.nextInt(90) + 10;
                }
                InsertionSortStepPainter issp = new InsertionSortStepPainter(currentFrame, a);
                issp.stepStay();
                panel.repaint();

                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Insertion.stepSort(a, issp, panel);
                    }
                });
                th.start();
            }
        });
        JMenuItem shellSortMenu = new JMenuItem("Shell");
        shellSortMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                Integer[] a = new Integer[arraySize];
                for (int i = 0; i < a.length; i++) {
                    a[i] = rnd.nextInt(90) + 10;
                }
                ShellSortStepPainter sssp = new ShellSortStepPainter(currentFrame, a);
                sssp.stepStay();
                panel.repaint();

                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Shell.stepSort(a, sssp, panel);
                    }
                });
                th.start();
            }
        });
        JMenuItem mergeSortMenu = new JMenuItem("Merge");
        mergeSortMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                Integer[] a = new Integer[arraySize];
                for (int i = 0; i < a.length; i++) {
                    a[i] = rnd.nextInt(90) + 10;
                }
                MergeSortStepPainter mssp = new MergeSortStepPainter(currentFrame, a);
                mssp.stepStay();
                panel.repaint();

                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Merge.stepSort(a, mssp, panel);
                    }
                });
                th.start();
            }
        });
        JMenuItem mergeBUSortMenu = new JMenuItem("MergeBU");
        mergeBUSortMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                Integer[] a = new Integer[arraySize];
                for (int i = 0; i < a.length; i++) {
                    a[i] = rnd.nextInt(90) + 10;
                }
                MergeSortStepPainter mssp = new MergeSortStepPainter(currentFrame, a);
                mssp.stepStay();
                panel.repaint();

                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        MergeBU.stepSort(a, mssp, panel);
                    }
                });
                th.start();
            }
        });
        JMenuItem quickSortMenu = new JMenuItem("Quick");
        quickSortMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                Integer[] a = new Integer[arraySize];
                for (int i = 0; i < a.length; i++) {
                    a[i] = rnd.nextInt(90) + 10;
                }
                QuickSortStepPainter qssp = new QuickSortStepPainter(currentFrame, a);
                qssp.stepStay();
                panel.repaint();

                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Quick.stepSort(a, qssp, panel);
                    }
                });
                th.start();
            }
        });
        JMenuItem quick3waySortMenu = new JMenuItem("Quick3way");
        quick3waySortMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                Integer[] a = new Integer[arraySize];
                for (int i = 0; i < a.length; i++) {
                    a[i] = rnd.nextInt(5) + 1;
                }
                QuickSortStepPainter qssp = new QuickSortStepPainter(currentFrame, a);
                qssp.stepStay();
                panel.repaint();

                Thread th = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Quick3way.stepSort(a, qssp, panel);
                    }
                });
                th.start();
            }
        });
        sortMenu.add(selectionSortMenu);
        sortMenu.add(insertionSortMenu);
        sortMenu.add(shellSortMenu);
        sortMenu.add(mergeSortMenu);
        sortMenu.add(mergeBUSortMenu);
        sortMenu.add(quickSortMenu);
        sortMenu.add(quick3waySortMenu);
        m.add(sortMenu);
        return m;
    }

    private JPanel createJPanel() {

        JPanel jp = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
                if (currentFrame != null) {
                    g.drawImage(currentFrame, 0, 0, this);
                }
            }
        };
        return jp;
    }

    public static void main(String[] args) {
        new Visualization("Algorithms visualuzation", 800, 600);
    }

}
