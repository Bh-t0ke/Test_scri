package Test.Test_script;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.io.FileInputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng {
	ChromeDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	@BeforeTest
	public void lunch() throws IOException {
		String url = common.readData(14, 1);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(priority = 1, enabled = true)
	public void login() throws InterruptedException, IOException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#login-id")).sendKeys("9999999999");
		driver.findElement(By.cssSelector("div#__layout button")).click();
	}

	@Test(priority = 2, enabled = true)
	public void verify() throws InterruptedException, IOException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='otp-id-form']")).sendKeys("9");
		driver.findElement(By.xpath("//input[@id='otp-id-form1']")).sendKeys("9");
		driver.findElement(By.xpath("//input[@id='otp-id-form2']")).sendKeys("2");
		driver.findElement(By.xpath("//input[@id='otp-id-form3']")).sendKeys("0");
		Thread.sleep(2000);
	}

	@Test(priority = 3, enabled = true)
	public void apply_loan_click() throws InterruptedException {

		WebElement applyNow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apply Loan")));
		js.executeScript("window.scrollTo(0, 0)");
		applyNow.click();
	}

//	
	@Test(priority = 4, enabled = true)
	public void Unsecured_Business_Loan_click() throws InterruptedException {
		Thread.sleep(2000);
		WebElement ubl = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Unsecured Business Loan")));
		js.executeScript("window.scrollTo(0, 0)");
		ubl.click();
	}

//	
	@Test(priority = 5, enabled = true)
	public void Basic_Details_Form_Business_Constitution() throws InterruptedException, AWTException, IOException {
		Thread.sleep(3000);
		List<WebElement> values = driver.findElements(By.tagName("option"));
		// Select Business Constitutionss
		for (int i = 0; i < values.size(); i++) {
			String dropdown_values = values.get(i).getText();
			String Business_Constitution = common.readData(1, 1);
			if (dropdown_values.equals(Business_Constitution)) {
				values.get(i).click();
			}
		}
	}

//	
	@Test(priority = 6, enabled = true)
	public void Basic_Details_Form_Business_Name() throws InterruptedException, IOException {
		// Business Namesss
		String name = common.readData(0, 1);
		driver.findElement(By.cssSelector("input#input-none-1")).sendKeys(name);
	}

//	
	@Test(priority = 7, enabled = true)
	public void Basic_Details_Form_Mobile_Number() throws InterruptedException {
		// Enter Mobile Number (As per Aadhaar)
		Random random = new Random();
		int firstDigit = random.nextInt(4) + 6; // Random number between 6 and 9
		StringBuilder mobileNumber = new StringBuilder(String.valueOf(firstDigit));

		// Append 9 more random digits to form a 10-digit mobile number
		for (int i = 0; i < 9; i++) {
			mobileNumber.append(random.nextInt(10)); // Append a random digit (0-9) to the mobile number
		}

		String mobilenumer = mobileNumber.toString();
		driver.findElement(By.cssSelector("div#__layout div:nth-child(1) > span > input#input-none"))
				.sendKeys(mobilenumer + 697859486);
	}

//
	@Test(priority = 8, enabled = true)
	public void Basic_Details_Form_email() throws InterruptedException {
		// Enter Email ID)
		String uuid = UUID.randomUUID().toString();
		String email = "user" + uuid.substring(0, 8) + "@gmail.com"; // You can replace "example.com" with your domain
		driver.findElement(By.cssSelector("div#__layout div:nth-child(2) > span > input#input-none")).sendKeys(email);

	}

//	
	@Test(priority = 9, enabled = true)
	public void Basic_Details_Form_Sector() throws InterruptedException, IOException {
		// Nature of Business (Sector)
		List<WebElement> values = driver.findElements(By.tagName("option"));
		for (int i = 0; i < values.size(); i++) {
			String dropdown_values = values.get(i).getText();
			String sector = common.readData(4, 1);
			;
			if (dropdown_values.equals(sector)) {
				values.get(i).click();
			}
		}
	}

//	
	@Test(priority = 10, enabled = true)
	public void Basic_Details_Form_Sub_Sector() throws InterruptedException, IOException {
		// Thread.sleep(3000);
		// Select Sub Sector
		List<WebElement> values = driver.findElements(By.tagName("option"));
		for (int i = 0; i < values.size(); i++) {
			String dropdown_values = values.get(i).getText();
			String sector = common.readData(5, 1);
			;
			if (dropdown_values.equals(sector)) {
				values.get(i).click();
			}
		}
	}

//	
	@Test(priority = 11, enabled = true)
	public void Basic_Details_Form_Upload_PAN() throws InterruptedException, AWTException {
		// Upload PAN
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.cssSelector("div#__layout div:nth-child(4) > div.custom-file.b-form-file > label"))
				.click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		WebElement element = driver
				.findElement(By.xpath("//div[@class='d-flex justify-content-center']//button[@class='_nfl_button']"));
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		element.click();
	}

	@Test(priority = 12, enabled = true)
	public void Basic_Details_Form_Aadhaar_Upload() throws InterruptedException, AWTException, IOException {
		// Enter Aadhaar Upload Front
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement reactElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#input-11")));
		System.out.println("name:--" + reactElement.getText());
		String Aadharname = common.readData(12, 1);
		reactElement.sendKeys(Aadharname);
		Thread.sleep(2000);
		WebElement reactElement2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form\']")));
		reactElement2.sendKeys("2");
		WebElement reactElement3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"otp-id-form1\"]")));
		reactElement3.sendKeys("3");
		WebElement reactElement4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form2\']")));
		reactElement4.sendKeys("4");
		WebElement reactElement5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form3\']")));
		reactElement5.sendKeys("6");
		WebElement reactElement6 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form4\']")));
		reactElement6.sendKeys("2");
		WebElement reactElement7 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form5\']")));
		reactElement7.sendKeys("4");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'otp-modal-2___BV_modal_body_\']/div[6]/button[2]")).click();
		Thread.sleep(2000);
//         Robot r= new Robot();
//         r.keyPress(KeyEvent.VK_A);
//         r.keyRelease(KeyEvent.VK_A);	
//         r.keyPress(KeyEvent.VK_F);
//         r.keyRelease(KeyEvent.VK_F);
//         r.keyPress(KeyEvent.VK_ENTER);
//         r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		// Enter Aadhaar Upload Back
//         WebElement reactElement1 = driver.findElement(By.cssSelector("div#__layout div:nth-child(2) > div.custom-file.b-form-file > label"));
//     	System.out.println("name:--"+reactElement1.getText());
//        reactElement1.click();
//        Thread.sleep(1000);
//        r.keyPress(KeyEvent.VK_A);
//        r.keyRelease(KeyEvent.VK_A);
//        r.keyPress(KeyEvent.VK_B);
//        r.keyRelease(KeyEvent.VK_B);
//        r.keyPress(KeyEvent.VK_ENTER);
//        r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

//	
	@Test(priority = 13, enabled = true)
	public void Basic_Details_Form_Resident_Office() throws InterruptedException, IOException {
		// Nature of Business (Sector)
		List<WebElement> values = driver.findElements(By.tagName("option"));
		for (int i = 0; i < values.size(); i++) {
			String dropdown_values = values.get(i).getText();
			String sector = common.readData(6, 1);
			;
			if (dropdown_values.equals(sector)) {
				values.get(i).click();
			}
		}
	}

	@Test(priority = 14, enabled = true)
	public void Business_Vintage() throws InterruptedException, IOException {
		// Thread.sleep(3000);
		// Select Sub Sector
		List<WebElement> values = driver.findElements(By.tagName("option"));
		for (int i = 0; i < values.size(); i++) {
			String dropdown_values = values.get(i).getText();
			String sector = common.readData(7, 1);
			;
			if (dropdown_values.equals(sector)) {
				values.get(i).click();
			}
		}
		// Assert.assertEquals(displayed_text, optionText, "PASS");
	}

	@Test(priority = 15, enabled = true)
	public void bankupload() throws InterruptedException, AWTException {
		// bank upload
		Robot r = new Robot();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement reactElement2 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#BNKSTMT1__BV_file_outer_ > label")));
		reactElement2.click();
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_B);
		r.keyRelease(KeyEvent.VK_B);
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// driver.findElement(By.cssSelector("input#stmt_password")).sendKeys("100001508239");
		driver.findElement(By.cssSelector("div#__layout button[type=\'button\']")).click();
		Thread.sleep(1000);
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Thread.sleep(1000);
		driver.findElement(
				By.cssSelector("div#__layout button[type=\'button\'].btn._nfl_button.col-auto.btn-secondary")).click();
		Thread.sleep(2000);
		WebElement label = driver.findElement(By.xpath(
				"//*[@id=\'__layout\']/div/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div[5]/div[3]/div/div[1]/div[2]/button[2]"));
		label.click();

		Thread.sleep(1000);

	}

	@Test(priority = 16, enabled = true)
	public void applicant_OTP_Verification() throws InterruptedException, IOException {
		WebElement Checkbox_button = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("sol-checkbox-accept-1")));
		// WebElement Checkbox = driver.findElement(By.id("sol-checkbox-accept-1"));
		Checkbox_button.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div#__layout div.flex-col.center.aadhar_padding_bottom > button")).click();
		Thread.sleep(2000);
		WebElement reactElement2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form\']")));
		reactElement2.sendKeys("2");
		WebElement reactElement3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"otp-id-form1\"]")));
		reactElement3.sendKeys("3");
		WebElement reactElement4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form2\']")));
		reactElement4.sendKeys("4");
		WebElement reactElement5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form3\']")));
		reactElement5.sendKeys("6");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'otp-modal-1___BV_modal_body_\']/div[6]/button")).click();
		Thread.sleep(80000);

	}

	@Test(priority = 17, enabled = true)
	public void Eligibility_Amount() throws InterruptedException, IOException {

		WebElement applynow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\'__layout\']/div/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div[5]/div[6]/div/div/div[1]/div/div/button")));
		js.executeScript("arguments[0].scrollIntoView(true);", applynow);
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//*[@id=\'__layout\']/div/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div[5]/div[6]/div/div/div[3]/div/div/button"))
				.click();
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// applynow.click();
		WebElement accept_button = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\'modal-1___BV_modal_body_\']/div[4]/button")));
		accept_button.click();
		Thread.sleep(7000);
	}

	@Test(priority = 18, enabled = true)
	public void Co_applicant() throws InterruptedException, IOException, AWTException {
		Thread.sleep(5000);
		// Upload PAN
		driver.findElement(By.cssSelector("div#coApp__BV_file_outer_ > label")).click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);

		// Select relationship
		List<WebElement> values = driver.findElements(By.tagName("option"));
		for (int i = 0; i < values.size(); i++) {
			String dropdown_values = values.get(i).getText();
			String sector = common.readData(9, 1);
			;
			if (dropdown_values.equals(sector)) {
				values.get(i).click();
			}
		}
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Enter Mobile Number (As per Aadhaar)
		Random random = new Random();
		int firstDigit = random.nextInt(4) + 6; // Random number between 6 and 9
		StringBuilder mobileNumber = new StringBuilder(String.valueOf(firstDigit));

		// Append 9 more random digits to form a 10-digit mobile number
		for (int i = 0; i < 9; i++) {
			mobileNumber.append(random.nextInt(10)); // Append a random digit (0-9) to the mobile number
		}

		String mobilenumer = mobileNumber.toString();
		driver.findElement(By.cssSelector("form#coApplicantSave input#input-none-1")).sendKeys(mobilenumer + 697859486);

		// Enter Email ID)
		String uuid = UUID.randomUUID().toString();
		String email = "user" + uuid.substring(0, 8) + "@gmail.com"; // You can replace "example.com" with your domain
		driver.findElement(By.cssSelector("form#coApplicantSave input#input-none")).sendKeys(email);
		Thread.sleep(2000);
		WebElement reactElement1 = driver.findElement(By.cssSelector("input#input-109"));
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		String Aadharname = common.readData(12, 1);
		reactElement1.sendKeys(Aadharname);
		Thread.sleep(2000);
		WebElement reactElement2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form\']")));
		reactElement2.sendKeys("2");
		WebElement reactElement3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"otp-id-form1\"]")));
		reactElement3.sendKeys("3");
		WebElement reactElement4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form2\']")));
		reactElement4.sendKeys("4");
		WebElement reactElement5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form3\']")));
		reactElement5.sendKeys("6");
		WebElement reactElement6 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form4\']")));
		reactElement6.sendKeys("2");
		WebElement reactElement7 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form5\']")));
		reactElement7.sendKeys("4");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'otp-modal-2___BV_modal_body_']/div[6]/button[2]")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement coApplicant_submit = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'coApplicantSave\']/div[3]/input")));
		coApplicant_submit.click();
		// check co-applicant eligibility
		WebElement Checkbox_button = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("sol-checkbox-accept-2")));
		Checkbox_button.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div#__layout div.flex-col.center.aadhar_padding_bottom > button")).click();
		// OTP verification
		Thread.sleep(2000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement reactElement8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form\']")));
		reactElement8.sendKeys("2");
		WebElement reactElement9 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"otp-id-form1\"]")));
		reactElement9.sendKeys("3");
		WebElement reactElement10 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form2\']")));
		reactElement10.sendKeys("4");
		WebElement reactElement11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'otp-id-form3\']")));
		reactElement11.sendKeys("6");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'otp-modal-1___BV_modal_body_\']/div[6]/button")).click();
		Thread.sleep(80000);
	}

	/*----------------------Business Details-----------------------*/
	@Test(priority = 19, enabled = true)

	public void Business_Details() throws InterruptedException, IOException, AWTException {
//select adderess type
		js.executeScript("window.scrollTo(0, 100)");
		Thread.sleep(2000);
		WebElement adderesstypes = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div#radio-group-address-type div:nth-child(3) > label")));
		adderesstypes.click();
		List<WebElement> adderss_radio = adderesstypes.findElements(By.tagName("span"));
		// Adderess type Name
		String adderess_name = common.readData(10, 1);
		System.out.println(adderess_name);
		for (WebElement adderss_list : adderss_radio) {
			String Actual_adderess = adderss_list.getText();
			System.out.println(Actual_adderess);
			if (Actual_adderess.equals(adderess_name)) {
				adderss_list.click();
				System.out.println(adderss_list.getText());
			}
		}

//Adderess ownership type
		Thread.sleep(1000);
		List<WebElement> values = driver.findElements(By.tagName("option"));
		for (int i = 0; i < values.size(); i++) {
			String dropdown_values = values.get(i).getText();
			String Adderess_type = common.readData(11, 1);
			if (dropdown_values.equals(Adderess_type)) {
				values.get(i).click();
			}
		}

//Applicant Business details 
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, 500)");
		WebElement A_ownership = driver.findElement(By.xpath("//label[@for='doc1']"));
		System.out.println(A_ownership.getText());
		Thread.sleep(3000);
		Robot r = new Robot();
		A_ownership.click();
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		// select current adderess checkbox
		// WebElement currentadderess =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'checkbox-1\']")));
		// driver.findElement(By.id("checkbox-1")).click();
		// currentadderess.click();
		// Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\'bussiness-details-pincode-field\']")).sendKeys("421004");
		driver.findElement(By.xpath("//*[@id=\'bussiness-details-line-one-field\']")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\'bussiness-details-landmark-field\']")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\'bussiness-details-city-field\']")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//*[@id=\'bussiness-details-state-field\']")).sendKeys("Maharashtra");
		Thread.sleep(2000);
		WebElement CA_ownership = driver.findElement(By.xpath("//*[@id=\'doc3__BV_file_outer_\']/label"));
		System.out.println(CA_ownership.getText());
		Thread.sleep(3000);
		CA_ownership.click();
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		WebElement CA_ownership_P = driver.findElement(By.xpath("//*[@id=\"doc4__BV_file_outer_\"]/label"));
		System.out.println(CA_ownership_P.getText());
		Thread.sleep(3000);
		CA_ownership_P.click();
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		// select gst select no
		js.executeScript("window.scrollTo(0, 1000)");
		WebElement gst = driver.findElement(By.xpath("//*[@id=\'radio-group-gst\']/div[2]/label"));
		gst.click();
		// Co-applicant address type selection
		Thread.sleep(3000);
//	          WebElement CadderessradioButton = driver.findElement(By.cssSelector("div#__layout div.mb-2 > label"));
//		       System.out.println(CadderessradioButton.getText());
//		    	js.executeScript("arguments[0].scrollIntoView(true);",CadderessradioButton);
//		    	  Thread.sleep(3000);
		WebElement Cadderessselect = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div#co_radio-group-address-type div:nth-child(3) > label")));

		js.executeScript("window.scrollTo(0, 1300)");
		// js.executeScript("arguments[0].scrollIntoView(true);",Cadderessselect);
		Thread.sleep(3000);
		Cadderessselect.click();
		// Adderess type Name
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement COA_ownership = driver.findElement(By.xpath("//*[@id=\'doc9__BV_file_outer_\']/label"));
		System.out.println(COA_ownership.getText());
		Thread.sleep(5000);
		COA_ownership.click();
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		WebElement COA_ownership_P = driver.findElement(By.xpath("//*[@id=\'doc10__BV_file_outer_\']/label"));
		System.out.println(COA_ownership_P.getText());
		COA_ownership_P.click();
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		WebElement business_submit = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#__layout button[type=\'button\']")));
		business_submit.click();
		Thread.sleep(10000);

	}

	@Test(priority = 20, enabled = true)
	public void Financialdocument() throws InterruptedException, IOException, AWTException {
		Robot r = new Robot();
		// WebElement business_submit =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#__layout
		// div.mt-3.col-lg-12.d-flex.justify-content-center > input")));
		WebElement VintageP = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='VINTPROOF']")));
		System.out.println(VintageP.getText());
		Thread.sleep(2000);
		VintageP.click();
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		WebElement EntityP = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='ENTITYP']")));
		System.out.println(EntityP.getText());
		// Thread.sleep(3000);
		EntityP.click();
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		WebElement Loan_Obligation = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div#less-then-details-loan-obligation button[type=\'button\']")));
		System.out.println(Loan_Obligation.getText());
		Loan_Obligation.click();
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		// click on ok button
		WebElement ok = driver.findElement(By.xpath("//*[@id=\'modal-6___BV_modal_footer_\']/button[2]"));
		System.out.println(ok.getText());
		// Thread.sleep(3000);
		ok.click();

		Thread.sleep(3000);

		WebElement business_submit = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div#__layout div.mt-3.col-lg-12.d-flex.justify-content-center > input")));
		business_submit.click();
		Thread.sleep(30000);
	}

	@Test(priority = 21, enabled = true)
	public void insurancedetails() throws InterruptedException, IOException, AWTException {
		WebElement insurance_Salutation = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select#nomineeSalutation")));
		insurance_Salutation.click();
		List<WebElement> adderss_radio = insurance_Salutation.findElements(By.tagName("option"));
		// Adderess type Name
		String insrance_name = common.readData(16, 1);
		System.out.println(insrance_name);
		for (WebElement adderss_list : adderss_radio) {
			String Actual_adderess = adderss_list.getText();
			System.out.println(Actual_adderess);
			if (Actual_adderess.equals(insrance_name)) {
				adderss_list.click();
				System.out.println(adderss_list.getText());
			}
		}

		// enter firstname
		driver.findElement(By.cssSelector("input#first-name-id")).sendKeys("First test");
		// enter surname
		driver.findElement(By.cssSelector("input#sur-name-id")).sendKeys("Last test");
		// select relation
		List<WebElement> values = driver.findElements(By.tagName("option"));
		for (int i = 0; i < values.size(); i++) {
			String dropdown_values = values.get(i).getText();
			String sector = common.readData(17, 1);
			;
			if (dropdown_values.equals(sector)) {
				values.get(i).click();
			}
		}

		// Select DOB
		driver.findElement(By.xpath(
				"//*[@id=\'__layout\']/div/div[2]/div[2]/div/div[3]/div/div/div[2]/span/form/div/span/div/div[5]/span/div[1]/div/input"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/span/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/table/tr[1]/td[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/table/tr[3]/td[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/table/tbody/tr[4]/td[4]")).click();
		Thread.sleep(3000);
		// Calculate premium
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//*[@id=\'__layout\']/div/div[2]/div[2]/div/div[3]/div/div/div[2]/span/form/div/span/div/div[8]/button"))
				.click();
		Thread.sleep(50000);

		// Cheque Details
		// account type selection
		List<WebElement> valuess = driver.findElements(By.tagName("option"));
		for (int i = 0; i < valuess.size(); i++) {
			String dropdown_valuess = valuess.get(i).getText();
			String sector = common.readData(18, 1);
			;
			if (dropdown_valuess.equals(sector)) {
				values.get(i).click();
			}
		}
		Thread.sleep(5000);
		// select cancel cheque
		WebElement cancelcheque = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#CANCHQ__BV_file_outer_ > label")));
		System.out.println(cancelcheque.getText());
		// Thread.sleep(3000);
		cancelcheque.click();
		Thread.sleep(3000);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		// edit cancel chque
		WebElement cancelchequeedit = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Edit']")));
		System.out.println(cancelcheque.getText());
		cancelchequeedit.click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div#input-pan-3 span > input#pan-input-3")).sendKeys("Test name");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div#__layout div.end > button")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		// final submit
		WebElement insurance_submit = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div#__layout div.mt-3.col-lg-12.d-flex.justify-content-center > input")));
		insurance_submit.click();
		Thread.sleep(30000);
	}

	@Test(priority = 22, enabled = true)
	public void disbursal() throws InterruptedException, IOException, AWTException {
		// Generate e-Nach button
		WebElement e_Nach = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#NACH")));
		System.out.println(e_Nach.getText());
		e_Nach.click();
		 Thread.sleep(5000);

		// select sign
		WebElement signdogh = driver
				.findElement(By.xpath("//*[@id=\'sign-dogh-sol-prop__BV_file_outer_\']/label"));
		System.out.println(signdogh.getText());
		// Thread.sleep(3000);
		signdogh.click();
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		// select signed
		WebElement signeddogh = driver.findElement(By
				.xpath("//*[@id=\'sign-loan-sol-prop__BV_file_outer_\']/label"));
		System.out.println(signeddogh.getText());
		signeddogh.click();
		// Thread.sleep(3000); C:\Users\bhushan.toke
		//signeddogh.sendKeys("C:\\Users\\bhushan.toke\\CA.PNG");
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);

		// final dusbursal submit
		WebElement disbursal_submit = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div#__layout div.d-flex.justify-content-center > input")));
		disbursal_submit.click();
		Thread.sleep(30000);
	}

	@Test(priority = 23, enabled = true)
	public void close() throws InterruptedException, IOException {
		driver.close();
	}

}