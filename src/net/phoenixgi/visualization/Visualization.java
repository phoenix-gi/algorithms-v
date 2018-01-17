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
import net.phoenixgi.algorithms.sort.Selection;

/**
 *
 * @author phoenix-gi
 */
public class Visualization extends JFrame {

    final static int arraySize = 25;
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
        sortMenu.add(selectionSortMenu);
        sortMenu.add(insertionSortMenu);
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
