package xingli.me.springsymphony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xingli.me.springsymphony.domain.ValidEmail;

/**
 * @author xingli13
 * @date 2018/11/8
 */
public interface ValidationDao extends JpaRepository<ValidEmail, String> {
	/**
	 * 根据uuid确定推送的邮件
	 * @param uuid uuid
	 * @return 返回的邮件
	 */
	ValidEmail findByUuid(String uuid);
}
