Feature: Administrator Rights


	Scenario Outline: Add a product into the product Catalog
	Given Login URL
	And Login Credentials for Admin
	When I Click on Login Button 
	Then Click on Modify Inventory
	Then Click on Add Product
	Then Fill in the form with details "<>" "<>" 	
	
	Examples:
	|| ||
	
