package Test.Test_script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_page{
	WebDriver driver=new ChromeDriver();
    private static WebElement inputField;

    // Constructor to initialize WebDriver and find the input field WebElement
    public Basic_page(WebDriver driver) {
        this.driver = driver;
        Basic_page.inputField = driver.findElement(By.cssSelector("input#login-id"));
    }

    // Method to return the input field WebElement
    public static WebElement getInputField() {
        return inputField;
    }
}
