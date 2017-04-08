package by.htp.library.page;

import org.openqa.selenium.WebDriver;

public abstract class Page {
	protected final WebDriver driver;
	
	public Page(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebDriver getDriver()
	{
		return this.driver;
	}
}
