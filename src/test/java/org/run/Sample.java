package org.run;

import java.awt.Window;

import org.help.BaseClass;
import org.help.PojoClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample extends BaseClass {
	PojoClass p;
	
	
	@BeforeClass
	private void openBrowser() {
   lanuchBrowse("chrome");
   lanuchUrl("https://www.cookiemanindia.com/");
	}

@Test
private void account() {
 p= new PojoClass();

 p.getAccount().click();
 
p.getCreateAcc().click();
 
}
	

@Parameters({"firstName","lastName"})
@Test
private void signupPage(String name,String last) {
WebElement e1 = p.getFirstName();
inputValues(e1, name);
WebElement e2 = p.getLastName();
inputValues(e2, last);


}


@Test(dataProvider="createAcc")
private void signupEmail(String mail,String pass) throws InterruptedException {
	threadSleep(2);

WebElement emailBox = p.getEmailBox();
inputValues(emailBox, mail);

WebElement passwordBox = p.getPasswordBox();
inputValues(passwordBox, pass);
	
}

@BeforeMethod
private void startTime() {
getDateAndTime();

}
@AfterMethod	
	private void endTime() {
getDateAndTime();
	}

@DataProvider(name="createAcc")
private Object[][] create() {
return new Object[][] {
	{ "jagadeshdhakshanamoorthy@outlook.com","Jaga@2503"} 
	
};






}

}	
	

	

