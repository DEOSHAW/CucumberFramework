Feature: NOPCommerce
@nopCommerce
Scenario: Search for Product
Given NOPCommerce portal is open
When User searches for below on NOPCommerce portal
|Laptop|Watches|
|Cell Phones|Headphones|
Then the product is displayed NOPCommerce portal