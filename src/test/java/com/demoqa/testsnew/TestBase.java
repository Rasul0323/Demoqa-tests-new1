package com.demoqa.testsnew;

import com.codeborne.selenide.Configuration;
import com.demoqa.testsnew.pages.RegistrationPage;
import com.demoqa.testsnew.pages.components.CalendarComponent;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
        Configuration.timeout = 3000;
        Configuration.holdBrowserOpen = true;


    }
}
