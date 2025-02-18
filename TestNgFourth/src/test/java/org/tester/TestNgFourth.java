package org.tester;

import java.util.Date;

import org.base.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgFourth extends BaseClass{
	@Test
	private void tc1() {
		launchUrl("https://profile.w3schools.com/login");
		PojoFbFourth p=new PojoFbFourth();
		passText("nareshrespons@gmail.com", p.getVarReff());
		passText("Tom@1234", p.getPassword());
		clickBtn(p.getLoginBtn());
	}
	
	@Test(enabled=false)
	private void tc8() {
		System.out.println("test case 8");

	}
	
	@Test(invocationCount = 3)
	private void tc5() {
		System.out.println("test case 5");

	}
	@Test(priority=1)
	private void tc4() {
		System.out.println("test case 4");

	}
	
	@BeforeMethod
	private void startDate() {
		Date d=new Date();
		System.out.println(d);

	}
	
	@AfterMethod
	private void endDate() {
		Date d=new Date();
		System.out.println(d);

	}
	@BeforeClass
	private void launchTheBrowser() {
		launchBrowser();
		windowMaximize();

	}
	
	@AfterClass
	private void closeTheBrowser() {
	System.out.println("close browser");

	}

}
