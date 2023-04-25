package commonFunctions;



import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;



public class LoginPage {

//define repository for login

@FindBy(xpath = "//input[@id='txtUsername']")

WebElement EnterUser;

@FindBy(name="txtPassword")

WebElement Enterpass;

@FindBy(xpath = "//input[@id='btnLogin']")

WebElement ClickLogin;

//method for login

public void verify_Login(String username,String password)

{

EnterUser.sendKeys(username);

Enterpass.sendKeys(password);

ClickLogin.click();

}

}




