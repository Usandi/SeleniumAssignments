package com.Assignments.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumHW3 {
    WebDriver driver;
    @BeforeMethod
    public void InitializePage() {
        System.setProperty("webdriver.chrome.driver","C:\\Usha\\SeleniumPractice\\src\\main\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();
    }
    @Test
    public void Assignment3() {
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement nway = driver.findElement(By.id("box101"));
        WebElement sholm = driver.findElement(By.id("box2"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement wash = driver.findElement(By.id("box3"));
        WebElement us = driver.findElement(By.id("box103"));
        WebElement copen = driver.findElement(By.id("box4"));
        WebElement denm = driver.findElement(By.id("box104"));
        WebElement seol = driver.findElement(By.id("box5"));
        WebElement skorea = driver.findElement(By.id("box105"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement spain = driver.findElement(By.id("box107"));
        Actions action = new Actions(driver);
        action.dragAndDrop(oslo,nway).build().perform();
        action.dragAndDrop(sholm,sweden).build().perform();
        action.dragAndDrop(wash,us).build().perform();
        action.dragAndDrop(copen,denm).build().perform();
        action.dragAndDrop(seol,skorea).build().perform();
        action.dragAndDrop(rome,italy).build().perform();
        action.dragAndDrop(madrid,spain).build().perform();
    }

    @AfterMethod
    public void ClosePage() {
        driver.close();
    }

}
