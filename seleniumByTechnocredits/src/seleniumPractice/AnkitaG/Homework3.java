package seleniumPractice.AnkitaG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;


public class Homework3 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.manage().window().maximize();
		Homework3 hw= new Homework3();
		hw.confirmboxValidation(driver);
	}
	public void confirmboxValidation(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement ele=driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		ele.click();
		Alert alert= driver.switchTo().alert();
		Thread.sleep(2000);
		String str=alert.getText();
		if(str.equals("Are you are doing your homework regularly, Press Okay else Cancel!!"))
		{
			alert.accept();
			System.out.println("being technocredit student pressed OK");
		}
		else
		{
			alert.dismiss();
			System.out.println("being technocredit student pressed Cancel");
		}
		
	}
}


