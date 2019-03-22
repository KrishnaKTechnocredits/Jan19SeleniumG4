package seleniumPractice.AnkitaG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;


public class Homework4 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.manage().window().maximize();
		Homework4 hw= new Homework4();
		hw.promptvalidation(driver);
	}
	public void promptvalidation(WebDriver driver) throws InterruptedException
	{	
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement ele=driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		ele.click();
		Alert alert= driver.switchTo().alert();
		Thread.sleep(2000);
		alert.sendKeys("Ankita");
		//String str=alert.getText();
		alert.accept();
		Thread.sleep(5000);
		WebElement el= driver.findElement(By.xpath("//p[@id='pgraphdemo']"));	
		if(el.getText().contains("Ankita"))
			{
				System.out.println("valid user");
				
			}
		
		else
		{
			ele.click();
			Thread.sleep(2000);
			driver.switchTo().alert().dismiss();
			WebElement ele1=driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
			if(ele1.getText().equals("User cancelled the prompt."))
			{
				System.out.println("valid name");
			}
			

		}
		
				

		
		
	}

}
