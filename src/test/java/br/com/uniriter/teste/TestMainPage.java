package br.com.uniriter.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.uniriter.teste.common.TestCommons;
import br.com.uniriter.teste.common.TestUtils;

public class TestMainPage extends TestCommons {

	@Before
	public void setUp() throws Exception {
		TestUtils.getDriver().get(TestUtils.URL_PAMPA);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		TestUtils.killDriver();
	}

	@Test
	public void testClickLogoHomePage() throws Exception {
		TestUtils.getDriver().findElement(By.cssSelector("li.quem_somos > a > img")).click();
		TestUtils.getDriver().findElement(By.cssSelector("img[alt=\"Renobrax - Energias Renováveis\"]")).click();
		assertEquals("http://www.pampaeolica.com.br/", TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testChangeLanguageEnglish() throws Exception {
		TestUtils.getDriver().findElement(By.id("traducao_1")).click();
		assertEquals("http://www.pampaeolica.com.br/en/", TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testChangeLanguageSpanish() throws Exception {
		TestUtils.getDriver().findElement(By.id("traducao_2")).click();
		assertEquals("http://www.pampaeolica.com.br/es/", TestUtils.getDriver().getCurrentUrl());
	}
}
