package com.coreframework.testngdataprovider;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.coreframework.exceldtos.FacebookLogin;
import com.coreframework.exceldtos.SignUpPage;

public class ExcelReadDataProvider implements Iterator<Object[]> {
	Logger logger = Logger.getLogger(ExcelReadDataProvider.class);
	private int rowIndex = 2;
	private final ExcelReader excelRead;
	private final String sheetName;
	private final String classObject;

	public ExcelReadDataProvider(String fileName, String sheetName, String classObject) {
		excelRead = new ExcelReader(fileName);
		this.sheetName = sheetName;
		this.classObject = classObject;
	}

	@Override
	public boolean hasNext() {
		logger.debug("row index" + rowIndex);
		logger.debug("number of rows in" + excelRead.getRowCount(sheetName));
		return (rowIndex <= excelRead.getRowCount(sheetName));
	}

	@Override
	public Object[] next() {
		List<String> lst = excelRead.getRowData(sheetName, rowIndex);
		if (classObject.equalsIgnoreCase("login")) {
			FacebookLogin _facebookLogin = new FacebookLogin();
			if (lst.size() > 0) {
				_facebookLogin.setUserLogin(lst.get(0));
				_facebookLogin.setUserPassword(lst.get(1));
				_facebookLogin.setIsValidUser(lst.get(2));
			}
			rowIndex++;
			return new Object[] { _facebookLogin };
		} else if (classObject.equalsIgnoreCase("SignUp")) {
			SignUpPage _signUpPage = new SignUpPage();
			if (lst.size() > 0) {
				_signUpPage.setFirstName(lst.get(0));
				_signUpPage.setLastName(lst.get(1));
				_signUpPage.setEmail(lst.get(2));
				_signUpPage.setNewPassword(lst.get(3));
				_signUpPage.setMonth(lst.get(4));
				_signUpPage.setDay(lst.get(5));
				_signUpPage.setYear(lst.get(6));
				_signUpPage.setGender(lst.get(7));
			}
			rowIndex++;
			return new Object[] { _signUpPage };
		}
		return null;

	}
}