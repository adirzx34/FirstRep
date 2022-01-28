package content;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Random;
import javax.swing.ImageIcon;

public class Zombie2 {
	private Random r=new Random();
	private double x,y, tick; 
	private int height=606,width=475; 
	private int life=10;
	private int i;
	private Image img;
	public Zombie2(int i,double x,double y) {
		this.i=i;
		this.x=x;
		this.y=y;
		tick=Math.random()*0.4+0.1;//Motion rate of the zombie
		img = new ImageIcon("Images/"+i+".gif").getImage();
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
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		if(this.life > 0){
		this.life = life;
		}
	}//hit zombies
	public void hit(){
		if(this.life > 0)
		{
		this.life--;
		}
		
	}
	//move zombie
	public void tick()
	{
		x+=tick;//0.1;
		if(x>1400){
			x=-250;		
		}
	}
	public void draw(Graphics g, ImageObserver o)
	{
		g.drawImage(img, (int)this.x, (int)this.y, this.width, this.height, o);
	}
}