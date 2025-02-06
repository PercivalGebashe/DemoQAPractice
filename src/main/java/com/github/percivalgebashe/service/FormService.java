package com.github.percivalgebashe.service;

import com.github.percivalgebashe.pages.FormPage;
import com.github.percivalgebashe.pages.component.DatePicker;
import com.github.percivalgebashe.util.jsExecutors.JSExecutors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class FormService extends FormPage {
    private final DatePicker datePickerComponent = new DatePicker();
    public void fillForm(Map<String,String> details){

        String firstName = details.get("firstName");
        String lastName = details.get("lastName");
        String email = details.get("email");
        String gender = details.get("gender");
        String mobile = details.get("mobile");
        String date = details.get("date");
        String subjects = details.get("subjects");

        List<String> hobbies = List.of(
                details.get("hobbies").split(","));

        String address = details.get("address");
        String state = details.get("state");
        String city = details.get("city");

        JSExecutors.scrollTo(getSubjectsTextFiled());

        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        selectGender(gender);
        enterMobile(mobile);
        selectDate(date);
        enterSubject(subjects);
        enterHobbies(hobbies);
        uploadPicture();
        enterAddress(address);
        setState(state);
        setCity(city);
    }

    public boolean isShow(){
        WebElement element = getDriver().findElement(
                By.xpath("//div[contains(@class,'modal-title')]"));
        return getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    private void openDatePicker() {
        JSExecutors.click(getDateSelector());
    }

    private void selectMonth(String month) {
        WebElement monthSelect = datePickerComponent.getMonthSelect();
        Select select = new Select(monthSelect);
        JSExecutors.click(monthSelect);
        select.selectByVisibleText(month);
    }

    private void selectYear(String year) {
        WebElement yearSelect = datePickerComponent.getYearSelect();
        Select select = new Select(yearSelect);
        JSExecutors.click(yearSelect);
        select.selectByVisibleText(year);
    }


    public void selectDate(String date) {
        openDatePicker();

        String[] datePartsArray = date.split(" ");

        selectMonth(datePartsArray[0]);
        selectYear(datePartsArray[2]);
        WebElement ActualDay = getDriver().findElement(By.xpath("//div[contains(@aria-label,'" + date+ "')]"));
        JSExecutors.click(ActualDay);
    }
}