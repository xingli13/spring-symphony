package xingli.me.springsymphony.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import xingli.me.springsymphony.config.AppConfig;

import javax.annotation.Resource;

/**
 * @author xingli13
 * @date 2018/11/8
 */
@Service
@Slf4j
public class MailService {
	@Resource
	JavaMailSender mailSender;

	void sendSimpleMail(String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(AppConfig.getConfig("mail-addr"));
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);

		try {
			mailSender.send(message);
			log.info(to + " " + subject + " is send.");
		} catch (Exception e) {
			log.error("发送邮件出现异常", e);
		}
	}
}
