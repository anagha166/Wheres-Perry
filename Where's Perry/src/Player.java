import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player{
	private Image img; 	
	private AffineTransform tx;
	private double x, y;
	private double vx, vy;
	private double gravity = 0.025;
	private double size;
	

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
		
		g.drawRect((int) x, (int) y, 10, 10);
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
		vy = -2;

	}
	
	
	
	
	public void update() {
		x += vx;
		y += vy;
		vy += gravity;
		tx = AffineTransform.getTranslateInstance(x, y);
	}
	
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
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);//"phineas.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	
	
	
	
	

}