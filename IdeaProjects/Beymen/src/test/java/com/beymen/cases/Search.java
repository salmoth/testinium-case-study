package com.beymen.cases;

import com.beymen.locators.Locators;
import junit.framework.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

public class Search {
    public Search(RemoteWebDriver driver) {
        _driver = driver;
    }

    private RemoteWebDriver _driver;
    final static Logger logger = Logger.getLogger(Search.class);
    private String searchValue1 = "Şort";
    private String searchValue2 = "Gömlek";

    @Test
    public void SearchFirstValue() throws Exception {
        WebElement searchBox = _driver.findElement((Locators.ActionBuilderPageLocators.searchBox));
        searchBox.sendKeys(searchValue1);
        Thread.sleep(1000);
        logger.info("\"Şort\" value entered.");
        searchBox.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        searchBox.sendKeys(Keys.DELETE);
        //searchBox.clear();
        Thread.sleep(1000);
        logger.info("\"Şort\" value deleted.");
    }

    @Test
    public void SearchSecondValue() throws Exception {
        WebElement searchBox = _driver.findElement((Locators.ActionBuilderPageLocators.searchBox));
        searchBox.sendKeys(searchValue2);
        logger.info("\"" + searchValue2 + "\"" + " value entered.");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        logger.info("\"" + searchValue2 + "\"" + " search results opened.");

        List<WebElement> allProducts = _driver.findElements((Locators.ActionBuilderPageLocators.productItem));
        List<WebElement> allProductsTitle = _driver.findElements((Locators.ActionBuilderPageLocators.productItemTitle));
        List<WebElement> allProductsPrice = _driver.findElements((Locators.ActionBuilderPageLocators.productItemPrice));
        List<WebElement> allProductsLink = _driver.findElements((Locators.ActionBuilderPageLocators.productItemLink));

        int productsList = allProducts.size();
        Random random = new Random();
        int randomProduct = random.nextInt(productsList);

        Thread.sleep(1000);
        logger.info("Random product item selected.");
        logger.info("Product Title:" + allProductsTitle.get(randomProduct).getText());
        logger.info("Product Price:" + allProductsPrice.get(randomProduct).getText());
        logger.info("Product Link:" + allProductsLink.get(randomProduct).getAttribute("href"));

        try {
            FileWriter fw = new FileWriter("ProductsList.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.write("Product Title:" + allProductsTitle.get(randomProduct).getText() + "\n");
            pw.write("Product Price:" + allProductsPrice.get(randomProduct).getText() + "\n");
            pw.write("Product Link:" + allProductsLink.get(randomProduct).getAttribute("href") + "\n");
            pw.close();
            System.out.println("Product Information added to ProductsList.txt folder.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);
        allProducts.get(randomProduct).click();
        logger.info("Product page opened.");
        Thread.sleep(1000);
    }

    @Test
    public void AddProductToBasketAndCheckPrice() throws Exception {
        /*  WebElement productEnableSize = _driver.findElement(Locators.ActionBuilderPageLocators.productEnableSize);
        productEnableSize.click();
        logger.info("Product size selected.");
        */
        JavascriptExecutor js = (JavascriptExecutor) _driver;
        String sizes = "document.querySelectorAll(\".m-variation__item:not(.-criticalStock, .-disabled, -active -criticalStock)\")[0].click();";
        js.executeScript(sizes);
        logger.info("Product size selected.");

        WebElement addBasket = _driver.findElement(Locators.ActionBuilderPageLocators.addBasket);
        addBasket.click();
        logger.info("Product added to basket.");

        String productItemPriceOnProduct = _driver.findElement(Locators.ActionBuilderPageLocators.productItemPriceOnProduct).getText();
        logger.info("Product price is " + productItemPriceOnProduct + " on product item page.");
        Thread.sleep(5000);

        WebElement cartButton = _driver.findElement(Locators.ActionBuilderPageLocators.cartButton);
        cartButton.click();
        logger.info("Cart opened.");
        Thread.sleep(2000);

        WebElement productItemPriceOnCart = _driver.findElement(Locators.ActionBuilderPageLocators.productItemPriceOnCart);
        WebElement orderSummaryValue = _driver.findElement(Locators.ActionBuilderPageLocators.orderSummaryValue);
        Assert.assertEquals(productItemPriceOnCart.getText(), orderSummaryValue.getText(), productItemPriceOnProduct);
        logger.info("The product price is equal to the order summary.");
        Thread.sleep(2000);
    }

}
