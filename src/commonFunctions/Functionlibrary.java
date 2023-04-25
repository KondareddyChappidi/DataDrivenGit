package commonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class Functionlibrary extends AppUtil {
	
	public static boolean verify_Login(String user,String pass)

	{

		driver.get(conpro.getProperty("Url"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.findElement(By.xpath(conpro.getProperty("ObjUser"))).sendKeys(user);

		driver.findElement(By.xpath(conpro.getProperty("ObjPass"))).sendKeys(pass);

		driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).click();

		String Expected ="dashboard";

		String Actual= driver.getCurrentUrl();

		if(Actual.contains(Expected))

		{

			Reporter.log("Login Success::"+Expected+"     "+Actual,true);

			return true;

		}

		else

		{

			String Error_Message = driver.findElement(By.xpath(conpro.getProperty("ObjError"))).getText();

			Reporter.log(Error_Message+"  "+Expected+"     "+Actual,true);

			return false;

		}

	}

}


