Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Search Experience for product search in both home and Offers page

Given User is on Greencart Landing page
When User searched wirh Shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceed to checkout and validate the <Name> items in checkout page
And Check user has ability to enter promo code and place the order

Examples:
| Name |
| Tom |
