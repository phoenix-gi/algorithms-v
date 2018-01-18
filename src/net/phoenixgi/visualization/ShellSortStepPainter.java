package net.phoenixgi.visualization;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author phoenix-gi
 */
public class ShellSortStepPainter extends SortStepPainter{

    public ShellSortStepPainter(BufferedImage img, Integer[] o) {
        super(img, o);
    }
    
    public void stepCurrentState(int k) {
        stepStay();
        
        g.setColor(Color.black);
        int[] xp = new int[]{k*step,k*step+step/2,k*step+step};
        int[] yp = new int[]{img.getHeight()-(int)(paddingY*0.1f),img.getHeight()-paddingY,img.getHeight()-(int)(paddingY*0.1f)};
        g.fillPolygon(xp, yp, 3);
    }
    
    public void stepExchange(int i, int j) {
        stepCurrentState(i);
        
        g.setColor(Color.pink);
        g.fillRect(i*step+paddingX, img.getHeight() - (int)(o[i]*scaleHeight)+paddingY, step-paddingX, (int)(o[i]*scaleHeight)-paddingY*2);
        g.fillRect(j*step+paddingX, img.getHeight() - (int)(o[j]*scaleHeight)+paddingY, step-paddingX, (int)(o[j]*scaleHeight)-paddingY*2);
        int[] xp = new int[]{j*step,j*step+step/2,j*step+step};
        int[] yp = new int[]{img.getHeight()-(int)(paddingY*0.1f),img.getHeight()-paddingY,img.getHeight()-(int)(paddingY*0.1f)};
        g.setColor(Color.blue);
        g.fillPolygon(xp, yp, 3);
    }

}
