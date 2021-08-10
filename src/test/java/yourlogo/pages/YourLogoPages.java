package yourlogo.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YourLogoPages {
	
	WebDriver driver;
	
	public  YourLogoPages(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy (how = How.XPATH, using= "//*[@class='login']")
	private static WebElement signinBtn;

	@FindBy (how = How.XPATH, using= "(//*[@name='email'])[1]")
	private static WebElement emailaddress;
	
	@FindBy (how = How.XPATH, using= "//*[@id='passwd']")
	private static WebElement password;
	
	@FindBy (how = How.XPATH, using= "//*[@class='icon-lock left']")
	private static WebElement signinbtn;

	@FindBy (how = How.XPATH, using= "(//*[@title='Dresses'])[2]")
	private static WebElement dressesBtn;
	
//	@FindBy (how = How.XPATH, using= "(//*[@class='price product-price'])[8]")
//	private static WebElement selectdress;
//	
//	@FindBy (how = How.XPATH, using= ("//*[@id='category']"))
//	private static WebElement addcart;
	@FindBy (how = How.XPATH, using= ("//*[@class='product-desc']/following-sibling::div[1]")) /*(actualTitle));*/
   private static WebElement price5;
	
	//@FindBy (how = How.XPATH, using= "//*[@class='logout']")
	//private static WebElement logoutbtn;
	

	
	public void clickontheSigninbutton() {
		signinBtn.click();
		
	}

	public void entervalidEmailaddressandpassword() {
		emailaddress.sendKeys("naherj2000@gmail.com");
		password.sendKeys("Abc789");
		
	}

	public void clickonSigninbutton() {

		signinbtn.click();
		
	}

	
	public void clickontheleftcornerDresses() {

		dressesBtn.click();
		
	}


		public void verify_the_page_title_as(String title) throws Throwable {
			
			String expected = title;
			String actual = driver.getTitle();
			Assert.assertTrue("Title does not match", actual.contains(expected));
		}
	

public void selecttheseconddressfromthelist() {
////		selectdress.click();
//		
	}
	public void clickonaddtocart() {
////	addcart.click();
//		
	}
//
	public void verifytotalpricewithshipping() {
//	
//		
	}
//
	public void signout() {
//		//logoutbtn.click();
//		
	}

	public void printpriceindesendingorder() {
	
		
		
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
		
		driver.findElement(By.xpath("//*[@class='logout']")).click();
		
	 price5.click();	
	 
	 driver.quit();
	 
	}
	
	
	
}
