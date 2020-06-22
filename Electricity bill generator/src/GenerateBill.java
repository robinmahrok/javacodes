import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GenerateBill extends JFrame implements ActionListener
{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JButton b1,b2;
	public static String me="",ac="";
	
	public void gBill(String name, String meterno, String runit)
	{
		super.setBounds(100, 100, 800, 700);
		  super.setTitle("Electricity bill generator");
		  super.setResizable(false);
		  
		  jl1=new JLabel("Bill Generation");
		  jl1.setBounds(200, 50, 200, 30);
		  super.add(jl1);
		  
		  jl2=new JLabel("Name: ");
		  jl2.setBounds(150, 100, 100, 30);
		  super.add(jl2);
		  
		  jl3=new JLabel("Meter no.: ");
		  jl3.setBounds(150, 150, 100, 30);
		  super.add(jl3);
		  
		  jl4=new JLabel("Reading unit: ");
		  jl4.setBounds(150, 200, 100, 30);
		  super.add(jl4);
		  
		  jl6=new JLabel(name);
		  jl6.setBounds(300, 100, 100, 30);
		  super.add(jl6);
		  
		  jl7=new JLabel(meterno);
		  jl7.setBounds(300, 150, 100, 30);
		  super.add(jl7);
		  
		  jl7=new JLabel(runit);
		  jl7.setBounds(300, 200, 100, 30);
		  super.add(jl7);
		  
		  
		  jl9=new JLabel("Note: Electricity charges per unit is Rs. 10");
		  jl9.setBounds(100, 300, 600, 30);
		  super.add(jl9);
		  
		  b1=new JButton("Generate Bill");
		  b1.setBounds(150, 350, 200, 30);
		  super.add(b1);
		  b1.addActionListener(this);
		  
		  b2=new JButton("Cancel");
		  b2.setBounds(400, 350, 200, 30);
		  super.add(b2);
		  b2.addActionListener(this);
		  
		  super.setLayout(null);
		  super.setVisible(true);
		   super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void details(String meterno, String areacode)
	{ 
		GenerateBill.me=meterno;
		GenerateBill.ac=areacode;
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
		//System.out.println(meterno);
		new GenerateBill().gBill(nline[2], meterno, nline[4]);
	
	
	}  
	catch(IOException e1)  
	{  
	e1.printStackTrace();  
	
	} 
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			new BillReciept().getDetails(me,ac);
		}
		else if(e.getSource()==b2)
		{ String metrno="",areacode="";
			new BillCheck().fetching(metrno,areacode);
		}
	}

}
