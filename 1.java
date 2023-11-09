import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUpAutomation {
    public static void main(String[] args) {
       WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

        
        driver.get("https://www.facebook.com");

        String expectedTitle = "Facebook";

        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Facebook homepage loaded successfully.");
        } else {
            System.out.println("Failed to load Facebook homepage.");
            driver.quit();
            return;
        }

       
        WebElement createAccountButton = driver.findElement(By.linkText("Create New Account"));
        createAccountButton.click();

        
        WebElement firstNameField = driver.findElement(By.name("firstname"));
        firstNameField.sendKeys("Test");
        WebElement lastNameField = driver.findElement(By.name("lastname"));
        lastNameField.sendKeys("User");

       
        WebElement emailField = driver.findElement(By.name("reg_email__"));
        emailField.sendKeys("fb@gmail.com");  

       
        WebElement passwordField = driver.findElement(By.name("reg_passwd__"));
        passwordField.sendKeys("fb@123"); 

        
        Select dayDropdown = new Select(driver.findElement(By.id("day")));
        dayDropdown.selectByVisibleText("11");
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        monthDropdown.selectByVisibleText("May");
        Select yearDropdown = new Select(driver.findElement(By.id("year")));
        yearDropdown.selectByVisibleText("1985");

        
        WebElement genderRadioButton = driver.findElement(By.cssSelector("input[name='sex'][value='2']"));
        genderRadioButton.click();

       
        WebElement signUpButton = driver.findElement(By.name("websubmit"));
        signUpButton.click();

       
            Thread.sleep(5000);          
       
        String currentURL = driver.getCurrentUrl();
        if (currentURL.contains("facebook.com")) {
            System.out.println("Facebook sign-up successful. Redirected to the homepage.");
        } else {
            System.out.println("Facebook sign-up failed. Not redirected to the homepage.");
        }

  
        driver.quit();
    }
}
