package seleniumPractise.pallavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Login_Password_Validation 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(3000);
		boolean flag = driver.findElement(By.xpath(".//*[text()='Login']")).isDisplayed();

		if (flag == true) 
		{
			driver.findElement(By.xpath(".//input[@id='unameSignin' and @class ='form-control' ]")).sendKeys("Pallavi");
			String password = "ab@123";
			driver.findElement(By.xpath(".//input[@id='pwdSignin' and @class='form-control']")).sendKeys(password);
			driver.findElement(By.xpath(".//button[@id='btnsubmitdetails']")).click();
			if (password.length()<9) 
			{
				Alert al = driver.switchTo().alert();
				Thread.sleep(1000);
				String alertMessage = al.getText();
				Thread.sleep(1000);
				al.accept();
				String message = "Failed! please enter strong password";
				if (alertMessage.equals(message)) 
				{
					System.out
							.println("Message after entering less than 8 characters in password id : " + alertMessage);
				}
			} 
			else 
			{
				Alert al = driver.switchTo().alert();
				Thread.sleep(1000);
				String alertMessage = al.getText();
				al.accept();
				String message = "Success!";
				if (alertMessage.equals(message)) 
				{
					System.out
							.println("Message after entering more than 8 characters in password id : " + alertMessage);
				}
			}
		}
	}
}
