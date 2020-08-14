package bms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CreateAcc extends JFrame implements ActionListener
{
    JButton b1,b2;
    JComboBox c;
    JTextField t;
    JLabel jl1,jl2;
	public void create()
	{
	    super.setTitle("Create Account");
		super.setBounds(100, 100, 500, 600);
        
		jl1=new JLabel("Bank:");		
		jl1.setBounds(100, 120, 100, 30);
		super.add(jl1);
		
		jl2=new JLabel("Amount");		
		jl2.setBounds(100, 170, 100, 30);
		super.add(jl2);
		
		String[] array = {"SBI","KMB","PNB","HDFC"};
		c=new JComboBox(array);
		c.setBounds(220, 120, 200, 30);
		super.add(c);
		
		t=new JTextField();
		t.setBounds(220, 170, 200, 30);
		super.add(t);
		
		b1=new JButton("Create Account");
		b1.setBounds(100, 220, 170, 30);
		super.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("Cancel");
		b2.setBounds(300, 220, 170, 30);
		super.add(b2);
		b2.addActionListener(this);
		
		super.setResizable(false);
		super.setLayout(null);
        super.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{  String com=(String)c.getSelectedItem();
		   String acco=t.getText();
		   int acc=Integer.parseInt(acco);
		   if(com=="SBI" && acc<1000) {
			   JOptionPane.showMessageDialog(this, "Minimum amount for SBI is 1000."); 
		   }
		   else if(com=="PNB" && acc<2000) {
			   JOptionPane.showMessageDialog(this, "Minimum amount for PNB is 2000."); 
		   }
		   else  if(com=="HDFC" && acc<5000) {
			   JOptionPane.showMessageDialog(this, "Minimum amount for HDFC is 5000."); 
		   }
		   else  if(com=="KMB" && acc<10000) {
			   JOptionPane.showMessageDialog(this, "Minimum amount for KMB is 10000."); 
		   }
		   else {
			   try {	
						Random r=new Random();
						 int j =r.nextInt();
						 if(j>0)
						 { String acn=com+"_"+j;
						 Class.forName("com.mysql.jdbc.Driver");
						  Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banks","root","8963");
						 String sts="1";
						Statement st=co.createStatement();
							 ResultSet rs=st.executeQuery("Select * from "+com+" where Acc_No='"+acn+"' and Status='"+1+"'");
							String name1="";
								while (rs.next()) 
								{
									name1=rs.getString("Amount");
								}
								if(name1=="")
								{
							
					            String 	qry="insert into "+com+" values"+"('"+acn+"','"+acco+"','"+sts+"')";
					             st.executeUpdate(qry);
					             JOptionPane.showMessageDialog(this, "Account is created and your account number is"+acn);
					             Menu m=new Menu();
					 			m.menu();
					 			this.dispose();
								}
							}
						}

								
			         
				  catch (Exception e1) 
			   {
					e1.printStackTrace();
				}
		    }
		   
		}
		else if(e.getSource()==b2)
		{
			Menu m=new Menu();
 			m.menu();
 			this.dispose();
		}
		
	}

}
