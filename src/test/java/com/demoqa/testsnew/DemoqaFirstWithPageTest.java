package com.demoqa.testsnew;

import org.junit.jupiter.api.Test;

public class DemoqaFirstWithPageTest extends TestBase {

    @Test
    void testPracticeForm() {
        registrationPage.openPage()
                        .setFirstName("Mr Sam")
                        .setlastName("Djon")
                        .setuserEmail("dfgsd@gmail.com")
                        .setGender("Male")
                        .setNumber("33333333333")
                        .setBirthDate("12", "July", "1993")
                        .setsubjects("History")
                        .setHobby("Sports")
                        .uploadPicture("4.jpg")
                        .setCurrentAddress("Rp-27")
                        .setState("NCR")
                        .setCity("Gurgaon")
                        .clickSubmit();


      registrationPage.verifyRegistrationResultsModalAppears()
                      .verifyResult("Student Name", "Mr Sam Djon")
                      .verifyResult("Student Email", "dfgsd@gmail.com")
                      .verifyResult("Gender", "Male")
                      .verifyResult("Mobile", "3333333333")
                      .verifyResult("Date of Birth", "12 July,1993")
                      .verifyResult("Subjects", "History")
                      .verifyResult("Hobbies", "Sports")
                      .verifyResult("Picture", "4.jpg")
                      .verifyResult("Address", "Rp-27")
                      .verifyResult("State and City", "NCR Gurgaon");
    }
}
