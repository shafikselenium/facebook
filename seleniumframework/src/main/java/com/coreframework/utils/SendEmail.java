package com.coreframework.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmail {
	public static void sendEmailThis(final String filePath) throws IOException, EmailException {
		sendEmailThis(filePath, "Seleium Automation report");

	}

	public static void sendEmailThis(final String filePath, final String subjectName)
			throws IOException, EmailException {
		File file = new File(filePath);
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("tsutiger129@gmail.com", "AccountFor@tsu"));
		email.setSSLOnConnect(true);
		email.setFrom("tsutiger129@gmail.com");
		email.setSubject(subjectName);
		email.attach(file);
		email.addTo("shafikshafik@gmail.com");
		email.send();
	}

}
