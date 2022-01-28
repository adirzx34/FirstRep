package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;

import init.Application;


public class Menu extends JPanel implements ActionListener{
	Application app;
	private JLabel bgimage = new JLabel(new ImageIcon("Images/backg.jpg"));
	private JButton startgame = new JButton(new ImageIcon("Images/startgame.png"));
	private JButton multiplayer = new JButton(new ImageIcon("Images/multiplayer.png"));
	private JButton exitgame = new JButton(new ImageIcon("Images/exit.png"));
	private Dimension d = new Dimension(130, 35);
	private int width = 800, height = 400;
	
	

	
	public Menu(Application app) 
	{
		this.app=app;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		bgimage.setBounds(0, 0, width, height);
			
		startgame.setBounds((width/2)-100, (height/2)-100, d.width, d.height);
		startgame.addActionListener(this);
		add(startgame);
		
		multiplayer.setBounds((width/2)-100, (height/2)-50, d.width, d.height);
		multiplayer.addActionListener(this);
		add(multiplayer);
		
		
		exitgame.setBounds((width/2)-100, (height/2), d.width, d.height);
		exitgame.addActionListener(this);
		add(exitgame);
		
		

	
		add(bgimage);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//single playr-level 1
		if(e.getSource().equals(startgame))
		{
			Level1 g = new Level1(app);
			app.changePanel(g);
		}
		
		if(e.getSource().equals(multiplayer))
		{
			
		}
		if(e.getSource().equals(exitgame))
		{
			System.exit(0);
		}
	}	

	

}
