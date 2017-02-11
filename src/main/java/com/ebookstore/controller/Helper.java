package com.ebookstore.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;



@Component
public class Helper {

	Path path;

	WebDriver driver;	
	
	//private static Helper setUp1;
	
	public  WebDriver getDriver() {
		return driver;
	}

	
	private String baseUrl;

	public Helper() {
		// System.setProperty("webdriver.chrome.driver",
		// "F:/Project/Selenium/chromedriver/chromedriver.exe");
		// driver = new ChromeDriver();
//		baseUrl = "http://localhost:8080/";
//		if (driver==null){
//			System.out.println("From Helper, driver is null");
//		}
//		else{
//			System.out.println("From helper, driver has been initialized");
//		}
		//driver.get(baseUrl + "/ebookstore/");
	}
//
//	public static Helper getSetUp() {
//		if (setUp1 == null) {
//			setUp1 = new Helper();
//		}
//		return setUp1;
//	}
//	
	
	public void getUrl(){		
		baseUrl = "http://localhost:8080/";
		driver.get(baseUrl + "/ebookstore/");
	}
	

	public void saveNewImage(MultipartFile productImage, int productId) {
		// HttpServletRequest session = new
		// String rootDirectory =
		// session.getSession().getServletContext().getRealPath("/");
		// System.out.println(rootDirectory);
		// String contextPath = session.getContextPath();
		// path = Paths.get(rootDirectory +
		// "\\WEB-INF\\resources\\productImages\\" + productId + ".png");
		path = Paths.get("C:\\Users\\chara\\git\\ebookstore\\src\\main\\webapp\\WEB-INF\\resources\\productImages\\"
				+ productId + ".png");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				// productImage.transferTo(new File (path.toString()));
				productImage.transferTo(new File(path.toString()));

				// int path = Project.PROJECT;
				//
				// //IResource.BACKGROUND_REFRESH
				//
				// //ResourceBundle.clearCache();
				// // IProject[] projects =
				// // ResourcesPlugin.getWorkspace().getRoot().getProjects();
				// for (IProject project :
				// ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
				// project.refreshLocal(IResource.DEPTH_INFINITE, null);
				// }

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
