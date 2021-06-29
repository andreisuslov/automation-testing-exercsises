package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.DynamicLoadingPage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingStepDefs {
    DynamicLoadingPage dynamicLoadingPage=new DynamicLoadingPage();
    @Given("user is on the dynamic loading page")
    public void user_is_on_the_dynamic_loading_page() {
        String url= ConfigReader.getPropertiesValue("baseUrl");
        Driver.getDriver().get(url+"/dynamic_loading/2");
    }




    @When("user clicks the start button and uses explicit wait.")
    public void user_clicks_the_start_button_and_uses_explicit_wait() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
dynamicLoadingPage.button.click();
wait.until(ExpectedConditions.visibilityOfAllElements(dynamicLoadingPage.helloWorld));
    }
    @Then("asserts that “Hello World!” text is displayed.")
    public void asserts_that_hello_world_text_is_displayed() {
String actualText=dynamicLoadingPage.helloWorld.getText();
String expectedText="Hello World!";
        Assert.assertEquals(actualText,expectedText);
    }

}
