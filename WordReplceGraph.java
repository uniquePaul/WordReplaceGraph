package 文字堆叠图像;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

public class 尝试 {
	
	public static void 创造新图片(String path){
		String base = "Paul";
		try {
		BufferedImage image = ImageIO.read(new File(path));
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(),image.getType());
		Graphics2D graphics2D = (Graphics2D) newImage.getGraphics();
		graphics2D.setFont(new Font("宋体", Font.ITALIC,12));	
		System.out.print(image.getWidth() + " " + image.getHeight());
		int index = 0;
		for (int i = 0; i < image.getHeight(); i += 12) {
			for (int j = 0; j < image.getWidth(); j += 12) {
			
				{
				int pxcolor = image.getRGB(j, i);
				int r = (pxcolor & 0xff0000) >> 16, 
					g = (pxcolor & 0xff00) >> 8, 
					b = pxcolor & 0xff;
				graphics2D.setColor(new Color(r,g,b));
				graphics2D.drawString(String.valueOf(base.charAt(index % base.length())), j, i);
				index ++;}
			}
			
		}
		ImageIO.write(newImage, "JPG", new FileOutputStream("Myprofile.jpg"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		尝试.创造新图片("我.jpg");
		System.out.println("OK");
	}
}
