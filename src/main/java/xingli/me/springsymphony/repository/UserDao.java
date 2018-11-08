package xingli.me.springsymphony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xingli.me.springsymphony.domain.User;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Integer> {

	/**
	 * 根据用户名或邮箱获取用户
	 * @param email 邮箱
	 * @param username 用户名
	 * @return 用户
	 */
	User findByEmailOrUsername(String email, String username);

	/**
	 * 根据用户名获取用户
	 * @param username 用户名
	 * @return 用户
	 */
	User findByUsername(String username);
}
