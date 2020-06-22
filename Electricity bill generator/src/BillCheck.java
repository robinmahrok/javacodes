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

public class BillCheck extends JFrame implements ActionListener
{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JButton b1,b2;
	public static String me="",ac="";
	
	public void bCheck(String name,String meterno,String houseno, String areacode )
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
		  
		  b1=new JButton("Check Bill");
		  b1.setBounds(150, 300, 100, 30);
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
	public void fetching(String meterno, String areacode)
	{ BillCheck.me=meterno;
	BillCheck.ac= areacode;
		
		
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
			BillCheck bc=new BillCheck();
			bc.bCheck(nline[2], meterno, nline[3], areacode);
		
		
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
	
			new GenerateBill().details(me,ac);
		}
		else if(e.getSource()==b2)
		{
			new AdminPanel().aPanel();
		}
	}
	

}
