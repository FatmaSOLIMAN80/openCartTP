# openCartTP

Selenium Automation Project: E-Commerce 

The openCart project is a test automation framework designed to validate and ensure the seamless functionality of an e-commerce application. Utilizing the capabilities of Selenium WebDriver, TestNG, and Java, this project provides a robust and efficient way to automate critical workflows within the application, ensuring a flawless user experience.

Primary Objective:
Our main goal is to automate the end-to-end user journey, encapsulating the complete flow, starting from the initial user registration to the final product checkout. The key processes automated include:

User Registration: Ensures that a user can successfully register, providing all necessary details, and gain access to their personalized account dashboard.
Login Process: Validates the user's ability to access their account using correct credentials and also checks the system's response to incorrect login attempts.
Product Search: Automates the product search mechanism, ensuring that users can efficiently search, view product details, and receive accurate search results based on various criteria.
Checkout Process: Validates the entire checkout pipeline, from adding products to the cart to choosing delivery options, applying discounts, selecting payment methods, and finally confirming the order.
By leveraging a hybrid approach, the framework combines the benefits of data-driven and keyword-driven methodologies. With a clear directory structure, it maintains a logical segregation between configuration files, utility functions, page objects, and test cases, ensuring scalability and ease of maintenance.

This project serves as an essential tool for QA teams, ensuring that the e-commerce platform consistently delivers a reliable and optimized user experience, devoid of critical bugs or issues.



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

Directory Structure:


openCart_TP_HybridFramework
│
├── src/main/java
│   ├── config
│   │   └── configTP.properties
│   │
│   ├── pageObjects
│   │   ├── AccountPage.java
│   │   ├── AccountRegistrationSuccessPage.java
│   │   ├── CheckoutPage.java
│   │   ├── ForgotYourPasswordPage.java
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   ├── RegisterPage.java
│   │   ├── SearchPage.java
│   │   └── ShoppingCartPage.java
│   │
│   ├── testData
│   │   ├── testData.properties
│   │   └── Tp_OpenCart_TestData.xlsx
│   │
│   └── utils
│       └── Utilities.java
│
├── src/test/java
│   ├── base
│   │   └── Base.java
│   │
│   └── testCases
│       ├── CheckoutTest.java
│       ├── ForgotPasswordTest.java
│       ├── LoginTest.java
│       ├── RegisterTest.java
│       └── SearchTest.java
│
├── src
│   └── Maven Dependencies
│
├── target
│
├── test-output
│
├── pom.xml
│
└── testng.xml

Each directory and its contents have specific roles:

config: Contains configuration properties for the testing framework.
pageObjects: Java classes representing individual web pages. Implements the Page Object Model design pattern for Selenium WebDriver tests.
testData: Contains properties and Excel sheets with test data.
utils: Provides utility methods and functionalities.
base: The base class initializes WebDriver and contains methods to set up and tear down tests.
testCases: Houses all the TestNG test cases for the application's functionalities.
Maven Dependencies: Dependencies needed for the project, managed by Maven.
target: Compiled bytecode of the project generated by Maven.
test-output: Contains reports and logs after test execution.
pom.xml: Maven Project Object Model file, which contains project configuration, dependencies, plugins, etc.
testng.xml: Configuration file for TestNG, specifying which tests to run and other test configurations.



Key Classes:

1. Base.java
Located in the base package, this is the foundational class for the testing framework. It contains methods to initialize the WebDriver and manage the setup and teardown for test executions.

2. Utilities.java
Found in the utils package, this class provides a set of utility methods and functionalities that assist in various tasks like waiting for elements, capturing screenshots, and other common functionalities required across the tests.

3. configTP.properties
A configuration file in the config package, it houses various settings and parameters essential for the testing framework, such as browser choice, base URLs, timeouts, etc.

4. Page Object Classes
All classes in the pageObjects package implement the Page Object Model (POM) design pattern. Each class represents a unique web page or a component of the application. Key classes include:

HomePage.java: Represents the main landing page of the application.
LoginPage.java: Methods and elements related to the login page.
RegisterPage.java: Represents user registration functionalities.
CheckoutPage.java: For functionalities related to checking out items in the cart.
SearchPage.java: Methods and elements for the product search functionality.
... and others representing different pages or functionalities of the application.
5. Test Classes
Classes in the testCases package contain actual TestNG test cases for testing various functionalities of the application:

LoginTest.java: Tests related to user login.
RegisterTest.java: Tests for user registration functionality.
CheckoutTest.java: Tests for checking out items in the shopping cart.
SearchTest.java: Tests for product search functionality.
... and other test classes for different application features.
6. testData.properties & Tp_OpenCart_TestData.xlsx
Found in the testData package, these files contain data that will be used for testing. The .properties file provides key-value pairs, while the .xlsx file provides data in a tabular format suitable for data-driven testing.


Running the Tests:

Navigate to the project root directory.
Run the tests using your preferred IDE or via the command line with TestNG or Maven commands.

Dependencies:

Selenium: For automating web applications.
TestNG: Used as the testing framework.
Maven: For project management and dependencies.

Common Errors and Solutions:

MoveTargetOutOfBoundsException: This error generally occurs when an element is out of the visible area. 
Solution: Ensure that you scroll the web page to bring the element into view before performing any action on it.

ElementClickInterceptedException: This occurs when trying to click an element which is obstructed by another element. 
Solution: Use the JavaScript Executor or Actions class to perform the click operation.

Features:

Hybrid Framework: Combines data-driven and keyword-driven testing frameworks.
Page Object Model: Implements the Page Object Model design pattern to ensure maintainability and scalability.
Reusable Utilities: Contains utility methods which can be reused across different test cases.
External Test Data: Utilizes an external Excel sheet for test data, allowing tests to be run with different data sets.

Future Enhancements:

- Integrate with Continuous Integration tools like Github Actions
