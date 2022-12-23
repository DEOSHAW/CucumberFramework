Feature: Green Kart
@greenkart
Scenario: Add products to Cart
Given Green Kart portal is launched
When User searches for below vegetables
|Vegetable|
|Ca|
|To|
And User adds products to the cart 
Then the products are displayed in the cart