package com.github.percivalgebashe.service;

import com.github.percivalgebashe.pages.FormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public class FormService extends FormPage {

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

        getWait().until(ExpectedConditions.visibilityOf(getFirstNameTextField()));

        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        selectGender(gender);
        enterMobile(mobile);
        enterDate(date);
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
}