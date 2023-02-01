package com.beymen.initializers;

import  org.openqa.selenium.WebDriver;
import  org.openqa.selenium.chrome.ChromeDriver;

public class WebDrivers {

    public static WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver","/Users/senemozgekara/IdeaProjects/drivers/chromedriver");
        WebDriver chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.beymen.com/");

        return (WebDriver)chromeDriver;
    }

}
