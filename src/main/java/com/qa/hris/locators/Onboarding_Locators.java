package com.qa.hris.locators;

import org.openqa.selenium.By;

public class Onboarding_Locators {

    public static By searchBar = By.xpath("//input[@type='search']");

    public static By preOnboardingRow = By.xpath("(//div[@row-id='0'])[1]");

    public static By employeeName = By.xpath("//div[@class='ag-center-cols-container']/div[@row-id='0']/div[@aria-colindex='1']");
}
