package by.htp.library.page;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SmokeTest {

	private WebDriver driver;
	
	
	@Before
	public void initBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() throws InterruptedException {
		BestsellerPage bp = new BestsellerPage(driver);
		bp.open();
		bp.search();
	}
	
	
	@After
	public void destroyBrowser()
	{
		driver.quit();
	}
	

}
