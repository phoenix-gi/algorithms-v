package net.phoenixgi.visualization;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author phoenix-gi
 */
public class SortStepPainter extends StepPainter {

    protected Integer o[];
    protected int max;
    protected int step;
    protected int paddingX;
    protected int paddingY;
    protected float scaleHeight;

    public SortStepPainter(BufferedImage img, Integer o[]) {
        super(img);
        this.o = o;

        step = img.getWidth() / o.length;

        max = o[0];
        for (int i : o) {
            if (i > max) {
                max = i;
            }
        }

        paddingX = (int) (0.2f * step);
        paddingY = (int) (0.025f * img.getHeight());
        scaleHeight = img.getHeight() / (float) max;
    }

    protected void clearImage() {
        g.setColor(Color.white);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
    }

    public void stepStay() {
        clearImage();

        g.setColor(Color.red);
        g.translate((img.getWidth() - step * o.length) / 2, 0);
        for (int i = 0; i < o.length; i++) {
            g.fillRect(i * step + paddingX, img.getHeight() - (int) (o[i] * scaleHeight) + paddingY, step - paddingX, (int) (o[i] * scaleHeight) - paddingY * 2);
        }
    }
}
