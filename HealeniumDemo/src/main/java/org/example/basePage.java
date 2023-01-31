package org.example;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;


public class basePage {

    protected SelfHealingDriver driver;

    public basePage(SelfHealingDriver driver) {
        this.driver = driver;
    }

    public void ClickElementByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
    public void ClickElementById(String id){
        driver.findElement(By.xpath(id)).click();
    }

    public void ClickElementByClassName(String className){
        driver.findElement(By.xpath(className)).click();
    }

    public void sendKeysToElementByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
    public financeNavigationPage clickThreeDots(){

        ClickElementByXpath("//div[@class='iconButton iconMore']");

        return new  financeNavigationPage (driver);
    }




}