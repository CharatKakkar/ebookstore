/**
 * 
 */
package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Charat Kakkar
 *
 */
public class BaseClass {

	private WebDriver driver;

	public void pageFactoryInit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	public void shutdownHook(WebDriver driver ){
		
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//			@Override
//			public void run() {
//				driver.quit();
//			}
//		});
	}
}
