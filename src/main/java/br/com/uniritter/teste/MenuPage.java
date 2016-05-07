package br.com.uniritter.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.uniritter.teste.common.PageCommon;
import br.com.uniritter.teste.common.TestUtils;
import br.com.uniritter.teste.exception.NoSuchMenuException;

public class MenuPage extends PageCommon {

	private WebElement menuQuemSomos;
	private WebElement menuPortfolio;
	private WebElement menuProprietariosRurais;
	private WebElement menuContato;
	
	public static final int QUEM_SOMOS = 1;
	public static final int PORTFOLIO = 2;
	public static final int PROPRIETARIOS_RURAIS = 3;
	public static final int CONTATO = 4;
	
	public static final String QUEM_SOMOS_URL = "http://www.pampaeolica.com.br/quem-somos.php";
	public static final String PORTFOLIO_URL = "http://www.pampaeolica.com.br/portfolio.php";
	public static final String PROPRIETARIOS_RURAIS_URL = "http://www.pampaeolica.com.br/proprietarios-rurais.php";
	public static final String CONTATO_URL = "http://www.pampaeolica.com.br/contato.php";
	public static final String FAZER_PARTE_URL = "http://www.pampaeolica.com.br/quero-fazer-parte.php";
		
	public MenuPage() {
		menuQuemSomos = TestUtils.getDriver().findElement(By.cssSelector("li.quem_somos > a > img"));
		menuPortfolio = TestUtils.getDriver().findElement(By.cssSelector("li.portfolio > a > img"));
		menuProprietariosRurais = TestUtils.getDriver().findElement(By.xpath("//ul[@id='menu']/li[3]/a"));
		menuContato = TestUtils.getDriver().findElement(By.cssSelector("li.contato > a > img"));
	}
	
	public void selectMenu(int menu) throws NoSuchMenuException {
		if (menu == QUEM_SOMOS) {
			menuQuemSomos.click();
		} else if (menu == PORTFOLIO) {
			menuPortfolio.click();
		} else if (menu == PROPRIETARIOS_RURAIS) {
			menuProprietariosRurais.click();
		} else if (menu == CONTATO) {
			menuContato.click();
		} else {
			throw new NoSuchMenuException("Menu Inexistente. Código: " + menu);
		}
	}
	
	public void selectFazerParte() {
		menuProprietariosRurais.click();
		WebElement logoFazerParte = TestUtils.getDriver().findElement(By.cssSelector("#box_1 > a > img"));
		logoFazerParte.click();
	}
}
