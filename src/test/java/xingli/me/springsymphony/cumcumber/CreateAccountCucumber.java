package xingli.me.springsymphony.cumcumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import xingli.me.springsymphony.AbstractSpringContextTest;
import xingli.me.springsymphony.domain.User;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * @author xingli13
 * @date 2018/11/1
 */
public class CreateAccountCucumber extends AbstractSpringContextTest {
	private MockMvc mockMvc;
//	private TransactionStatus txStatus;

	private User user = new User();
	private String s;

//	@Resource
//	private PlatformTransactionManager txMgr;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//		txStatus = txMgr.getTransaction(new DefaultTransactionDefinition());
	}
//	@After
//	public void rollbackAfterHook(){
//		txMgr.rollback(txStatus);
//	}
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
		String userStr = new ObjectMapper().writeValueAsString(user);
		s = mockMvc.perform(post("/join")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(userStr))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		System.out.println(s);
	}

	@Then("he receive the status code {string}")
	public void heReceiveTheStatusCode(String arg0) throws Throwable {
		String expected = "{\"s\":\"" + arg0 + "\"}";
		JSONAssert.assertEquals(expected, s, false);
	}

	@And("^he receive the message \"([^\"]*)\"$")
	public void heReceiveTheMessage(String msg) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String expected = "{\"em\":\"" + msg + "\"}";
		JSONAssert.assertEquals(expected, s, false);
	}
	@Given("login with name {string} and password {string}")
	public void login_with_name_and_password(String name, String password) throws Throwable {
		fillingTheTheUsernameMing(name);
		fillingInThePasswordAbc(password);
		pressTheButtonSignUp();
	}
}
