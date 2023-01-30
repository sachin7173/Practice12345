package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(xpath="//input[@id='login_field']")private WebElement UN;
@FindBy(xpath="//input[@id='password']")private WebElement PWD;
@FindBy(xpath="//input[@name='commit']")private WebElement loginbtn;

public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void username2(String username) {
	UN.sendKeys(username);
}
public void password2(String password) {
	PWD.sendKeys(password);
}
public void loginbtn() {
	loginbtn.click();
}
}
