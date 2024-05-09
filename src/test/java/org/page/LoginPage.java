package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	private WebElement loginValidation;

	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(WebElement userName) {
		this.userName = userName;
	}

	public WebElement getPass() {
		return pass;
	}

	public void setPass(WebElement pass) {
		this.pass = pass;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	public WebElement getLoginValidation() {
		return loginValidation;
	}

	public void setLoginValidation(WebElement loginValidation) {
		this.loginValidation = loginValidation;
	}
	
	
	
	
	
	
	


	}


