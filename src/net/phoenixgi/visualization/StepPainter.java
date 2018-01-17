package net.phoenixgi.visualization;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author phoenix-gi
 */
public abstract class StepPainter {

    protected BufferedImage img;
    protected Graphics2D g;

    public StepPainter(BufferedImage img) {
        this.img = img;
        g = (Graphics2D) img.getGraphics();
    }

}
