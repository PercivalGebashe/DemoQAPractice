package com.github.percivalgebashe.stepDefinitions;

import com.github.percivalgebashe.pages.BaseClass;
import com.github.percivalgebashe.service.FormService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class FillFormSteps extends BaseClass {

    private FormService service;

    @Given("I visit {string}")
    public void openBrowser(String url){
        getDriver().get(url);
    }

    @When("I fill in student details:")
    public void fillForm(DataTable table){
        service = new FormService();

        List<Map<String,String>> tableData = table.asMaps(String.class,String.class);
        Map<String,String> details = tableData.get(0);
        service.fillForm(details);
    }

    @Then("I submit the form")
    public void submitForm(){
        service.submitForm();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(service.isShow());
    }
}