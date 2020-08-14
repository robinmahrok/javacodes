package bms;
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

class BabyOfAuthenticator extends Authenticator
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

public class veri
{
	public void abc()
	throws Exception
	{
	// create object of properties in order to
	// provide configuration info... about
	// mail server
	Properties p = new Properties();
	p.put("mail.smtp.host","smtp.gmail.com");
	p.put("mail.smtp.port","587");
	p.put("mail.smtp.starttls.enable","true");
	p.put("mail.smtp.auth","true");
 	p.put("mail.smtp.ssl.trust","smtp.gmail.com");
	p.put("mail.debug","true");
	
	// create object of Authenticator
	BabyOfAuthenticator baby = new 
			BabyOfAuthenticator();
	
	// create object of session
	Session ses = Session.getInstance
			(p, baby);
	
	// create object of mime-message to denote
	// actual message to be sent to mail server
	MimeMessage message = new MimeMessage(ses);
	
	// provide a subject
	message.setSubject("TEST MAIL !!");
	Forgot f=new Forgot();
   String email1=f.email.getText();
	
	String[] emails = {"robinsinghmahrok@gmail.com"};

	
	InternetAddress[] inadrs = new 
			InternetAddress[emails.length];
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
//			body2 = new MimeBodyPart(),
//			body3 = new MimeBodyPart();
	 
	Random r=new Random();
	int j=r.nextInt();
	
	// associate a text with body1
	body1.setContent
	("<p style='color : red;'>Your verification code is: "+j%10000+"</p>", 
			"text/html");
	
	
	
	// associate attachments with body2 and body3
	
	
	// create multipart to store body parts
	MimeMultipart parts = new MimeMultipart();
	
	// store all the body parts inside multipart
	parts.addBodyPart(body1);
	
	// store multipart inside message
	message.setContent(parts);
	
	// send this message to the mail server
	Transport.send(message);
	
	
	
	}
}



