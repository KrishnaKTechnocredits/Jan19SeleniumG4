package seleniumPractise.prachiJ;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

/*
 * javaScript Confirmation> Ok/Cancel > Message under the button
 *	Validate the message with OK/Cancel.
 */

public class TechnoRegistration_Q6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		String url = "http://automationbykrishna.com/index.html";
		driver.get(url);
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		TechnoRegistration_Q6 technoRegistration_Q6 = new TechnoRegistration_Q6();
		ArrayList<String> al = new ArrayList<String>();

		WebElement fName = driver.findElement(By.xpath("//div[@id='registration']/descendant::input[@name='fName']"));
		fName.sendKeys("Prachi Jain");
		String fullName = fName.getAttribute("value");
		al.add(fullName);

		WebElement add = driver.findElement(By.xpath("//div[@id='registration']//following::input[position()=2][@id='address']"));
		add.sendKeys("Atlanta 2");
		String address = add.getAttribute("value");
		al.add(address);

		WebElement email = driver.findElement(By.xpath("//input[contains(@name,'email')]"));
		email.sendKeys("jainprachi@gmail.com");
		String emailId = email.getAttribute("value");
		al.add(emailId);

		WebElement city = driver.findElement(By.xpath("//input[starts-with(@placeholder,'City')]"));
		city.sendKeys("Pune");
		String cityTown = city.getAttribute("value");
		al.add(cityTown);

		WebElement org = driver.findElement(By.xpath("//div[@id='registration']/form/div/input[last()-3]"));
		org.sendKeys("CG");
		String organisation = org.getAttribute("value");
		al.add(organisation);

		WebElement genderM = driver.findElement(By.xpath("//p[text()='Enter your account details below']//preceding-sibling::div/descendant::input[1]"));
		WebElement genderF = driver.findElement(By.xpath("//p[text()='Enter your account details below']//preceding-sibling::div/descendant::input[2]"));
		if (genderM.isSelected() == true) {
			genderF.click();
		}

		WebElement user = driver.findElement(By.xpath("//input[contains(@id,'username')][@class='form-control']"));
		user.sendKeys("validateUserName");
		String userName = user.getAttribute("value");
		al.add(userName);

		WebElement pwd = driver.findElement(By.xpath("//input[@id='passwordReg']"));
		pwd.sendKeys("@392xyz");
		String password = pwd.getAttribute("value");
		al.add(password);

		WebElement rePwd = driver.findElement(By.xpath("//input[contains(@id,'repasswordReg')]"));
		rePwd.sendKeys("@392xyz");
		String rePassword = rePwd.getAttribute("value");
		al.add(rePassword);

		WebElement terms = driver.findElement(By.xpath("//label[@class='checkbox']/input"));
		terms.click();

		WebElement submit = driver.findElement(By.xpath("//div[contains(@class,'registration')]//preceding-sibling::button"));
		submit.click();

		Alert alert = driver.switchTo().alert();
		String expected = "Success";

		if (alert.getText().equals(expected)) {
			if (alert.getText().equals("Success")) {
				System.out.println("You have registered successfully");
			}
		} else {
			technoRegistration_Q6.validateFirstName(al, alert, driver);
			alert.accept();
		}
	}

	void validateFirstName(ArrayList<String> al, Alert alert, WebDriver driver) {
		if (al.get(0).length() == 0) {
			if (alert.getText().equals("Full name can't be blank")) {
				System.out.println("Full Name required");
			}
		} else {
			TechnoRegistration_Q6 technoRegistration_Q6 = new TechnoRegistration_Q6();
			technoRegistration_Q6.validateAddress(al, alert, driver);
		}
	}

	void validateAddress(ArrayList<String> al, Alert alert, WebDriver driver) {
		if (al.get(1).length() == 0) {
			if (alert.getText().equals("address cannot be blank")) {
				System.out.println("Address cannot be blank");
			}
		} else {
			TechnoRegistration_Q6 technoRegistration_Q6 = new TechnoRegistration_Q6();
			technoRegistration_Q6.validateEmail(al, alert, driver);
		}
	}

	void validateEmail(ArrayList<String> al, Alert alert, WebDriver driver) {
		String email = (String) al.get(2);
		if (al.get(2).length() == 0) {
			if (alert.getText().equals("Please enter email id")) {
				System.out.println("Email cannot be blank");
			}

		} else if (!email.contains("@")) {
			if (alert.getText().equals("Please use correct email format")) {
				System.out.println("Email Should contain @");
			}

		} else if (!email.contains(".")) {
			if (alert.getText().equals("Please use correct email format")) {
				System.out.println("Email Should contain .");
			}
		} else {
			TechnoRegistration_Q6 technoRegistration_Q6 = new TechnoRegistration_Q6();
			technoRegistration_Q6.validateCity(al, alert, driver);
		}
	}

	void validateCity(ArrayList<String> al, Alert alert, WebDriver driver) {
		if (al.get(3).length() == 0) {
			if (alert.getText().equals("Please enter City")) {
				System.out.println("City cannot be blank");
			}
		} else {
			TechnoRegistration_Q6 technoRegistration_Q6 = new TechnoRegistration_Q6();
			technoRegistration_Q6.validateOrganisation(al, alert, driver);
		}
	}

	void validateOrganisation(ArrayList<String> al, Alert alert, WebDriver driver) {
		if (al.get(4).length() == 0) {
			if (alert.getText().equals("Please enter your current organization")) {
				System.out.println("Organisation cannot be blank");
			}
		} else {
			TechnoRegistration_Q6 technoRegistration_Q6 = new TechnoRegistration_Q6();
			technoRegistration_Q6.validateUserName(al, alert, driver);
		}
	}

	void validateUserName(ArrayList<String> al, Alert alert, WebDriver driver) {
		if (al.get(5).length() == 0) {
			if (alert.getText().equals("Username is mandatory field.")) {
				System.out.println("User Name cannot be blank");
			}
		} else {
			TechnoRegistration_Q6 technoRegistration_Q6 = new TechnoRegistration_Q6();
			technoRegistration_Q6.validatePassword(al, alert, driver);
		}
	}

	void validatePassword(ArrayList<String> al, Alert alert, WebDriver driver) {
		if (al.get(6).length() == 0) {
			if (alert.getText().equals("password is mandatory field.")) {
				System.out.println("Password cannot be blank");
			}
		} else {
			TechnoRegistration_Q6 technoRegistration_Q6 = new TechnoRegistration_Q6();
			technoRegistration_Q6.validateRePassword(al, alert, driver);
		}
	}

	void validateRePassword(ArrayList<String> al, Alert alert, WebDriver driver) {
		if (al.get(7).length() == 0) {
			if (alert.getText().equals("please reenter password")) {
				System.out.println("Re-enter Password field cannot be blank");
			}
		} else if (!al.get(6).equals(al.get(7))) {
			if (alert.getText().equals("retype password donot match.")) {
				System.out.println("Both Passwords should be same");
			}
		} else {
			TechnoRegistration_Q6 technoRegistration_Q6 = new TechnoRegistration_Q6();
			technoRegistration_Q6.validateTerms(alert, driver);
		}
	}

	void validateTerms(Alert alert, WebDriver driver) {
		 WebElement terms =
		driver.findElement(By.xpath("//input[@id='signupAgreement']"));
		if(terms.isSelected()==false)
		{
		if (alert.getText().equals("Please agree to terms of service and privacy policy")) {
			System.out.println("Please agree to Terms and conditions before submtting");
		}
		}
	}
}