package com.qa.hris.stepDefinition;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;

public class Hook {
        @Before
        public void start() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--incognito");
            options.addArguments("start-maximized");
            DriverManager.initializeChrome(options);
            DriverManager.getWebDriver().get("https://uat-hris.geminisolutions.com/");

        }
    }
