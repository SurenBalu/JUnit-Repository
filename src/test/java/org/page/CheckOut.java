package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut extends BaseClass {
	
	public CheckOut() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="first-name")
	private WebElement firstName;
	@FindBy(id = "last-name")
	private WebElement lastName;
	@FindBy(id = "postal-code")
	private WebElement postalCode;
	@FindBy(id = "reload-button")
	private WebElement reloadButton;
	
	
	
	public WebElement getReloadButton() {
		return reloadButton;
	}
	public void setReloadButton(WebElement reloadButton) {
		this.reloadButton = reloadButton;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public void setFirstName(WebElement firstName) {
		this.firstName = firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public void setLastName(WebElement lastName) {
		this.lastName = lastName;
	}
	public WebElement getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(WebElement postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
	
	
	

}
