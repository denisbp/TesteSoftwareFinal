package br.com.uniritter.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.uniritter.teste.common.PageCommon;
import br.com.uniritter.teste.common.TestUtils;
import br.com.uniritter.teste.exception.NoSuchLanguageException;

public class MainPage extends PageCommon {

	private WebElement logoHomePage;
	private WebElement englishFlag;
	private WebElement spanishFlag;
	
	public static final String HOME_PAGE_URL = "http://www.pampaeolica.com.br/";
	public static final String HOME_PAGE_ENGLISH_URL = "http://www.pampaeolica.com.br/en/";
	public static final String HOME_PAGE_SPANISH_URL = "http://www.pampaeolica.com.br/es/";
	
	public static final int ENGLISH = 1;
	public static final int SPANISH = 2;
	
	public MainPage() {
		logoHomePage = TestUtils.getDriver().findElement(By.cssSelector("img[alt=\"Renobrax - Energias Renováveis\"]"));
		englishFlag = TestUtils.getDriver().findElement(By.id("traducao_1"));
		spanishFlag = TestUtils.getDriver().findElement(By.id("traducao_2"));
	}
	
	public void clickLogo() {
		logoHomePage.click();
	}
	
	public void changeLanguage(int language) throws NoSuchLanguageException {
		if (language == ENGLISH) {
			englishFlag.click();
		} else if (language == SPANISH) {
			spanishFlag.click();
		} else {
			throw new NoSuchLanguageException("Tradução não suportada. Código: " + language);
		}
	}
}
