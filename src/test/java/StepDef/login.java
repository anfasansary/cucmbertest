package StepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import Hooks.prestep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {
	
	WebDriver driver = prestep.driver;
	
	@Given("Load SignIn page")
	public void load_sign_in_page() {
	    
	    driver.get("https://o2.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
	    
	}
	@When("^Enter (.+) and (.+)$")
	public void enter_username_and_password(String userName,String passWord) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passWord);
		driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
	}
	@Then("User should be in home page")
	public void user_should_be_in_home_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("loginButton")).click();
		WebElement logoutbutton = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a"));

	Assert.assertEquals(logoutbutton.getText(), "Logout");
		 
	}



}
