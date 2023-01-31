package org.example;

import com.epam.healenium.SelfHealingDriver;

public class financeNavigationPage  extends basePage{
    public financeNavigationPage(SelfHealingDriver driver) {
        super(driver);
    }

    public financeNavigationPage navigateToBrandFinance(){
        ClickElementByXpath("//div[@class='simpleMenuOptions'][contains(.,'Finance')]");

        return new  financeNavigationPage (driver);
    }

    public financeNavigationPage NavigateToBrandFinanceSettings(){
        ClickElementById("ni_1372050625");

        return new  financeNavigationPage (driver);
    }

    public financeNavigationPage navigateToBrandDocumentSettings(){
        ClickElementById("ni_3587456783");

        return new  financeNavigationPage (driver);
    }


}
