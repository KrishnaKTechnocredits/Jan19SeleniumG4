package seleniumPractise.prachiJ.Assingment2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Init;

public class WebTable {

	static String deptWiseEmp = "";

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		WebTable webTable = new WebTable();
		webTable.webTable(driver);

		List<WebElement> e = driver.findElements(By.cssSelector("table.table-striped>thead+tbody>tr"));
		int rows = e.size();

		webTable.managerDetails(driver, rows);
		webTable.duplicateEntry(driver, rows);
		webTable.deptWiseEmp(driver, rows);
	}

	void webTable(WebDriver driver) throws InterruptedException {
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#demotable")));
		driver.findElement(By.cssSelector("a#demotable")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 15);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.table-striped")));
		// driver.findElement(By.cssSelector("table.table-striped"));

	}

	void managerDetails(WebDriver driver, int rows) {
		HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
		for (int i = 1; i <= rows; i++) {
			WebElement e1 = driver.findElement(
					By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(4)"));
			String mngrId = e1.getText();
			if (hm1.containsKey(mngrId)) {
				hm1.put(mngrId, hm1.get(mngrId) + 1);
			} else {
				hm1.put(mngrId, 1);
			}
		}
		// System.out.println(hm1);
		int totalMngrs = hm1.size();
		System.out.println("Total Managers: " + totalMngrs); 								         //Q1 : Total Managers
		System.out.println("****************************************************************************************");
		int max = 0;
		String maxEmpMngr = "";
		Set<String> key = hm1.keySet();
		for (String mngr : key) {
			System.out.println("No.of employess under Manager " + mngr + " are: " + hm1.get(mngr));  // Q2 : No. of employees under respective mngrs
			if (hm1.get(mngr) > max) {
				max = hm1.get(mngr);
				maxEmpMngr = mngr;
			}
		}
		System.out.println("****************************************************************************************");
		System.out.println("Maximum no. of employes report to " + maxEmpMngr + " Manager");         // Q3 : Max no. of employees report to which mngr
		System.out.println("****************************************************************************************");
	}

	void duplicateEntry(WebDriver driver, int rows) {
		HashMap<String, String> hm2 = new HashMap<String, String>(); 								// Q4 : Duplicate Employee
		for (int i = 1; i <= rows; i++) {
			WebElement e1 = driver.findElement(
					By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(4)"));
			String mngrId = e1.getText();
			WebElement e2 = driver.findElement(
					By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(2)"));
			String empId = e2.getText();
			WebElement e3 = driver.findElement(
					By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(3)"));
			String empName = e3.getText();
			if (hm2.containsKey(empId)) {
				String existingMngrId = hm2.put(empId, mngrId);
				if (existingMngrId.equals(mngrId)) {
					System.out.println("Employee with below details is Duplicate:" + "\n" + "ID: " + empId + "\n"
							+ "Name: " + empName + "\n" + "Manager: " + existingMngrId);
					System.out.println(
							"****************************************************************************************");
				}
			} else {
				hm2.put(empId, mngrId);
			}
		}
	}

	void deptWiseEmp(WebDriver driver, int rows) {
		LinkedHashMap<String, String> hm3 = new LinkedHashMap<String, String>();					 // Q5 : Department wise employees
		for (int i = 1; i <= rows; i++) {
			WebElement e1 = driver.findElement(
					By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(5)"));
			String empDept = e1.getText();
			WebElement e2 = driver.findElement(
					By.cssSelector("table.table-striped>thead+tbody>tr:nth-child(" + i + ")>td:nth-child(3)"));
			String empName = e2.getText();

			if (hm3.containsKey(empDept)) {
				String empDeptPresent = hm3.get(empDept);
				deptWiseEmp = empDeptPresent + "--" + empName;
				hm3.put(empDept, deptWiseEmp);
			} else {
				deptWiseEmp = empName;
				hm3.put(empDept, deptWiseEmp);
			}
		}

		Set<String> keys = hm3.keySet();
		int deptCnt = 1;
		System.out.println("Department wise employees are displayed as below:");
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
