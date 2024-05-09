package org.execute;
import org.base.BaseClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.page.CheckOut;
import org.page.LoginPage;
import org.page.LogoutPage;
import org.page.ProductPage;

public class ExecutionClass {
	public static BaseClass base;
    public static LogoutPage logout;


		
		@BeforeClass
		public static void loginButton(){
			
	     	base = new BaseClass();
	     	base.getDriver("Chrome");
		    base.getUrl("https://www.saucedemo.com/v1/");
		    base.winMax();
			LoginPage L = new LoginPage();
			L.getUserName().sendKeys("standard_user");
			L.getPass().sendKeys("secret_sauce");
			L.getLoginButton().click();
			if (L.getLoginValidation().isDisplayed()) {
				System.out.println("Login Success");
				
			}
			else {
				System.out.println("Login UnSuccess");
				
			}
		}
	
		@Before
		public void addToCart() {
			ProductPage page = new ProductPage();
			
		try {
	
			for (int i = 0; i < 6; i++) {
				page.getAddToCart().click();
				
			}
			Thread.sleep(2000);
			if(page.getAddToCartValidation().isDisplayed()) {
				System.out.println("Cart has 6 items");
			}else {
				System.out.println("cart invalid");
			}
			for (int j = 0; j < 2; j++) {
				
				page.getRemoveCart().click();
			}
			Thread.sleep(2000);
			if (page.getRemoveCartValidation().isDisplayed()) {
				System.out.println("Cart has 4 items");
			} else {
				System.out.println("Cart revalidation unsucess");
			}
			page.getRemoveCartValidation().click();
			page.getCheckOut().click();
			
			WebElement validation3 = page.getCheckOutValidation();
			if (validation3.isDisplayed()) {
				System.out.println("Checkout Validated");
				
			} else {
				System.out.println("Checkout in valid");

			}
		} catch (Exception e) {
		}
		try {
			CheckOut c = new CheckOut();
			ProductPage p = new ProductPage();
			c.getFirstName().sendKeys("Surendran");
			c.getLastName().sendKeys(".B");
			c.getPostalCode().sendKeys("234567");
			p.getContinueButton().click();
				
			
		} catch (Exception e) {

		}
		
		}
		@Test
		public void finish() {
			  
			
			try {
				Thread.sleep(3000);
				logout.getFinish().click();
				WebElement validation4 = logout.getFinishValidation();
				if (validation4.isDisplayed()) {
					System.out.println("Finish Validated");
				} else {
					System.out.println("Invalid Finish");

				}
			} catch (Exception e) {
			}
		}
	

	@After
		public void logout() {
			
		logout = new  LogoutPage();
			try {
				Thread.sleep(3000);
				logout.getOpenMenu().click();
				logout.getLogout().click();
				if (logout.getLogoutValidation().isDisplayed()) {
					System.out.println("Logout Validated");
					
				} else {
System.out.println("logout in valid");
				}
				
				
			} catch (Exception e) {
			}
		
		
		
		
	}	
		
		
		
}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	


