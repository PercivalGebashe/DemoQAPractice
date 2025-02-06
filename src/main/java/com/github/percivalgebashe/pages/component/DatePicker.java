package com.github.percivalgebashe.pages.component;

import com.github.percivalgebashe.pages.FormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePicker extends FormPage {

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthSelect;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearSelect;

    private final By MONTH_FRAME = By.xpath("//div[contains(@aria-label,'month  ')]");

    private final By WEEKS = By.xpath("//div[@class='react-datepicker__week']");

    public DatePicker() {
        PageFactory.initElements(getDriver(), this);
    }

    /**
     *
     * @param date {String} e.g. January 1st, 2025
     * @return WebElement
     */
    public WebElement getDayOfWeek(String date){
        return getDriver().findElement(WEEKS);
    }

    public WebElement getMonthSelect() {
        return monthSelect;
    }
    public WebElement getYearSelect() {
        return yearSelect;
    }

    public WebElement getMonthFrame() {
        return getDriver().findElement(MONTH_FRAME);
    }
    public WebElement getWeekFrame() {
        return getDriver().findElement(WEEKS);
    }
}

