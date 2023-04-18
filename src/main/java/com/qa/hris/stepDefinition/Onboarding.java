package com.qa.hris.stepDefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.hris.locators.Onboarding_Locators;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Onboarding extends DriverAction {
    @When("User clicks on Search Bar")
    public void userClicksOnSearchBar() {
        if (isExist(Onboarding_Locators.searchBar)) {
            click(Onboarding_Locators.searchBar);
            GemTestReporter.addTestStep("Verify if search bar exists",
                    "Search bar exists as required", STATUS.PASS, takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify if search bar exists",
                    "Search bar doesn't exist", STATUS.FAIL, takeSnapShot());
        }
    }

    @Then("User enters {string}")
    public void userEnters(String employeeName) {
        if (isExist(Onboarding_Locators.searchBar)){
            typeText(Onboarding_Locators.searchBar, employeeName);
            GemTestReporter.addTestStep("Verify user is able to enter text",
                    "User entered text successfully", STATUS.PASS, takeSnapShot());
            waitSec(2);
        } else {
            GemTestReporter.addTestStep("Verify user is able to enter text",
                    "User is not able to enter text", STATUS.FAIL, takeSnapShot());
        }
    }

    @Then("User verifies if {string} is present")
    public void userVerifiesIfEmployeeNameIsPresent(String employeeName) {
        waitSec(3);
        if (isExist(Onboarding_Locators.preOnboardingRow)){
            if (isExist(Onboarding_Locators.employeeName) && getElementText(Onboarding_Locators.employeeName).toLowerCase().contains(employeeName)){
                GemTestReporter.addTestStep("Verify employee searched is displayed not",
                        "Employee name searched is present", STATUS.PASS, takeSnapShot());
            }
            else {
                GemTestReporter.addTestStep("Verify employee searched is displayed or not",
                        "Employee name searched is not displayed", STATUS.FAIL, takeSnapShot());
            }
        }
        else {
            GemTestReporter.addTestStep("Verify employee searched is displayed not",
                    "Employee name searched does not exists", STATUS.FAIL, takeSnapShot());
        }
    }
}
