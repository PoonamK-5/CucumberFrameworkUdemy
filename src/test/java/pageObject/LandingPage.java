package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	private By search=By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	private By productName=By.xpath("//h4[normalize-space()='Tomato - 1 Kg']");
	private By topDealsLink=By.linkText("Top Deals");
	private By itemCount=By.cssSelector("a.increment");
	private By addToCart=By.cssSelector(".product-action button");
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName(){
		return driver.findElement(productName).getText();
	}
	
	public void topDealsLink() {
		driver.findElement(topDealsLink).click();
	}
	
	public String getTitleLandingPage() {
		return driver.getTitle();
	}
	
	public void addItems(int count) {
		for(int i=1;i<count;i++) {
			driver.findElement(itemCount).click();
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}
}

