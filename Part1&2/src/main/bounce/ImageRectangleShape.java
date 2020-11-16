package bounce;

import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageRectangleShape extends RectangleShape{
	public static Image image;
	
	public ImageRectangleShape(int deltaX, int deltaY, Image image) {
		super._deltaX = deltaX;
		super._deltaY = deltaY;
		this.image = image;
	}
	
	public static Image makeImage(String imageFileName, int shapeWidth) {
		
		int sw = shapeWidth; // width of new shape
		//int sh = 0; // height of new shape
		File f = new File(imageFileName); // instance of File
		BufferedImage b = null;
		BufferedImage b2 = null;
		int w; // width of loaded image
		int h; // height of loaded image
		double sf = 0.0; // scale factor
		Graphics2D g;
		BufferedImage b3 = null;
		
		try {
			b = ImageIO.read(f);
			b2 = b;
			w = b.getWidth();
			h = b.getHeight();
			
			if (w > sw) {
				int sh;
				sf = (double)sw / (double)w;
				sh = (int) ((int) h * sf);
				//System.out.println(sf); // test
				//System.out.println(sh);
				b2 = new BufferedImage(sw, sh, BufferedImage.TYPE_4BYTE_ABGR);
				g = b2.createGraphics();
				g.drawImage(b, 0, 0, sw, sh, null);
			}
			b3 = b2;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b3;
	}
	
	public void doPaint(Painter painter) {
		painter.drawImage(this.image, _x, _y, image.getWidth(null), image.getHeight(null));
	}

}
