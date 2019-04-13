package seleniumPractise.pallavi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebTableOperations {
	static String employeeOfDepartment = "";

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = util.Init.initChromeDriver();
		WebTableOperations webTableOperations = new WebTableOperations();
		webTableOperations.employeeManagerTable(driver);

		List<WebElement> list = driver.findElements(By.cssSelector("table.table-striped>thead+tbody>tr"));
		int rows = list.size();

		webTableOperations.totalManagers(driver, rows);
		//webTableOperations.duplicateEmployee(driver, rows);
		//webTableOperations.employeesOfDepartment(driver, rows);
	}

	void employeeManagerTable(WebDriver driver) throws InterruptedException {
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#demotable")));
		driver.findElement(By.cssSelector("a#demotable")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 15);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.table-striped")));

	}

	void totalManagers(WebDriver driver, int rows) {
		HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
		for (int i = 1; i <= rows; i++) {
			WebElement e1 = driver.findElement(By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(4)"));
			String mngrId = e1.getText();
			if (hm1.containsKey(mngrId)) {
				hm1.put(mngrId, hm1.get(mngrId) + 1);
			} else {
				hm1.put(mngrId, 1);
			}
		}
		int totalMngrs = hm1.size();
		System.out.println("Total Managers: " + totalMngrs);
		System.out.println("****************************************************************************************");
		int max = 0;
		String maxEmpMngr = "";
		Set<String> key = hm1.keySet();
		for (String mngr : key) {
			System.out.println("No.of employees reporting to  Manager " + mngr + " are: " + hm1.get(mngr));
			if (hm1.get(mngr) > max) {
				max = hm1.get(mngr);
				maxEmpMngr = mngr;
			}
		}
		System.out.println("****************************************************************************************");
		System.out.println("Maximum number of employees report to this manager : " + maxEmpMngr);
		System.out.println("****************************************************************************************");
	}

	void duplicateEmployee(WebDriver driver, int rows) {
		HashMap<String, String> hm2 = new HashMap<String, String>();
		for (int i = 1; i <= rows; i++) {
			WebElement e1 = driver.findElement(By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(4)"));
			String mngrId = e1.getText();
			WebElement e2 = driver.findElement(By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(2)"));
			String empId = e2.getText();
			WebElement e3 = driver.findElement(By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(3)"));
			String empName = e3.getText();
			if (hm2.containsKey(empId)) {
				String existingMngrId = hm2.put(empId, mngrId);
				if (existingMngrId.equals(mngrId)) {
					System.out.println("Duplicate employee details are :" + "\n" + "ID: " + empId + "\n" + "Name: " + empName + "\n" + "Manager: " + existingMngrId);
					System.out.println("****************************************************************************************");
				}
			} else {
				hm2.put(empId, mngrId);
			}
		}
	}

	void employeesOfDepartment(WebDriver driver, int rows) {
		LinkedHashMap<String, String> hm3 = new LinkedHashMap<String, String>();
		for (int i = 1; i <= rows; i++) {
			WebElement e1 = driver.findElement(By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(5)"));
			String empDept = e1.getText();
			WebElement e2 = driver.findElement(By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(3)"));
			String empName = e2.getText();

			if (hm3.containsKey(empDept)) {
				String empDeptPresent = hm3.get(empDept);
				employeeOfDepartment = empDeptPresent + "--" + empName;
				hm3.put(empDept, employeeOfDepartment);
			} else {
				employeeOfDepartment = empName;
				hm3.put(empDept, employeeOfDepartment);
			}
		}

		Set<String> keys = hm3.keySet();
		int deptCnt = 1;
		System.out.println("Employees under departments :");
		for (String eDept : keys) {
			String eName = hm3.get(eDept);
			String name[] = eName.split("--");
			System.out.println(deptCnt + ") " + eDept + ":" + name.length);
			int empCnt = 1;

			for (int i = 0; i < name.length; i++) {
				System.out.println("\t" + empCnt + ". " + name[i]);
				empCnt++;
			}
			deptCnt++;
		}
		System.out.println("****************************************************************************************");
	}

}
