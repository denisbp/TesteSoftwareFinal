package br.com.uniritter.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import br.com.uniritter.teste.common.PageCommon;
import br.com.uniritter.teste.common.TestUtils;

public class ContactPage extends PageCommon {

	private WebElement buttonSend;
	
	private WebElement textBoxName;
	private WebElement textBoxLocation;
	private WebElement textBoxEmail;
	private WebElement textBoxMessage;
	
	public static final String ERROR_MESSAGE_NAME = "Informe o nome";
	public static final String ERROR_MESSAGE_LOCATION = "Informe sua localidade";
	public static final String ERROR_MESSAGE_EMAIL = "Informe seu E-mail";
	public static final String ERROR_MESSAGE_MESSAGE = "Digite uma mensagem";
	

	public ContactPage() {
		buttonSend = TestUtils.getDriver().findElement(By.id("btn_enviar"));
		
		textBoxName = TestUtils.getDriver().findElement(By.id("txt_nome"));
		textBoxLocation = TestUtils.getDriver().findElement(By.id("txt_localidade_v"));
		textBoxEmail = TestUtils.getDriver().findElement(By.id("txt_email"));
		textBoxMessage = TestUtils.getDriver().findElement(By.id("txta_mensagem"));
	}
	
	public void sendMessage() {
		buttonSend.click();
	}
	
	public void setName(String name) {
		textBoxName.clear();
		textBoxName.sendKeys(name);;
	}
	
	public String getName() {
		return textBoxName.getText();
	}
	
	public void setLocation(String location) {
		textBoxLocation.clear();
		textBoxLocation.sendKeys(location);;
	}
	
	public String getLocation() {
		return textBoxLocation.getText();
	}
	
	public void setEmail(String email) {
		textBoxEmail.clear();
		textBoxEmail.sendKeys(email);;
	}
	
	public String getEmail() {
		return textBoxEmail.getText();
	}
	
	public void setMessage(String message) {
		textBoxMessage.clear();
		textBoxMessage.sendKeys(message);;
	}
	
	public String getMessage() {
		return textBoxMessage.getText();
	}
	
	public String getErrorName() {
		String msg = "";
		if ("".equals(textBoxName.getText())) {
			try {
				WebElement labelErrorName = TestUtils.getDriver().findElement(By.cssSelector("label.error"));
				msg = labelErrorName.getText();
			} catch (NoSuchElementException e) {
				return "";
			}
		}
		return msg;
	}
	
	public String getErrorLocation() {
		String msg = "";
		if ("".equals(textBoxLocation.getText())) {
			try {
				WebElement labelErrorLocation;
				if ("".equals(getErrorName())) {
					labelErrorLocation = TestUtils.getDriver().findElement(By.cssSelector("label.error"));
				} else {
					labelErrorLocation = TestUtils.getDriver().findElement(By.xpath("//table[@id='tbl_proprietarios']/tbody/tr[2]/td/label"));
				}
				msg = labelErrorLocation.getText();
			} catch (NoSuchElementException e) {
				return "";
			}
		}
		return msg;
	}
	
	public String getErrorEmail() {
		String msg = "";
		if ("".equals(textBoxEmail.getText())) {
			try {
				WebElement labelErrorEmail;
				if ("".equals(getErrorName())) {
					labelErrorEmail = TestUtils.getDriver().findElement(By.cssSelector("label.error"));
				} else if ("".equals(getErrorLocation())) {
					labelErrorEmail = TestUtils.getDriver().findElement(By.xpath("//table[@id='tbl_proprietarios']/tbody/tr[2]/td/label"));
				} else {
					labelErrorEmail = TestUtils.getDriver().findElement(By.xpath("//table[@id='tbl_proprietarios']/tbody/tr[3]/td/label"));
				}
				msg = labelErrorEmail.getText();
			} catch (NoSuchElementException e) {
				return "";
			}
		}
		return msg;
	}
	
	public String getErrorMessage() {
		String msg = "";
		if ("".equals(textBoxMessage.getText())) {
			try {
				WebElement labelErrorMessage;
				if ("".equals(getErrorName())) {
					labelErrorMessage = TestUtils.getDriver().findElement(By.cssSelector("label.error"));
				} else if ("".equals(getErrorLocation())) {
					labelErrorMessage = TestUtils.getDriver().findElement(By.xpath("//table[@id='tbl_proprietarios']/tbody/tr[2]/td/label"));
				} else if ("".equals(getErrorEmail())) {
					labelErrorMessage = TestUtils.getDriver().findElement(By.xpath("//table[@id='tbl_proprietarios']/tbody/tr[3]/td/label"));
				} else {
					labelErrorMessage = TestUtils.getDriver().findElement(By.xpath("//table[@id='tbl_proprietarios']/tbody/tr[4]/td/label"));
				}
				msg = labelErrorMessage.getText();
			} catch (NoSuchElementException e) {
				return "";
			}
		}
		return msg;
	}

}
