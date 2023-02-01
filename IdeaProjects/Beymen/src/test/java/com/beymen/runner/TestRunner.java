package com.beymen.runner;

import com.beymen.initializers.WebDrivers;
import org.openqa.selenium.WebDriver;

public class TestRunner {

    public static void main(String[] args) throws Exception {
        WebDriver[] drivers = {(WebDriver) WebDrivers.chromeDriver()};

        for (WebDriver driver : drivers) {
            CasesTestRunner.runTests(driver);
        }
    }
}
