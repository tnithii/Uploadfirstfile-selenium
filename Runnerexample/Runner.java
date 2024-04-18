package Runnerexample;

/*import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;*/
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
//runner
@CucumberOptions(features="C:\\Users\\Home\\Selenium_Starts\\BDDframework\\src\\test\\java\\Featureexample\\Login.feature",glue="stepdefinitionexample")
public class Runner extends AbstractTestNGCucumberTests {

}
