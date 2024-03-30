package com.demoqa.testsnew;

import com.demoqa.testsnew.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.demoqa.testsnew.TestData.*;
import static com.demoqa.testsnew.utils.RandomUtils.getRandomCity;
import static com.demoqa.testsnew.utils.RandomUtils.getRandomInt;


public class PracticeFormRegistrationTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option(TestData.gender),
            userNumber = 89 + faker.phoneNumber().subscriberNumber(8),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 25)),
            monthOfBirth = faker.options().option(months),
            yearOfBirth = String.valueOf(getRandomInt(1956, 2004)),
            subject = faker.options().option(subjects),
            hobbies = faker.options().option(hobbiess),
            currentAddress = faker.address().streetAddress(),
            randomState = faker.options().option(states),
            randomCity = getRandomCity(randomState);

    @Test
    void testPracticeForm() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setlastName(lastName)
                .setuserEmail(userEmail)
                .setGender(userGender)
                .setNumber(userNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setsubjects(subject)
                .setHobby(hobbies)
                .uploadPicture("4.jpg")
                .setCurrentAddress(currentAddress)
                .setState(randomState)
                .setCity(randomCity)
                .clickSubmit();


        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", "4.jpg")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", randomState + " " + randomCity);
    }
}