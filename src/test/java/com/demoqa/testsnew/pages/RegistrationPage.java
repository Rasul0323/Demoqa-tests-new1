package com.demoqa.testsnew.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.testsnew.pages.components.CalendarComponent;
import com.demoqa.testsnew.pages.components.ResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();
    SelenideElement formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
           gender = $("#genterWrapper"),
           userNumber = $("#userNumber"),
           dateOfBirthInput = $("#dateOfBirthInput"),
           subjectsInput = $("#subjectsInput"),
           hobbies = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
           currentAddressInput = $("#currentAddress"),
          stateInput = $("#state"),
          cityInput = $("#city"),
         submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formHeaderText.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public RegistrationPage removeBanners() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setlastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setuserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setNumber(String value) {
        userNumber.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
       calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setsubjects(String value) {
       subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobby(String value) {
       hobbies.$(byText(value)).click();
        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }
    public void clickSubmit() {
        submitButton.click();
    }
    public RegistrationPage verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();

        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
      resultsModal.verifyResult(key, value);
        return this;
    }

}
