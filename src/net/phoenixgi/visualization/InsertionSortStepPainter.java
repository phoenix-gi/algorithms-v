package net.phoenixgi.visualization;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author phoenix-gi
 */
public class InsertionSortStepPainter extends SortStepPainter {
    
    public InsertionSortStepPainter(BufferedImage img, Integer o[]) {
        super(img,o);
    }

    public void stepExchange(int i, int j) {
        stepStay();
        g.setColor(Color.black);
        int[] xp = new int[]{i * step, i * step + step / 2, i * step + step};
        int[] yp = new int[]{img.getHeight() - (int) (paddingY * 0.1f), img.getHeight() - paddingY, img.getHeight() - (int) (paddingY * 0.1f)};
        g.fillPolygon(xp, yp, 3);
        
        g.setColor(Color.pink);
        //g.fillRect(i * step + paddingX, img.getHeight() - (int) (o[i] * scaleHeight) + paddingY, step - paddingX, (int) (o[i] * scaleHeight) - paddingY * 2);
        g.fillRect(j * step + paddingX, img.getHeight() - (int) (o[j] * scaleHeight) + paddingY, step - paddingX, (int) (o[j] * scaleHeight) - paddingY * 2);
        xp = new int[]{j * step, j * step + step / 2, j * step + step};
        yp = new int[]{img.getHeight() - (int) (paddingY * 0.1f), img.getHeight() - paddingY, img.getHeight() - (int) (paddingY * 0.1f)};
        g.setColor(Color.blue);
        g.fillPolygon(xp, yp, 3);
    }
}
