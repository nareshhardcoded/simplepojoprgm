package org.tester;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoFbFourth extends BaseClass {

	// with page factory
	// non parameterized constructor
	// FindAll
	public PojoFbFourth() {
		PageFactory.initElements(driver, this);
	}

	// private web elements (there is no semicolon in the findby line)
	@FindAll({ @FindBy(xpath = "//input[@name='email']"),
			@FindBy(xpath = "//input[@placeholder='email']")

	})
	private WebElement getVarRef;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;

	// generate getters and setters (right click -> source-> generate getter and
	// setters option

	public WebElement getVarReff() {
		return getVarRef;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
