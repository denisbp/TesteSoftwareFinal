package br.com.uniriter.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.uniriter.teste.common.TestCommons;
import br.com.uniriter.teste.common.TestUtils;

public class TestBarraMenu extends TestCommons {

	@Before
	public void setUp() throws Exception {
		TestUtils.getDriver().get(TestUtils.URL_PAMPA);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		TestUtils.killDriver();
	}
	
	@Test
	public void testClickMenuQuemSomos() throws Exception {
		TestUtils.getDriver().findElement(By.cssSelector("li.quem_somos > a > img")).click();
		assertEquals("http://www.pampaeolica.com.br/quem-somos.php", TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testClickMenuPortfolio() throws Exception {
		TestUtils.getDriver().findElement(By.cssSelector("li.portfolio > a > img")).click();
		assertEquals("http://www.pampaeolica.com.br/portfolio.php", TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testClickMenuProprietariosRurais() throws Exception {
		TestUtils.getDriver().findElement(By.xpath("//ul[@id='menu']/li[3]/a")).click();
		assertEquals("http://www.pampaeolica.com.br/proprietarios-rurais.php", TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testClickMenuContato() throws Exception {
		TestUtils.getDriver().findElement(By.cssSelector("li.contato > a > img")).click();
		assertEquals("http://www.pampaeolica.com.br/contato.php", TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testMenuProprietariosRuraisClickQueroFazerParte() throws Exception {
		TestUtils.getDriver().findElement(
				By.xpath("//img[contains(@src,'http://www.pampaeolica.com.br/imagens/m-proprietarios-rurais.jpg')]"))
				.click();
		TestUtils.getDriver().findElement(By.cssSelector("#box_1 > a > img")).click();
		assertEquals("http://www.pampaeolica.com.br/quero-fazer-parte.php", TestUtils.getDriver().getCurrentUrl());
	}
}
