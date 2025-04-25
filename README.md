# 🧪 Automated UI & API Testing Framework

This project demonstrates a robust automation framework combining **Selenium WebDriver + Cucumber** for UI testing and **Rest Assured** for API testing. The framework follows **BDD principles** and emphasizes clean code practices with **Page Object Model** and **reusable step definitions**.

---

## 🧰 Tools & Tech Stack

- Java 21
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- Rest Assured
- JUnit
- Gherkin
- Page Object Model (POM)

---

## 📁 Project Structure
```bash
ProjectName/
├── src/
│   └── test/
│       └── java/
│           └── context/
│               └── TestContext.java
│           └── Pages/
│               ├── CheckoutPage.java
│               ├── LoginPage.java
│               ├── ProductPage.java
│               └── SharedPage.java
│           └── restObjects/
│               └── RestApiObject.java
│           └── runner/
│               └── TestRunner.java
│           └── stepDefinition/
│               └── rest/
│                   ├── RegisterLoginSteps.java
│                   └── UserApiSteps.java
│               └── CheckoutPageSteps.java
│               └── commonSteps.java
│               └── ProductPageSteps.java
│               └── LoginSteps.java
│           └── utility/
│               ├── BrowserDriver.java
│               └── CommonStepsUtil.java
│       └── resources/
│           └── features/
│               └── rest/
│                   ├── RegisterLogin.feature
│                   └── UserApi.feature
│               ├── checkoutPage.feature
│               ├── login.feature
│               └── productPage.feature
├── target/
│   └── cucumber-report/
├── pom.xml
├── README.md
└── .gitignore

```
---

## ✅ Features

### 🔍 UI Testing (SauceDemo)
- Login flow validations
- Cart and checkout processes
- Product detail navigation
- Negative and edge case testing

### 🔗 API Testing (Reqres.in)
- GET, POST, PUT, PATCH, DELETE operations
- Auth and error scenarios
- Response validation with status and payload checks

---

## 🚀 Running the Tests

Make sure Java and Maven are installed.

To run **all tests**:
```bash
mvn clean test


mvn clean test -Dcucumber.filter.tags="@ui"


mvn clean test -Dcucumber.filter.tags="@api"


target/cucumber-reports/



