package seleniumPractice.AnkitaG;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;


public class Homework6 {

	static WebDriver driver;
	WebElement ele;
	String fullName = "Ankita gupta";
	String address = "pune";
	String email = "ankita:";
	String city = "Pune";
	String companyName = "Abc";
	String userName = "Ankita";
	String password = "Gupta123456";
	String retypePassword = "Gupta123456";

	public static void main(String[] args) throws IOException, InterruptedException {

		Homework6 reg = new Homework6();
		driver =Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(3000);

		reg.withoutDetails();
		Thread.sleep(5000);
		reg.validateFullName();
		Thread.sleep(5000);
		reg.validateAddress();
		Thread.sleep(5000);
		reg.validateEmail();
		Thread.sleep(5000);
		reg.validateCity();
		Thread.sleep(5000);
		reg.validCompany();
		Thread.sleep(5000);
		reg.validateName();
		Thread.sleep(5000);
		reg.validatePassword();
		Thread.sleep(5000);
		reg.validateReenterPassword();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//input[@value='agree this condition']")).click();
		Thread.sleep(3000);
		reg.ele.click();
		Thread.sleep(3000);
		reg.validateAlertMessage();
		driver.close();

	}
	
	void validateAlertMessage() throws InterruptedException
	{
		Alert alt = driver.switchTo().alert();
		System.out.println("Message displayed is: " + alt.getText());
		Thread.sleep(2000);
		alt.accept();
	
	}

	void scroll() {

		ele = driver.findElement(By.id("btnsubmitsignUp"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);

	}

	void withoutDetails() throws InterruptedException {

		scroll();
		ele.click();
		
		validateAlertMessage();
		}

	void validateFullName() throws InterruptedException {

		WebElement fName = driver.findElement(By.id("fullName"));
		fName.sendKeys(fullName);
		scroll();
		ele.click();
		validateAlertMessage();
	}

	void validateAddress() throws InterruptedException {

		WebElement fName = driver.findElement(By.id("fullName"));
		fName.clear();
		fName.sendKeys(fullName);
		WebElement aName = driver.findElement(By.id("address"));
		aName.sendKeys(address);
		scroll();
		ele.click();
		validateAlertMessage();
	
	}

	void validateEmail() throws InterruptedException {

		WebElement fName = driver.findElement(By.id("fullName"));
		fName.clear();
		fName.sendKeys(fullName);
		WebElement aName = driver.findElement(By.id("address"));
		aName.clear();
		aName.sendKeys(address);
		WebElement eName = driver.findElement(By.id("useremail"));
		eName.sendKeys(email);
		scroll();
		ele.click();
		Alert alt = driver.switchTo().alert();
		Alert alt1 = driver.switchTo().alert();
		Alert alt2 = driver.switchTo().alert();
		if(alt.getText().equals("Please use correct email format"))
		{
		System.out.println("Failure message is: " + alt.getText());
		Thread.sleep(2000);
		alt.accept();
		}
		else if(alt1.getText().equals("Please use correct email format"))
		{
			System.out.println("Failure message is: " + alt1.getText());
			Thread.sleep(2000);
			alt.accept();
		}
		else
		{
			System.out.println("Success message is : "+alt2.getText());
		}
		Thread.sleep(1000);
		eName.clear();
		Thread.sleep(1000);
		eName.sendKeys("Ankita@gmail.com");
		email="Ankita@gmail.com";
		ele.click();
		validateAlertMessage();
	}

		void validateCity() throws InterruptedException {

		WebElement fName = driver.findElement(By.id("fullName"));
		fName.clear();
		fName.sendKeys(fullName);
		WebElement aName = driver.findElement(By.id("address"));
		aName.clear();
		aName.sendKeys(address);
		WebElement eName = driver.findElement(By.id("useremail"));
		eName.clear();
		eName.sendKeys(email);
		WebElement tName = driver.findElement(By.id("usercity"));
		tName.sendKeys(city);
		scroll();
		ele.click();
		validateAlertMessage();
	}

	void validCompany() throws InterruptedException {

		WebElement fName = driver.findElement(By.id("fullName"));
		fName.clear();
		fName.sendKeys(fullName);
		WebElement aName = driver.findElement(By.id("address"));
		aName.clear();
		aName.sendKeys(address);
		WebElement eName = driver.findElement(By.id("useremail"));
		eName.clear();
		eName.sendKeys(email);
		WebElement tName = driver.findElement(By.id("usercity"));
		tName.clear();
		tName.sendKeys(city);
		WebElement cName = driver.findElement(By.id("organization"));
		cName.sendKeys(companyName);
		scroll();
		ele.click();
		validateAlertMessage();
	}

	void validateName() throws InterruptedException {

		WebElement fName = driver.findElement(By.id("fullName"));
		fName.clear();
		fName.sendKeys(fullName);
		WebElement aName = driver.findElement(By.id("address"));
		aName.clear();
		aName.sendKeys(address);
		WebElement eName = driver.findElement(By.id("useremail"));
		eName.clear();
		eName.sendKeys(email);
		WebElement tName = driver.findElement(By.id("usercity"));
		tName.clear();
		tName.sendKeys(city);
		WebElement cName = driver.findElement(By.id("organization"));
		cName.clear();
		cName.sendKeys(companyName);
		WebElement uName = driver.findElement(By.id("usernameReg"));
		uName.sendKeys(userName);
		scroll();
		ele.click();
		validateAlertMessage();

	
	}

	void validatePassword() throws InterruptedException {

		WebElement fName = driver.findElement(By.id("fullName"));
		fName.clear();
		fName.sendKeys(fullName);
		WebElement aName = driver.findElement(By.id("address"));
		aName.clear();
		aName.sendKeys(address);
		WebElement eName = driver.findElement(By.id("useremail"));
		eName.clear();
		eName.sendKeys(email);
		WebElement tName = driver.findElement(By.id("usercity"));
		tName.clear();
		tName.sendKeys(city);
		WebElement cName = driver.findElement(By.id("organization"));
		cName.clear();
		cName.sendKeys(companyName);
		WebElement uName = driver.findElement(By.id("usernameReg"));
		uName.clear();
		uName.sendKeys(userName);
		WebElement pName = driver.findElement(By.id("passwordReg"));
		pName.sendKeys(password);
		scroll();
		ele.click();
		validateAlertMessage();
	}

	void validateReenterPassword() throws InterruptedException {

		WebElement fName = driver.findElement(By.id("fullName"));
		fName.clear();
		fName.sendKeys(fullName);
		WebElement aName = driver.findElement(By.id("address"));
		aName.clear();
		aName.sendKeys(address);
		WebElement eName = driver.findElement(By.id("useremail"));
		eName.clear();
		eName.sendKeys(email);
		WebElement tName = driver.findElement(By.id("usercity"));
		tName.clear();
		tName.sendKeys(city);
		WebElement cName = driver.findElement(By.id("organization"));
		cName.clear();
		cName.sendKeys(companyName);
		WebElement uName = driver.findElement(By.id("usernameReg"));
		uName.clear();
		uName.sendKeys(userName);
		WebElement pName = driver.findElement(By.id("passwordReg"));
		pName.clear();
		pName.sendKeys(password);
		WebElement rpName = driver.findElement(By.id("repasswordReg"));
		rpName.sendKeys(password);
		scroll();
		ele.click();
		validateAlertMessage();
	}
}


