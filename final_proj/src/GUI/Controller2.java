package GUI;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import content.Bomb;
import content.Bullet;
import content.Lifes;
import content.Mokesh;
import content.Money;
import content.Zombie;

//Controller class of level number 1
public class Controller2{
	private LinkedList<Bullet> b = new LinkedList<Bullet>(); //link list of bullet
	private LinkedList<Zombie> z = new LinkedList<Zombie>(); //link list of zombie
	private LinkedList<Mokesh> m = new LinkedList<Mokesh>(); //link list of Mokesh
	private LinkedList<Money> money = new LinkedList<Money>(); //link list of money gift
	private LinkedList<Lifes> lf = new LinkedList<Lifes>(); //link list of Life gift
	private LinkedList<Bomb> bomb = new LinkedList<Bomb>(); //link list of bonus time
	private boolean b1=false;
	
	Random r = new Random();
	int r1,r2,r3,r4;
	
	int flag=0,flag1=0,flag2=0;
	int flag_lev=0,flag_bomb=0,flag_money=0;
	
	Bullet TempBullet; 
	Zombie TempZombie;	
	Mokesh TempMokesh;
	Money TempMoney;
	Lifes TempLife; 
	Bomb TempBomb;
	Level2 level2;

	public Controller2(Level2 level2){
		this.level2 = level2;
		//create 6 zombies random use to  grills a random image of a zombie
		for(int i=0;i<3;i++){
			r1=	r.nextInt(3)+1;
			addZombie(new Zombie(r1,-200,120+(i*200)));
		}
		for(int i=0;i<3;i++){
			r1=	r.nextInt(3)+1;
			addZombie(new Zombie(r1,-500,120+(i*200)));
		}
		r2=(r.nextInt(800))+200;
	    addMokesh(new Mokesh(r2,50));
		r2=(r.nextInt(800))+200;
	    addMokesh(new Mokesh(r2,50));
		r2=(r.nextInt(800))+200;
	    addMokesh(new Mokesh(r2,50));

	}
//A function that manages the movement of zombies and bullets
	public void tick()
	{
		for(int i=0 ; i <b.size(); i++)
		{	
			b1=true;
			TempBullet = b.get(i);
			//Checking that the bullets still exist, so they move
			if(TempBullet!=null){
				TempBullet.tick();
			}
		}
		for(int i=0 ; i <z.size(); i++)
		{	
			//Checking that the zombies still exist, so they move

			TempZombie = z.get(i);
			if(TempZombie!=null){
				TempZombie.tick();
			}
		}
		for(int i=0 ; i <m.size(); i++)
		{	
			//Checking that the mokesh still exist, so they move

			TempMokesh = m.get(i);
			if(TempMokesh!=null){
				TempMokesh.tick();
			}
		}
		for(int i=0 ; i <money.size(); i++)
		{	
			//Checking that the money still exist, so they move

			TempMoney = money.get(i);
			if(TempMoney!=null){
				TempMoney.tick();
			}
		}

		for(int i=0 ; i <lf.size(); i++)
		{	
			//Checking that the life gift still exist, so they move

			TempLife = lf.get(i);
			if(TempLife!=null){
				TempLife.tick();
			}
		}
		
		for(int i=0 ; i <bomb.size(); i++)
		{	
			//Checking that the life gift still exist, so they move

			TempBomb = bomb.get(i);
			if(TempBomb!=null){
				TempBomb.tick();
			}
		}
		
		for(int i=0 ; i <b.size(); i++)
		{		
			b1=true;
			TempBullet = b.get(i);
			for(int j=0 ; j <z.size(); j++ )
			{

				TempZombie = z.get(j);
		 //checke if there was a zombie hit raises the score by 10 in addition to downloading from the life of the zombie 1 and if the zombie's life reaches 0 it deletes it
				if(TempZombie!=null&&TempBullet!=null&&TempBullet.getX() < TempZombie.getX()+TempZombie.getWidth()-60 && TempZombie.getX() < TempBullet.getX() && TempBullet.getY() >= TempZombie.getY() && TempBullet.getY() <=TempZombie.getY() + TempZombie.getHeight()-60)
					{
							level2.play.setScore(10);
							removeBullet(TempBullet);

							if(TempZombie.getLife()==1){
								removeZombie(TempZombie);
								level2.zl2--;
							}
							else{
								TempZombie.hit();
								
							}
							b1=false;
					}

			}
				// stop the bullet in the end of the screen 
				if(TempBullet.getX() < 0)
				{	
				b1=false;
				}
		}
		
		//Check if the zombie touches a player 
		for(int i=0 ; i <z.size(); i++)
		{		
			TempZombie = z.get(i);
				
				if (level2.play.getX() < TempZombie.getX()+TempZombie.getWidth()-60 && level2.play.getX()+level2.play.getWidth() > TempZombie.getX() && level2.play.getY() < TempZombie.getY()+TempZombie.getHeight()-40 && level2.play.getY() + level2.play.getHeight() > TempZombie.getY())
				{
					level2.play.hit();
					level2.play.moveX(1200);
					level2.repaint();
				}
		}
		//Check if the mokesh touches a player 
		for(int j=0 ; j <m.size(); j++ )
		{
				TempMokesh = m.get(j);
				
				if (level2.play.getX() < TempMokesh.getX()+TempMokesh.getWidth() && level2.play.getX()+level2.play.getWidth() > TempMokesh.getX() && level2.play.getY() < TempMokesh.getY()+TempMokesh.getHeight()-15 && level2.play.getY() + level2.play.getHeight() > TempMokesh.getY())
				{
					level2.play.hit();
					level2.play.moveX(1200);
					level2.repaint();
				}
		
		}
		
		//Check if the player take a life gift
		for(int j=0 ; j <lf.size(); j++ )
		{
				TempLife = lf.get(j);

				if (level2.play.getX() < TempLife.getX()+TempLife.getWidth()-15 && level2.play.getX()+level2.play.getWidth() > TempLife.getX() && level2.play.getY() < TempLife.getY()+TempLife.getHeight()-15 && level2.play.getY() + level2.play.getHeight() > TempLife.getY() && flag_lev==0)
				{
					level2.play.setLife(1);
					flag_lev=1;
					removeLife(TempLife);
					level2.repaint();
				}
		}
		
		//Check if the player take a money gift
		for(int j=0 ; j <money.size(); j++ )
		{
				TempMoney = money.get(j);
		
				if (level2.play.getX() < TempMoney.getX()+TempMoney.getWidth()-15 && level2.play.getX()+level2.play.getWidth() > TempMoney.getX() && level2.play.getY() < TempMoney.getY()+TempMoney.getHeight()-15 && level2.play.getY() + level2.play.getHeight() > TempMoney.getY() && flag_money==0)
				{
					level2.play.setScore(15);
					flag_money=1;
					removeMoney(TempMoney);
				}
		}
		

		//Check if the player take a bomb that kill him
		for(int j=0 ; j <bomb.size(); j++ )
		{
			TempBomb = bomb.get(j);

				if (level2.play.getX() < TempBomb.getX()+TempBomb.getWidth()-15 && level2.play.getX()+level2.play.getWidth() > TempBomb.getX() && level2.play.getY() < TempBomb.getY()+TempBomb.getHeight()-15 && level2.play.getY() + level2.play.getHeight() > TempBomb.getY() && flag_bomb==0)
				{
					System.out.println("check2");
					level2.play.setLife(-4);
					level2.repaint();
					flag_bomb=1;
					removeBomb(TempBomb);
					
				}
		}
		
		// timers for gifts 
		
		// add score 
	    if(level2.getTl()==20 && flag==0)
	    { 	
	    r3=(r.nextInt(800))+200;	
		addMoney(new Money(r3,50));

		flag=1;
	    }    
	    
		// add life
	    if(level2.getTl()==15 && flag2==0)
	    { 	
			r4=(r.nextInt(800))+200;
			addLife(new Lifes(r4,50));
			flag2=1;
	    }
	    
	    // bomb that kill player 
	    if(level2.getTl()==25 && flag1==0)
	    { 	
	    r3=(r.nextInt(800))+200;	
		addBomb(new Bomb(r3,50));
		flag1=1;
	    }    
	    
	}

//Repaint any movement
	public void render(Graphics g)
	{
		// repaint bullet
		for(int i=0 ; i <b.size(); i++)
		{
			TempBullet = b.get(i);
			TempBullet.render(g, null);	
		}
		// repaint zombie
		for(int i=0 ; i <z.size(); i++)
		{	
			TempZombie = z.get(i);
			TempZombie.draw(g, null);	
		}
		// repaint Mokesh
		for(int i=0 ; i <m.size(); i++)
		{	
			TempMokesh = m.get(i);
			TempMokesh.draw(g, null);	
		}
		// repaint Money gift
		for(int i=0 ; i <money.size(); i++)
		{	
			TempMoney = money.get(i);
			TempMoney.draw(g, null);	
		}
		// repaint Lifes gift
		for(int i=0 ; i <lf.size(); i++)
		{	
			TempLife = lf.get(i);
			TempLife.draw(g, null);	
		}
		// repaint bomb gift
		for(int i=0 ; i <bomb.size(); i++)
		{	
			TempBomb = bomb.get(i);
			TempBomb.draw(g, null);	
		}
	}
	
	//add bullet to list
	public void addBullet(Bullet block){
		b.add(block);
	}
	//remove bullet from list
	public void removeBullet(Bullet block){
		b.remove(block);
	}
	
	//add zombie to list
	public void addZombie(Zombie block){
		z.add(block);
	}
	//remove zombie from list
	public void removeZombie(Zombie block){
		z.remove(block);
	}
	
	//add mokesh to list
	public void addMokesh(Mokesh mokesh){
		m.add(mokesh);
	}
	//remove mokesh from list
	public void removeMokesh(Mokesh mokesh){
		m.remove(mokesh);
	}
	
	//add money to list
	public void addMoney(Money moneyy){
		money.add(moneyy);
	}
	//remove money from list
	public void removeMoney(Money moneyy){
		money.remove(moneyy);
	}
	
	//add life to list
	public void addLife(Lifes lifes){
		lf.add(lifes);
	}
	//remove life from list
	public void removeLife(Lifes lifes){
		lf.remove(lifes);
	}
	
	//add bomb to list
	public void addBomb(Bomb bom){
		bomb.add(bom);
	}
	//remove bomb from list
	public void removeBomb(Bomb bom){
		bomb.remove(bom);
	}
	
	public boolean getB()
	{
		return this.b1;
	}
	public void setB1(boolean b1) {
		this.b1 = b1;
	}

}
