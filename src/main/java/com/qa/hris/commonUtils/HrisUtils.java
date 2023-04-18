package com.qa.hris.commonUtils;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.hris.locators.Login_Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class HrisUtils extends DriverAction {

    @When("User clicks on Login Button")
    public void signIn() {
        try {
            waitSec(2);
            if (isExist(Login_Locators.loginButton)) {
                click(Login_Locators.loginButton, "Click on Login Button", "Clicked Login Button");
            }
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Check visibility of Login Button", "Login button is not present", STATUS.FAIL, takeSnapShot());
            throw exception;
        }
        waitSec(3);
    }

    @Then("User enters the {string}")
    public void enterCredentials(String credentialType) throws IOException {
        try {
            List<String> browserWindows = new ArrayList<>(getWindowHandles());
            switchToWindow(browserWindows.get(1));
            waitSec(2);
            switch (credentialType) {
                case "username":
                    typeText(Login_Locators.credentials(credentialType), readProperties(credentialType));
                    break;
                case "password":
                    typeText(Login_Locators.credentials(credentialType), readProperties(credentialType));
                    break;
                default:
                    System.out.println("Please enter a valid Input");
            }
            waitSec(2);
            click(Login_Locators.nextButton, "Next Button");
            waitSec(2);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Verify if Login window appears on the screen", "Login window does not appear on the screen", STATUS.FAIL, takeSnapShot());
            throw e;
        }
    }

    @And("User logins into the application")
    public void login() {
        try {
            waitSec(2);
            getElement(Login_Locators.nextButton).click();
            List<String> browserWindows = new ArrayList<>(getWindowHandles());
            switchToWindow(browserWindows.get(0));
        } catch (Exception e) {
            throw e;
        }
    }

    public static String readProperties(String property) throws IOException {
        FileReader read = new FileReader("src/main/resources/config.properties");
        Properties credential = new Properties();
        credential.load(read);
        return credential.getProperty(property);
    }

    @Then("Verify user is logged into the application or not")
    public void verifyLogin() {
        try {
            String expectedUrl = "https://uat-hris.geminisolutions.com/onboarding/employees";
            waitSec(10);
            if (getCurrentURL().contains(expectedUrl) && isExist(Login_Locators.image)) {
                GemTestReporter.addTestStep("Verify if User is logged into the application", "User logins into the HRIS portal", STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify if User is logged into the application", "User is unable to login into the HRIS Portal", STATUS.FAIL, takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Verify if User is logged into the application", "User is unable to login into the HRIS Portal", STATUS.FAIL, takeSnapShot());
            throw e;
        }
    }

}


