# openCartTP

Selenium Automation Project: E-Commerce 

Overview:

This project automates the ...... processes for an e-commerce application using Selenium, TestNG, and Java. The primary objective is to automate the complete flow from ..... to .....

Prerequisites:

Java JDK 17.0.7
Selenium 4.11.0
TestNG
ChromeDriver compatible with Chrome 117.0.5938.134
Maven (Optional, for dependency management)

Setup:

Clone the repository.
Navigate to the project directory.
Install the necessary dependencies.

| - src
   | - main
       | - java
           | - base (Contains base setup and utility methods)
           | - pageObjects (Contains classes for each page of the application)
   | - test
       | - java
           | - testCases (Contains TestNG classes to run tests)

Key Classes:

Base: Base class containing methods to initialize the web driver, load property files, and other setup related methods.
LoginPage: Represents the login page of the application.
HomePage: Represents the main/home page of the application.
AccountPage: Represents the user's account page.
SearchPage: Represents the search results page.
AddToCartPage: Represents the cart page where items can be added before checkout.
CheckoutPage: Represents the checkout page of the application.

Running the Tests:

Navigate to the project root directory.
Run the tests using your preferred IDE or via the command line with TestNG or Maven commands.

Common Errors and Solutions:

MoveTargetOutOfBoundsException: This error generally occurs when an element is out of the visible area. 
Solution: Ensure that you scroll the web page to bring the element into view before performing any action on it.

ElementClickInterceptedException: This occurs when trying to click an element which is obstructed by another element. 
Solution: Use the JavaScript Executor or Actions class to perform the click operation.

Future Enhancements:

- Integrate with Continuous Integration tools like Github Actions
