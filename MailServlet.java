package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailServlet
 */
public class MailServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String to=request.getParameter("to");
	String mes=request.getParameter("mes");
	String sub=request.getParameter("sub");
	Properties p=new Properties();
	p.put("mail.smtp.host", "smtp.gmail.com");
	p.put("mail.smtp.port", "487");
	p.put("mail.smtp.auth", "true");
p.put("mail.smtp.starttls.enable","true");



	final char ch[]="9666919255".toCharArray();
	try {
		Session s=Session.getInstance(p, new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    	    return new PasswordAuthentication("sandashv@gmail.com","9494951153");  
		    	      }  
		    	    });  
		Message m=new MimeMessage(s);
	m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	m.setSubject(sub);
	m.setText(mes);
	Transport t=s.getTransport("smtp");
	t.send(m);

response.setContentType("text/html");
out.println("<h1>email delivered succesfully to "+to+"<h1>");
				
	} catch (Exception e) {
		out.println(e);
		
	}
	
	}

}
