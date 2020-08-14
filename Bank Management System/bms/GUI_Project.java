package bms;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI_Project extends JFrame implements ActionListener
{
  JButton b1,b2;
  public void firstFrame()
  throws Exception
  {  
  
	  super.setBounds(50, 50, 800, 700);
	  super.setResizable(false);
	  super.setTitle("Home Page");
	  
	  b1=new JButton();
	  b1.setBounds(235, 100, 323, 95);
	  super.add(b1);
	  b1.addActionListener(this);
	  
	  b2=new JButton();
	  b2.setBounds(200, 300, 389, 129);
	  super.add(b2);
	  b2.addActionListener(this);
	  
	  ImageIcon ic1=new ImageIcon("D:\\Android\\signup.png"); 
	  ImageIcon ic2=new ImageIcon("D:\\Android\\login.jpg"); 
	  
	  b1.setIcon(ic1);
	  b2.setIcon(ic2);
	  
	  super.setLayout(null);
	  super.setVisible(true);
  }
  public static void main(String[] args) throws Exception 
  {
	GUI_Project g=new GUI_Project();
	g.firstFrame();
  }
  
@Override
public void actionPerformed(ActionEvent e) 
{ Signup g1=new Signup();
  Login g2=new Login();
	if(e.getSource()==b1)
	{
		
	   g1.SignUp();
	   super.dispose();
	}
	else if(e.getSource()==b2)
	{
		g2.LogIn();
		super.dispose();
	}

}
	
}
class Signup extends JFrame implements ActionListener
{  JTextField t1,t2,t3,t4;
   JPasswordField pt1,pt2;
   JButton signup,cancel;
   JLabel l1,l2,l3,l4,l5,l6;
   
	 public void SignUp()
	 
	 { 
		 
		 super.setTitle("Sign Up");
		 super.setBounds(50, 50, 800, 700);
		 super.setResizable(false);
		 
		 l1 = new JLabel("Name:");
			l1.setBounds(100, 70, 300, 30);
			super.add(l1);
		 
			 l2 = new JLabel("E-Mail:");
			l2.setBounds(100, 120, 300, 30);
			super.add(l2);
				 
			l3 = new JLabel("Mobile:");
			l3.setBounds(100, 170, 300, 30);
			super.add(l3);
			
			l4 = new JLabel("Password:");
			l4.setBounds(100, 220, 300, 30);
			super.add(l4);
						
			l5 = new JLabel("Confirm Password:");
			l5.setBounds(100, 270, 300, 30);
			super.add(l5);
							
			l6 = new JLabel("Address:");
			l6.setBounds(100, 320, 300, 30);
			super.add(l6);
								
			t1=new JTextField();
			t1.setBounds(300, 70, 300, 30);
			super.add(t1);
					
			t2=new JTextField();
			t2.setBounds(300, 120, 300, 30);
			super.add(t2);
			
			t3=new JTextField();
			t3.setBounds(300, 170, 300, 30);
			super.add(t3);
			
			pt1=new JPasswordField();
			pt1.setBounds(300, 220, 300, 30);
			super.add(pt1);
			
			pt2=new JPasswordField();
			pt2.setBounds(300, 270, 300, 30);
			super.add(pt2);
			
			t4=new JTextField();
			t4.setBounds(300, 320, 300, 30);
			super.add(t4);
			
			signup=new JButton("Sign up");
			signup.setBounds(250, 400, 100, 40);
			super.add(signup);
			signup.addActionListener(this);
			
			cancel=new JButton("Cancel");
			cancel.setBounds(500, 400, 100, 40);
			super.add(cancel);
			cancel.addActionListener(this);
			
			super.setLayout(null);
		 
			super.setVisible(true);
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==signup)
		{ String st1=t1.getText();
		String st2=t2.getText();
		String st3=t3.getText();
		String st4=pt1.getText();
		String st5=pt2.getText();
		String st6=t4.getText();
				int stn=st4.hashCode();

		  if(st1.isEmpty()||st2.isEmpty()||st3.isEmpty()||st6.isEmpty())
		  {
			JOptionPane.showMessageDialog(this, "No field could be empty");  
		  }
		  else if(!(st2.contains("@")) || !(st2.contains(".")) ||(st2.indexOf("@")==0)||(st2.lastIndexOf(".")<(st2.lastIndexOf("@")+2))||st2.lastIndexOf(".")==st2.length()-1)
		  {
			  JOptionPane.showMessageDialog(this, "Invalid Email!");
		  }
		  else if(st3.length()<10)
		  {
			  JOptionPane.showMessageDialog(this, "Invalid Phone number!");
		  }
		  else if(!(st4.equals(st5))||(st4.equals(""))||st5.equals("")) 
		  { 
			  JOptionPane.showMessageDialog(this, "Passwords do not match");  
		  }
		  else {
		
		  try {
			
			Class.forName("com.mysql.jdbc.Driver");
			  Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banks","root","8963");
			  
			Statement st=co.createStatement();
	String str="Select Name from user_info where Mobile='"+st3+"'";
	ResultSet rs=st.executeQuery(str);
	String name1="";
	while (rs.next()) 
	{
		name1=rs.getString("name");
	}
			if(name1=="") 
			{
			String 	qry="insert into user_info values"+"('"+st1+"','"+st2+"','"+st3+"','"+stn+"','"+st6+"')";
			  st.executeUpdate(qry);
			  JOptionPane.showMessageDialog(this, "Signup completed successfully and we are redirecting you to login page");  
			  Login l=new Login();
			  l.LogIn();
			  super.dispose();
		  }
			else 
			{
				JOptionPane.showMessageDialog(this, "Mobile number can not be repeated");  
			}
		  }
		  catch (Exception e1) {
			
			e1.printStackTrace();
		}
		  }		   
		}
		else if(e.getSource()==cancel)
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
		
	} 
	
	
}
class Login extends JFrame implements ActionListener
{
    JButton login,cancel,forgot;
    JTextField t1;
    JPasswordField p1;
    JLabel l1,l2;
	
	public void LogIn()
       {
    	   super.setTitle("Log In");
    	   super.setBounds(100, 100, 500, 600);
    	   
    	   l1= new JLabel("E-Mail:");
    	   l1.setBounds(70, 120, 150, 30);
    	   super.add(l1);
    	   
    	   l2=new JLabel("Password:");
    	   l2.setBounds(70, 170, 150, 30);
    	   super.add(l2);
    	   
    	   t1=new JTextField();
    	   t1.setBounds(180, 120, 180, 30);
    	   super.add(t1);
    	   
    	   p1=new JPasswordField();
    	   p1.setBounds(180, 170, 180, 30);
    	   super.add(p1);
    	   
    	   login=new JButton("Login");
    	   login.setBounds(100, 220, 100, 30);
    	   super.add(login);
    	   login.addActionListener(this);
    	   
    	   cancel=new JButton("Cancel");
    	   cancel.setBounds(300, 220, 100, 30);
    	   super.add(cancel);
    	   cancel.addActionListener(this);
    	   
    	   forgot=new JButton("Forgot Password");
    	   forgot.setBounds(170, 270, 150, 30);
    	   super.add(forgot);
    	   forgot.addActionListener(this);
    	   
    	   super.setLayout(null);
  		 
			super.setVisible(true);

        }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login)
		{
			
			String emai=t1.getText();
			String pass=p1.getText();
			int p=pass.hashCode();
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				  Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banks","root","8963");
				  
				Statement st=co.createStatement();
				String qry="Select * from user_info where Password='"+p+"' and Email='"+emai+"'";
				ResultSet rs=st.executeQuery(qry);
				String gete="";  
				while (rs.next())
				{
					gete=rs.getString("Name");
					
				}
				if(gete.equals(""))
				{
					JOptionPane.showMessageDialog(this, "Email or password not found");  
				}
				else {
					JOptionPane.showMessageDialog(this, "Hi "+gete+" Email or password found. We are redirecting you to Menu");
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







class Deposit extends JFrame implements ActionListener
{
    JButton b2,b1;
    JComboBox c;
    JTextField t1,t2;
    JLabel jl1,jl2,jl3;
	public void deposit()
	{
	    super.setTitle("Deposit");
		super.setBounds(100, 100, 500, 600);
        
		jl1=new JLabel("Bank:");		
		jl1.setBounds(100, 120, 100, 30);
		super.add(jl1);
		
		jl2=new JLabel("Account  no.");		
		jl2.setBounds(100, 170, 100, 30);
		super.add(jl2);
		
		jl3=new JLabel("Amount:");		
		jl3.setBounds(100, 220, 100, 30);
		super.add(jl3);
		
		String[] array = {"SBI","KMB","PNB","HDFC"};
		c=new JComboBox(array);
		c.setBounds(220, 120, 200, 30);
		super.add(c);
		
		t1=new JTextField();
		t1.setBounds(220, 170, 200, 30);
		super.add(t1);
		
		t2=new JTextField();
		t2.setBounds(220, 220, 200, 30);
		super.add(t2);
		
		b2=new JButton("Deposit");
		b2.setBounds(100, 270, 170, 30);
		super.add(b2);
		b2.addActionListener(this);
		
		b1=new JButton("Cancel");
		b1.setBounds(300, 270, 170, 30);
		super.add(b1);
		b1.addActionListener(this);
		
		super.setLayout(null);
        super.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2)
		{
			 try {
						 String com=(String)c.getSelectedItem();
						   String acn=t1.getText();
						   String amt=t2.getText();
						   int acc=Integer.parseInt(amt);
						     int sts=1;
						Class.forName("com.mysql.jdbc.Driver");
						Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banks","root","8963");
						 
						Statement st=co.createStatement();
							 ResultSet rs=st.executeQuery("Select * from "+com+" where Acc_No='"+acn+"' and Status='"+1+"'");
							String amou="";
								while (rs.next()) 
								{
									amou=rs.getString("Amount");
								}
								if(amou.isEmpty())
									 JOptionPane.showMessageDialog(this, "Your account number is not present"); 
							    int namt=Integer.parseInt(amou)+acc;
							    String namt1=Integer.toString(namt);
					            String 	qry="update "+com+" set Amount='"+namt1+"' where Acc_No='"+acn+"'";
					             st.executeUpdate(qry);
					   
					   JOptionPane.showMessageDialog(this, "You have added "+amt); 
				 Menu m=new Menu();
				m.menu();
				super.dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  
		}
		else if(e.getSource()==b1)
		{
			Menu m=new Menu();
			m.menu();
			super.dispose();
		}
		}
	
}

class Money extends JFrame implements ActionListener
{
    JButton b2,b1;
    JComboBox c1,c2;
    JTextField t1,t2,t3;
    JLabel jl1,jl2,jl3,jl4,jl5;
	public void money()
	{
	    super.setTitle("Money Transfer");
		super.setBounds(100, 100, 500, 600);
        
		jl1=new JLabel("Sender's Bank:");		
		jl1.setBounds(100, 120, 150, 30);
		super.add(jl1);
		
		jl2=new JLabel("Sender's Account  no.");		
		jl2.setBounds(100, 170, 150, 30);
		super.add(jl2);
		

		jl3=new JLabel("Reciever's Bank:");		
		jl3.setBounds(100, 220, 150, 30);
		super.add(jl3);

		jl4=new JLabel("Reciever's Account no.");		
		jl4.setBounds(100, 270, 150, 30);
		super.add(jl4);
		
		jl5=new JLabel("Amount:");		
		jl5.setBounds(100, 320, 150, 30);
		super.add(jl5);
		
		String[] array = {"SBI","KMB","PNB","HDFC"};
		c1=new JComboBox(array);
		c1.setBounds(250, 120, 200, 30);
		super.add(c1);
		
		t1=new JTextField();
		t1.setBounds(250, 170, 200, 30);
		super.add(t1);
		
		c2=new JComboBox(array);
		c2.setBounds(250, 220, 200, 30);
		super.add(c2);
		
		t2=new JTextField();
		t2.setBounds(250, 270, 200, 30);
		super.add(t2);
		
		t3=new JTextField();
		t3.setBounds(250, 320, 200, 30);
		super.add(t3);
		
		b2=new JButton("Money Transfer");
		b2.setBounds(100, 370, 170, 30);
		super.add(b2);
		b2.addActionListener(this);
		
		b1=new JButton("Cancel");
		b1.setBounds(300, 370, 170, 30);
		super.add(b1);
		b1.addActionListener(this);
		
		super.setLayout(null);
        super.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2)
		{
			 try {
				 String com1=(String)c1.getSelectedItem();
				 String com2=(String)c2.getSelectedItem();
				   String acn1=t1.getText();
				   String acn2=t2.getText();
				   String amt=t3.getText();
				   int acc=Integer.parseInt(amt);
				   int []mins= {1000,2000,5000,10000};
				   
				   int sts=1,i=0;
				  
				   if(com1=="SBI")
					   i=0;
				   else if(com1=="PNB")
					   i=1;
				   else if(com1=="HDFC")
					   i=2;
				   else if(com1=="KMB")
					   i=3;
				Class.forName("com.mysql.jdbc.Driver");
				Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banks","root","8963");
				 
				Statement st=co.createStatement();
					 ResultSet rs1=st.executeQuery("Select * from "+com1+" where Acc_No='"+acn1+"' and Status='"+1+"'");
					 
					String amous="";
						while (rs1.next()) 
						{
							amous=rs1.getString("Amount");
						}
						if((com1=="SBI" && Integer.parseInt(amous)<(acc+mins[0])) || (com1=="HDFC" && Integer.parseInt(amous)<(acc+mins[2])) || (com1=="PNB" && Integer.parseInt(amous)<(acc+mins[1])) || (com1=="KMB" && Integer.parseInt(amous)<(acc+mins[3])) )
						{
							int v=Integer.parseInt(amous)-acc;
							 int q=mins[i]-v;
							JOptionPane.showMessageDialog(this, "You should add "+q+" INR first to begin transaction of "+acc+" INR in your account"); 
						}
						else
						{
						ResultSet rs2=st.executeQuery("Select * from "+com2+" where Acc_No='"+acn2+"' and Status='"+1+"'");
						String amour="";
						while (rs2.next()) 
						{
							amour=rs2.getString("Amount");
						}
						if(amous.isEmpty())
							 JOptionPane.showMessageDialog(this, "Sender's account number is not present"); 
						else if(amour.isEmpty())
							 JOptionPane.showMessageDialog(this, "Reciever's account number is not present"); 
						else
						{int namts=Integer.parseInt(amous)-acc;
						int namtr=Integer.parseInt(amour)+acc;
					    String namt1s=Integer.toString(namts);
					    String namt1r=Integer.toString(namtr);
			            String 	qry1="update "+com1+" set Amount='"+namt1s+"' where Acc_No='"+acn1+"'";
			            String 	qry2="update "+com2+" set Amount='"+namt1r+"' where Acc_No='"+acn2+"'";
			             st.executeUpdate(qry1);
			             st.executeUpdate(qry2);
			   JOptionPane.showMessageDialog(this, "You have transferred "+amt); 
		 Menu m=new Menu();
		m.menu();
		super.dispose();
			} }
			 }catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		else if(e.getSource()==b1)
		{Menu m=new Menu();
		m.menu();
		super.dispose();
			
		}
		
	}

	
}


class Check extends JFrame implements ActionListener
{
    JButton b1,b2;
    JComboBox c;
    JTextField t;
    JLabel jl1,jl2;
	public void check()
	{
	    super.setTitle("Check balance");
		super.setBounds(100, 100, 500, 600);
        
		jl1=new JLabel("Bank:");		
		jl1.setBounds(100, 120, 100, 30);
		super.add(jl1);
		
		jl2=new JLabel("Account no.");		
		jl2.setBounds(100, 170, 100, 30);
		super.add(jl2);
		
		String[] array = {"SBI","KMB","PNB","HDFC"};
		c=new JComboBox(array);
		c.setBounds(220, 120, 200, 30);
		super.add(c);
		
		t=new JTextField();
		t.setBounds(220, 170, 200, 30);
		super.add(t);
		
		b1=new JButton("Show Balance");
		b1.setBounds(100, 220, 170, 30);
		super.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("Cancel");
		b2.setBounds(300, 220, 170, 30);
		super.add(b2);
		b2.addActionListener(this);
		
		super.setLayout(null);
        super.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			 try {
				 String com=(String)c.getSelectedItem();
				   String acn=t.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banks","root","8963");
				 
				Statement st=co.createStatement();
					 ResultSet rs=st.executeQuery("Select * from "+com+" where Acc_No='"+acn+"' and Status='"+1+"'");
					String amou="";
						while (rs.next()) 
						{
							amou=rs.getString("Amount");
						}
						if(amou.isEmpty())
							 JOptionPane.showMessageDialog(this, "Your account number is not present"); 
						else {    
			   
			   JOptionPane.showMessageDialog(this, "Your remaining amount is "+amou); 
		 Menu m=new Menu();
		m.menu();
		super.dispose();
			} }
			 catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		}
		else if(e.getSource()==b2)
		{
			Menu m=new Menu();
			m.menu();
			super.dispose();
		}
		
	}

}

class Deactivate extends JFrame implements ActionListener
{
    JButton b1,b2;
    JLabel jl1,jl2;
    JComboBox c;
    JTextField t;
	public void deactivate()
	{
	    super.setTitle("Deactivate Account");
		super.setBounds(100, 100, 500, 600);
        
		jl1=new JLabel("Bank:");		
		jl1.setBounds(100, 120, 100, 30);
		super.add(jl1);
		
		jl2=new JLabel("Account no.");		
		jl2.setBounds(100, 170, 100, 30);
		super.add(jl2);
		
		String[] array = {"SBI","KMB","PNB","HDFC"};
		c=new JComboBox(array);
		c.setBounds(220, 120, 200, 30);
		super.add(c);
		
		t=new JTextField();
		t.setBounds(220, 170, 200, 30);
		super.add(t);
		
		b1=new JButton("Deactivate");
		b1.setBounds(100, 220, 170, 30);
		super.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("Cancel");
		b2.setBounds(300, 220, 170, 30);
		super.add(b2);
		b2.addActionListener(this);
		
		super.setLayout(null);
        super.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			 try {
				 String com=(String)c.getSelectedItem();
				   String acn=t.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banks","root","8963");
				 
				Statement st=co.createStatement();
					 ResultSet rs=st.executeQuery("Select * from "+com+" where Acc_No='"+acn+"' and Status='"+1+"'");
					String amou="";
						while (rs.next()) 
						{
							amou=rs.getString("Amount");
						}
						if(amou.isEmpty())
							 JOptionPane.showMessageDialog(this, "Your account is not present"); 
						else {
							String qr="UPDATE "+com+" set Status='"+0+"' where ACC_No='"+acn+"'";
						st.executeUpdate(qr);
						
			   
			   JOptionPane.showMessageDialog(this, "Your account is Deactivated Successfully "); 
		 Menu m=new Menu();
		m.menu();
		super.dispose();
			} 
			 }catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==b2)
		{
			Menu m=new Menu();
			m.menu();
			super.dispose();
		}
		
	}
}



