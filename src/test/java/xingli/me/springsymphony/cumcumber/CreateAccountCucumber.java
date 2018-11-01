package xingli.me.springsymphony.cumcumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xingli.me.springsymphony.controlller.UserController;
import xingli.me.springsymphony.domain.User;

import javax.annotation.Resource;

/**
 * @author xingli13
 * @date 2018/11/1
 */
@ContextConfiguration
@SpringBootTest
@RunWith(SpringRunner.class)
public class CreateAccountCucumber {
	//	UserController controller = new UserController();
	@Resource
	UserController controller;
	String s;
	private User user = new User();

	@Given("filling in the password {string}")
	public void fillingInThePasswordAbc(String arg0) throws Throwable {
		user.setPassword(arg0);
	}


	@And("filling the the username {string}")
	public void fillingTheTheUsernameMing(String username) throws Throwable {
		user.setUsername(username);
	}


	@When("press the button signUp")
	public void pressTheButtonSignUp() throws Throwable {
		s = controller.newUserJoin(user);
	}


	@Then("he receive the status code {string}")
	public void heReceiveTheStatusCode(String arg0) throws Throwable {
		String expected = "{\"s\":\"1\"}";
		JSONAssert.assertEquals(expected, s, false);
	}
//
//	@And("he receive the message {string}")
//	public void heReceiveTheMessage(String arg0) throws Throwable {
//		String expected = "{\"m\":\"" + arg0 + "\"}";
//		JSONAssert.assertEquals(expected, s, false);
//	}
}
