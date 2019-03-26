package seleniumPractice.AnkitaG;


	//package seleniumPractise.pallavi;

	 import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	 import util.Init;

	 public class tst {

	 	public static void main(String[] args) throws InterruptedException 
		{
			WebDriver driver =Init.initChromeDriver();
			driver.get("http://automationbykrishna.com/#");
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Basic Elements")).click();
			Thread.sleep(1000);
			String expectedResult = "You must be TechnoCredits student!!";
			driver.findElement(By.xpath(".//button[text()='Alert']")).click();
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String actualResult = alert.getText();
			Thread.sleep(1000);
			alert.accept();
			if (actualResult.equals(expectedResult)) 
			{
				System.out.println("Script is passed as message displayed is : " + actualResult);
			} 
			else 
			{
				System.out.println("Failed as wrong message is being displayed");
			}
		}
	}


