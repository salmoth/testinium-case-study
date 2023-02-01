package com.beymen.cases;

import com.beymen.locators.Locators;
import junit.framework.Assert;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.apache.log4j.LogManager.*;

public class CartPage {
    private RemoteWebDriver _driver;

    public CartPage(RemoteWebDriver driver) {
        _driver = driver;
    }

    final static Logger logger = getLogger(CartPage.class);

    @Test
    public void ChangeProductQuantity() throws Exception {
        WebElement productItemPriceOnCart = _driver.findElement(Locators.ActionBuilderPageLocators.productItemPriceOnCart);
        String onePrice = productItemPriceOnCart.getText().substring(0, productItemPriceOnCart.getText().length() - 6);
        logger.info("1 product item price: " + productItemPriceOnCart.getText());

        Select dropdown = new Select(_driver.findElement(Locators.ActionBuilderPageLocators.quantitySelectValue));
        dropdown.selectByIndex(1);
        logger.info("Selected 2 items.");
        Thread.sleep(2000);

        WebElement orderSummaryValue = _driver.findElement(Locators.ActionBuilderPageLocators.orderSummaryValue);
        String twoPrice = orderSummaryValue.getText().substring(0, orderSummaryValue.getText().length() - 6);
        logger.info("2 product items price: " + orderSummaryValue.getText());
        Thread.sleep(1000);

        float one = Float.parseFloat(onePrice);
        float two = Float.parseFloat(twoPrice);
        Assert.assertEquals((one + one), two);
        logger.info("2 product price is true.");
        Thread.sleep(2000);
    }

    @Test
    public void DeleteBasketItemsAndCheckBasket() throws Exception {
        WebElement remoteCartItem = _driver.findElement(Locators.ActionBuilderPageLocators.remoteCartItem);
        remoteCartItem.click();
        Thread.sleep(2000);
        logger.info("Items in the basket have been deleted.");
        Thread.sleep(2000);

        WebElement emptyCart = _driver.findElement(Locators.ActionBuilderPageLocators.emptyCart);
        Assert.assertNotNull(emptyCart.getText());
        logger.info(emptyCart.getText());
    }
}
