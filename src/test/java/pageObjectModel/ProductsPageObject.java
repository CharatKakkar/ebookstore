package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPageObject {

	WebDriver driver;
	
	public ProductsPageObject(WebDriver driver){
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="itemnum1")
	//@FindBy(id="productList")
	WebElement firstItem;
	
	@FindBy(xpath= "//*[@id='productList_length']/label/select")
	WebElement productTableDropdown;
	
	@FindBy(id="ordernow")
	WebElement orderNowButton;
	
	public void firstProductClick(){
		firstItem.click();
		//productTable.findElement(By.xpath("//*[@id='productList']/tbody//tr[1]//td[7]//a")).click();
	}

	public void orderNowButtonClick(){
		orderNowButton.click();
	}
	
	public void selectProductTableDropdown(String valueDrop){
		Select dropdown = new Select(productTableDropdown);
		dropdown.selectByValue(valueDrop);
	}
	
	public void getProductAtPosition(int elementNumber){
		String elementXpath= "(//a[contains (@href,'ebookstore/product/viewProduct') and contains (@id,'itemnum')])["+elementNumber+"]";
		System.out.println("elementXpath" + elementXpath);
		driver.findElement(By.xpath(elementXpath)).click();
	}
	
}
