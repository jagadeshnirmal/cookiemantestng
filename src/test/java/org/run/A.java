package org.run;

import org.help.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class A extends BaseClass{

	@Parameters("browser")
	@Test
	private void tc1(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriver d= new ChromeDriver();			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriver d= new FirefoxDriver();
			}
		else {
			
			WebDriver d= new EdgeDriver();
		}

	}

}
