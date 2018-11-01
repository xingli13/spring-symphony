package xingli.me.springsymphony;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, glue = {"me.xingli.springsymphony.cucumber","cucumber.api.spring"})
public class SpringSymphonyApplicationTests {

//	@Test
//	public void contextLoads() {
//	}

}
