package net.phoenixgi.visualization;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author phoenix-gi
 */
public class QuickSortStepPainter extends SortStepPainter {

    public QuickSortStepPainter(BufferedImage img, Integer[] o) {
        super(img, o);
    }
    
    public void stepPartition(int i, int j) {
        clearImage();
        stepStay();
        int[] xp = new int[]{i*step,i*step+step/2,i*step+step};
        int[] yp = new int[]{img.getHeight()-(int)(paddingY*0.1f),img.getHeight()-paddingY,img.getHeight()-(int)(paddingY*0.1f)};
        g.setColor(Color.black);
        g.fillPolygon(xp, yp, 3);
        
        xp = new int[]{j*step,j*step+step/2,j*step+step};
        g.setColor(Color.blue);
        g.fillPolygon(xp, yp, 3);
    }
    
    public void stepExchange(int i, int j) {
        stepPartition(i,j);
        g.setColor(Color.pink);
        g.fillRect(i*step+paddingX, img.getHeight() - (int)(o[i]*scaleHeight)+paddingY, step-paddingX, (int)(o[i]*scaleHeight)-paddingY*2);
        g.setColor(Color.orange);
        g.fillRect(j*step+paddingX, img.getHeight() - (int)(o[j]*scaleHeight)+paddingY, step-paddingX, (int)(o[j]*scaleHeight)-paddingY*2);
    }
    
    public void stepPartitionEnd(int j) {
        stepPartition(j,j);
        g.setColor(Color.blue);
        g.fillRect(j*step+paddingX, img.getHeight() - (int)(o[j]*scaleHeight)+paddingY, step-paddingX, (int)(o[j]*scaleHeight)-paddingY*2);
    }

}
