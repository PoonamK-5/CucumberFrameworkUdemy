package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObject.LandingPage;
import pageObject.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefination {

	public String offerPageProductname;
	TestContextSetup testContextSetup;

	public OffersPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String string) {
		OffersPage offersPage =testContextSetup.pageObjectManager.getOffersPage();	
		switchToOffersPage();
		offersPage.searchItem(string);
		offerPageProductname = offersPage.getProductName();
		System.out.println(offerPageProductname);
	}

	public void switchToOffersPage() {
		//if switched to offer page skip below part
		//if(testContextSetup.driver.getCurrentUrl("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		//PageObjectManager pageObjectManager = new PageObjectManager(testContextSetup.driver);
		LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
		landingPage.topDealsLink();
		testContextSetup.genericUtils.SwitchWindowToChild();
	}
	@Then("validate product name in Offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductname);
	}

}
