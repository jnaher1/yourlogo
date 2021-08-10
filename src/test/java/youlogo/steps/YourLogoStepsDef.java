package youlogo.steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import yourlogo.pages.YourLogoPages;

public class YourLogoStepsDef {
	WebDriver driver;
	YourLogoPages logopages;
	

@Given("^user go to your logo homepage$")
public void user_go_to_your_logo_homepage() throws Throwable {
    

	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
	driver = new ChromeDriver();

	driver.get("http://automationpractice.com/index.php");
	driver.manage().window().maximize();
   
}

@Given("^click on the Sign in button$")
public void click_on_the_Sign_in_button() throws Throwable {
    
   logopages = new YourLogoPages (driver);
   logopages.clickontheSigninbutton();
   
   
}



@When("^user enter valid Email address and password$")
public void user_enter_valid_Email_address_and_password() throws Throwable {
	  logopages = new YourLogoPages (driver);
	   logopages.entervalidEmailaddressandpassword();
   
}

@When("^user click on the Sign in button$")
public void user_click_on_the_Sign_in_button() throws Throwable {
    
   logopages.clickonSigninbutton();

}
@Then("^user nevigate to home page$")
public void user_nevigate_to_home_page() throws Throwable {
//	logopages.nevigatetohomepage();
}
@Then("^verify the page title as \"([^\"]*)\"$")
public void verify_the_page_title_as(String title) throws Throwable {
	
	String expected = title;
	String actual = driver.getTitle();
	Assert.assertTrue("Title does not match", actual.contains(expected));
}



@Then("^user click on the upper left corner Dresses$")
public void user_click_on_the_upper_left_corner_Dresses() throws Throwable {
    
	logopages.clickontheleftcornerDresses();
		
		}



@Then("^print price value in desendeing sorted order$")
public void print_price_value_in_desendeing_sorted_order() throws Throwable {

 //logopages.printpriceindesendingorder();
 

 
//Thread.sleep(3000);
	
		List<WebElement> AllPrices = driver.findElements(By.xpath("//*[@class='product-desc']/following-sibling::div[1]")); /*(actualTitle));*/
       ArrayList<String> NewList = new ArrayList<String>();
          
		    for (int i = 0; i < AllPrices.size(); i++) {
               NewList.add(AllPrices.get(i).getText().toString());
               }
		 
		//sorting ArrayList in desending order;
		Collections.sort(NewList, Collections.reverseOrder());
       System.out.println("List of the prices in sorted order: " + NewList);
		
       String SecondPrice = NewList.get(1);
		System.out.println("Price of second dress: " + SecondPrice);
		
		driver.findElement(By.xpath("(//*[contains(text(),'" + SecondPrice + "')])[2] ")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("(//*[contains(text(),'Proceed to checkout')])")).click();

		driver.findElement(By.xpath("(//*[@id='category'])")).click();
		
		
		Double expected = Double.parseDouble(SecondPrice.replace("$", "")) + 2;
		System.out.println("The Expected price is: " + expected);
		
		
//		Double actual = Double.parseDouble(driver.findElement(By.xpath("//*[@id='total_price']")).getText().replace("$", ""));
//	    Assert.assertTrue("Price does not match", actual.equals(expected));
//		
		
		
		
		
		
		driver.findElement(By.xpath("//*[@class='logout']")).click();
		//codingPage.clickSortedOrders();
		
		
       driver.quit();

}


@Then("^user select the second dress from the list$")
public void user_select_the_second_dress_from_the_list() throws Throwable {
//    //logopages.selecttheseconddressfromthelist();
//    
//   
//   
}
//
@Then("^user click on Add to cart$")
public void user_click_on_Add_to_cart() throws Throwable {
//    
   //logopages.clickonaddtocart();
} 

//	Double expected = Double.parseDouble("$30.50".replace("$", "")) + 2;
//	System.out.println("The Expected price is: " + expected);
//	Double actual = Double.parseDouble(driver.findElement(By.xpath("//*[@id='total_price']")).getText().replace("$", ""));
//	
//	Assert.assertTrue("Price does not match", actual.equals(expected));
//}

@Then("^user verify Total price with shipping is there$")
public void user_verify_Total_price_with_shipping_is_there() throws Throwable {
//    
// //  logopages.verifytotalpricewithshipping();
}
//
@Then("^user sign out$")
public void user_sign_out() throws Throwable {
//    
////  // logopages.signout();
}
//
@Then("^user close the browser$")
public void user_close_the_browser() throws Throwable {
////    driver.close();
////   
}}



