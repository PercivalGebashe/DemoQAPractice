package com.github.percivalgebashe.util.actions;

import com.github.percivalgebashe.util.jsExecutors.JSExecutors;
import com.github.percivalgebashe.pages.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action extends BaseClass {

    private static final Actions actions;

    static {
        actions = new Actions(getDriver());
    }

    public static void click(WebElement element){
        actions.click(element)
                .perform();
    }

    public static void sendKeys(WebElement element, String keys){
        actions
                .sendKeys(element,Keys.CLEAR)
                .sendKeys(keys)
                .perform();
    }

    public static void clickEnter(WebElement element){
        actions.sendKeys(element, Keys.ENTER)
                .perform();
    }

    public static void scrollToElement(WebElement element){
        actions.scrollToElement(element);
    }

    public static Actions getActions(){
        return actions;
    }
}
