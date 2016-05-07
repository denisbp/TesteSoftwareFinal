package br.com.uniriter.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import br.com.uniriter.teste.common.TestCommons;
import br.com.uniritter.teste.MenuPage;
import br.com.uniritter.teste.MainPage;
import br.com.uniritter.teste.common.TestUtils;
import br.com.uniritter.teste.exception.NoSuchLanguageException;

public class TestMainPage extends TestCommons {
	
	private MainPage mainPage;
	private MenuPage menuPage;

	@Before
	public void setUp() throws Exception {
		TestUtils.getDriver().get(TestUtils.URL_PAMPA);
		mainPage = new MainPage();
		menuPage = new MenuPage();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		TestUtils.killDriver();
	}

	@Test
	public void testClickLogoHomePage() throws Exception {
		menuPage.selectMenu(MenuPage.QUEM_SOMOS);
		mainPage = new MainPage();
		mainPage.clickLogo();
		assertEquals(MainPage.HOME_PAGE_URL, TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testChangeLanguageEnglish() throws Exception {
		mainPage.changeLanguage(MainPage.ENGLISH);
		assertEquals(MainPage.HOME_PAGE_ENGLISH_URL, TestUtils.getDriver().getCurrentUrl());
	}

	@Test
	public void testChangeLanguageSpanish() throws Exception {
		mainPage.changeLanguage(MainPage.SPANISH);
		assertEquals(MainPage.HOME_PAGE_SPANISH_URL, TestUtils.getDriver().getCurrentUrl());
	}
	
	@Test(expected=NoSuchLanguageException.class)
	public void testChangeLanguageInvalidOption() throws Exception {
		mainPage.changeLanguage(3);
	}
}
