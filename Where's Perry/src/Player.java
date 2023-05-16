import java.awt.Color;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Player{
	private Image img; 	
	private AffineTransform tx;
	private double x, y;
	private double vx, vy;
	private int floor= 300;
	private double gravity = 0.05;
	private double size;
	private BufferedImage color;
	private int clr; 
	

	public Player() {
		img = getImage("/imgs/Phineas.png"); //load the image for Tree
		
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 
		
	
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(0, 0);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		update();
		
		g.drawRect((int) x, (int) y, 30, 10);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
		size = a;
	}
	
	public void moveLeft(){
		//x += speed;
		vx = 1;
		x += 10;
		img = getImage("/imgs/Phineas.png");
		
		
	}
	
	public void stop(){
		//x += speed;
		vx = 0;
			
	}
	
	
	public void moveRight(){
		//x-= speed;
		vx = -1;
	
		img = getImage("/imgs/Phinflip.png");
		//tx = AffineTransform.getTranslateInstance(x, y);
	}
	
	
	public void jump() {
		if(y == floor-1) {
			vy = -3;
		}

	}
	
	public int getclr() {
		clr = color.getRGB(10,10); 
		System.out.println("i "+ clr);
		return clr;
	}
	
	
	public void update() {
		x += vx;
		y += vy;
		vy += gravity;
		tx = AffineTransform.getTranslateInstance(x, y);
		if (y>= floor) {
			y = floor-1;
		}
		
		
		
	}
	/*
	
	public void GetPixelColor (int x,int y) {
		 File file = new File("/imgs/background.png");
		 BufferedImage image = null;
			try {
				image = ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        // Getting pixel color by position x and y 
	        int clr = image.getRGB(x, y);
	       // int red =   (clr & 0x00ff0000) >> 16;
	       // int green = (clr & 0x0000ff00) >> 8;
	      //  int blue =   clr & 0x000000ff;
	        System.out.println("try detect" + clr);
	        //System.out.println("Red Color value = " + red);
	      //  System.out.println("Green Color value = " + green);
	      //  System.out.println("Blue Color value = " + blue);
	       
	       
	    
	}
	*/
	
	
	public double getHeight() {
		return y;
	}		
	
	public double getSize() {
		return size;
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Player.class.getResource(path);
			color = ImageIO.read(imageURL);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);//"phineas.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	
	
	
	
	

}