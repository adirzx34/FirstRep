package content;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.swing.ImageIcon;

public class Mokesh {
	private Random r=new Random();
	private double x,y, tick; 
	private int height=200,width=200; 
	private Image img;
	
	public Mokesh(double x,double y) {
		this.x=x;
		this.y=y;
		tick=Math.random()*0.4+0.5;//Motion rate of the zombie
		img = new ImageIcon("Images/mokesh.png").getImage();
	}
	
	public double getX() {
		return x;
}
	public void setX(int x) {
		this.x = this.x+x;
	}
	public double getY() {
		return y;
	}
	public void setY(int y) {
		this.y = this.y+y;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	//move mokesh 
	public void tick()
	{
		y+=tick;//0.1;
		if(y>750){
			y=-250;
			x=(r.nextInt(800))+200;			
		}
	}
	public void draw(Graphics g, ImageObserver o)
	{
		g.drawImage(img, (int)this.x, (int)this.y, this.width, this.height, o);
	}
}
