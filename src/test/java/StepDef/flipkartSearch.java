package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Hooks.prestep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class flipkartSearch {
	
	WebDriver driver = prestep.driver;
	
	@Given("Load flipkart site")
	public void load_flipkart_site() {
		  
	    driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.linkText("✕")).click();
	}
	@When("Enter search keyword")
	public void enter_search_keyword() {
	   driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("mobile");
	}
	@Then("Clicks on search button")
	public void clicks_on_search_button() {
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
}
