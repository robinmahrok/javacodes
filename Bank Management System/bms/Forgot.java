package bms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
class BabyOfAuthenticator1 extends Authenticator
{
	
	public PasswordAuthentication getPasswordAuthentication()
	{
	// create object of PA
	PasswordAuthentication pa = new PasswordAuthentication
		("kingbrooker21@gmail.com",
				"Robin@1999");	
	
	// return object of PA
	return pa;
	}
}
public class Forgot extends JFrame implements ActionListener
{ 
	JButton done,cancel;
    JTextField email;
    JLabel e;
    JPasswordField pt1,pt2;
	   JButton change;
	   JLabel l1,l2;
    public void forgot()
    {   super.setTitle("Forgot Password");
    	super.setBounds(100, 100, 600, 700);
    	super.setResizable(false);
    	
    	e=new JLabel("Enter Email:");
    	e.setBounds(100, 100, 200, 30);
    	super.add(e);
    	
    	email=new JTextField();
    	email.setBounds(300, 100, 200, 30);
    	super.add(email);
    	
//    	
//    	l1 = new JLabel("New Password:");
//		l1.setBounds(100, 150, 200, 30);
//		super.add(l1);
//		
//		l2 = new JLabel("RE-Type New Password:");
//		l2.setBounds(100, 200, 200, 30);
//		super.add(l2);
//
//		pt1=new JPasswordField();
//       pt1.setBounds(300, 150, 200, 30);
//       super.add(pt1);
// 
//       pt2=new JPasswordField();
//       pt2.setBounds(300, 200, 200, 30);
//       super.add(pt2);
 
       change=new JButton("Done");
       change.setBounds(100, 250, 170, 30);
		super.add(change);
		change.addActionListener(this);
		
		cancel=new JButton("Cancel");
	cancel.setBounds(300, 250, 170, 30);
	super.add(cancel);
	cancel.addActionListener(this);
       
  String email1=email.getText();
    	super.setLayout(null);
        super.setVisible(true);
    }
    
    
	@Override
	public void actionPerformed(ActionEvent e1) {
		
		if(e1.getSource()==change)
		{
			String email1=email.getText();	
			 
			try { 
				
				Class.forName("com.mysql.jdbc.Driver");
			  Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banks","root","8963");
			  
			Statement st=co.createStatement();
			String qry="Select * from user_info where Email='"+email1+"'";
			ResultSet rs=st.executeQuery(qry);
			String gete="";
			String gets="";
			while (rs.next())
			{
				gete=rs.getString("Email");
				gets=rs.getString("Name");
				
			}
			if(gete.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Email or password not found");  
			}
			else {
				JOptionPane.showMessageDialog(this, "Hi "+gets+" Email found. We are sending a verification code on your E-mail");
			
			Properties p = new Properties();
			p.put("mail.smtp.host","smtp.gmail.com");
			p.put("mail.smtp.port","587");
			p.put("mail.smtp.starttls.enable","true");
			p.put("mail.smtp.auth","true");
			p.put("mail.smtp.ssl.trust","smtp.gmail.com");
			//p.put("mail.debug","true");
			
			// create object of Authenticator
			BabyOfAuthenticator1 baby = new 
					BabyOfAuthenticator1();
			
			// create object of session
			Session ses = Session.getInstance
					(p, baby);
			
			// create object of mime-message to denote
			// actual message to be sent to mail server
			MimeMessage message = new MimeMessage(ses);
			
			// provide a subject
			message.setSubject("TEST MAIL !!");
			
			String[] emails = {email1};
			
			InternetAddress[] inadrs = new 
					InternetAddress[emails.length];
			
			// ye code hasan ne likha hai !!
			message.setFrom(new InternetAddress("kingbrooker21@gmail.com"));
			
			for(int i = 0; i < emails.length; i++)
			{
			// create object of internet-address to
			// denote email
			InternetAddress ina = 
					new InternetAddress(emails[i]);
			
			// store this object inside array
			inadrs[i] = ina;
			}
			
			// lets specify the types of RCVRS
			message.addRecipients
			(RecipientType.TO, inadrs);
			
			// create some body parts
			MimeBodyPart body1 = new MimeBodyPart();
//					body2 = new MimeBodyPart(),
			MimeBodyPart body2 = new MimeBodyPart();
			Random r=new Random();
			int arr[]=new int[4];
			
			   int  j = r.nextInt();
			     for (int i = 0; i < 4; i++)
			     {
			       arr[i] = j % 10;
			       j = j / 10;
			     }
			     
			   
			    for (int i = 0; i < 4; i++)
			    {
			     if (arr[i] < 0)
			     {
			         arr[i] = arr[i] * -1;
			         
			     }
			    }
			 
			// associate a text with body1
			body1.setContent
			("<p style='color : red;'> Your Verification code is "+arr[0]+""+arr[1]+""+arr[2]+""+arr[3]+"</p>", 
					"text/html");
			
			// create multipart to store body parts
			MimeMultipart parts = new MimeMultipart();
			 
			// store all the body parts inside multipart
			parts.addBodyPart(body1);
			
			
			st.executeUpdate("Insert into otp values"+"('"+arr[0]+arr[1]+arr[2]+arr[3]+"','"+email1+"')");
			
			message.setContent(parts);
			
			Transport.send(message);
			
				JOptionPane.showMessageDialog(this, "Your verificatin mail is sent!");
				
				Verification v=new Verification();
				v.forgote();
				
			}
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
			
				super.dispose();
			}	
	
		else if(e1.getSource()==cancel)
		{
			Login m=new Login();
			m.LogIn();
			super.dispose();
		}
		
}
}




