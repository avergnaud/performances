package com.catamania.loadtestjboss4;

import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.*;
import java.io.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

import static java.lang.System.out;

public class AuthentAndSubmit
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

@Test(threadPoolSize = 10, invocationCount = 2)
public void testMethod()
{
  WebDriver driver = new RemoteWebDriver(service.getUrl(),
                               DesiredCapabilities.chrome());

        long start = System.currentTimeMillis();

        /*AUTHENT*/
        driver.get("http://localhost:8080/TestJboss4/");
        WebElement searchBox = driver.findElement(By.name("user"));
        searchBox.sendKeys("idValide");
        searchBox = driver.findElement(By.name("pwd"));
        searchBox.sendKeys("mdpValide");
        searchBox.submit();
        ExpectedCondition<Boolean> condition = leDriver -> !leDriver.getTitle().equals("Titre authentification");
        (new WebDriverWait(driver, 10)).until(condition);
        Assert.assertEquals("Formulaire", driver.getTitle());

        /*FORMULAIRE*/
        searchBox = driver.findElement(By.name("champ1"));
        searchBox.sendKeys("valeur 1");
        searchBox = driver.findElement(By.name("champ2"));
        searchBox.sendKeys("valeur 2");
        searchBox.submit();
        condition = leDriver -> !leDriver.getTitle().equals("Formulaire");
        (new WebDriverWait(driver, 10)).until(condition);
        Assert.assertEquals("Accueil", driver.getTitle());

        System.out.println("ThreadId " + Thread.currentThread().getId() + " elapsed time: " + (System.currentTimeMillis() - start));

        driver.quit();
}


}
