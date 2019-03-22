package seleniumPractise.pallavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		WebElement ele = driver.findElement(By.xpath(".//header[text()=' Different Examples of Alerts ']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
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
		driver.findElement(By.xpath(".//button[text()='Javascript Prompt']")).click();
		al.dismiss();
		String dismissMessage = driver.findElement(By.xpath(".//p[text()='User cancelled the prompt.']")).getText();
		if (dismissMessage.equals("User cancelled the prompt.")) 
		{
			System.out.println("Script passed and message being displayed is : " + dismissMessage);
		} 
		else 
		{
			System.out.println("Invalid message is being displayed");
		}
	}
}
