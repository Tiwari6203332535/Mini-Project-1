package in.happy.util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	@Autowired
	 public JavaMailSender mail;
	
	public Boolean mailsender(String subject ,String body, String to ,File f) {
		  
		try {
			
			MimeMessage mimeMessage = mail.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(to);
			helper.addAttachment("plan_info", f);
			
			mail.send(mimeMessage);
		} catch (Exception e) {
		e.printStackTrace();
	}

		return true;
}
}