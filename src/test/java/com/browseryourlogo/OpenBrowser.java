package com.browseryourlogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class OpenBrowser {

	
	public static void main(String[] args) /*throws Throwable*/{
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //fire fox
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		driver.findElement(By.id("email")).sendKeys("naherj2000@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Abc789");
		driver.findElement(By.id("SubmitLogin")).click();
		
		String expectedTitle = "My account - My Store";
		String actualTitle = driver.getTitle().trim();
		Assert.assertTrue("Page title does not match", actualTitle.equals(expectedTitle));

		driver.findElement(By.xpath("(//*[contains(text(),'Dresses')])[5]")).click();
        // This will scroll down the page by 1000 pixel vertical
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
		//Thread.sleep(3000);
		List<WebElement> AllPrices = driver.findElements(By.xpath("//*[@class='product-desc']/following-sibling::div[1]")); /*(actualTitle));*/

		ArrayList<String> NewList = new ArrayList<String>();

		for (int i = 0; i < AllPrices.size(); i++) {

			NewList.add(AllPrices.get(i).getText().toString());

		}
		 //sorting ArrayList in desending order
		Collections.sort(NewList, Collections.reverseOrder());

		System.out.println("List of the prices in sorted order: " + NewList);
		String SecondPrice = NewList.get(1);
		System.out.println("Price of second dress: " + SecondPrice);
		
		driver.findElement(By.xpath("(//*[contains(text(),'" + SecondPrice + "')])[2] ")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("(//*[contains(text(),'Proceed to checkout')])")).click();
		
		Double expected = Double.parseDouble(SecondPrice.replace("$", "")) + 2;
		System.out.println("The Expected price is: " + expected);
		
		driver.findElement(By.xpath ("//*[@id='category']"));// own xpath
//		Double actual = Double.parseDouble(driver.findElement(By.xpath("//*[@id='total_price']")).getText().replace("$", ""));
//		
//		Assert.assertTrue("Price does not match", actual.equals(expected));
//	
	driver.findElement(By.xpath("//*[@class='logout']")).click();
	
	driver.quit();
}
//	@FindBy (how = How.XPATH, using= "//*[@class='logout']")
//	private static WebElement logoutbtn;
}