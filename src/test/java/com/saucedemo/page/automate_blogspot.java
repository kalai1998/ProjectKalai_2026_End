package com.saucedemo.page;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class automate_blogspot {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
//		driver.get("https://testautomationpractice.blogspot.com/");
//		WebElement element = driver.findElement(By.xpath("//h2[text()='Footer Links']"));
//        WebElement element2 = driver.findElement(By.className("title"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(3000);
//        js.executeScript("arguments[0].scrollIntoView(true);", element2);

		try {
			driver.get("https://testautomationpractice.blogspot.com/");

			driver.findElement(By.id("name")).sendKeys("Kalaiarasan");
			driver.findElement(By.id("email")).sendKeys("kalaiarasan.28904@gmail.com");
			driver.findElement(By.id("phone")).sendKeys("9789843820");
			driver.findElement(By.id("textarea")).sendKeys("1/126 kaliamman koil st");
			WebElement mRadio = driver.findElement(By.id("male"));
			if (!mRadio.isSelected()) {
				mRadio.click();
			}
			WebElement sundayCbox = driver.findElement(By.id("sunday"));
			if (!sundayCbox.isSelected()) {
				sundayCbox.click();
			}
			WebElement mondayCbox = driver.findElement(By.id("monday"));
			if (!mondayCbox.isSelected()) {
				mondayCbox.click();
			}
			Select countryName = new Select(driver.findElement(By.id("country")));
			countryName.selectByValue("india");
			Select colorsName = new Select(driver.findElement(By.id("colors")));
			colorsName.selectByVisibleText("Green");
			Select sortList = new Select(driver.findElement(By.id("animals")));
			sortList.selectByValue("cat");
			try {

				WebElement datePickerInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("datepicker")));
				datePickerInput.click();
				datePickerInput.sendKeys("09/29/2026");
				datePickerInput.sendKeys(Keys.ENTER);
				System.out.println("Date selected successfully");
			} catch (Exception e) {
				System.out.println("Failed to enter date:" + e.getMessage());
			}
			WebElement datepicker2Input = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtDate")));
			datepicker2Input.click();
			datepicker2Input.sendKeys("09/29/2026");
			datepicker2Input.sendKeys(Keys.ENTER);
			System.out.println("Date picked successfully");
			WebElement startDateInput = driver.findElement(By.id("start-date"));
			WebElement endDateInput = driver.findElement(By.id("end-date"));
			WebElement submitBtn = driver.findElement(By.cssSelector("button.submit-btn"));

			// Option A: Send keys directly (Day-Month-Year format, e.g., 10-Oct-2026 ->
			// "10102026")
			startDateInput.sendKeys("10102026");
			endDateInput.sendKeys("25102026");

			// Click Submit
			submitBtn.click();
			System.out.println("Date range submitted successfully!");
			WebElement resultDaterange = driver.findElement(By.id("result"));
			System.out.println(resultDaterange);
			WebElement file1 = driver.findElement(By.xpath("//button[text()='Upload Single File']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", file1);
			WebElement fileInput = driver.findElement(By.id("singleFileInput"));
			fileInput.sendKeys("C:\\Users\\Lenovo\\Documents\\StoredProcedures.txt");
			WebElement uploadFile1 = driver.findElement(By.xpath("//button[@type='submit'][1]"));
			uploadFile1.click();
			WebElement fileStatus = driver.findElement(By.id("singleFileStatus"));
			String textStatus = fileStatus.getText();
			System.err.println(textStatus);
			WebElement fileInput2 = driver.findElement(By.id("multipleFilesInput"));
			fileInput2.sendKeys("C:\\Users\\Lenovo\\Documents\\ModelTypes.txt");
			WebElement uploadfile2 = driver.findElement(By.xpath("//button[text()='Upload Multiple Files']"));
			uploadfile2.click();
			WebElement fileStatus2 = driver.findElement(By.id("multipleFilesStatus"));
			String status2 = fileStatus2.getText();
			System.err.println(status2);
			// Right side actions
			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("window.scrollBy(0, -1500);");
			WebElement btnTitle = driver.findElement(By.xpath("//button[(text()='START')]"));
			btnTitle.click();
			// 1. Click the button that triggers the Simple Alert
			driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();

			// 2. Switch control from the main page to the alert popup
			Alert simpleAlert = driver.switchTo().alert();
			simpleAlert.accept();
			driver.findElement(By.xpath("//button[text()='Confirmation Alert']")).click();
			Alert cnfrmAlert = driver.switchTo().alert();
			cnfrmAlert.accept();
			driver.findElement(By.xpath("//button[text()='Prompt Alert']")).click();
			Alert promptAlert = driver.switchTo().alert();
			System.out.println(promptAlert.getText());
			promptAlert.sendKeys("Kalaiarasan");
			promptAlert.accept();
			WebElement statusName = driver.findElement(By.id("demo"));
			System.out.println(statusName.getText());
			String originalWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
			// Now get all open window handles
//			// 1. Save the window handle of your original tab before clicking
			// String originalWindow = driver.getWindowHandle();

			// 2. Click the "New Tab" button (based on your DOM snippet: <button
			// onclick="myFunction()">New Tab</button>)
			WebElement newTabButton = driver.findElement(By.xpath("//button[text()='New Tab']"));
			newTabButton.click();

			// 3. Get all open browser window/tab handles
			Set<String> allWindowHandles = driver.getWindowHandles();

			// 4. Loop through the handles and switch to the new tab
			for (String windowHandle : allWindowHandles) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			// You are now on the new tab! Do whatever you need here:
			System.out.println("New Tab Title: " + driver.getTitle());

			// 5. CLOSE the new tab if you want (optional)
			// driver.close();

			// 6. SWITCH BACK to your main/original tab
			driver.switchTo().window(originalWindow);

			// You are back on the main tab!
			System.out.println("Back to Main Tab Title: " + driver.getTitle());
			// popups
			// return to popupbutton page
			// scrolling to popuup button
			WebElement popUpclick = driver.findElement(By.xpath("//button[@onclick='return popup()']"));
			popUpclick.click();
			driver.manage().window().maximize();
			jsc.executeScript("window.scrollBy(0, 100);");
			// 4. Loop through the handles and switch to the new tab
			for (String windowHandle : allWindowHandles) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			// You are now on the new tab! Do whatever you need here:
			System.out.println("New Tab Title: " + driver.getTitle());

			// 5. CLOSE the new tab if you want (optional)
			// driver.close();

			// 6. SWITCH BACK to your main/original tab
			driver.switchTo().window(originalWindow);

			// You are back on the main tab!
			System.out.println("Back to Main Tab Title: " + driver.getTitle());
			// Point me Hover
			jsc.executeAsyncScript("window.scrollBy(0, 1000);");
			WebElement source = driver.findElement(By.id("draggable"));
			WebElement target = driver.findElement(By.id("droppable"));
			actions.dragAndDrop(source, target);
			String dropped = source.getText();
			System.out.println(dropped);
			if (dropped.equals("Dropped..!")) {
				System.out.println("Dropped successfully..");
			} else {
				System.out.println("Not successfully dropped");
			}
		} finally {
//			driver.quit();
//			System.out.println("Browser closed successfully");
		}

	}
	
	private void kalai() {
		System.out.println("Kalai");
	}
	
	private void arasan() {
		System.out.println("Arasan");
	}

}
