package org.help;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoClass extends BaseClass{

public PojoClass() {

PageFactory.initElements(driver,this);
}
	
	
	
	public WebElement getAccount() {
		return account;
	}
	public WebElement getCreateAcc() {
		return createAcc;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return LastName;
	}
	public WebElement getEmailBox() {
		return emailBox;
	}
	public WebElement getPasswordBox() {
		return passwordBox;
	}
	public WebElement getSumbitButton() {
		return sumbitButton;
	}

	@FindBy(id="customer_register_link")
	WebElement createAcc;
	
	@FindBy(id="FirstName")
	WebElement firstName;
	
	@FindBy(id="LastName")
	WebElement LastName;
	
	@FindBy(xpath="(//input[@class='input-full'])[3]")
	WebElement emailBox;
	
	@FindBy(xpath="(//input[@class='input-full'])[4]")
	WebElement passwordBox;
	@FindBy(xpath="//input[@value='Create']")
	WebElement sumbitButton;
	@FindBy(xpath="(//a[@href='/account'])[1]")
	WebElement account;
	
	
}
