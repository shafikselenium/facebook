package com.facebookqa.testcases;

import org.testng.annotations.BeforeMethod;

import com.coreframework.selenium.BaseDriverInitilization;
import com.facebookqa.pageobjects.UserLoginHomePage;

public class BaseTestCase extends BaseDriverInitilization {
	UserLoginHomePage homePageObject;

// Test comment
	@BeforeMethod
	public void SetUp() {
		homePageObject = new UserLoginHomePage();
	}
}
