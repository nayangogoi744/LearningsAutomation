// Not Working Example


package com.testtalks.karatedemo.MavenProjectSelenium;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSend {

	public static void main(String[] args) throws EmailException {
		
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setDebug(false);
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("dummyemail744@gmail.com", "SAG*@dem0123"));
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		email.setFrom("nayangogoi744@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("nayan.jyotigogoi@softwraeag.com");
		email.send();
		
	}

}
