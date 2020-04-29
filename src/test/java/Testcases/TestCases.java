package Testcases;



import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProfilePage;

public class TestCases extends BaseTest{

	
	public void testRegisterationSucessfully() {
		registerPage.setFristName("Mmahmouddddddd");
		registerPage.setLastName("Hhameddddddd");
		registerPage.setPhoneNumber("01020322460");
		registerPage.setEmail("test00@test.com");
		registerPage.setPassword("P@ssw0rd");
		registerPage.setConfirmPassword("P@ssw0rd");
		ProfilePage profilePage = registerPage.clickSignUpButton();
		assertEquals(profilePage.getProfileName(),"Hi, Mmahmouddddddd Hhameddddddd","Incorrect Text");
	}
	
	
	public void testConfirmPasswordValidation() {
		registerPage.setFristName("Ahmedd");
		registerPage.setLastName("Ahmmed");
		registerPage.setPhoneNumber("01020322460");
		registerPage.setEmail("test6@test.com");
		registerPage.setPassword("P@ssw0rd");
		registerPage.setConfirmPassword("P@ssw0rddddd");
		registerPage.clickSignUpButtonForValidation();
		registerPage.implicitWaitValidation();
		assertEquals(registerPage.getValidationMessageText(),"Password not matching with confirm password.", "Incorrect Validation Text");
	}
	
	public void testFirstNameNotEquallastName() {
		registerPage.setFristName("Name");
		registerPage.setLastName("Name");
		registerPage.setPhoneNumber("01020322460");
		registerPage.setEmail("test99@test.com");
		registerPage.setPassword("P@ssw0rd");
		registerPage.setConfirmPassword("P@ssw0rd");
		registerPage.clickSignUpButtonForValidation();
		registerPage.implicitWaitValidation();
		assertEquals(registerPage.getValidationMessageText(),"First Name Should not equal lastname", "Incorrect Validation Text");
	}
	
	public void testFirstNameSmalLetterValidation() {
		registerPage.setFristName("name");
		registerPage.setLastName("Name");
		registerPage.setPhoneNumber("01020322460");
		registerPage.setEmail("test99@test.com");
		registerPage.setPassword("P@ssw0rd");
		registerPage.setConfirmPassword("P@ssw0rd");
		registerPage.clickSignUpButtonForValidation();
		registerPage.implicitWaitValidation();
		assertEquals(registerPage.getValidationMessageText(),"First Name Should Start With Capital letter", "Incorrect Validation Text");
	}
	
	public void testLastNameSmalLetterValidation() {
		registerPage.setFristName("Name");
		registerPage.setLastName("name");
		registerPage.setPhoneNumber("01020322460");
		registerPage.setEmail("test99@test.com");
		registerPage.setPassword("P@ssw0rd");
		registerPage.setConfirmPassword("P@ssw0rd");
		registerPage.clickSignUpButtonForValidation();
		registerPage.implicitWaitValidation();
		assertEquals(registerPage.getValidationMessageText(),"Last Name should Start With Capital letter", "Incorrect Validation Text");
	}
	
	
	public void testInvalidEmailValidation() {
		registerPage.setFristName("Name");
		registerPage.setLastName("Asdkjfhk");
		registerPage.setPhoneNumber("01020322460");
		registerPage.setEmail("dfgsdjkfhksajfh");
		registerPage.setPassword("P@ssw0rd");
		registerPage.setConfirmPassword("P@ssw0rd");
		registerPage.clickSignUpButtonForValidation();
		registerPage.implicitWaitValidation();
		assertEquals(registerPage.getValidationMessageText(),"The Email field must contain a valid email address.", "Incorrect Validation Text");
	}
	
	public void testInvalidMobileNumberValidation() {
		registerPage.setFristName("Name");
		registerPage.setLastName("Looool");
		registerPage.setPhoneNumber("03423dfssd");
		registerPage.setEmail("test100000@test.com");
		registerPage.setPassword("P@ssw0rd");
		registerPage.setConfirmPassword("P@ssw0rd");
		registerPage.clickSignUpButtonForValidation();
		registerPage.implicitWaitValidation();
		assertEquals(registerPage.getValidationMessageText(),"The Mobile Number field must contain a valid Mobile Number.", "Incorrect Validation Text");
	}
	
	public void testPasswordWithNoCapitalLetterValidation() {
		registerPage.setFristName("Name");
		registerPage.setLastName("Looool");
		registerPage.setPhoneNumber("03423dfssd");
		registerPage.setEmail("test100000@test.com");
		registerPage.setPassword("p@ssw0rd");
		registerPage.setConfirmPassword("p@ssw0rd");
		registerPage.clickSignUpButtonForValidation();
		registerPage.implicitWaitValidation();
		assertEquals(registerPage.getValidationMessageText(),"The Password field must contain a Capital Letter", "Incorrect Validation Text");
	}
	
	public void testPasswordMOREThanEightCharValidation() {
		registerPage.setFristName("Name");
		registerPage.setLastName("Looool");
		registerPage.setPhoneNumber("03423dfssd");
		registerPage.setEmail("test100000@test.com");
		registerPage.setPassword("aaReeeeeee");
		registerPage.setConfirmPassword("aaReeeeeee");
		registerPage.clickSignUpButtonForValidation();
		registerPage.implicitWaitValidation();
		assertEquals(registerPage.getValidationMessageText(),"The Password field must be at least 6 characters in length.", "Incorrect Validation Text");
	}

	

	
	
	}
