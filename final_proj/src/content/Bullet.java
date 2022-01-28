package content;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class Bullet{
	private double x;
	private double y;
	private Image bullet;
	
	
	public Bullet(double x,double y) {
	this.x=x; 
	this.y=y; 
	bullet = new ImageIcon("Images/bullet.png").getImage();
	}
	
	//speed of bullet movement
	public void tick(){
		x-=5;
	}
	public void render(Graphics g, ImageObserver o)
	{
	g.drawImage(bullet, (int)this.x, (int)this.y, o);
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getBullet() {
		return bullet;
	}

	public void setBullet(Image bullet) {
		this.bullet = bullet;
	}
}