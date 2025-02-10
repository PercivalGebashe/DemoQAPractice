package com.github.percivalgebashe.pages;

import com.github.percivalgebashe.util.actions.Action;
import com.github.percivalgebashe.util.jsExecutors.JSExecutors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class FormPage extends BaseClass{

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameTextField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameTextField;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[contains(@id,'gender-radio')]")
    private List<WebElement> genderRadios;

    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement userNumberTextField;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateSelector;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    private WebElement subjectsTextFiled;

    @FindBy(xpath = "//input[contains(@id,'hobbies-checkbox')]")
    private List<WebElement> hobbiesCheckBox;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    private WebElement uploadPictureBtn;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement adddresTextField;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@id='react-select-4-input']")
    private WebElement cityInput;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitBtn;



    public FormPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getFirstNameTextField() {
        return firstNameTextField;
    }

    public WebElement getLastNameTextField() {
        return lastNameTextField;
    }

    public WebElement getEmailTextField() {
        return emailTextField;
    }

    public List<WebElement> getGenderRadios() {
        return genderRadios;
    }

    public WebElement getUserNumberTextField() {
        return userNumberTextField;
    }

    public WebElement getDateSelector() {
        return dateSelector;
    }

    public WebElement getSubjectsTextFiled() {
        return subjectsTextFiled;
    }

    public List<WebElement> getHobbiesCheckBox() {
        return hobbiesCheckBox;
    }

    public WebElement getUploadPictureBtn() {
        return uploadPictureBtn;
    }

    public WebElement getAdddresTextField() {
        return adddresTextField;
    }

    public WebElement getStateInput() {
        return stateInput;
    }

    public WebElement getCityInput() {
        return cityInput;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public void enterFirstName(String firstName){
        JSExecutors.scrollTo(getFirstNameTextField());
        JSExecutors.sendKeys(getFirstNameTextField(), firstName);
    }

    public void enterLastName(String lastName){
        JSExecutors.scrollTo(getLastNameTextField());
        JSExecutors.sendKeys(getLastNameTextField(), lastName);
    }

    public void enterEmail(String email){
        JSExecutors.scrollTo(getEmailTextField());
        JSExecutors.sendKeys(getEmailTextField(), email);
    }

    public void selectGender(String gender){
       List<WebElement> elements = getGenderRadios();
       for(WebElement element : elements){
           if(element.getDomAttribute("value").equalsIgnoreCase(gender)){
               JSExecutors.click(element);
           }
       }
    }

    public void enterMobile(String mobile){
        JSExecutors.sendKeys(getUserNumberTextField(), mobile);
    }

    public void enterDate(String date){
        JSExecutors.sendKeys(getDateSelector(), date);
    }

    public void enterSubject(String subjects){
        JSExecutors.scrollTo(getSubjectsTextFiled());
        for (String subject : subjects.split(",")) {
            getSubjectsTextFiled().sendKeys(subject);
            Action.clickEnter(getSubjectsTextFiled());
        }
    }

    public void enterHobbies(String hobbies){

        for(WebElement element : getHobbiesCheckBox()){
            WebElement sibling = element.findElement(
                    By.xpath("following-sibling::label"));
            if(hobbies.contains(sibling.getText())){
                JSExecutors.scrollTo(element);
                JSExecutors.click(element);
            }else{

            }
        }
    }

    public void uploadPicture(){
        File file = new File("./src/test/resources/testData/imgages/Toolsqa_logo.jpg");
        String filePath = file.getAbsolutePath();
        getUploadPictureBtn().sendKeys(filePath);
    }

    public void enterAddress(String address){
        getAdddresTextField().sendKeys(address);
    }

    public void setState(String state) {
        JSExecutors.scrollTo(getStateInput());
        JSExecutors.sendKeys(getStateInput(), state);
        Action.clickEnter(getStateInput());
    }

    public void setCity(String city){
        JSExecutors.scrollTo(getCityInput());
        JSExecutors.sendKeys(getCityInput(), city);
        Action.clickEnter(getCityInput());

    }

    public void submitForm(){
        getSubmitBtn().submit();
    }

    public WebElement getSelect(){
        return getWait().until(
                ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//div[contains(@class, '-menu')]")));
    }

    public WebElement getSelectItem(String item){
        WebElement select =  getSelect();
        getWait().until(ExpectedConditions.visibilityOf(select));
        return select.findElement(By.xpath("./child::*[contains(text()," + item + ")]"));
    }


}
