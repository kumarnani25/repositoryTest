package Testscripts;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.testng.annotations.Test;


public class sendemail {
	
	
	@Test
	public static void emailsend(String recepient,String folderpath) throws MessagingException
	{
		System.out.println("Sending Email...");
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		final  String myemail="Dnaveen25.kumar@gmail.com";
		final  String password="nave@nani25";
		
	      
		
		Session session=Session.getInstance(properties,new Authenticator(){
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return  new PasswordAuthentication(myemail,password);
			}
		});
		
		
		Message message=prepareMessage(session,myemail,recepient,folderpath);
		Transport.send(message);
		System.out.println("Sent successfully");
		}
	
	private static Message prepareMessage(Session session, String myemail,String recepient,String folderpath)
	{
		//String folderpath="https://tineye.com/images/widgets/mona.jpg";
		try{
		
		Message message=new MimeMessage(session);
		message.setFrom(new InternetAddress(myemail));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
		message.setSubject("My first Email");
		//message.setText("Hi this is automation report");
		String report = 
				"<h1> This is automation report</h1>"+
				"<a href=\"https://google.com\">Report</a>";
		message.setContent(report, "text/html; charset=utf-8");
		
		    
		return message;
		}
		catch(Exception e)
		{
		Logger.getLogger(sendemail.class.getName()).log(Level.SEVERE,null,e);	
		}
		return null;
	}
	
		
	}


