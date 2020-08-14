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

public class Verification extends JFrame  implements ActionListener
{
	JButton done,cancel;
    JTextField email;
    JLabel e;
    JPasswordField pt1,pt2;
	   JButton change;
	   JLabel l1,l2;
    public void forgote()
    {   super.setTitle("Verification");
    	super.setBounds(100, 100, 600, 700);
    	super.setResizable(false);
    	
    	e=new JLabel("Enter Code:");
    	e.setBounds(100, 100, 200, 30);
    	super.add(e);
    	
    	email=new JTextField();
    	email.setBounds(300, 100, 200, 30);
    	super.add(email);
       
    	
    	change=new JButton("Done");
        change.setBounds(100, 250, 170, 30);
 		super.add(change);
 		change.addActionListener(this);
 		
 		cancel=new JButton("Cancel");
 	cancel.setBounds(300, 250, 170, 30);
 	super.add(cancel);
 	cancel.addActionListener(this);
        
     	
     	super.setLayout(null);
         super.setVisible(true);
    
    }
	@Override
	public void actionPerformed(ActionEvent ar) {
		
		if(ar.getSource()==change)
		{  String code=email.getText();
		Forgot f=new Forgot();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banks","root","8963");
		 
		Statement st=co.createStatement();
			 ResultSet rs=st.executeQuery("Select * from otp where otp1='"+code+"'");
			String otpn="";
				while (rs.next()) 
				{
					otpn=rs.getString("Email");
				}
		
				if(!(otpn==""))
				{
			JOptionPane.showMessageDialog(this, "Your e mail is verified. and we are redirectiong you to change password page");
			Change_Password c=new Change_Password();
			c.ChangePass();
			super.dispose();
		     }
				else {
		 JOptionPane.showMessageDialog(this, "Your e mail is not verified!");
		 this.dispose();
		}
		}
		 catch (Exception e) {
			// TODO: handle exception
		}
		
		}
		else if(ar.getSource()==cancel)
			super.dispose();
	}

}
