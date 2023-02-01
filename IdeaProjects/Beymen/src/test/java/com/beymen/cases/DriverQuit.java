package com.beymen.cases;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverQuit {

    private RemoteWebDriver _driver;

    public DriverQuit(RemoteWebDriver driver){_driver=driver;}

    public void driverClose(){_driver.quit();}
}
