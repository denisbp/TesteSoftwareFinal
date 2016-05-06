package br.com.uniriter.teste.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestUtils {
	private static WebDriver driver;
	public static final String URL_PAMPA = "http://www.pampaeolica.com.br/";

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static void killDriver() {
		driver.quit();
		driver = null;
	}
}
