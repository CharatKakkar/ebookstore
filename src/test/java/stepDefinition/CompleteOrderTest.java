/**
 * 
 */
package stepDefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.utility.TestHelper;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjectModel.CartPageObject;
import pageObjectModel.HeaderPageObject;
import pageObjectModel.HomePageObject;
import pageObjectModel.LoginPageObject;
import pageObjectModel.OrderCheckoutPageObject;
import pageObjectModel.ProductsPageObject;

/**
 * @author charat
 *
 */
public class CompleteOrderTest {

	private WebDriver driver;

	private Boolean error = Boolean.FALSE;

	private String errstr = "";

	private LoginPageObject loginPageObject;
	private ProductsPageObject productsPageObject;
	private HomePageObject homePageObject;
	private HeaderPageObject headerPageObject;
	private CartPageObject cartPageObject;
	private OrderCheckoutPageObject orderCheckoutPageObject;

	@Before
	public void setUp() {
		driver = TestHelper.getSetUp().getDriver();
		loginPageObject = new LoginPageObject(driver);
		productsPageObject = new ProductsPageObject(driver);
		homePageObject = new HomePageObject(driver);
		headerPageObject = new HeaderPageObject(driver);
		cartPageObject = new CartPageObject(driver);
		orderCheckoutPageObject = new OrderCheckoutPageObject(driver);

		// super.shutdownHook(driver);
	}

	@Given("^Login URL and login credentials \"([^\"]*)\" \"([^\"]*)\"$")
	public void login_URL_and_login_credentials(String arg1, String arg2) {
		homePageObject.loginLink();
		loginPageObject.enterUsername(arg1);
		loginPageObject.enterPassword(arg2);
		loginPageObject.clickLogin();
	}

	@Then("^Add some products into the cart$")
	public void add_some_products_into_the_cart() throws InterruptedException {
		// Thread.sleep(3000);
		homePageObject.productPageClick();
		// Thread.sleep(3000);
		productsPageObject.firstProductClick();
		// Thread.sleep(3000);
		productsPageObject.orderNowButtonClick();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		headerPageObject.productsButtonClick();
		productsPageObject.getProductAtPosition(4);
		productsPageObject.orderNowButtonClick();
		Thread.sleep(2000);
		alert.accept();

	}
	

@Then("^Click on cart and verify the total$")
public void click_on_cart_and_verify_the_total()  {
	headerPageObject.cartButtonClick();
}


	@Then("^Click on check out$")
	public void click_on_check_out() {
		cartPageObject.checkoutButtonClick();
	}

	@Then("^Verify the details are present for Shipping and Billing Address$")
	public void verify_the_details_are_present_for_Shipping_and_Billing_Address() {

		orderCheckoutPageObject.nextDetailsClick();
	}

	@Then("^Submit the order Verify that Order ID is display at thank you page$")
	public void submit_the_order_Verify_that_Order_ID_is_display_at_thank_you_page() {

		orderCheckoutPageObject.fillCreditCardInfo();
		orderCheckoutPageObject.submitClick();
	}

}
