package by.htp.library.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.library.dao.BookDao;
import by.htp.library.dao.BookDaoImpl;
import by.htp.library.domain.Book;


public class BestsellerPage extends Page{
	
	private final String URL = "https://oz.by/books/bestsellers";
	
	public BestsellerPage(WebDriver driver) {
		super(driver);
	}

	
	public void open() throws InterruptedException {
		getDriver().get(URL);
		Thread.sleep(1000);
	}
	
	public void search() throws InterruptedException
	{
		List <WebElement> list = new ArrayList <WebElement>();
		list = getDriver().findElement(By.id("goods-table")).findElements(By.cssSelector("li.viewer-type-card__li:not(.pg-element-preloaded)"));
	
		for (int i = 0; i < list.size(); i++){
			String title = list.get(i).findElement(By.xpath(".//p[@class = 'item-type-card__title']")).getText();
			String author = list.get(i).findElement(By.xpath(".//p[@class = 'item-type-card__info']")).getText();
			String priceStr = list.get(i).findElement(By.xpath(".//span[@class = 'item-type-card__btn']")).getText();
			String oneprice = priceStr.split(" ")[0].replace(',', '.');
			double price = Double.parseDouble(oneprice);
			String src = list.get(i).findElement(By.xpath(".//img")).getAttribute("src");	
			Book book = new Book();
			book.setTitle(title);
			book.setAuthor(author);
			book.setPrice(price);
			book.setSrc(src);
			BookDao bd = new BookDaoImpl();
			bd.addBook(book);			
		}
	}
}
