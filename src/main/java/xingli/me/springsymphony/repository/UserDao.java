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
	 * 根据用户名获取用户
	 * @param username username
	 * @return 如果存在该username，返回user，否则为空
	 */
	User findFirstByUsername(String username);

}
