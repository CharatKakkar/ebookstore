package com.ebookstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.ebookstore.model.Cart;
import com.ebookstore.model.CartItem;
import com.ebookstore.model.Customer;
import com.ebookstore.model.Product;
import com.ebookstore.service.CartItemService;
import com.ebookstore.service.CartService;
import com.ebookstore.service.CustomerService;
import com.ebookstore.service.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CartItemService cartItemService;

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart getCart(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		return cart;
	}

	@RequestMapping(value = "/add/{productId}/c/{qty}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productId") int productId, @PathVariable(value = "qty") int qty,
			@AuthenticationPrincipal User activeUser) {
		System.out.println("Quantity entered is " + qty);
		System.out.println("Product Id is " + productId);
		Customer customer = customerService.getCustomerByuserName(activeUser.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);

		List<CartItem> cartItems = cart.getCartItems();

		for (int i = 0; i < cartItems.size(); i++) {
			if (product.getProductId() == cartItems.get(i).getProduct().getProductId()) {
				CartItem cartItem = cartItems.get(i);
				cartItem.setQty(cartItem.getQty() + qty);
				cartItem.setItemTotal(product.getProductPrice() * cartItem.getQty());
				cartItemService.addCartItem(cartItem);
				cartService.updateCart(cart.getCartId());
				return;
			}
		}
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQty(qty);
		cartItem.setItemTotal(product.getProductPrice() * cartItem.getQty());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
		cartService.updateCart(cart.getCartId());
	}

	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser) {
		System.out.println("--------------- remove function called ---------------------");
		Customer customer = customerService.getCustomerByuserName(activeUser.getUsername());
		int cartId = customer.getCart().getCartId();
		CartItem cartItem = cartItemService.getCartItemByProductId(productId, cartId);

		cartItemService.removeCartItem(cartItem);
		cartService.updateCart(cartId);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}

}
