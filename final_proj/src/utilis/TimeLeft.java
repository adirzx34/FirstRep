package utilis;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class TimeLeft {
	Toolkit toolkit; 
	public Timer timer; 
	int timee; 
	public int res=0;
	int flag=0;
	public TimeLeft(int sec){
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer(); 
		timer.schedule(new RemindTask(sec), 0,1*1000);
	}
	
	public int geTimee(){
		return timee; 
	}
	public void setTimee(int timee){
		this.timee= timee;
	}
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Player: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	
public class RemindTask extends TimerTask{
		int time; 
		public RemindTask(int time){
			this.time = time; 
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(time > 0){
				time--; 
				setTimee(time);
			}
			else{
				toolkit.beep();
				infoBox("Time Out", "Game Over");
				res=1;
				timer.cancel();
			}
			
		}
		public void setTime(int t){
			this.time=t;
		}
			
	}

}
