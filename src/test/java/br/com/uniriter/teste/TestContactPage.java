package br.com.uniriter.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import br.com.uniriter.teste.common.TestCommons;
import br.com.uniritter.teste.ContactPage;
import br.com.uniritter.teste.MenuPage;
import br.com.uniritter.teste.common.TestUtils;

public class TestContactPage extends TestCommons {

	private MenuPage menuPage;
	private ContactPage contactPage;

	@Before
	public void setUp() throws Exception {
		TestUtils.getDriver().get(TestUtils.URL_PAMPA);
		menuPage = new MenuPage();
		menuPage.selectMenu(MenuPage.CONTATO);
		contactPage = new ContactPage();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		TestUtils.killDriver();
	}

	@Test
	public void testSendContactAllEmptyFields() throws Exception {
		contactPage.sendMessage();
		assertEquals(ContactPage.ERROR_MESSAGE_NAME, contactPage.getErrorName());
		assertEquals(ContactPage.ERROR_MESSAGE_LOCATION, contactPage.getErrorLocation());
		assertEquals(ContactPage.ERROR_MESSAGE_EMAIL, contactPage.getErrorEmail());
		assertEquals(ContactPage.ERROR_MESSAGE_MESSAGE, contactPage.getErrorMessage());
	}

	/*
	@Test
	public void testSendContactEmptyFieldEmail() throws Exception {
		contactPage.setName("Nome de Teste");
		contactPage.setLocation("Localidade Teste");
		contactPage.setMessage("Mensagem de Teste, por favor, ignore.");
		contactPage.sendMessage();
		assertEquals(ContactPage.ERROR_MESSAGE_EMAIL, contactPage.getErrorEmail());
	}
	*/

	@Test
	public void testSendContactEmptyFieldLocation() throws Exception {
		contactPage.setName("Nome de Teste");
		contactPage.setEmail("email@testemail.tst");
		contactPage.setMessage("Mensagem de Teste, por favor, ignore.");
		contactPage.sendMessage();
		assertEquals(ContactPage.ERROR_MESSAGE_LOCATION, contactPage.getErrorLocation());
	}

	@Test
	public void testSendContactEmptyFieldName() throws Exception {
		contactPage.setLocation("Localidade Teste");
		contactPage.setEmail("email@testemail.tst");
		contactPage.setMessage("Mensagem de Teste, por favor, ignore.");
		contactPage.sendMessage();
		assertEquals(ContactPage.ERROR_MESSAGE_NAME, contactPage.getErrorName());
	}

	@Test
	public void testSendContactSuccess() throws Exception {
		contactPage.setName("Nome de Teste");
		contactPage.setLocation("Localidade Teste");
		contactPage.setEmail("email@testemail.tst");
		contactPage.setMessage("Mensagem de Teste, por favor, ignore.");
		contactPage.sendMessage();
		contactPage = new ContactPage(); //inicializando elementos apos o refresh
		assertEquals("", contactPage.getName());
		assertEquals("", contactPage.getLocation());
		assertEquals("", contactPage.getEmail());
		assertEquals("", contactPage.getMessage());
		assertEquals("", contactPage.getErrorName());
	}
}
