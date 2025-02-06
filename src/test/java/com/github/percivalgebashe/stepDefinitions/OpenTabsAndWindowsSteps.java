package com.github.percivalgebashe.stepDefinitions;

import com.github.percivalgebashe.pages.BaseClass;
import com.github.percivalgebashe.pages.BrowserWindows;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class OpenTabsAndWindowsSteps extends BaseClass {

    BrowserWindows page;

    @When("I click on the new tab button")
    public void clickNewTab(){
        page = new BrowserWindows();
        page.clickNewTabBtn();
    }

    @Then("A new tab should open with url {string}")
    public void switchToTab(String url){
        String[] windowHandles = getDriver().getWindowHandles().toArray(new String[3]);
        getDriver().switchTo().window(windowHandles[1]);
        assertEquals(getDriver().getCurrentUrl(), url);
    }

    @When("I click on the new window button")
    public void clickNewWindow(){
        page = new BrowserWindows();
        page.clickNewWindowBtn();
    }

    @Then("A new window should open with url {string}")
    public void switchToWindow(String url){
        String[] windowHandles = getDriver().getWindowHandles().toArray(new String[3]);
        getDriver().switchTo().window(windowHandles[1]);
        assertEquals(getDriver().getCurrentUrl(), url);
    }

    @When("I click on the new window with message button")
    public void clickNewWithMsg(){
        page = new BrowserWindows();
        page.clickNewWindowWithMsgBtn();
    }

    @Then("A new window should open with url with massage {string}")
    public void confirmMessageInWindow(String msg){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){

        }
        Set<String> windowHandles = getDriver().getWindowHandles();
        String window = "";
        for(String handle : windowHandles){
            assert getDriver().switchTo().window(handle)
                    .findElement(By.xpath("//body")).getText().equals(msg);
            window = handle;
            break;
        }

        assert !(window.isEmpty());
        getDriver().switchTo().window(window);

        String actualMsg = page.getPageMsg();

        assertEquals(actualMsg, msg);
    }


    @When("I switch to iframe with Id {string}")
    public void switchToFramWithID(String id){
        WebElement frame = getDriver().findElement(By.id(id));

        getDriver().switchTo().frame(frame);
    }

    @Then("I should be in frame with heading {string}")
    public void confirmHeading(String heading){
        String actualHeading = getDriver().findElement(By.id("sampleHeading")).getText();
        assertEquals(actualHeading, heading);
    }

}
