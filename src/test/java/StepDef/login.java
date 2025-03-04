package StepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

	
	@When("Enter username and password")
	public void enter_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
		driver.findElement(By.id("loginButton")).click();
	}
	
	@Then("User should be in home page")
	public void user_should_be_in_home_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement logoutbutton = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a"));

	Assert.assertEquals(logoutbutton.getText(), "Logout");
		 
	}
	
	@When("Clicks on Register a patient")
	public void clicks_on_register_a_patient() {
	    driver.findElement(By.xpath("//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")).click();
	}
	@When("Enter demographics informations")
	public void enter_demographics_informations() {
	    driver.findElement(By.xpath("//input[@name='givenName']")).sendKeys("Aswathy");
	    driver.findElement(By.xpath("//input[@name='familyName']")).sendKeys("Chandrathil");
	    driver.findElement(By.xpath("//button[@id='next-button']")).click();
	    
	    WebElement gender = driver.findElement(By.id("gender-field"));
	    Select obj = new Select(gender);
	    obj.selectByVisibleText("Female");
	    driver.findElement(By.xpath("//button[@id='next-button']")).click();
	    driver.findElement(By.xpath("//input[@id='birthdateDay-field']")).sendKeys("16");
	    WebElement month = driver.findElement(By.id("birthdateMonth-field"));
	    Select mon = new Select(month);
	    mon.selectByVisibleText("June");
	    driver.findElement(By.xpath("//input[@id='birthdateYear-field']")).sendKeys("1993");
	    driver.findElement(By.xpath("//button[@id='next-button']")).click();
	    
	}
	@When("Enter contactinfo")
	public void enter_contactinfo() {
		 driver.findElement(By.xpath("//input[@id=\"address1\"]")).sendKeys("kuruppampady");
		 driver.findElement(By.xpath("//button[@id='next-button']")).click();
		 driver.findElement(By.xpath("//button[@id='next-button']")).click();
	}
	@When("Enter retaionships")
	public void enter_retaionships() {
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
	}


	@Then("Clicks on confirm Patient should register successfully")
	public void clicks_on_confirm_patient_should_register_successfully() {
		driver.findElement(By.id("submit")).click();
		
		WebDriverWait wdw=new WebDriverWait(driver,Duration.ofSeconds(20));
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"patient-header row \"]/div[2]/div/span")));
				
				boolean patientId =  driver.findElement(By.xpath("//*[@class=\"patient-header row \"]/div[2]/div/span")).isDisplayed();
				Assert.assertTrue("Patient Id should generate ", 
						patientId);

	}

	@When("Clicks on Find Patient Record")
	public void clicks_on_find_patient_record() {
		driver.findElement(By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")).click();
	}
	@When("Enter search by name")
	public void enter_search_by_name() {
	    driver.findElement(By.xpath("//input[@placeholder='Search by ID or Name']")).sendKeys("Aswathy");
	}
	@When("Select search patient")
	public void select_search_patient() throws InterruptedException {
		WebElement moveMouse=driver.findElement(By.xpath("//*[@id='patient-search-results-table_wrapper']/table/tbody/tr[1]"));
		Actions ac=new Actions(driver);
		ac.moveToElement(moveMouse).click().perform();
		

	}
	@When("Clicks on edit")
	public void clicks_on_edit() {
		
		driver.findElement(By.xpath("//span[@id='edit-patient-demographics']")).click();
	}
	@When("Update patient name and save")
	public void update_patient_name_and_save() {
	    driver.findElement(By.xpath("//input[@name='givenName']")).clear();
	    driver.findElement(By.xpath("//input[@name='givenName']")).sendKeys("AswathyRajan");
	    driver.findElement(By.xpath("//a[@id='save-form']")).click();
	}
	@Then("Clicks on confirm and patient name should update successfully")
	public void clicks_on_confirm_and_patient_name_should_update_successfully() {
		driver.findElement(By.xpath("//button[@id='registration-submit']")).click();
		WebDriverWait wdw=new WebDriverWait(driver,Duration.ofSeconds(20));
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='PersonName-givenName']")));
				
				WebElement actual_updated_name =  driver.findElement(By.xpath("//span[@class='PersonName-givenName']"));
				Assert.assertEquals(actual_updated_name.getText(), "AswathyRajan");
	}


}
