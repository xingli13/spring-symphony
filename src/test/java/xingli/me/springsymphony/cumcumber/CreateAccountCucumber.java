package xingli.me.springsymphony.cumcumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import xingli.me.springsymphony.AbstractSpringContextTest;
import xingli.me.springsymphony.controlller.UserController;
import xingli.me.springsymphony.domain.User;
import xingli.me.springsymphony.repository.UserDao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;
/**
 * @author xingli13
 * @date 2018/11/1
 */
public class CreateAccountCucumber extends AbstractSpringContextTest {
	private MockMvc mockMvc;

	private User user = new User();
	private String s;
	@InjectMocks
	UserController controller;
	// TODO: 2018/11/2  是用来提高效率的，想办法降低测试复杂度，精简不必要操作
	// TODO: 2018/11/2 不必要的操作，不要使用web环境
	@Mock
	UserDao dao;
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		dao = mock(UserDao.class);
		when(dao.findFirstByUsername("ming"))
				.thenReturn(null).thenReturn(new User());
	}

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
