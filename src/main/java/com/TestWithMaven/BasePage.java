package com.TestWithMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserFactory;

/**
 * Created by pc on 06-Feb-17.
 */
public class BasePage {
    WebDriver driver = BrowserFactory.getDriver();

    public BasePage()
    {
        PageFactory.initElements(driver, this);
    }
}
