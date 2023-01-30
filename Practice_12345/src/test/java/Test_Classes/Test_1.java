package Test_Classes;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes.BaseClass;
import POM_Classes.HomePage;
import POM_Classes.LoginPage;
import POM_Classes.LogoutPage;
import POM_Classes.SigninPage;
import POM_Classes.UtilityClass;

public class Test_1 extends BaseClass{

	SigninPage signin;
	LoginPage login;
	HomePage home;
	LogoutPage logout;
	@BeforeClass
	public void openBrowser2() throws IOException {
		openBrowser();
		signin=new SigninPage(driver);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		logout=new LogoutPage(driver);
	}
	@BeforeMethod
	public void login2() throws IOException, InterruptedException {
		signin.signinbtn();
		login.username2(UtilityClass.getPrpertyFileData("username"));
		login.password2(UtilityClass.getPrpertyFileData("password"));
		login.loginbtn();
		Thread.sleep(2000);
		home.accountbtn();
	}
	@Test
	public void verifyusername() throws IOException {
		String expResult = UtilityClass.getPrpertyFileData("username1");
		String actResult = home.verifyusername2();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actResult, expResult,"act and exp result is different");
		soft.assertAll();
	}
	@AfterMethod
	public void logout2(ITestResult result) throws IOException, InterruptedException {
		if(result.getStatus()==ITestResult.FAILURE) {
			int TCID=7679;
			UtilityClass.CaptureScreenshot(driver, TCID);
			Thread.sleep(2000);
		}logout.logoutbtn();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
