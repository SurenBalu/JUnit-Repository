package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BaseClass {
	
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='FINISH']")
	private WebElement finish;
	@FindBy(xpath = "//div[text()='Finish']")
	private WebElement finishValidation;
	@FindBy(xpath = "//button[text()='Open Menu']")
	private WebElement openMenu;
	@FindBy(id="logout_sidebar_link")
	private WebElement logout;
	@FindBy(xpath = "//h4[text()='Accepted usernames are:']")
	private WebElement logoutValidation;
	
	
	public WebElement getFinish() {
		return finish;
	}
	public void setFinish(WebElement finish) {
		this.finish = finish;
	}
	public WebElement getFinishValidation() {
		return finishValidation;
	}
	public void setFinishValidation(WebElement finishValidation) {
		this.finishValidation = finishValidation;
	}
	public WebElement getOpenMenu() {
		return openMenu;
	}
	public void setOpenMenu(WebElement openMenu) {
		this.openMenu = openMenu;
	}
	public WebElement getLogout() {
		return logout;
	}
	public void setLogout(WebElement logout) {
		this.logout = logout;
	}
	public WebElement getLogoutValidation() {
		return logoutValidation;
	}
	public void setLogoutValidation(WebElement logoutValidation) {
		this.logoutValidation = logoutValidation;
	}
	
	
	
	
	
	

}
