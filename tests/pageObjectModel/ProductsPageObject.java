package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPageObject {

	WebDriver driver;
	
	public ProductsPageObject(WebDriver driver){
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="productList")
	WebElement productTable;
	
	public void productTable(){
		productTable.findElement(By.xpath("//*[@id='productList']/tbody//tr[1]//td[6]//a")).click();
	}

	@FindBy(how=How.XPATH, using= "//*[@id='productList_length']/label/select")
	WebElement productTableDropdown;
	
	public void selectProductTableDropdown(String valueDrop){
		Select dropdown = new Select(productTableDropdown);
		dropdown.selectByValue(valueDrop);
	}
	
	
}
