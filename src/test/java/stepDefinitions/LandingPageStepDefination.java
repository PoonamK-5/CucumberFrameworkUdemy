package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefination {
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		 this.landingPage= testContextSetup.pageObjectManager.getLandingPage();
	}
	@Given("User is on Greencart Landing page")
	public void user_is_on_greencart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	
	@When("^User searched wirh Shortname (.+) and extracted actual name of product$")
	public void user_searched_wirh_shortname_and_extracted_actual_name_of_product(String string) {
		
		landingPage.searchItem(string);	
		testContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName+" is extracted from home page");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void added_item_product(String count) throws InterruptedException
	{
		Thread.sleep(5000);
		landingPage.addItems(Integer.parseInt(count));
		landingPage.addToCart();
	}
	

}
