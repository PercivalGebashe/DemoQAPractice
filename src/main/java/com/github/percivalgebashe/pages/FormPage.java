package com.github.percivalgebashe.pages;

import com.github.percivalgebashe.actions.Action;
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

    @FindBy(xpath = "//div[@id='state']")
    private WebElement stateSelector;

    @FindBy(xpath = "//div[@id='city']")
    private WebElement citySelector;

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

    public WebElement getCitySelector() {
        return citySelector;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public void enterFirstName(String firstName){
        Action.sendKeys(getFirstNameTextField(), firstName);
    }

    public void enterLastName(String lastName){
        Action.sendKeys(getLastNameTextField(), lastName);
    }

    public void enterEmail(String email){
        Action.sendKeys(getEmailTextField(), email);
    }

    public void selectGender(String gender){

       List<WebElement> elements = getGenderRadios();
       for(WebElement element : elements){
           WebElement sibling = element.findElement(By.xpath("following-sibling::label"));
           String radioGender = sibling.getText();
           if(radioGender.equalsIgnoreCase(gender)){
               Action.click(sibling);
           }
       }
    }

    public void enterMobile(String mobile){
        Action.sendKeys(getUserNumberTextField(), mobile);
    }

    public void enterDate(String date){
        Action.sendKeys(getDateSelector(), date);
    }

    public void enterSubject(String subject){
        for (String s : subject.split(",")) {
            Action.sendKeys(getSubjectsTextFiled(),s);
        }
    }

    public void enterHobbies(List<String> hobbies){

        for(WebElement element : getHobbiesCheckBox()){
            WebElement sibling = element.findElement(
                    By.xpath("following-sibling::label"));
            if(hobbies.contains(sibling.getText())){
                System.out.println("Its true!");
                Action.click(element);
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
        Action.click(getStateSelector());
        getMenuItem(state);
    }

    public void setCity(String city){
        Action.click(getCitySelector());
        getMenuItem(city);

    }

    public void submitForm(){
        getSubmitBtn().submit();
    }

    public WebElement getMenu(){
        return getWait().until(
                ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//div[contains(@class, '-menu')]")));
    }

    public WebElement getMenuItem(String item){
        WebElement menu =  getMenu();
        getWait().until(ExpectedConditions.visibilityOf(menu));
        return menu.findElement(By.xpath("./child::*[contains(text()," + item + ")]"));
    }


}
