package seleniumPractise.prachiJ.Assingment1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Init;

/*
 * Alert Demo > Submit > Alert
 * Validation of the values of Alert Demo with of the Alert.
 */
public class AlertDemo_Q1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		String url = "http://automationbykrishna.com/#";
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/preceding-sibling::ul/li[4]/a")).click();
		Thread.sleep(2000);	

		AlertDemo_Q1 alertDemo_Q1 = new AlertDemo_Q1();
		alertDemo_Q1.alertValuesValidation(driver);
	}
	
	void alertValuesValidation(WebDriver driver) throws InterruptedException
	{
		WebElement e1 = driver.findElement(By.xpath("//input[@id='UserFirstName']"));
		WebElement e2 = driver.findElement(By.xpath("//input[@id='UserLastName']"));
		WebElement e3 = driver.findElement(By.xpath("//input[@id='UserCompanyName']"));	
		e1.sendKeys("Prachi");
		e2.sendKeys("Jain");
		e3.sendKeys("CG");
		String fName = e1.getAttribute("value");
		String lName = e2.getAttribute("value");
		String cName = e3.getAttribute("value");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String alertMsg = alert.getText();
		if((alertMsg.contains(fName)) && (alertMsg.contains(lName)) && (alertMsg.contains(cName)))
		{
			if(alertMsg.equals("Prachi and Jain and CG"))
			{
				System.out.println("Validation of values of Alert Demo with that of Alert message passed");
				alert.accept();
			}
		}	
	}
}
