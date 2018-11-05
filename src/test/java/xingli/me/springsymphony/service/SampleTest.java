package xingli.me.springsymphony.service;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.*;

/**
 * @author xingli13
 * @date 2018/11/5
 */
public class SampleTest {
	String name;
	String msg;

	@Given("my name is {string}")
	public void my_name_is(String string) {
		// Write code here that turns the phrase above into concrete actions
		this.name = string;
	}

	@When("I press hello")
	public void i_press_hello() {
		// Write code here that turns the phrase above into concrete actions
		msg = "hello," + name;
	}

	@Then("I get {string}")
	public void i_get(String string) {
		assertThat(string).isEqualTo(msg);
	}
}
