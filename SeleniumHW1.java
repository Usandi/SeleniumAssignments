package com.Assignments.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumHW1 {
    WebDriver driver;
    @BeforeMethod
    public void InitializePage() {
        System.setProperty("webdriver.chrome.driver","C:\\Usha\\SeleniumPractice\\src\\main\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void Assignment1() {
        driver.findElement(By.linkText("REGISTER")).click();
        driver.findElement(By.name("firstName")).sendKeys("Firstname");
        driver.findElement(By.name("lastName")).sendKeys("Lastname");
        driver.findElement(By.name("phone")).sendKeys("123-1234");
        driver.findElement(By.name("userName")).sendKeys("abc@ab.bc");
        driver.findElement(By.name("address1")).sendKeys("1234 abcd");
        driver.findElement(By.name("city")).sendKeys("Mycity");
        driver.findElement(By.name("state")).sendKeys("AB");
        driver.findElement(By.name("postalCode")).sendKeys("12345");
        WebElement dpdn = driver.findElement(By.name("country"));
        Select sdpdn = new Select(dpdn);
        sdpdn.selectByValue("215");
        Actions action = new Actions(driver);
        WebElement uname = driver.findElement(By.name("userName"));
        action.keyDown(uname, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();//select username
        WebElement email = driver.findElement(By.name("email"));
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(email,Keys.CONTROL).perform();// copy username
        action.keyDown(email, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();// paste username into email
        driver.findElement(By.name("password")).sendKeys("Password");
        WebElement pword = driver.findElement(By.name("password"));
        WebElement cpword = driver.findElement(By.name("confirmPassword"));
        action.keyDown(pword, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();//select password
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(pword,Keys.CONTROL).perform();// copy password
        action.keyDown(cpword, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();// paste username into email
        driver.findElement(By.xpath("//input[@name='register']")).click();
        String message = driver.findElement(By.xpath("//table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")).getText();
        System.out.println(message);
        Assert.assertEquals(message,"Dear Firstname Lastname,");

    }
    @AfterMethod
    public void ClosePage() {
        driver.close();
    }
}
