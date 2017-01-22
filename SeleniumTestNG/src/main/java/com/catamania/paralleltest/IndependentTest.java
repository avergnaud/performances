package com.catamania.paralleltest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IndependentTest
{
    @Test(threadPoolSize = 10, invocationCount = 10, timeOut = 1000)
    public void testMethod()
    {
        Long id = Thread.currentThread().getId();
        try {
          Thread.sleep(1000);
        } catch(InterruptedException e) {

        }
        System.out.println("Test method executing on thread with id: " + id);
    }
}
