package com.catamania.paralleltest;

import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.*;
import java.io.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

import static java.lang.System.out;

public class IndependentTest
{

private ChromeDriverService service;


@BeforeTest
public void beforeTest() {
        out.println("beforeTest " + service);

        try {
                service = new ChromeDriverService.Builder()
                          .usingDriverExecutable(new File("/home/ubuntu/dev/chromedriver"))
                          .usingAnyFreePort()
                          .build();
                service.start();
        } catch(IOException e) {e.printStackTrace(); }
}

@AfterTest
public void afterTest() {
        service.stop();
}

@Test(threadPoolSize = 10, invocationCount = 10)
public void testMethod()
{
  WebDriver driver = new RemoteWebDriver(service.getUrl(),
                               DesiredCapabilities.chrome());
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("webdriver");
        searchBox.submit();
        ExpectedCondition<Boolean> condition = leDriver -> !leDriver.getTitle().equals("Google");
        (new WebDriverWait(driver, 10)).until(condition);
        Assert.assertEquals("webdriver - Recherche Google", driver.getTitle());
        driver.quit();
}


}
