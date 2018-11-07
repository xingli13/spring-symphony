package xingli.me.springsymphony;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration
public class SpringCucumberTest {
	@Rule
	protected MockitoRule rule;
}
