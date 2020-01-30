package scenario;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.When;

public class Scenario {
	WebDriver driver;
	@When("users launches chrome and navigates to application")
	public void users_launches_chrome_and_navigates_to_application() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2a.04.30\\Desktop\\Selenium drivers\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		   
	}

	@When("user login to testme application")
	public void user_login_to_testme_application() {
		   driver.findElement(By.linkText("SignIn")).click();
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    driver.findElement(By.id("userName")).sendKeys("lalitha");
		    driver.findElement(By.id("password")).sendKeys("password123");
		    driver.findElement(By.name("Login")).click();
		    Assert.assertEquals(driver.getTitle(),"Home");
	}

	@When("user searches available products and click view details")
	public void user_searches_available_products_and_click_view_details() {
	    driver.findElement(By.name("products")).sendKeys("head");
	    driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
	    
	}

@When("validates the item")
	public void validates_the_item() {
	   Assert.assertEquals(driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[1]/center[1]/h4")).getText(),"Headphone");
	    System.out.println("Product found");
	}



}
