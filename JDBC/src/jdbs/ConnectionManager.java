package jdbs;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;






public class ConnectionManager {
	
	

public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/swing","root","");  
		if (con != null)
		{
			System.out.println("Connected");
		}
		else
		{
			System.out.println("not Connected");
		}
		
		JFrame obj=new JFrame("Login page");
		 obj.setContentPane(new JLabel(new ImageIcon("C:\\icon.jpg")));
		 
		final JTextField un;
		JPasswordField pas,rpas;
		final JLabel un1,pas1,rpas1;
		un1=new JLabel("Username");
		un1.setBounds(50, 50, 160, 30);
		un=new JTextField();
		un.setBounds(150, 50, 160, 30);
		
		pas1=new JLabel("Password");
		pas1.setBounds(50, 100, 160, 30);
		pas=new JPasswordField();
		pas.setBounds(150, 100, 160, 30);
		
		rpas1=new JLabel("Re-Password");
		rpas1.setBounds(50, 150, 160, 30);
		rpas=new JPasswordField();
		rpas.setBounds(150, 150, 160, 30);

		obj.add(un1);obj.add(un);
		
		obj.add(pas1);obj.add(pas);
		
		obj.add(rpas1);obj.add(rpas);
		
		
	     
		JButton b=new JButton("Login");
		b.setBounds(100, 200, 160, 30);
		obj.add(b);

		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String uname=un.getText();
				String pass=pas.getText();
				String rpass=rpas.getText();
				System.out.print(pass+" "+rpass);
				if(!(pass.equals(rpass)))
				{
			    java.sql.Statement statement = null;
					try {
						statement = con.createStatement();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						String s="INSERT INTO login VALUES('"+uname+"','"+pass+"','"+rpass+"')";
						//System.out.println(s);
						statement.executeUpdate(s);
					    //System.out.println("printed");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			
			else
			{
				JLabel str=new JLabel("The passwords are same enter a new one to change the password");
				str.setBounds(100, 350, 300, 100);
				obj.add(str);
				
			}
			}
			
		
		});
		
	     		
	    obj. setSize(500, 400);
		obj.setLayout(null);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
