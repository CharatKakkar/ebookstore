package com.ebookstore.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.web.multipart.MultipartFile;

public class Helper {
	
	Path  path;
	public void saveNewImage (MultipartFile productImage , int productId){		
		//HttpServletRequest session = null;
		//String rootDirectory = session.getSession().getServletContext().getRealPath("/");
		// String contextPath = session.getContextPath();
	//	path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\productImages\\" + productId + ".png");
		path = Paths.get("C:\\Users\\Charat Kakkar\\git\\20AugLibrary2\\src\\main\\webapp\\WEB-INF\\resources\\productImages\\"
						+productId + ".png");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				// productImage.transferTo(new File (path.toString()));
				productImage.transferTo(new File(path.toString()));
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}

}
