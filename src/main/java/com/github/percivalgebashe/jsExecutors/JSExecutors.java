package com.github.percivalgebashe.jsExecutors;

import com.github.percivalgebashe.pages.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutors extends BaseClass {

    public static void setAttribute(String attribute,
                                    String value,
                                    WebElement target){
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].setAttribute('"+
                attribute+
                "', '"+
                value+
                "');", target);

    }
}
