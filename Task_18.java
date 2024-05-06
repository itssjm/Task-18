		import java.time.Duration;

import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.Select;
		import org.openqa.selenium.support.ui.WebDriverWait;


public class Task_18 {

	//public Task_18() {
		
	
		    public static void main(String[] args) {
		        // Set the path of ChromeDriver executable
		        System.setProperty("webdriver.chrome.driver", "C:/Users/Moses/Documents/chromedriver-win64/chromedriver.exe");

		        // Initialize ChromeDriver
		        WebDriver driver = new ChromeDriver();

		        // Navigate to Facebook website
		        driver.get("https://www.facebook.com/");

		        // Maximize browser window
		        driver.manage().window().maximize();

		        // Verify redirection to Facebook homepage
		        String expectedTitle = "Facebook – log in or sign up";
		        String actualTitle = driver.getTitle();
		        if (actualTitle.equals(expectedTitle)) {
		            System.out.println("Successfully redirected to Facebook homepage.");
		        } else {
		            System.out.println("Redirection to Facebook homepage failed.");
		            driver.quit();
		            return;
		        }

		        // Click on "Create new account" button
		    	
		    		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		    		
		    		
		    		
		        // Fill out sign-up form
		    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		    		
		    	WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
		        firstNameField.sendKeys("Jacky");
		    		

		        WebElement lastNameField = driver.findElement(By.name("lastname"));
		        lastNameField.sendKeys("Tommy");

		        WebElement emailField = driver.findElement(By.name("reg_email__"));
		        emailField.sendKeys("testuser1979@test.com");
		        
//		        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
//		        wait1.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
		        
//		        WebElement RegemailField = driver.findElement(By.name("reg_email_confirmation__"));
//		        RegemailField.sendKeys("testuser123@test.com");
		                
		        
		        WebElement passwordField = driver.findElement(By.name("reg_passwd__"));
		        passwordField.sendKeys("Test123@test.com");

		        // Select date of birth
		        Select daySelect = new Select(driver.findElement(By.id("day")));
		        daySelect.selectByVisibleText("11");

		        Select monthSelect = new Select(driver.findElement(By.id("month")));
		        monthSelect.selectByVisibleText("May");

		        Select yearSelect = new Select(driver.findElement(By.id("year")));
		        yearSelect.selectByVisibleText("1985");

		        // Select gender
		        WebElement genderRadioButton = driver.findElement(By.xpath("//input[@name='sex' and @value='2']")); // Change the value to '1' for Female
		        genderRadioButton.click();

		        // Click on "Sign Up" button
		        WebElement signUpButton = driver.findElement(By.name("websubmit"));
		        signUpButton.click();
		        
		        try {
		            Thread.sleep(20000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }


		        // Wait for successful registration and redirection to homepage
		        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Continue')]")));

		        // Verify successful registration
		        String newTitle = driver.getTitle();
		        if (newTitle.equals(expectedTitle)) {
		            System.out.println("Successfully registered and redirected to Facebook homepage.");
		        } else {
		            System.out.println("Registration failed.");
		        }
		        // Close the browser
		        driver.quit();
		    }

	private static WebElement until(ExpectedCondition<WebElement> visibilityOfElementLocated) {
		// TODO Auto-generated method stub
		return null;
	}
		

 
	}


