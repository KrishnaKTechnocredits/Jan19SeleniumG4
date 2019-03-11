package seleniumPractice.AnkitaG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;


public class HomeWork5 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.manage().window().maximize();
		HomeWork5 hw= new HomeWork5();
		hw.registration(driver);
	}
	public void registration(WebDriver driver) throws InterruptedException
	{
		
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("ankita");
		String pwd="211313236465";
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Thread.sleep(2000);
		
		
		if(pwd.length()<=8)
		{
			String alertmsg=driver.switchTo().alert().getText();
			if(alertmsg.equals("Failed! please enter strong password"))
			{
				driver.switchTo().alert().accept();
				System.out.println("alert handled and accepted");
			}
		}
		else
		{
			
			String alertmsg1=driver.switchTo().alert().getText();
			if(alertmsg1.equals("Success!"))
			{
				driver.switchTo().alert().accept();
				System.out.println("user successfully logged in");
			}
		}
		
	}

}