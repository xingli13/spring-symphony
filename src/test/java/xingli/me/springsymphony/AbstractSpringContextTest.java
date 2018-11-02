package xingli.me.springsymphony;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class AbstractSpringContextTest {
	@Autowired
	protected WebApplicationContext wac;
	@Rule
	protected MockitoRule rule;
}
