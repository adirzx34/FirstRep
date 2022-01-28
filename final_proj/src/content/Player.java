package content;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class Player {
	private double x=1200,y=500; 
	private int height=150,width=150; 
	protected int life=3;
	private Image img = new ImageIcon("Images/player.gif").getImage();
	private boolean playlife=true;
	private static int score=0;

	public static int getScore() {
		return score;
	}
	public void setScore(int score) {
		Player.score+= score;
	}

	public double getX() {
	return x;
	}
	public void moveX(int x) {
		this.x = x;
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
	public int getLife() {
	return this.life;
	}
	public void setLife(int life) {
	this.life+= life;
	}
	//if zombie hit player life--
	public void hit(){
		if(this.life > 0){
		this.life--;
		}
		else 
		{
			System.out.println("no lifes");
		}
	}



public void draw(Graphics g, ImageObserver o)
{
	g.drawImage(img, (int)this.x, (int)this.y, this.width, this.height, o);
}
}