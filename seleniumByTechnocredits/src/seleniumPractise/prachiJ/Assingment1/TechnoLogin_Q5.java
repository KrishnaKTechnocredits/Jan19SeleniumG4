package seleniumPractise.prachiJ.Assingment1;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Init;
/*
 * Registration > Login> password less than/equal to 8 letters > alert
 *	Validate the alert text
 */
public class TechnoLogin_Q5 {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		String url = "http://automationbykrishna.com/index.html";
		driver.get(url);
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		String uname = "jainprachi.cs@gmail.com";
		String upassword = "@392xyz";
		TechnoLogin_Q5 technoLogin = new TechnoLogin_Q5();

		WebElement e1 = driver.findElement(By.id("unameSignin"));
		e1.sendKeys(uname);
		String username = e1.getAttribute("value");

		WebElement e2 = driver.findElement(By.id("pwdSignin"));
		e2.sendKeys(upassword);
		String password = e2.getAttribute("value");

		WebElement e3 = driver.findElement(By.id("btnsubmitdetails"));
		e3.click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		if (alert.getText().equals("Success!")) {
			System.out.println("Validation of Login passed");
		} else {
			technoLogin.usernameValidation(username, password, driver, alert);
		}
	}

	void usernameValidation(String username, String password, WebDriver driver, Alert alert) {

		if (username.length() == 0) {
			if (alert.getText().equals("Failed! please enter username")) {
				System.out.println("Username cannot be blank");
			}
		} else {
			System.out.println("Validation of username passed");
			TechnoLogin_Q5 technoLogin = new TechnoLogin_Q5();
			technoLogin.passwordValidation(password, driver, alert);
		}
	}

	void passwordValidation(String password, WebDriver driver, Alert alert) {
		
		if (password.length() == 0) {
			if (alert.getText().equals("Failed! please enter password")) {
				System.out.println("Password cannot be blank");
			}
		} else if (password.length() <= 8) {
			if (alert.getText().equals("Failed! please enter strong password")) {
				System.out.println("Password cannot be less than 9 characters");
			}
		} else {
			System.out.println("Validation of password passed");
		}
	}
}
