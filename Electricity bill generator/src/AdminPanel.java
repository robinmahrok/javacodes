import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdminPanel extends JFrame implements ActionListener
{ JButton b1,b2;
JTextField tf1,tf2;
JLabel jl1,jl2,jl3;
 public void aPanel() {
	 
	 super.setBounds(100, 100, 800, 700);
	  super.setTitle("Electricity bill generator");
	  super.setResizable(false);
	  
	  jl1=new JLabel("Welcome Robin Singh");
	  jl1.setBounds(200, 50, 200, 30);
	  super.add(jl1);
	  
	  jl2=new JLabel("Meter No.: ");
	  jl2.setBounds(150, 100, 100, 30);
	  super.add(jl2);
	  
	  jl3=new JLabel("Area code: ");
	  jl3.setBounds(150, 150, 100, 30);
	  super.add(jl3);
	  
	  tf1=new JTextField();
	  tf1.setBounds(250, 100, 300, 30);
	  super.add(tf1);
	  
	  tf2=new JTextField();
	  tf2.setBounds(250, 150, 300, 30);
	  super.add(tf2);
	  
	  b1=new JButton("Submit");
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
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{ String a="";
		
			String metrno=tf1.getText();
			String areacode=tf2.getText();
			try  
			{  
			File file=new File("D:\\Bills.txt");    //creates a new file instance  
			FileReader fr=new FileReader(file);   //reads the file  
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
			String line;  
			while((line=br.readLine())!=null)  
			{  
			sb.append(line);      //appends line to string buffer  
			sb.append("\n");     //line feed   
			}  
			fr.close();    //closes the stream and release the resources  
			a=sb.toString();
			String []abc=a.split("--");
			int count=0;
			for(int i=0;i<abc.length;i++)
			{
			if(abc[i].contains(metrno) && abc[i].contains(areacode))
			{count++;
			}
			}
			if(count!=0)
			{
				new BillCheck().fetching(metrno,areacode);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Meter number or area code not present");
			}
			
			}  
			catch(IOException e1)  
			{  
			e1.printStackTrace();  
			
			}  
			
		}
		else if(e.getSource()==b2)
		{
			new AdminLogin().aLogin();
		}
		
	}
	

}
