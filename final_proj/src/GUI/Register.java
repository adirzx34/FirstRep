package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

import init.Application;
import utilis.DBCon;

public class Register extends JPanel implements ActionListener{
	private Application app;
	
	private JLabel bgimage = new JLabel(new ImageIcon("Images/backg.jpg"));
	private JLabel title = new JLabel("Registration Form");
	private JLabel lblUser = new JLabel("User Name");
	private JTextField txtUser = new JTextField();
	private JLabel lblFName = new JLabel("First Name");
	private JTextField txtFName = new JTextField();
	private JLabel  lblLName = new JLabel("Last Name");
	private JTextField txtLName = new JTextField();
	private JLabel  lblPass = new JLabel("Password");
	private JPasswordField txtPass = new JPasswordField();
	private JButton send = new JButton(new ImageIcon("Images/register.png"));
	private Dimension d = new Dimension(180, 30);
	private Dimension d1 = new Dimension(250, 30);
	private Dimension d2 = new Dimension(100, 30);
	private Dimension d3 = new Dimension(130, 35);
	private Font f1 = new Font("David",Font.BOLD,26);
	private int width = 800, height = 400;

	public Register(Application app)
	{
		this.app=app;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		bgimage.setBounds(0, 0, width, height);
		
		lblUser.setForeground(Color.GREEN);
		lblUser.setFont(f1);
		lblUser.setBounds(200, 100, d.width, d.height);
		add(lblUser);
		txtUser.setFont(f1);
		txtUser.setBounds(350, 100, d.width, d.height);
		add(txtUser);
		lblFName.setForeground(Color.GREEN);
		lblFName.setFont(f1);
		lblFName.setBounds(200, 150, d.width, d.height);
		add(lblFName);
		txtFName.setFont(f1);
		txtFName.setBounds(350, 150, d.width, d.height);
		add(txtFName);
		lblLName.setForeground(Color.GREEN);
		lblLName.setFont(f1);
		lblLName.setBounds(200, 200, d.width, d.height);
		add(lblLName);
		txtLName.setFont(f1);
		txtLName.setBounds(350, 200, d.width, d.height);
		add(txtLName);
		lblPass.setForeground(Color.GREEN);
		lblPass.setFont(f1);
		lblPass.setBounds(200, 250, d.width, d.height);
		add(lblPass);
		txtPass.setFont(f1);
		txtPass.setBounds(350, 250, d.width, d.height);
		add(txtPass);
		send.setPreferredSize(new Dimension(250,80));
		send.setBounds(350, 300, d3.width, d3.height);
		send.addActionListener(this);
		add(send);
		add(bgimage);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource().equals(send))
			
		{
			//insert into data base the informassion
			if(txtUser.getText().length()>0 && txtFName.getText().length()>0 && txtLName.getText().length()>0&& txtPass.getText().length() > 0){
			try {
				DBCon.register(txtUser.getText(), txtFName.getText(),txtLName.getText(),txtPass.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			app.changePanel(new Menu(app));
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"wrong user or password");
			}
		}
	}
	
}