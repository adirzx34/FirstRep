package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import init.Application;
import utilis.DBCon;

public class Login extends JPanel implements ActionListener{
	private Application app;
	private JLabel bgimage = new JLabel(new ImageIcon("Images/backg.jpg"));
	private JLabel lblUser = new JLabel("User Name");
	private JTextField txtUser = new JTextField();
	private JLabel  lblPass = new JLabel("Password");
	private JPasswordField txtPass = new JPasswordField();
	private JButton login = new JButton(new ImageIcon("Images/login.png"));
	private JButton register = new JButton(new ImageIcon("Images/register.png"));
	private JButton exitgame = new JButton(new ImageIcon("Images/exit.png"));
	private Dimension d = new Dimension(180, 30);
	private Dimension d1 = new Dimension(250, 30);
	private Dimension d2 = new Dimension(100, 30);
	private Dimension d3 = new Dimension(130, 35);
	private Font f1 = new Font("David",Font.BOLD,26);
	private int width = 800, height = 400;
	
	public Login(Application app)
	{
		this.app=app;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		
		lblUser.setForeground(Color.GREEN);
		lblUser.setFont(f1);
		lblUser.setBounds(200, 100, d.width, d.height);
		add(lblUser);
		txtUser.setFont(f1);
		txtUser.setBounds(350, 100, d.width, d.height);
		add(txtUser);
		lblPass.setForeground(Color.GREEN);
		lblPass.setFont(f1);
		lblPass.setBounds(200, 150, d.width, d.height);
		add(lblPass);
		txtPass.setFont(f1);
		txtPass.setBounds(350, 150, d.width, d.height);
		add(txtPass);
		//login button 
		login.setPreferredSize(new Dimension(250,80));
		login.setBounds(350, 200, d3.width, d3.height);
		login.addActionListener(this);
		add(login);
		// register button 
		register.setPreferredSize(new Dimension(250,80));
		register.setBounds(350, 250, d3.width, d3.height);
		register.addActionListener(this);
		add(register);
		// exit game button 
		exitgame.setBounds(350, 300, d3.width, d3.height);
		exitgame.addActionListener(this);
		add(exitgame);
		// ADD BACKGROUND 
		bgimage.setBounds(0, 0, width, height);
		add(bgimage);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(login))
		{
			
			try {
				//query check if user and pass correct
				if(DBCon.login(txtUser.getText(), txtPass.getText())==1 && txtUser.getText().length()>0 &&txtPass.getText().length()>0 )
					app.changePanel(new Menu(app));
				else
					 JOptionPane.showMessageDialog(null,"wrong user or password");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
			
		app.changePanel(new Menu(app));
		}
		//register panel
		if(e.getSource().equals(register))
		{
			
			app.changePanel(new Register(app));
		}
		//exit game
		if(e.getSource().equals(exitgame))
		{
			System.exit(0);
		}
	}

	
}
