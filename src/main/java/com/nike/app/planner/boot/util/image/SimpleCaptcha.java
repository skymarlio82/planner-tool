
package com.nike.app.planner.boot.util.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class SimpleCaptcha {

	public static String output2os(OutputStream os) throws IOException {
		// Define number characters contains the captcha image, declare global
		int iTotalChars = 6;
		// Size image iHeight and iWidth, declare global
		int iWidth  = 150;
		int iHeight = 40;
		// font style
		Font fntStyle1 = new Font("Arial", Font.BOLD, 30);
		// Possible random characters in the image
		Random randChars = new Random();
		String sImageCode = (Long.toString(Math.abs(randChars.nextLong()), 36)).substring(0, iTotalChars);
		// BufferedImage is used to create a create new image
		// TYPE_INT_RGB - does not support transparency, TYPE_INT_ARGB - support transparency
		BufferedImage biImage = new BufferedImage(iWidth, iHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2dImage = (Graphics2D)biImage.getGraphics();
		// Draw background rectangle and noisy filled round rectangles
		int iCircle = 15;
		for (int i = 0; i < iCircle; i++) {
			g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
		}
		g2dImage.setFont(fntStyle1);
		for (int i = 0; i < iTotalChars; i++) {
			g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
			if (i%2 == 0) {
				g2dImage.drawString(sImageCode.substring(i, i + 1), 25*i, 24);
			} else {
				g2dImage.drawString(sImageCode.substring(i, i + 1), 25*i, 35);
			}
		}
		// create jpeg image and display on the screen
		ImageIO.write(biImage, "png", os);
		// Dispose function is used to destroy an image object
		g2dImage.dispose();
		return sImageCode;
	}
}
