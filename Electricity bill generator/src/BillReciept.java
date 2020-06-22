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

public class BillReciept extends JFrame implements ActionListener {
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15;
	JButton b1,b2,b3;
	
	public void bReciept(String name,String meterno,String houseno, String areacode, String runit, String tamount, String date )
	{
		 super.setBounds(100, 100, 800, 700);
		  super.setTitle("Electricity bill generator");
		  super.setResizable(false);
		  
		  jl1=new JLabel("User Details");
		  jl1.setBounds(200, 50, 200, 30);
		  super.add(jl1);
		  
		  jl2=new JLabel("Name: ");
		  jl2.setBounds(150, 100, 100, 30);
		  super.add(jl2);
		  
		  jl3=new JLabel("Meter no.: ");
		  jl3.setBounds(150, 150, 100, 30);
		  super.add(jl3);
		  
		  jl4=new JLabel("Area code: ");
		  jl4.setBounds(150, 200, 100, 30);
		  super.add(jl4);
		  
		  jl5=new JLabel("House No: ");
		  jl5.setBounds(150, 250, 100, 30);
		  super.add(jl5);
		  
		  jl10=new JLabel("Reading Unit: ");
		  jl10.setBounds(150, 300, 100, 30);
		  super.add(jl10);
		  
		  jl11=new JLabel("Total amount ");
		  jl11.setBounds(150, 350, 100, 30);
		  super.add(jl11);
		  
		  jl12=new JLabel("Due date ");
		  jl12.setBounds(150, 400, 100, 30);
		  super.add(jl12);
		  
		  jl6=new JLabel(name);
		  jl6.setBounds(300, 100, 100, 30);
		  super.add(jl6);
		  
		  jl7=new JLabel(meterno);
		  jl7.setBounds(300, 150, 100, 30);
		  super.add(jl7);
		  
		  jl8=new JLabel(areacode);
		  jl8.setBounds(300, 200, 100, 30);
		  super.add(jl8);
		  
		  jl9=new JLabel(houseno);
		  jl9.setBounds(300, 250, 100, 30);
		  super.add(jl9);
		  
		  jl13=new JLabel(runit);
		  jl13.setBounds(300, 300, 100, 30);
		  super.add(jl13);
		  
		  jl14=new JLabel(tamount);
		  jl14.setBounds(300, 350, 100, 30);
		  super.add(jl14);
		  
		  jl15=new JLabel(date);
		  jl15.setBounds(300, 400, 100, 30);
		  super.add(jl15);
		  
		  b1=new JButton("Download");
		  b1.setBounds(150, 450, 100, 30);
		  super.add(b1);
		  b1.addActionListener(this);
		  
		  b2=new JButton("Print");
		  b2.setBounds(300, 450, 100, 30);
		  super.add(b2);
		  b2.addActionListener(this);
		  
		  b3=new JButton("Cancel");
		  b3.setBounds(450, 450, 100, 30);
		  super.add(b3);
		  b3.addActionListener(this);
		  
		  super.setLayout(null);
		  super.setVisible(true);
		   super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void getDetails( String meterno, String areacode)
	{ String name="",houseno="", runit="",tamount="",date="";
		
	try  
	{  
		AdminPanel ad=new AdminPanel();
		
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
	String a=sb.toString();
	String []abc=a.split("--");
	int m=0;
	for(int i=0;i<abc.length;i++)
	{
	if(abc[i].contains(meterno) && abc[i].contains(areacode))
	{
	m=i;
	}
	}
	
		String []nline=abc[m].split("#");
		String rs="Rs."+nline[5];
		new BillReciept().bReciept(nline[2], meterno, nline[3], areacode, nline[4], rs, nline[6]);
	
	
	}  
	catch(IOException e1)  
	{  
	e1.printStackTrace();  
	
	} 
	
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			JOptionPane.showMessageDialog(this, "Download not working!");
		}
		else if(e.getSource()==b2)
		{
			JOptionPane.showMessageDialog(this, "Print not working!");
		}
		else if(e.getSource()==b3)
		{
			
		}
	}

}
