package com.beymen.locators;

import org.openqa.selenium.By;

public class Locators {

    public static class ActionBuilderPageLocators {
        public static By cmpAccept = By.id("onetrust-accept-btn-handler");
        public static By genderWomanButton = By.id("genderWomanButton");
        public static By searchBox = By.cssSelector("body > header > div > div > div.col-4.col-sm-4.col-md-4.col-lg-4.col-xl-6 > div > div > div > input");
        public static By productItem = By.cssSelector("#productList > div > div");
        public static By productItemTitle = By.cssSelector("#productList > div > div > div > div.m-productCard__detail > a:nth-child(2) > h3");
        public static By productItemPrice = By.cssSelector("#productList > div > div > div > div.m-productCard__detail > div > span.m-productCard__priceWrapper > span.m-productCard__newPrice");
        public static By productItemLink = By.cssSelector("#productList > div > div > div > div.m-productCard__detail > a:nth-child(2)");
        public static By productEnableSize = By.cssSelector("#sizes > div > span.m-variation__item");
        public static By addBasket = By.id("addBasket");
        public static By cartButton = By.cssSelector("body > header > div > div > div.col.col-xl-3.d-flex.justify-content-end > div > a.o-header__userInfo--item.bwi-cart-o.-cart");
        public static By productItemPriceOnProduct = By.cssSelector("#priceNew");
        public static By productItemPriceOnCart = By.cssSelector("body > div.wrapper > div.container.m-basket > div > div > div.col-12.col-md-12.col-lg-8 > div.m-basket__body > div.m-basket__item > div.m-basket__content > div > div.m-basket__productTools > div.m-basket__productInfo > div.m-basket__productPrice > div > div.m-productPrice__content > span.m-productPrice__salePrice");
        public static By orderSummaryValue = By.cssSelector("body > div.wrapper > div.container.m-basket > div > div > div.col-12.col-md-12.col-lg-4 > div.m-orderSummary > div.m-orderSummary__body > ul > li.m-orderSummary__item.-grandTotal > span.m-orderSummary__value");
        public static By quantitySelectValue = By.cssSelector("#quantitySelect0-key-0");
        public static By remoteCartItem = By.id("removeCartItemBtn0-key-0");
        public static By emptyCart = By.cssSelector("#emtyCart > div > strong");
    }
}
