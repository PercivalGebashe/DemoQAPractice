package com.github.percivalgebashe.actions;

import com.github.percivalgebashe.jsExecutors.JSExecutors;
import com.github.percivalgebashe.pages.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Action extends BaseClass {

    private static final Actions actions;

    static {
        actions = new Actions(getDriver());
    }

    public static void click(WebElement element){
        JSExecutors.scrollTo(element);
        actions.click(element)
                .perform();
    }

    public static void sendKeys(WebElement element, String keys){
        actions.sendKeys(element,Keys.CLEAR)
                .sendKeys(keys)
                .perform();
        actions.sendKeys(element,Keys.ENTER);
    }
}
