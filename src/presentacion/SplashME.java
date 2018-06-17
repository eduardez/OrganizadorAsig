/**
 * 
 */
package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.SplashScreen;

/**
 * @author Eduardez
 *
 */
public class SplashME  {
	public static void main(String [] args) throws InterruptedException {
		SplashScreen splash= SplashScreen.getSplashScreen();
		Rectangle bounds = splash.getBounds();
		Graphics g2= splash.createGraphics();
		g2.setColor(Color.BLUE);
		for (int i=0;i<100;i++) {
			g2.fillRect(0, 0, bounds.width*i/100, 20);
			splash.update();
			Thread.sleep(100);
		}
	}

}
