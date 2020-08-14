package bms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw extends JFrame implements ActionListener
{
    JButton b2,b1;
    JComboBox c;
    JTextField t1,t2;
    JLabel jl1,jl2,jl3;
	public void withdraw()
	{
	    super.setTitle("Withdrawl");
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
		
		b2=new JButton("Withdraw");
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
				   int []mins= {1000,2000,5000,10000};
				   
				   
						   int sts=1,i=0;
						   
						   if(com=="SBI")
							   i=0;
						   else if(com=="PNB")
							   i=1;
						   else if(com=="HDFC")
							   i=2;
						   else if(com=="KMB")
							   i=3;
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
						else if((com=="SBI" && Integer.parseInt(amou)<(acc+mins[0])) || (com=="HDFC" && Integer.parseInt(amou)<(acc+mins[2])) || (com=="PNB" && Integer.parseInt(amou)<(acc+mins[1])) || (com=="KMB" && Integer.parseInt(amou)<(acc+mins[3])) )
						{
							int v=Integer.parseInt(amou)-acc;
							 int q=mins[i]-v;
							JOptionPane.showMessageDialog(this, "You should add "+q+" INR first to begin transaction of "+acc+" INR in your account"); 
						}
						else {
						int namt=Integer.parseInt(amou)-acc;
					    String namt1=Integer.toString(namt);
			            String 	qry="update "+com+" set Amount='"+namt1+"' where Acc_No='"+acn+"'";
			             st.executeUpdate(qry);
			   
			   JOptionPane.showMessageDialog(this, "You have debited "+amt); 
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
		else if(e.getSource()==b1)
		{
			Menu m=new Menu();
			m.menu();
			super.dispose();
		}
	}	
}
