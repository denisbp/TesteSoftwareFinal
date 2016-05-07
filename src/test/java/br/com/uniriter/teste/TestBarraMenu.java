package br.com.uniriter.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import br.com.uniriter.teste.common.TestCommons;
import br.com.uniritter.teste.MenuPage;
import br.com.uniritter.teste.common.TestUtils;
import br.com.uniritter.teste.exception.NoSuchMenuException;

public class TestBarraMenu extends TestCommons {

	private MenuPage menuPage;
	
	@Before
	public void setUp() throws Exception {
		TestUtils.getDriver().get(TestUtils.URL_PAMPA);
		menuPage = new MenuPage();
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		TestUtils.killDriver();
	}
	
	@Test
	public void testClickMenuQuemSomos() throws Exception {
		menuPage.selectMenu(MenuPage.QUEM_SOMOS);
		assertEquals(MenuPage.QUEM_SOMOS_URL, TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testClickMenuPortfolio() throws Exception {
		menuPage.selectMenu(MenuPage.PORTFOLIO);
		assertEquals(MenuPage.PORTFOLIO_URL, TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testClickMenuProprietariosRurais() throws Exception {
		menuPage.selectMenu(MenuPage.PROPRIETARIOS_RURAIS);
		assertEquals(MenuPage.PROPRIETARIOS_RURAIS_URL, TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testClickMenuContato() throws Exception {
		menuPage.selectMenu(MenuPage.CONTATO);
		assertEquals(MenuPage.CONTATO_URL, TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testMenuProprietariosRuraisClickQueroFazerParte() throws Exception {
		menuPage.selectFazerParte();
		assertEquals(MenuPage.FAZER_PARTE_URL, TestUtils.getDriver().getCurrentUrl());
	}
	
	@Test(expected=NoSuchMenuException.class)
	public void testClickMenuInvalido() throws Exception {
		menuPage.selectMenu(5);
	}
}
