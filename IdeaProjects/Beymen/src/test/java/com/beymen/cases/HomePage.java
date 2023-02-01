package com.beymen.cases;

import com.beymen.locators.Locators;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage {
    private RemoteWebDriver _driver;
    final static Logger logger = Logger.getLogger(HomePage.class);
    private String mainURL = "https://www.beymen.com/";

    public HomePage(RemoteWebDriver driver) {
        _driver = driver;
    }

    @Test
    public void URLCheck() throws Exception {
        logger.info("Beymen website is opened.");
        Assertions.assertEquals(_driver.getCurrentUrl(), mainURL);
        logger.info("The website address has been checked.");
        Thread.sleep(1000);
    }

    @Test
    public void AcceptCMP() throws Exception {
        WebElement cmpAcceptButton = _driver.findElement(Locators.ActionBuilderPageLocators.cmpAccept);
        cmpAcceptButton.click();
        logger.info("CMP accepted.");

        WebElement genderWomanButton = _driver.findElement((Locators.ActionBuilderPageLocators.genderWomanButton));
        genderWomanButton.click();
        logger.info("Gender option selected female.");
    }
}
