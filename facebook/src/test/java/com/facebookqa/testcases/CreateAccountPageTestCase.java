package com.facebookqa.testcases;

import java.util.Iterator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.coreframework.exceldtos.SignUpPage;
import com.coreframework.selenium.BaseDriverInitilization;
import com.coreframework.testngdataprovider.ExcelReadDataProvider;
import com.facebookqa.pageobjects.LoggedOutPageObject;
import com.facebookqa.pageobjects.UserLoginHomePage;

public class CreateAccountPageTestCase extends BaseDriverInitilization {
	UserLoginHomePage homePageObject;

	@BeforeMethod
	public void SetUp() {
		homePageObject = new UserLoginHomePage();
	}

	@Test(dataProvider = "data-source")
	public void signUpAccount(SignUpPage signUpPage) {
		loadBaseUrl();
		LoggedOutPageObject loggedoutPage = homePageObject.signUp(signUpPage.getFirstName(), signUpPage.getLastName(),
				signUpPage.getEmail(), signUpPage.getNewPassword(), signUpPage.getMonth(), signUpPage.getDay(),
				signUpPage.getYear(), signUpPage.getGender());
		loggedoutPage.clickLoggedOut();

	}

	@DataProvider(name = "data-source")
	public Iterator<Object[]> dataOneByOne() {
		System.out.println("in data One by One");
		return new ExcelReadDataProvider("facebook.xlsx", "Sheet2", "SignUp");
	}
}
