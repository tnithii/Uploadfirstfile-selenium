package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefinition1{

	static WebDriver driver;
	@Before
	public void Open_URL()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@After
	public void Close_Browser()
	{
		driver.quit();
	}
	
	
	  @Given("^when the usesr enters the URL$") public void enters_the_URL() {
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	  
	  }
	 
	@When ("^the user enters the valid username and password$")
	public void username_and_password()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
	}
	@And ("^the user clicks the submit button$")
	public void submit_button()
	
	{
		driver.findElement(By.id("btnLogin")).click();
		
		
	}
	@Then ("^the user should be redirected to the profile page$")
	public void profile_page()
	{
		String welcomemessage=driver.findElement(By.id("welcome")).getText();
		System.out.println(welcomemessage);
		Assert.assertEquals(welcomemessage,"Welcome Paul");
		System.out.println("valid test pass");
	}
	
	@When ("^the user enters the invalid username and password$")
	public void invalid_username_and_password()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin123");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
	}
	@Then ("^it should show the error message$")
	public void error_message()
	{
		String errormessage=driver.findElement(By.id("spanMessage")).getText();
		System.out.println(errormessage);
		Assert.assertEquals(errormessage,"Invalid credentials");
		System.out.println("invalid test pass");
	}
	
}
