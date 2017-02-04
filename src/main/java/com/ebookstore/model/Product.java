package com.ebookstore.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = -6423749643543334160L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;

	@NotEmpty(message = "The product name must not be null.")
	private String productName;
	private String productCategory;
	private String productDescription;

	@Min(value = 0, message = "The product price must no be less then zero.")
	private double productPrice;
	private String productCondition;
	
//	
//	private String productStatus;
//
//	@Min(value = 0, message = "The product unit must not be less than zero.")
//	private int unitInStock;
	
	private String author;

	@Transient
	private MultipartFile productImage;

	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItems;

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCondition() {
		return productCondition;
	}

	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}

//	public String getProductStatus() {
//		return productStatus;
//	}
//
//	public void setProductStatus(String productStatus) {
//		this.productStatus = productStatus;
//	}
//
//	public int getUnitInStock() {
//		return unitInStock;
//	}
//
//	public void setUnitInStock(int unitInStock) {
//		this.unitInStock = unitInStock;
//	}
//
//	public String getProductPublisher() {
//		return author;
//	}
//
//	public void setProductPublisher(String productManufacturer) {
//		this.author = productManufacturer;
//	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

}
