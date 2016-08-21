package by.robotun.webapp.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import by.robotun.webapp.domain.User;
import by.robotun.webapp.exception.ServiceException;

@Service("defaultMailService")
public class MailService {

	static final Logger LOGGER = Logger.getLogger(MailService.class);

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendSimpleMailMessage(SimpleMailMessage simpleMailMessage) throws ServiceException {
		boolean isSend = false;
		try {
			mailSender.send(simpleMailMessage);
		} catch (MailException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return isSend;
	}
	
	public boolean sendMimeMessage(MimeMessage mimeMessage) throws ServiceException {
		boolean isSend = false;
		try {
			mailSender.send(mimeMessage);
		} catch (MailException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return isSend;
	}
	
	public SimpleMailMessage constructRecoveryPasswordSimpleMailMessage(String contextPath, String message, String messageSubject, String token, User user) {
		StringBuilder url = new StringBuilder(contextPath);
		url.append("/secure/changePassword?id=");
		url.append(user.getIdUser());
		url.append("&token=");
		url.append(token);
		StringBuilder text = new StringBuilder(message);
		text.append(" ");
		text.append(url);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("jobster.by@gmail.com");
		mailMessage.setTo(user.getLogin());
		mailMessage.setSubject(messageSubject);
		mailMessage.setText(text.toString());
		return mailMessage;
	}
	
	public MimeMessage constructRecoveryPassdwordMimeMessage(String contextPath, String message, String messageSubject, String token, User user) throws ServiceException {
		MimeMessage mailMessage = mailSender.createMimeMessage();
		StringBuilder url = new StringBuilder(contextPath);
		url.append("/secure/changePassword?id=");
		url.append(user.getIdUser());
		url.append("&token=");
		url.append(token);
		StringBuilder text = new StringBuilder(message);
		text.append(" ");
		text.append(url);
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage, true);
			mimeMessageHelper.setTo(user.getLogin());
		    mimeMessageHelper.setFrom("jobster.by@gmail.com");
		    mimeMessageHelper.setSubject(messageSubject);
		    mimeMessageHelper.setText(text.toString(),true);
		} catch (MessagingException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
		return mailMessage;
	}
}