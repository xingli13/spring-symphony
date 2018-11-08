package xingli.me.springsymphony.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xingli.me.springsymphony.config.AppConfig;
import xingli.me.springsymphony.config.SymException;
import xingli.me.springsymphony.domain.User;
import xingli.me.springsymphony.domain.ValidEmail;
import xingli.me.springsymphony.repository.UserDao;
import xingli.me.springsymphony.repository.ValidationDao;
import xingli.me.springsymphony.util.EncryptUtils;
import xingli.me.springsymphony.util.TokenUtils;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author xingli13
 * @date 2018/11/5
 */
@Service
@Slf4j
public class UserService {
	@Resource
	UserDao userDao;
	@Resource
	ValidationDao validationDao;
	@Resource
	MailService mailService;
	private User user;

	/**
	 * 新用户注册，并发送验证邮件
	 *
	 * @param user user
	 */
	public void userJoin(User user) {
		// 检验用户名或邮箱是否存在
		if (userDao.findByEmailOrUsername(user.getEmail(), user.getUsername()) == null) {
			user.setStatus(0);
			// 修改密码为加密后的
			user.setPassword(EncryptUtils.encryptPassword(user.getPassword()));
			// 发送激活邮件
			sendValidateEmail(user);
			userDao.save(user);
		} else {
			throw new SymException("002");
		}
	}

	// FIXME: 2018/11/8 重放攻击 修改body https?
	// TODO: 2018/11/8 过期时间之类的判断
	// TODO: 2018/11/8 邮件的模板

	private void sendValidateEmail(User user) {
		// 如何生成唯一id
		String uuid = UUID.randomUUID().toString();
		String link = AppConfig.getConfig("host") + "/confirm_verification/" + uuid;
		ValidEmail validEmail = new ValidEmail(uuid, user);
		validationDao.save(validEmail);
//		mailService.sendSimpleMail(user.getEmail(), "Please verify your sym account", link);
		log.info(link);
	}

	public void verifyEmail(String verifyId) {
		// 判断用户名是否相同
		ValidEmail email = validationDao.findByUuid(verifyId);

		// 判断用户状态是否为0
		user = email.getUser();
		if (user.getStatus() == 1) {
			throw new SymException("003");
		}
		// set status 1 并写入
		user.setStatus(1);
		userDao.save(user);

		log.info(user.getUsername() + "已激活");
	}

	public String login(String username, String password) {
		// 找到这个用户
		User user = userDao.findByUsername(username);
		if (user == null){
			throw new SymException("005");
		}

		// 对于传来的密码进行加密验证
		if (!EncryptUtils.isPasswordCorrect(password, user.getPassword())){
			throw new SymException("005");
		}

		// 如果没有激活,返回
		if (user.getStatus() == 0){
			throw new SymException("004");
		}
		// 生成token
		// FIXME: 2018/11/8 需要保存token吗
		return TokenUtils.generateToken(user.getUsername());
	}
}
