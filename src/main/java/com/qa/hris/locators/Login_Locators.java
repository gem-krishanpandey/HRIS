package com.qa.hris.locators;

import org.openqa.selenium.By;

public class Login_Locators {

    public static By loginButton = By.xpath("//button[@class='login-btn']");

    public static By credentials(String credentialType) {
        if (credentialType.contains("username")) {
            return By.xpath("//input[@type='email']");
        } else {
            return By.xpath("//input[@type='password']");
        }
    }

    public static By nextButton = By.id("idSIButton9");

    public static By image = By.xpath("//img[@class='img-pos']");


}

