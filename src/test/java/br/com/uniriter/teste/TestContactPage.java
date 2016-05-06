package br.com.uniriter.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.uniriter.teste.common.TestCommons;
import br.com.uniriter.teste.common.TestUtils;

public class TestContactPage extends TestCommons {

	@Before
	public void setUp() throws Exception {
		TestUtils.getDriver().get(TestUtils.URL_PAMPA);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		TestUtils.killDriver();
	}

	@Test
	public void testSendContactAllEmptyFields() throws Exception {
		TestUtils.getDriver().findElement(By.cssSelector("li.contato > a > img")).click();
		TestUtils.getDriver().findElement(By.id("btn_enviar")).click();
		assertEquals("Informe o nome", TestUtils.getDriver().findElement(By.cssSelector("label.error")).getText());
		assertEquals("Informe sua localidade",
				TestUtils.getDriver().findElement(By.xpath("//table[@id='tbl_proprietarios']/tbody/tr[2]/td/label")).getText());
		assertEquals("Informe seu E-mail",
				TestUtils.getDriver().findElement(By.xpath("//table[@id='tbl_proprietarios']/tbody/tr[3]/td/label")).getText());
		assertEquals("Digite uma mensagem",
				TestUtils.getDriver().findElement(By.xpath("//table[@id='tbl_proprietarios']/tbody/tr[4]/td/label")).getText());
	}

	@Test
	public void testSendContactEmptyFieldEmail() throws Exception {
		TestUtils.getDriver().findElement(By.cssSelector("li.contato > a > img")).click();
		TestUtils.getDriver().findElement(By.id("txt_nome")).clear();
		TestUtils.getDriver().findElement(By.id("txt_nome")).sendKeys("Nome de Teste");
		TestUtils.getDriver().findElement(By.id("txt_localidade_v")).clear();
		TestUtils.getDriver().findElement(By.id("txt_localidade_v")).sendKeys("Localidade Teste");
		TestUtils.getDriver().findElement(By.id("txta_mensagem")).clear();
		TestUtils.getDriver().findElement(By.id("txta_mensagem")).sendKeys("Mensagem de Teste, por favor, ignore.");
		TestUtils.getDriver().findElement(By.id("btn_enviar")).click();
		assertEquals("Informe seu E-mail", TestUtils.getDriver().findElement(By.cssSelector("label.error")).getText());
	}

	@Test
	public void testSendContactEmptyFieldLocation() throws Exception {
		TestUtils.getDriver().findElement(By.cssSelector("li.contato > a")).click();
		TestUtils.getDriver().findElement(By.id("txt_nome")).clear();
		TestUtils.getDriver().findElement(By.id("txt_nome")).sendKeys("Nome de Teste");
		TestUtils.getDriver().findElement(By.id("txt_email")).clear();
		TestUtils.getDriver().findElement(By.id("txt_email")).sendKeys("email@testemail.tst");
		TestUtils.getDriver().findElement(By.id("txta_mensagem")).clear();
		TestUtils.getDriver().findElement(By.id("txta_mensagem")).sendKeys("Mensagem de Teste, por favor, ignore.");
		TestUtils.getDriver().findElement(By.id("btn_enviar")).click();
		assertEquals("Informe sua localidade", TestUtils.getDriver().findElement(By.cssSelector("label.error")).getText());
	}

	@Test
	public void testSendContactEmptyFieldName() throws Exception {
		TestUtils.getDriver().findElement(By.cssSelector("li.contato > a > img")).click();
		TestUtils.getDriver().findElement(By.id("txt_localidade_v")).clear();
		TestUtils.getDriver().findElement(By.id("txt_localidade_v")).sendKeys("Localidade Teste");
		TestUtils.getDriver().findElement(By.id("txt_email")).clear();
		TestUtils.getDriver().findElement(By.id("txt_email")).sendKeys("email@testemail.tst");
		TestUtils.getDriver().findElement(By.id("txta_mensagem")).clear();
		TestUtils.getDriver().findElement(By.id("txta_mensagem")).sendKeys("Mensagem de Teste, por favor, ignore.");
		TestUtils.getDriver().findElement(By.id("btn_enviar")).click();
		assertEquals("Informe o nome", TestUtils.getDriver().findElement(By.cssSelector("label.error")).getText());
	}

	@Test
	public void testSendContactSuccess() throws Exception {
		TestUtils.getDriver().findElement(By.cssSelector("li.contato > a > img")).click();
		TestUtils.getDriver().findElement(By.id("txt_nome")).clear();
		TestUtils.getDriver().findElement(By.id("txt_nome")).sendKeys("Nome de Teste");
		TestUtils.getDriver().findElement(By.id("txt_localidade_v")).clear();
		TestUtils.getDriver().findElement(By.id("txt_localidade_v")).sendKeys("Localidade Teste");
		TestUtils.getDriver().findElement(By.id("txt_email")).clear();
		TestUtils.getDriver().findElement(By.id("txt_email")).sendKeys("email@testemail.tst");
		TestUtils.getDriver().findElement(By.id("txta_mensagem")).clear();
		TestUtils.getDriver().findElement(By.id("txta_mensagem")).sendKeys("Mensagem de Teste, por favor, ignore.");
		TestUtils.getDriver().findElement(By.id("btn_enviar")).click();
		assertEquals("", TestUtils.getDriver().findElement(By.id("txt_nome")).getText());
		assertEquals("", TestUtils.getDriver().findElement(By.id("txt_localidade_v")).getText());
		assertEquals("", TestUtils.getDriver().findElement(By.id("txt_email")).getText());
		assertEquals("", TestUtils.getDriver().findElement(By.id("txta_mensagem")).getText());
		assertFalse(isElementPresent(By.cssSelector("label.error")));
	}
}
