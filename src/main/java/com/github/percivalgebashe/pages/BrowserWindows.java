package com.github.percivalgebashe.pages;

import com.github.percivalgebashe.util.actions.Action;
import com.github.percivalgebashe.util.jsExecutors.JSExecutors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrowserWindows extends BaseClass{

    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement newTabBtn;

    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement newWindowBtn;

    @FindBy(xpath = "//button[@id='messageWindowButton']")
    private WebElement windowWithMsgBtn;

    public BrowserWindows(){
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getNewTabBtn() {
        return newTabBtn;
    }

    public WebElement getNewWindowBtn() {
        return newWindowBtn;
    }

    public WebElement getWindowWithMsgBtn() {
        return windowWithMsgBtn;
    }

    public void clickNewTabBtn(){
        JSExecutors.click(getNewTabBtn());
    }

    public void clickNewWindowBtn(){
        JSExecutors.click(getNewWindowBtn());
    }

    public void clickNewWindowWithMsgBtn(){
        //Action.click(getWindowWithMsgBtn());
        getWait().until(ExpectedConditions.elementToBeClickable(getWindowWithMsgBtn()));

    }

    public String getPageMsg(){
        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body")))
                .getText();
    }
}
