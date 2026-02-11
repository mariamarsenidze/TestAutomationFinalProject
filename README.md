# Test Automation Final Project

##  პროექტის აღწერა
ეს რეპოზიტორი შეიცავს Final Test Automation პროექტის ავტომატიზებულ ტესტებს.
ტესტები განხორციელებულია UI და API დონეზე Selenium WebDriver-ის, Rest-Assured-ის, TestNG-ისა და Allure Report-ის გამოყენებით.

---

##  ჯგუფის წევრები

### სახელი და გვარი:

- მარიამ არსენიძე
- ლიკა წულაია 
- ლიკა მარტიაშვილი
- ნინო მარტყოფლიშვილი

---

##  ტესტ ქეისების განაწილება

###  მარიამ არსენიძე
**ავტომატიზებული ტესტ ქეისები:**
- LoginIncorrectTest (UI)
- LoginTest (UI)
- LogOutTest (UI)
- API 3: Get All Brands List (API)
- API 4: PUT To All Brands List (API)

---

###  ლიკა წულაია
**ავტომატიზებული ტესტ ქეისები:**
- ContactFormTest (UI)
- AddProductTest (UI)
- API 1: Get All Products List (API)
- API 2: POST To All Products List (API)
- API 5: POST To Search Product (API)

---

### ლიკა მარტიაშვილი
**ავტომატიზებული ტესტ ქეისები:**
- SearchProductTest (UI)
- RemoveProductTest (UI)
- AddReviewTest (UI)
- API 6: POST To Search Product without parameter (API)
- API 7: POST To Verify Login with valid details (API)

---

### ნინო მარტყოფლიშვილი
**ავტომატიზებული ტესტ ქეისები:**
- RegistrationTest (UI)
- RegisterExistingTest (UI)
- API 8: POST To Verify Login without email parameter (API)
- API 9: DELETE To Verify Login (API)
- API 10: POST To Verify Login with invalid details (API)

---

##  გამოყენებული ტექნოლოგიები
- Java
- Selenium WebDriver
- Rest-Assured
- TestNG
- Maven
- Allure Report

---

##  ტესტების გაშვების ინსტრუქცია (TestNG)

###  IntelliJ IDEA-დან ტესტების გაშვება
1. გახსენით პროექტი IntelliJ IDEA-ში
2. გახსენით `testng.xml` ფაილი **ან** სასურველი ტესტ კლასი
3. დააჭირეთ მარჯვენა ღილაკს
4. აირჩიეთ **Run 'testng.xml'** ან **Run Test**

---

##  Allure რეპორტის გენერაცია

### Allure რეპორტის გენერაცია და გახსნა
1. გახსენით Terminal
2. შეასრულეთ შემდეგი ბრძანება:
```bash
allure serve allure-results
