package com.github.percivalgebashe.pages;

import com.github.percivalgebashe.jsExecutors.JSExecutors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//div[@id='state']//input")
    private WebElement stateSelector;

    @FindBy(xpath = "//div[@id='city']//input")
    private WebElement citySelectore;

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

    public WebElement getStateSelector() {
        return stateSelector;
    }

    public WebElement getCitySelectore() {
        return citySelectore;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public void enterFirstName(String firstName){
        getFirstNameTextField().sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        getLastNameTextField().sendKeys(lastName);
    }

    public void enterEmail(String email){
        getEmailTextField().sendKeys(email);
    }

    public void selectGender(String gender){

       List<WebElement> elements = getGenderRadios();
       for(WebElement element : elements){
           WebElement sibling = element.findElement(By.xpath("following-sibling::label"));
           String radioGender = sibling.getText();
           if(radioGender.equalsIgnoreCase(gender)){
               getWait().until(ExpectedConditions.elementToBeClickable(sibling));
               sibling.click();
           };
       }
    }

    public void enterMobile(String mobile){
        getUserNumberTextField().sendKeys(mobile);
    }

    public void enterDate(String date){

//        JSExecutors.setAttribute("value",date, getDateSelector());
        getDateSelector().clear();
        getDateSelector().sendKeys(date);
        getDateSelector().sendKeys(Keys.ENTER);
    }

    public void enterSubject(String subject){
        getSubjectsTextFiled().sendKeys(subject);
        getSubjectsTextFiled().sendKeys(Keys.ENTER);
    }

    public void enterHobbies(List<String> hobbies){

        for(WebElement element : getHobbiesCheckBox()){
            WebElement sibling = element.findElement(
                    By.xpath("following-sibling::label"));
            if(hobbies.contains(sibling.getText())){
                element.click();
            }
        }
    }

    public void upPicture(){
        File file = new File("./src/test/resources/testData/imgages/Toolsqa_logo.jpg");
        String filePath = file.getAbsolutePath();
        getUploadPictureBtn().sendKeys(filePath);
    }

    public void enterAddress(String address){
        getAdddresTextField().sendKeys(address);
    }

    public void setState(String state){
        getStateSelector().sendKeys(state);
        getStateSelector().sendKeys(Keys.ENTER);
    }

    public void setCity(String city){
        getCitySelectore().sendKeys(city);
//        getStateSelector().sendKeys(Keys.ENTER);
    }

    public void subtForm(){
        getSubmitBtn().submit();
    }


}
