package seleniumPractise.pallavi;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Registration_Validation 
{
	static WebDriver driver;
	WebElement ele;
	String fullName = "Pallavi Shrivastava";
	String address = "Aundh";
	String email = "erpallavi@";
	String city = "Pune";
	String companyName = "Google";
	String userName = "abc";
	String password = "xyz";
	String retypePassword = "ShrivasP";

	String fullNameMessage = "Full name can't be blank";
	String addressMessage = "address cannot be blank";
	String eMailMessage = "Please enter email id";
	String cityMessage = "Please enter City";
	String companyMessage = "Please enter your current organization";
	String userNameMessage = "Username is mandatory field.";
	String passwordMessage = "password is mandatory field.";
	String reenterPasswordMessage = "please reenter password";

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Registration_Validation reg = new Registration_Validation();
		driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(3000);

		reg.blankDetails();
		Thread.sleep(5000);
		reg.fullN();
		Thread.sleep(5000);
		reg.addressN();
		Thread.sleep(5000);
		reg.emailN();
		Thread.sleep(5000);
		reg.cityN();
		Thread.sleep(5000);
		reg.companyN();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//div[@class='radios']//child::label[2]")).click();
		Thread.sleep(5000);
		reg.nameOfUser();
		Thread.sleep(5000);
		reg.passwordOfUser();
		Thread.sleep(5000);
		reg.retypePasswordOfUser();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//input[@value='agree this condition']")).click();
		Thread.sleep(3000);
		reg.ele.click();
		Thread.sleep(3000);
		Alert al = driver.switchTo().alert();
		if (al.getText().equals("Success")) 
		{
			System.out.println("Correct Message is displaying as: " + al.getText());
		} 
		else 
		{
			reg.alertMessage();
		}
		al.accept();
		driver.close();
	}

	void alertMessage() throws InterruptedException 
	{
		Alert alt = driver.switchTo().alert();
		Thread.sleep(2000);
		if (alt.getText().equals(fullNameMessage)) 
		{
			System.out.println("Correct Message is displaying as: " + alt.getText());
		} 
		else if (alt.getText().equals(addressMessage)) 
		{
			System.out.println("Correct Message is displaying as: " + alt.getText());
		} 
		else if (alt.getText().equals(eMailMessage)) 
		{
			System.out.println("Correct Message is displaying as: " + alt.getText());
		} 
		else if (alt.getText().equals(cityMessage)) 
		{
			System.out.println("Correct Message is displaying as: " + alt.getText());
		} 
		else if (alt.getText().equals(companyMessage)) 
		{
			System.out.println("Correct Message is displaying as: " + alt.getText());
		} 
		else if (alt.getText().equals(userNameMessage)) 
		{
			System.out.println("Correct Message is displaying as: " + alt.getText());
		} 
		else if (alt.getText().equals(passwordMessage)) 
		{
			System.out.println("Correct Message is displaying as: " + alt.getText());
		} 
		else if (alt.getText().equals(reenterPasswordMessage)) 
		{
			System.out.println("Correct Message is displaying as: " + alt.getText());
		} 
		else if (alt.getText().equals("Please agree to terms of service and privacy policy")) 
		{
			System.out.println("Correct Message is displaying as: " + alt.getText());
		} 
		else 
		{
			System.out.println("Displaying message is not the expected one: " + alt.getText());

		}
		alt.accept();
	}

	void scroll() 
	{
		ele = driver.findElement(By.id("btnsubmitsignUp"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	void blankDetails() throws InterruptedException 
	{
		scroll();
		ele.click();
		alertMessage();
	}

	void fullN() throws InterruptedException 
	{
		WebElement fName = driver.findElement(By.id("fullName"));
		fName.sendKeys(fullName);
		scroll();
		ele.click();
		alertMessage();
	}

	void addressN() throws InterruptedException 
	{
		WebElement fName = driver.findElement(By.id("fullName"));
		fName.clear();
		fName.sendKeys(fullName);
		WebElement aName = driver.findElement(By.id("address"));
		aName.sendKeys(address);
		scroll();
		ele.click();
		alertMessage();
	}

	void emailN() throws InterruptedException 
	{
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

		if (alt.getText().equals("Please use correct email format")) 
		{
			System.out.println("Failure message is: " + alt.getText());
			Thread.sleep(2000);
			alt.accept();
		} 
		else if (alt1.getText().equals("Please use correct email format")) 
		{
			System.out.println("Failure message is: " + alt1.getText());
			Thread.sleep(2000);
			alt.accept();
		} 
		else 
		{
			alertMessage();
		}
		Thread.sleep(1000);
		eName.clear();
		Thread.sleep(1000);
		eName.sendKeys("pallavi@gmail.com");
		email = "pallavi@gmail.com";
		ele.click();
		alertMessage();
	}

	void cityN() throws InterruptedException 
	{
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
		alertMessage();
	}

	void companyN() throws InterruptedException 
	{
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
		alertMessage();
	}

	void nameOfUser() throws InterruptedException 
	{
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
		ele.click();
		if (userName.length() <= 5) 
		{
			Alert al = driver.switchTo().alert();
			Thread.sleep(1000);
			String alertMessage = al.getText();
			Thread.sleep(1000);
			al.accept();
			String message = "Username length should be greater then 5 characters.";
			if (alertMessage.equals(message)) 
			{
				System.out.println("Message after entering less than or equal to 5 characters in username field : "
						+ alertMessage);
			} 
			else 
			{
				alertMessage();
			}
		}
		Thread.sleep(1000);
		uName.clear();
		Thread.sleep(1000);
		uName.sendKeys("Pallavi");
		userName = "Pallavi";
		scroll();
		ele.click();
		alertMessage();
	}

	void passwordOfUser() throws InterruptedException 
	{
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
		ele.click();
		if (password.length() <= 5) 
		{
			Alert al = driver.switchTo().alert();
			Thread.sleep(1000);
			String alertMessage = al.getText();
			Thread.sleep(1000);
			al.accept();
			String message = "password length should be greater then 5 characters.";
			if (alertMessage.equals(message)) {
				System.out.println("Message after entering less than or equal to 5 characters in password field : "
						+ alertMessage);
			} 
			else 
			{
				alertMessage();
			}
		}
		Thread.sleep(1000);
		pName.clear();
		Thread.sleep(1000);
		pName.sendKeys("ShrivasP");
		password = "ShrivasP";
		scroll();
		ele.click();
		alertMessage();
	}

	void retypePasswordOfUser() throws InterruptedException 
	{
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
		alertMessage();
	}
}
