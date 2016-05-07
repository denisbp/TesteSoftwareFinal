package br.com.uniritter.teste.common;

public class PageCommon {

	String title;

	public PageCommon() {
		title = TestUtils.getDriver().getTitle();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
