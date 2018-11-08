package xingli.me.springsymphony.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author xingli13
 * @date 2018/11/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
	@Resource
	MailService mailService;

	@Test
	public void sendSimpleMail() {
		mailService.sendSimpleMail("xingli13@iflytek.com", "test Simple email", "hello world");
	}
}