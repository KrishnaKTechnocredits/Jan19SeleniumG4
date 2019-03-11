package seleniumPractice.AnkitaG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;


public class HomeWork1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.manage().window().maximize();
		HomeWork1 hw= new HomeWork1();
		hw.alertvalidation(driver);		
	}
	
	public void alertvalidation(WebDriver driver) throws InterruptedException
	{
	driver.findElement(By.linkText("Basic Elements")).click();
	Thread.sleep(2000);
	String fname= "ankita";
	String lname="gupta";
	String cName= "majesco";
	driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(fname);
	driver.findElement(By.xpath("//input[@id='UserLastName']|//inuput[contains(@name,'ulname')]")).sendKeys(lname);
	driver.findElement(By.xpath("//input[contains(@placeholder,'Companyname')]")).sendKeys(cName);
	driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[text()='Submit']")).click();
	Thread.sleep(2000);
	Alert alert=driver.switchTo().alert();//alert method is a method of Alert interface and returns reference variable of alert. as alert is a method os interface implemented by remoteWebdriver class
	
	System.out.println(alert.getText());
	String str=alert.getText();
	String[] substr=str.split(" ");
	for(int i=0; i<substr.length;i++)
	{
		if(!substr[i].equals("and"))
		{
			if(substr[i].equals(fname))
			{
				System.out.println("correct name: "+ fname);
			}
			if(substr[i].equals(lname))
			{
				System.out.println("correct last name: "+ lname);
			}
			if(substr[i].equals(cName))
			{
				System.out.println("correct company name: "+ cName);
			}
		}
		
		
	}		
	alert.accept();				
	driver.close();
	}
}
