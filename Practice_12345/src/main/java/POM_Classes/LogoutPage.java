package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy(xpath="//button[contains(text(),'Sign out')]")private WebElement logoutbtn;
	
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public void logoutbtn() {
		logoutbtn.click();
	}
}
