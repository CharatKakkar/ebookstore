<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<jsp:useBean id="now" class="java.util.Date" />


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Order</h1>


			<p class="lead">Order confirmation</p>
		</div>

		<div class="container">

			<div class="row">

				<form:form commandName="order">

					<div
						class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 co-md-offset-3">

						<div class="text-center">
							<h1>Receipt</h1>
						</div>
						<div class="table table-bordered table-inverse">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<address>
									<strong>Shipping Address</strong><br>
									${order.cart.customer.shippingAddress.streetAddress} <br>
									${order.cart.customer.shippingAddress.apartmentNumber} <br>
									${order.cart.customer.shippingAddress.city},
									${order.cart.customer.shippingAddress.state} <br>
									${order.cart.customer.shippingAddress.country},
									${order.cart.customer.shippingAddress.zipCode} <br>
								</address>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 text-right">
								<p>
									Shipping Date:
									<fmt:formatDate type="date" value="${now}" />
								</p>
							</div>
						</div>

						<div class="table table-bordered ">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<address>
									<strong>Billing Address</strong><br>
									${order.cart.customer.billingAddress.streetAddress} <br>
									${order.cart.customer.billingAddress.apartmentNumber} <br>
									${order.cart.customer.billingAddress.city},
									${order.cart.customer.billingAddress.state} <br>
									${order.cart.customer.billingAddress.country},
									${order.cart.customer.billingAddress.zipCode} <br>
								</address>
							</div>
						</div>

						<div class="table table-bordered ">
							<table class="display nowrap dataTable dtr-inline collapsed">

								<thead class="thead-inverse">
									<tr class="bg-success">
										<th>Product</th>
										<th>Quantity</th>
										<th>Price</th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="cartItem" items="${order.cart.cartItems}">
										<tr>
											<td class="table table-warning">${cartItem.product.productName}</td>
											<td class=" table col-md-1" style="text-align: center">${cartItem.qty}</td>
											<td class="table col-md-1" style="text-align: center">${cartItem.product.productPrice}</td>
											<td class="table col-md-1" style="text-align: center">${cartItem.itemTotal}</td>
										</tr>
									</c:forEach>

									<tr>
										<td class="table col-md-1" style="text-align: center"><strong>Grand Total:$ </strong></td>
										<td class="table col-md-2" style="text-align: right" ><strong> ${order.cart.grandTotal}</strong></td>
									</tr>
								</tbody>

							</table>
						</div>
						<table class="form-address-table">
							<tbody>
								<tr>
									<th colspan="2" style="text-align: center;" id="ccTitle7">
										Credit Card Details</th>
								</tr>
								<tr>
									<td width="50%"><span class="form-sub-label-container"
										style="vertical-align: top;"> <label
											class="form-sub-label" for="input_7_cc_firstName"
											id="sublabel_cc_firstName"
											style="min-height: 13px; margin: 0 0 3px 0;"> First
												Name </label> <input type="text" id="input_7_cc_firstName"
											
											class="form-textbox cc_firstName" size="20" value=""
											data-component="cc_firstName">
									</span></td>
									</tr>
									<tr>
									
									<td width="50%"> <label
											class="form-sub-label" for="input_7_cc_lastName"
											id="sublabel_cc_lastName"
											style="min-height: 13px; margin: 0 0 3px 0;"> Last
												Name </label> <input type="text" id="input_7_cc_lastName"
											
											class="form-textbox cc_lastName" size="20" value=""
											data-component="cc_lastName">
									</td>
								</tr>
								<tr>
									<td colspan="2"><span class="form-sub-label-container"
										style="vertical-align: top;"> <label
											class="form-sub-label" for="input_7_cc_number"
											id="sublabel_cc_number"
											style="min-height: 13px; margin: 0 0 3px 0;"> Credit
												Card Number </label> <input type="number" id="input_7_cc_number"
											
											class="form-textbox cc_number" autocomplete="off" size="20"
											value="" data-component="cc_number"> -
									</span> <span class="form-sub-label-container"
										style="vertical-align: top;"> <label
											class="form-sub-label" for="input_7_cc_ccv"
											id="sublabel_cc_ccv"
											style="min-height: 13px; margin: 0 0 3px 0;">
												Security Code </label> <input type="number" id="input_7_cc_ccv"
										 class="form-textbox cc_ccv"
											autocomplete="off" style="width: 52px;" value=""
											data-component="cc_ccv">
									</span></td>
								</tr>
								<tr>
									<td colspan="2"><span class="form-sub-label-container"
										style="vertical-align: top;"> <label
											class="form-sub-label" for="input_7_cc_exp_month"
											id="sublabel_cc_exp_month"
											style="min-height: 13px; margin: 0 0 3px 0;">
												Expiration Month </label> <select class="form-dropdown cc_exp_month"
											 id="input_7_cc_exp_month"
											data-component="cc_exp_month">
												<option></option>
												<option value="1">January</option>
												<option value="2">February</option>
												<option value="3">March</option>
												<option value="4">April</option>
												<option value="5">May</option>
												<option value="6">June</option>
												<option value="7">July</option>
												<option value="8">August</option>
												<option value="9">September</option>
												<option value="10">October</option>
												<option value="11">November</option>
												<option value="12">December</option>
										</select> /
									</span> <span class="form-sub-label-container"
										style="vertical-align: top;"> <label
											class="form-sub-label" for="input_7_cc_exp_year"
											id="sublabel_cc_exp_year"
											style="min-height: 13px; margin: 0 0 3px 0;">
												Expiration Year </label> <select class="form-dropdown cc_exp_year"
											name="exp_year" id="input_7_cc_exp_year"
											data-component="cc_exp_year">
												<option></option>
												<option value="2017">2017</option>
												<option value="2018">2018</option>
												<option value="2019">2019</option>
												<option value="2020">2020</option>
												<option value="2021">2021</option>
												<option value="2022">2022</option>
												<option value="2023">2023</option>
												<option value="2024">2024</option>
												<option value="2025">2025</option>
												<option value="2026">2026</option>
												<option value="2027">2027</option>
												<option value="2028">2028</option>
												<option value="2029">2029</option>
												<option value="2030">2030</option>
												<option value="2031">2031</option>
												<option value="2032">2032</option>
												<option value="2033">2033</option>
												<option value="2034">2034</option>
												<option value="2035">2035</option>
												<option value="2036">2036</option>
										</select>
									</span></td>
								</tr>
							</tbody>
						</table>


						<input type="hidden" name="_flowExecutionKey" /> <br> <br>
						<button id="back" class="btn btn-default"
							name="_eventId_backToShowCustomerInfo">Back</button>
						<button id="submit" name="_eventId_next" class="btn btn-success">Submit</button>
						<button id="cancel" name="_eventId_cancel" class="btn btn-warning">Cancel</button>
					</div>
				</form:form>
			</div>
		</div>
		<%@include file="/WEB-INF/views/template/footer.jsp"%>

	</div>
</div>
