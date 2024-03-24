package com.demoqa.testsnew;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaFirstWithPageTest extends TestBase {
    @Test
    void testPracticeForm() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Mr Sam");
        $("#lastName").setValue("Djon");
        $("#userEmail").setValue("dfgsd@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("33333333333");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("July")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1993")).click();
        $(".react-datepicker__day--012").click();
        $("#subjectsInput").setValue("History");
        $("#subjectsInput").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/4.jpg"));
        $("#currentAddress").setValue("Rp-27");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Gurgaon")).click();
        $("#submit").click();

        $(".table").shouldHave(
                text("Mr Sam Djon"),
                text("dfgsd@gmail.com"),
                text("Male"),
                text("3333333333"),
                text("12 July,1993"),
                text("History"),
                text("Sports"),
                text("4.jpg"),
                text("Rp-27"),
                text("NCR Gurgaon"));

    }
}
