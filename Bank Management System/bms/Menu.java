package bms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6,b7;
    public void menu()
    {  super.setBounds(100, 100, 600, 700);
    	b1=new JButton("Create Account");
    	b1.setBounds(200, 150, 200, 30);
    	super.add(b1);
    	b1.addActionListener(this);
    	
    	b2=new JButton("Deposit");
    	b2.setBounds(200, 200, 200, 30);
    	super.add(b2);
    	b2.addActionListener(this);
    	
    	b3=new JButton("Withdraw");
    	b3.setBounds(200, 250, 200, 30);
    	super.add(b3);
    	b3.addActionListener(this);
    	
    	b4=new JButton("Check Balance");
    	b4.setBounds(200, 300, 200, 30);
    	super.add(b4);
    	b4.addActionListener(this);
    	
    	b5=new JButton("Money Transfer");
    	b5.setBounds(200, 350, 200, 30);
    	super.add(b5);
    	b5.addActionListener(this);
    	
    	b6=new JButton("Deactivate Account");
    	b6.setBounds(200, 400, 200, 30);
    	super.add(b6);
    	b6.addActionListener(this);
    	
    	super.setLayout(null);
        super.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent cl) 

	{
		if(cl.getSource()==b1)
		{
			CreateAcc c=new CreateAcc();
			c.create();
			super.dispose();
		}
		else if(cl.getSource()==b2)
		{  Deposit d=new Deposit();
		d.deposit();
			
			super.dispose();
		}
		else if(cl.getSource()==b3)
		{
			Withdraw w=new Withdraw();
			w.withdraw();
			super.dispose();
		}
		else if(cl.getSource()==b4)
		{ Check c=new Check();
		c.check();
			super.dispose();
		}
		else if(cl.getSource()==b5)
		{Money m=new Money();
		 m.money();
			
			super.dispose();
		}
		else if(cl.getSource()==b6)
		{  Deactivate d=new Deactivate();
		d.deactivate();
			
			super.dispose();
		}	
		
	}
}