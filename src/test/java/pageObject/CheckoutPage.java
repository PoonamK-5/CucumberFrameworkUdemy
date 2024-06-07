package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}

	private By promoBtn=By.cssSelector(".promoBtn");
	private By checkoutButton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By catyBag=By.cssSelector("img[alt='Cart']");
	private By placeOrder=By.xpath("//button[contains(text(),'Place Order')]");
	private By productName=By.xpath("//p[@class='product-name']");
	
	public void checkoutItem() {
		driver.findElement(catyBag).click();
		driver.findElement(checkoutButton).click();
	}
	
	public boolean verifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean verifyPlaceOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	public String getProductName(){
		return driver.findElement(productName).getText();
	}
		
	
	
}

