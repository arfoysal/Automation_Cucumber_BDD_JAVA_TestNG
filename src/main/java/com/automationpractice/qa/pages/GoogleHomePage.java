package com.automationpractice.qa.pages;

public class GoogleHomePage extends BasePage{

    public String title(){
        return getDriver().getTitle();
    }
}
