package bms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Change_Password extends JFrame implements ActionListener
{
	JButton login,cancel,forgot;
    JTextField t1;
    JPasswordField p1,p2;
    JLabel l1,l2,l3;
	
	public void ChangePass()
       {
    	   super.setTitle("Change Password");
    	   super.setBounds(100, 100, 500, 600);
    	   super.setResizable(false);
    	   
    	   l1= new JLabel("E-mail:");
    	   l1.setBounds(70, 120, 150, 30);
    	   super.add(l1);
    	   
    	   l2=new JLabel("Password:");
    	   l2.setBounds(70, 170, 150, 30);
    	   super.add(l2);
    	   
    	   l3=new JLabel("Confirm Password:");
    	   l3.setBounds(70, 220, 150, 30);
    	   super.add(l3);
    	   
    	   t1=new JTextField();
    	   t1.setBounds(180, 120, 180, 30);
    	   super.add(t1);
    	   
    	   p1=new JPasswordField();
    	   p1.setBounds(180, 170, 180, 30);
    	   super.add(p1);
    	   
    	   p2=new JPasswordField();
    	   p2.setBounds(180, 220, 180, 30);
    	   super.add(p2);
    	   
    	   login=new JButton("Set Password");
    	   login.setBounds(100, 270, 150, 30);
    	   super.add(login);
    	   login.addActionListener(this);
    	   
    	   cancel=new JButton("Cancel");
    	   cancel.setBounds(300, 270, 150, 30);
    	   super.add(cancel);
    	   cancel.addActionListener(this);
    	   
    	   super.setLayout(null);
  		 
			super.setVisible(true);

        }

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==login)
		{
			
			String pass=p1.getText();
			String cpass=p1.getText();
			String email=t1.getText();
			int p=pass.hashCode();
			int cp=cpass.hashCode();
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				  Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banks","root","8963");
				  
				Statement st=co.createStatement();
				String qry="Select * from otp where Email='"+email+"'";
				ResultSet rs=st.executeQuery(qry);
				String gete="";  
				while (rs.next())
				{
					gete=rs.getString("Email");
					
				}
				if(gete.equals(""))
				{
					JOptionPane.showMessageDialog(this, "Enter your own e-mail");  
				}
				else if(pass=="" || cpass=="" || !(pass.equals(cpass)))
				{
				
					JOptionPane.showMessageDialog(this, "Passwords do no match or field is empty");  
					
				}
				
				else if(p==cp) {
					st.executeUpdate("update user_info set Password='"+p+"' where Email='"+email+"'");
					JOptionPane.showMessageDialog(this, "Your password is updated. And we are redirecting you to Menu ");
				  Menu m=new Menu();
					m.menu();
					super.dispose();
			}
			
			}
		
			  catch (Exception e1) {
				
				e1.printStackTrace();
			}
		
		}
		else if (e.getSource()==cancel)
		{
			GUI_Project g=new GUI_Project();
			try {
				g.firstFrame();
				super.dispose();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if(e.getSource()==forgot)
		{
			Forgot f=new Forgot();
			f.forgot();
			super.dispose();
		}
	}

}
