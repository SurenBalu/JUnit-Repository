package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseClass {
	public ProductPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement addToCart;
	@FindBy(xpath = "//span[text()='6']")
	private WebElement addToCartValidation;
	@FindBy(xpath = "//button[text()='REMOVE']")
	private WebElement removeCart;
	@FindBy(xpath ="//span[text()='4']")
	private WebElement removeCartValidation;
	@FindBy(xpath = "//a[text()='CHECKOUT']")
	private WebElement checkOut;
	@FindBy(xpath = "//div[text()='Checkout: Your Information']")
	private WebElement checkOutValidation;
	@FindBy(xpath = "//input[@class='btn_primary cart_button']")
	private WebElement continueButton;
	@FindBy(xpath = "//div[text()='Checkout: Overview']")
	private WebElement confirmValidation;
	
	
	public WebElement getAddToCart() {
		return addToCart;
	}
	public void setAddToCart(WebElement addToCart) {
		this.addToCart = addToCart;
	}
	public WebElement getAddToCartValidation() {
		return addToCartValidation;
	}
	public void setAddToCartValidation(WebElement addToCartValidation) {
		this.addToCartValidation = addToCartValidation;
	}
	public WebElement getRemoveCart() {
		return removeCart;
	}
	public void setRemoveCart(WebElement removeCart) {
		this.removeCart = removeCart;
	}
	public WebElement getRemoveCartValidation() {
		return removeCartValidation;
	}
	public void setRemoveCartValidation(WebElement removeCartValidation) {
		this.removeCartValidation = removeCartValidation;
	}
	public WebElement getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(WebElement checkOut) {
		this.checkOut = checkOut;
	}
	public WebElement getCheckOutValidation() {
		return checkOutValidation;
	}
	public void setCheckOutValidation(WebElement checkOutValidation) {
		this.checkOutValidation = checkOutValidation;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
	public void setContinueButton(WebElement continueButton) {
		this.continueButton = continueButton;
	}
	public WebElement getConfirmValidation() {
		return confirmValidation;
	}
	public void setConfirmValidation(WebElement confirmValidation) {
		this.confirmValidation = confirmValidation;
	}
	
	
	
	

}
