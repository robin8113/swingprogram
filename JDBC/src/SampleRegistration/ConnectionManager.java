package SampleRegistration;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

public class ConnectionManager {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/swing","root","");  
		Statement statement=(Statement) con.createStatement();
		JFrame obj2=new JFrame("Login Page");
		obj2.setContentPane(new JLabel(new ImageIcon("C:\\icon.jpg")));
		final JTextField unam,upass;
		obj2.setSize(600,400);
		JLabel username,pass1;
		username=new JLabel("Username:");
		username.setBounds(50, 50, 100, 30);
		unam= new JTextField();
		unam.setBounds(150, 50, 160, 30);
		username.setForeground(Color.white);
		
		
		pass1=new JLabel("Password:");
		pass1.setBounds(50, 100, 100, 30);
		upass= new JPasswordField();
		upass.setBounds(150, 100, 160, 30);
		pass1.setForeground(Color.white);
		
		
		JButton log=new JButton("Login");
		log.setBounds(150, 200, 160, 30);
		log.setBackground(Color.blue);
		log.setForeground(Color.white);
		log.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String uname=unam.getText();
				String passw=upass.getText();
				try {
					String s="Select username,password from rob where username='"+uname+"' and password='"+passw+"'";
					
					ResultSet result=statement.executeQuery(s);
					if(result.next()==false)
					{
						JOptionPane.showMessageDialog(log, "Please Sign in to Login");
						unam.setText(null);
						upass.setText(null);
					}
					else
					{
						JOptionPane.showMessageDialog(log, " Login Successfull");
						unam.setText(null);
						upass.setText(null);
						obj2.setVisible(false);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} );
		
		JButton b=new JButton("Create Acoount");
		b.setBounds(350, 200, 160, 30);
		b.setBackground(Color.GREEN);
		b.setForeground(Color.white);
    b.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			JFrame obj=new JFrame("Registation Page");
			final JTextField fn,ln,eml,mb,user,rep;
			final JPasswordField pass,rpas;
			obj.setSize(600,800);
			JLabel l,l1,us,pw,rpas1,mob,em;
			final JLabel veryl;
			l=new JLabel("First Name :");
			l.setBounds(50, 50, 100, 30);
			
			fn= new JTextField();
			fn.setBounds(150, 50, 160, 30);
			
			
			l1=new JLabel("Last Name :");
			l1.setBounds(50, 100, 100, 30);
			ln= new JTextField();
			ln.setBounds(150, 100, 160, 30);
           ln.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					if(fn.getText().trim().equals("%s"))
					{
						fn.requestFocus(true);
					}
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					if(fn.getText().trim().equals(""))
					{
						fn.requestFocus(true);
						JOptionPane.showMessageDialog(fn, "Enter a valid firstname");
						
					}
				}	
			});
			us=new JLabel("User name :");
			us.setBounds(50, 150, 160, 30);
			user= new JTextField();
			user.setBounds(150, 150, 160, 30);
			
user.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					if(ln.getText().trim().equals("%s"))
					{
						ln.requestFocus(true);
					}
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					if(ln.getText().trim().equals(""))
					{
						ln.requestFocus(true);
						JOptionPane.showMessageDialog(ln, "Enter a valid secondname");
						
					}
				}	
			});
			pw=new JLabel("Password :");
			pw.setBounds(50, 200, 160, 30);
			pass= new JPasswordField();
			pass.setBounds(150, 200, 160, 30);
			
pass.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					if(user.getText().trim().equals("%s"))
					{
						user.requestFocus(true);
					}
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					if(user.getText().trim().equals(""))
					{
						user.requestFocus(true);
						JOptionPane.showMessageDialog(user, "Enter a valid username");
						
					}
				}	
			});
			
			rpas1=new JLabel("Re-Password");
			rpas1.setBounds(50, 250, 160, 30);
			rpas=new JPasswordField();
			rpas.setBounds(150, 250, 160, 30);
			
			
rpas.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					if(pass.getText().trim().equals("%s"))
					{
						pass.requestFocus(true);
					}
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					if(pass.getText().trim().equals(""))
					{
						pass.requestFocus(true);
						JOptionPane.showMessageDialog(pass, "Enter a valid Password");
						
					}
				}	
			});
			mob=new JLabel("Mobile :");
			mob.setBounds(50, 300, 160, 30);
			mb= new JTextField();
			mb.setBounds(150, 300, 160, 30);
   mb.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					if(rpas.getText().trim().equals("%s"))
					{
						rpas.requestFocus(true);
					}
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					
					char[] s1=pass.getPassword();
					
					char[] s2=rpas.getPassword();
					
					if(Arrays.equals(s1, s2))
					{
						mb.requestFocus(true);
						
						
					}
					else
					{
						
						JOptionPane.showMessageDialog(mob, "Incorrect password enter properly");
						pass.setText(null);
						rpas.setText(null);
						pass.requestFocus(true);
					}
				}
			});
			em=new JLabel("Email :");
			em.setBounds(50, 350, 160, 30);
			eml= new JTextField();
			eml.setBounds(150, 350, 160, 30);
			
eml.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					if(mb.getText().trim().equals("%s"))
					{
						mb.requestFocus(true);
					}
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					if(mb.getText().trim().equals(""))
					{
						pass.requestFocus(true);
						JOptionPane.showMessageDialog(mb, "Enter a valid mobile number");
						
					}
				}	
			});
			JButton obj1=new JButton("Submitt");
			obj1.setBounds(150, 400, 160, 30);
			obj1.setBackground(Color.orange);
			obj1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String fname=fn.getText();
					String lname=ln.getText();
					String uname=user.getText();
					String pname=pass.getText();
					String rpname=rpas.getText();
					String mob=mb.getText();
					String gmail=eml.getText();
					// TODO Auto-generated method stub
					
					try {
						
						
						statement.executeUpdate("insert into rob values('"+fname+"','"+lname+"','"+uname+"','"+pname+"','"+rpname+"','"+mob+"','"+gmail+"')");
						JOptionPane.showMessageDialog(eml, "Registation successfull");
						fn.setText(null);
						ln.setText(null);
						user.setText(null);
						pass.setText(null);
						rpas.setText(null);
						mb.setText(null);
						eml.setText(null);
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			obj.add(l);obj.add(l1);
			obj.add(fn);obj.add(ln);
			obj.add(us);obj.add(user);
			obj.add(pw);obj.add(pass);
			obj.add(mob);obj.add(mb);
			obj.add(em);obj.add(eml);
			obj.add(rpas);obj.add(rpas1);
			obj.add(obj1);
			obj.setLayout(null);
			obj.setVisible(true);

		  obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	});		
	
    obj2.add(username);obj2.add(unam);
	obj2.add(pass1);obj2.add(upass);
	obj2.add(log);obj2.add(b);
	obj2.setLayout(null);
	obj2.setVisible(true);
	
}
}
