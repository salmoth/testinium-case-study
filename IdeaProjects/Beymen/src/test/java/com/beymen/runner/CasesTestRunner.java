package com.beymen.runner;

import com.beymen.cases.CartPage;
import com.beymen.cases.DriverQuit;
import com.beymen.cases.HomePage;
import com.beymen.cases.Search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class CasesTestRunner {

    static void runTests(WebDriver driver) throws Exception {

        HomePage homePage = new HomePage((RemoteWebDriver) driver);
        homePage.URLCheck();
        homePage.AcceptCMP();

        Search search = new Search((RemoteWebDriver) driver);
        search.SearchFirstValue();
        search.SearchSecondValue();
        search.AddProductToBasketAndCheckPrice();

        CartPage cartPage = new CartPage((RemoteWebDriver) driver);
        cartPage.ChangeProductQuantity();
        cartPage.DeleteBasketItemsAndCheckBasket();

        DriverQuit driverQuit = new DriverQuit((RemoteWebDriver) driver);
        driverQuit.driverClose();
    }
}
