package seleniumPractise.pallavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Javascript_Prompt 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//button[text()='Javascript Prompt']")).click();
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
		Thread.sleep(1000);
		al.sendKeys("Pallavi");
		Thread.sleep(1000);
		al.accept();
		String message = driver.findElement(By.xpath(".//p[text()='Hello Pallavi! How are you today?']")).getText();
		if (message.contains("Pallavi")) 
		{
			System.out.println("Script passed and message being displayed is : " + message);
		} 
		else 
		{
			System.out.println("Invalid message is being displayed");
		}
	}
}
