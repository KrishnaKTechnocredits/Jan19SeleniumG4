package seleniumPractise.prachiJ.Assingment3;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.Init;

public class Registration {
	static WebDriver driver = Init.initChromeDriver();

	@Test(dataProvider = "registerData")
	void doRegister(String name, String address, String email, String city, String company, String username,
			String password, String repassword, String terms, String expectedMsz) throws InterruptedException {
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#fullName")));
		driver.findElement(By.cssSelector("#fullName")).sendKeys(name);
		driver.findElement(By.cssSelector("#address")).sendKeys(address);
		driver.findElement(By.cssSelector("#useremail")).sendKeys(email);
		driver.findElement(By.cssSelector("#usercity")).sendKeys(city);
		driver.findElement(By.cssSelector("#organization")).sendKeys(company);
		driver.findElement(By.cssSelector("#usernameReg")).sendKeys(username);
		driver.findElement(By.cssSelector("#passwordReg")).sendKeys(password);
		driver.findElement(By.cssSelector("#repasswordReg")).sendKeys(repassword);
		if (terms.equals("yes")) {
			driver.findElement(By.cssSelector("#signupAgreement")).click();
		}
		driver.findElement(By.cssSelector("#btnsubmitsignUp")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String actualMsz = alert.getText();
		alert.accept();
		Assert.assertEquals(expectedMsz, actualMsz);
	}

	@AfterTest
	void browserClose(){
		driver.close();
	}
	
	@DataProvider(name = "registerData")
	Object[][] registerDataProvider() throws IOException {
		ExcelSheetRead excelSheetRead = new ExcelSheetRead("J:\\JavaGit\\HomeWork_TestNG_22March2019.xlsx");
		Object[][] cellData = excelSheetRead.getRowData("data");
		return cellData;
	}
	
}
