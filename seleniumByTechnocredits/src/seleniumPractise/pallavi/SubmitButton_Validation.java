package seleniumPractise.pallavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class SubmitButton_Validation 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//input[contains(@id,'UserFirstName')]")).sendKeys("Pallavi");
		String firstName = driver.findElement(By.xpath(".//input[contains(@id,'UserFirstName')]"))
				.getAttribute("value");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//input[@id='UserLastName' and @name='ulname']")).sendKeys("Shrivastava");
		String lastName = driver.findElement(By.xpath(".//input[@id='UserLastName' and @name='ulname']"))
				.getAttribute("value");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//input[@name='cmpname' or @id='UserCompanyName']")).sendKeys("Mindtree");
		String companyName = driver.findElement(By.xpath(".//input[@name='cmpname' or @id='UserCompanyName']"))
				.getAttribute("value");
		Thread.sleep(1000);
		String submitVerification = firstName + " and " + lastName + " and " + companyName;
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()=' Alert Demo ']//following::button[text()='Submit'][1]")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		if (alertMessage.equals(submitVerification)) 
		{
			System.out.println(" Expected message being displayed after clicking on Submit button is " + alertMessage);
		} 
		else 
		{
			System.out.println("Invalid message is being displayed");
		}
	}
}
