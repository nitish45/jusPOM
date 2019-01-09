package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeTest
	public void setUp(){		

		loginpage = new LoginPage();
		initialization();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest(){
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		Assert.assertTrue(loginpage.validateCRMlogo());
	}
	
	@Test(priority=3)
	public void loginTest(){
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//Assert.assertEquals(driver.getTitle(), "");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
