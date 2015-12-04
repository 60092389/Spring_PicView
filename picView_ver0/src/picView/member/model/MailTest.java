package picView.member.model;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.velocity.VelocityConfig;

@Component
public class MailTest {
	
	private JavaMailSender mailSender;
	private VelocityConfig velocityConfig;

	@Autowired
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Autowired
	public void setVelocityConfig(VelocityConfig velocityConfig) {
		this.velocityConfig = velocityConfig;
	}
	
	
	public void sendMail(String user_mail, String subject, 
			Map<String, Object> textParams, String formatUrl) throws FileNotFoundException, URISyntaxException{
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = 
					new MimeMessageHelper(message,true,"utf-8");
			
			String mailText = null;
			
			mailText = VelocityEngineUtils.mergeTemplateIntoString(velocityConfig.getVelocityEngine(), 
					formatUrl, "utf-8", textParams);
			
			messageHelper.setFrom("kosta103@kosta.com", "코스타103");
			messageHelper.setTo(new InternetAddress(user_mail));
			messageHelper.setSubject(subject);
			messageHelper.setText(mailText, true);
			
			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
