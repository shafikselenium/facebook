package com.facebookqa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserLoginHomePage extends PageHeader {
	@FindBy(xpath = ".//input[@id='email']")
	WebElement userName;
	@FindBy(xpath = ".//input[@id='pass']")
	WebElement userPassword;
	@FindBy(xpath = ".//label[@id='loginbutton']")
	WebElement login;

	@FindBy(xpath = ".//input[@id='u_0_m']")
	WebElement firstName;
	@FindBy(xpath = ".//input[@id='u_0_o']")
	WebElement lastName;
	@FindBy(xpath = ".//input[@id='u_0_r']")
	WebElement emailOrMobileNumber;
	@FindBy(xpath = ".//input[@id='password_step_input']")
	WebElement password;
	@FindBy(xpath = ".//select[@id='month']")
	WebElement month;
	@FindBy(xpath = ".//select[@id='day']")
	WebElement day;
	@FindBy(xpath = ".//select[@id='year']")
	WebElement year;
	@FindBy(xpath = ".//input[@id='u_0_6']")
	WebElement female;
	@FindBy(xpath = ".//input[@id='u_0_7']")
	WebElement male;
	@FindBy(xpath = ".//input[@id='u_0_8']")
	WebElement custom;
	@FindBy(xpath = ".//input[@id='u_0_10']")
	WebElement genderOptional;
	@FindBy(xpath = ".//button[@name='websubmit']")
	WebElement signUp;

	public UserLoginHomePage() {
		PageFactory.initElements(driver, this);

	}

	public LoggedOutPageObject login(String userNameStr, String password) {
		userName.sendKeys(userNameStr);
		userPassword.sendKeys(password);
		login.click();
		return new LoggedOutPageObject();
	}

	public LoggedOutPageObject signUp(String firstName, String lastName, String email, String newPassword, String month,
			String day, String year, String gender) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		emailOrMobileNumber.sendKeys(email);
		password.sendKeys(newPassword);
		Select select_month = new Select(this.month);
		select_month.selectByVisibleText(month);
		Select select_day = new Select(this.day);
		select_day.selectByVisibleText(day);
		Select select_year = new Select(this.year);
		select_year.selectByVisibleText(year);
		male.click();
		signUp.click();
		return new LoggedOutPageObject();
	}
}