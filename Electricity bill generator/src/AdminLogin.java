import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdminLogin extends JFrame implements ActionListener
{ JButton b1,b2;
JTextField tf1,tf2;
JLabel jl1,jl2,jl3;

public void aLogin()
{
	super.setBounds(100, 100, 800, 700);
	  super.setTitle("Electricity Bill Generator");
	  super.setResizable(false);
	  
	  jl1=new JLabel("Admin Login");
	  jl1.setBounds(200, 50, 200, 30);
	  super.add(jl1);
	  
	  jl2=new JLabel("Username:");
	  jl2.setBounds(150, 100, 100, 30);
	  super.add(jl2);
	  
	  jl3=new JLabel("Password: ");
	  jl3.setBounds(150, 150, 100, 30);
	  super.add(jl3);
	  
	  tf1=new JTextField();
	  tf1.setBounds(250, 100, 300, 30);
	  super.add(tf1);
	  
	  tf2=new JTextField();
	  tf2.setBounds(250, 150, 300, 30);
	  super.add(tf2);
	  
	  b1=new JButton("Login");
	  b1.setBounds(200, 300, 100, 30);
	  super.add(b1);
	  b1.addActionListener(this);
	  
	  b2=new JButton("Cancel");
	  b2.setBounds(400, 300, 100, 30);
	  super.add(b2);
	  b2.addActionListener(this);
	  
	  super.setLayout(null);
	  super.setVisible(true);
	   super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


public static void main(String[] args)
		throws Exception
		{
			AdminLogin a=new AdminLogin();
			a.aLogin();
		}



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==b1)
	{ 
		String s1=tf1.getText();
		String s2=tf2.getText();
		if(s1.equals("Admin") && s2.equals("Admin123"))
		{
			AdminPanel ap=new AdminPanel();
			ap.aPanel();
		}
		else
			JOptionPane.showMessageDialog(this, "Wrong credentials");
	}
	else if(e.getSource()==b2)
	{
		System.exit(0);
	}
	
}

}
