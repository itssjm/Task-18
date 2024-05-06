import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;


	
		public class Task_18A {
			
	    public static void main(String[] args) {
	        // Set the path of ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "C:/Users/Moses/Documents/chromedriver-win64/chromedriver.exe");

	        // Initialize ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to jQueryUI droppable website
	        driver.get("https://jqueryui.com/droppable/");
	        
	     // Maximize browser window
	        driver.manage().window().maximize();

	        // Switch to iframe containing the droppable elements
	        driver.switchTo().frame(0);

	        // Find source and target elements
	        WebElement sourceElement = driver.findElement(By.id("draggable"));
	        WebElement targetElement = driver.findElement(By.id("droppable"));

	        // Perform drag and drop operation
	        Actions actions = new Actions(driver);
	        actions.dragAndDrop(sourceElement, targetElement).build().perform();

	        // Verify color property of target element's CSS
	        String targetColor = targetElement.getCssValue("background-color");
	        if (targetColor.equals("rgba(0, 255, 0, 1)")) { // Yellow color indicates successful drop
	            System.out.println("Drag and drop operation successful.");
	        } else {
	            System.out.println("Drag and drop operation failed.");
	        }

	        // Verify text of target element
	        String targetText = targetElement.getText();
	        if (targetText.equals("Dropped!")) {
	            System.out.println("Text of the target element changed to 'Dropped!'.");
	        } else {
	            System.out.println("Text of the target element did not change.");
	        }
	        
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Close the browser
	        driver.quit();
	    }
		

	}


