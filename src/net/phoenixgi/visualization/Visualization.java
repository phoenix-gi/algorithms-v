package net.phoenixgi.visualization;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author phoenix-gi
 */
public class Visualization extends JFrame {
    
    public Visualization(String name,int width,int height) {
        super(name);
        Toolkit t = Toolkit.getDefaultToolkit();
        setBounds(t.getScreenSize().width/2-width/2,t.getScreenSize().height/2-height/2,width,height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(createJMenuBar());
        setLayout(new BorderLayout());
        add(createJPanel(),BorderLayout.CENTER);
        setVisible(true);
    }
    
    private JMenuBar createJMenuBar() {
        JMenuBar m = new JMenuBar();
        JMenu sortMenu = new JMenu("Sort");
        JMenuItem selectionSortMenu = new JMenuItem("Selection");
        JMenuItem insertionSortMenu = new JMenuItem("Insertion");
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
            };
        };
        return jp;
    }
    
    public static void main(String[] args) {
        new Visualization("Algorithms visualuzation",640,480);
    }
    
}
