package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CheckoutPage;
import pageObject.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefination {
	TestContextSetup testContextSetup;
	CheckoutPage checkoutPage;
	String checkoutPageProductName;
	
	public CheckoutPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.checkoutPage=testContextSetup.pageObjectManager.checkoutPage();
	}
	
	@Then("Check user has ability to enter promo code and place the order")
	public void Check_user_has_ability_to_enter_promo() throws InterruptedException {	

		Thread.sleep(5000);
		Assert.assertTrue(checkoutPage.verifyPromoBtn());	
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());
	}
	
	@Then("^User proceed to checkout and validate the (.+) items in checkout page$")
	public void proceed_to_checkout(String string) {
		checkoutPage.checkoutItem();
		checkoutPageProductName=checkoutPage.getProductName();
		
		Assert.assertTrue(checkoutPageProductName.contains(string));
	}
	
	
}
