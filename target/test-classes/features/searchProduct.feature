Feature: Search and Place the order for Products

@OffersPage
Scenario Outline: Search Experience for product search in both home and Offers page

Given User is on Greencart Landing page
When User searched wirh Shortname <Name> and extracted actual name of product
Then User searched for <Name> shortname in offers page
And validate product name in Offers page matches with Landing page

Examples:
| Name |
| Tom |
| Beet |

