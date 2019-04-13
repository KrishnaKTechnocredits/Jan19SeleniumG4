package seleniumPractise.pallavi;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClientClass {

	WebDriver driver;
	WebElement ele;

	@BeforeClass
	void startBrowser() throws InterruptedException {
		driver = util.Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(3000);
	}

	@DataProvider(name = "SignupDetails")
	Object[][] signupData() throws IOException {
		ExcelSheetOperation obj = new ExcelSheetOperation("E:\\Technocredits\\Selenium\\ExcelData\\SignUpDetails.xlsx");
		Object[][] data = obj.getAllRows("Sheet3");

		return data;
	}

	@Test(dataProvider = "SignupDetails")
	void signupValidation(String fullname, String address, String emailId, String city, String company, String username, String password, String retypePassword, String aggre, String expected) throws InterruptedException {
		validateSignUpFields(fullname, address, emailId, city, company, username, password, retypePassword, aggre, expected);
	}

	void validateAlertMessage(String expected) throws InterruptedException {
		Alert alt = driver.switchTo().alert();
		String actual = alt.getText();
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
		alt.accept();
	}

	void scroll() {

		ele = driver.findElement(By.id("btnsubmitsignUp"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	void validateSignUpFields(String fullName, String address, String emailId, String city, String companyName, String userName, String password, String retypePassword, String aggrementCheckbox, String expectedResult) throws InterruptedException {

		WebElement fName = driver.findElement(By.id("fullName"));
		fName.clear();
		fName.sendKeys(fullName);
		Thread.sleep(1000);
		WebElement aName = driver.findElement(By.id("address"));
		aName.clear();
		aName.sendKeys(address);
		Thread.sleep(1000);
		WebElement eName = driver.findElement(By.id("useremail"));
		eName.clear();
		eName.sendKeys(emailId);
		Thread.sleep(1000);
		WebElement tName = driver.findElement(By.id("usercity"));
		tName.clear();
		tName.sendKeys(city);
		Thread.sleep(1000);
		WebElement cName = driver.findElement(By.id("organization"));
		cName.clear();
		cName.sendKeys(companyName);
		scroll();
		Thread.sleep(1000);
		WebElement uName = driver.findElement(By.id("usernameReg"));
		uName.clear();
		uName.sendKeys(userName);
		Thread.sleep(1000);
		WebElement pName = driver.findElement(By.id("passwordReg"));
		pName.clear();
		pName.sendKeys(password);
		Thread.sleep(1000);
		WebElement rpName = driver.findElement(By.id("repasswordReg"));
		rpName.clear();
		rpName.sendKeys(retypePassword);
		Thread.sleep(1000);
		if (aggrementCheckbox.equals("yes")) {
			driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		}
		scroll();
		ele.click();

		validateAlertMessage(expectedResult);
	}

}
