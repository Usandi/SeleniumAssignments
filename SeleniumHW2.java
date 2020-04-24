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

public class SeleniumHW2 {
    WebDriver driver;
    @BeforeMethod
    public void InitializePage() {
        System.setProperty("webdriver.chrome.driver","C:\\Usha\\SeleniumPractice\\src\\main\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void Assignment2() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
        WebElement emplist = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        Actions action = new Actions(driver);
        action.moveToElement(pim).moveToElement(emplist).click().build().perform();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
        //String s = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[2]")).getText();
        //System.out.println(s);
        int rcount = rows.size();
        //System.out.println(rcount);
        for (int i=2; i<=rcount; i++) {
            String fname = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[3]")).getText();
            System.out.println(fname);
            String lname = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[4]")).getText();
            System.out.println(lname);
            String jobttl = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[5]")).getText();
            System.out.println(jobttl);
            String mnger = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[8]")).getText();
            System.out.println(mnger+"\n");
        }
    }
    @AfterMethod
    public void ClosePage() {
        driver.close();
    }
}
