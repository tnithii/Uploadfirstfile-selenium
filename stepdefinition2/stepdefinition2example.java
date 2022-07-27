package stepdefinition2;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefinition2example {

	static WebDriver driver;

	@Given("^when the usesr enters the URL$")
	public void enters_the_URL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
	}

	/*
	 * @When ("^the user enters the valid username and password$") public void
	 * username_and_password(DataTable credentials) { List<Map <String,String>>
	 * data=credentials.asMaps(String.class,String.class);
	 * driver.findElement(By.id("txtUsername")).sendKeys(data.get(0).get("username")
	 * );
	 * driver.findElement(By.id("txtPassword")).sendKeys(data.get(0).get("password")
	 * ); }
	 */

	@When("^the user enters the valid username and password$")
	public void username_and_password(DataTable credentials) {
		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {
			driver.findElement(By.id("txtUsername")).sendKeys(data.get("username"));
			driver.findElement(By.id("txtPassword")).sendKeys(data.get("password"));
		}

	}

	@And("^the user clicks the submit button$")
	public void submit_button()

	{
		driver.findElement(By.id("btnLogin")).click();

	}

	@Then("^the user should be redirected to the profile page$")
	public void profile_page() {
		String welcomemessage = driver.findElement(By.id("welcome")).getText();
		System.out.println(welcomemessage);
		Assert.assertEquals(welcomemessage, "Welcome Paul");
		System.out.println("valid test pass");
	}

}
