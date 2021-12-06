package ru.zenicko.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Ya, Jenkins will be with you everywhere!")
public class PracticeFormTests extends BaseClass {

    @Test
    @DisplayName("Testing the students form")
    @Feature("The form from https://demoqa.com/automation-practice-form")
    @Story("Using the common pattern")
    @Owner("Zenicko Co")
    void practiceFormTests() {
        Map<String, String> expectedData = (new DataTests()).getDataForForm();
        //The some variables
        String
                gender = "",
                stemp,
                currentDate = "",
                Hobbies = "",
                stateAndCity = "";
        int pos;

        open("https://demoqa.com/automation-practice-form");
        //Name
        $("#firstName").setValue(expectedData.get("Student firstName"));
        $("#lastName").setValue(expectedData.get("Student lastName"));
        //Email
        $("#userEmail").setValue(expectedData.get("Student Email"));

        //Gender
        switch (expectedData.get("Gender")) {
            case "Female":
                $$(".custom-control-label").get(1).click();
                gender = "Female";
                break;
            case "Other":
                $$(".custom-control-label").get(2).click();
                gender = "Other";
                break;
            default:
                $$(".custom-control-label").get(0).click();
                gender = "Male";
        }

        //Mobile(10 Digits)
        $("#userNumber").setValue(expectedData.get("Mobile"));

        //Date of Birth
        $("#dateOfBirthInput").click();
        currentDate = $("#dateOfBirthInput").getAttribute("value");
        System.out.println("currentDate " + currentDate);
        //$("#dateOfBirthInput").clear();
        for (int i = 1; i <= expectedData.get("Date of Birth").length(); i++) {
            $("#dateOfBirthInput").sendKeys(Keys.BACK_SPACE);
        }
        $("#dateOfBirthInput").setValue(expectedData.get("Date of Birth"));

        //Subjects
        $("#subjectsInput").setValue(expectedData.get("Subjects"));
        $("#react-select-2-option-0").click();

        //Hobbies

        if (expectedData.get("Hobbies").contains("Sports")) {
            $("#hobbiesWrapper").$$(".custom-control-label").get(0).click();
            Hobbies = "Sports";
        }
        if (expectedData.get("Hobbies").contains("Reading")) {
            $("#hobbiesWrapper").$$(".custom-control-label").get(1).click();
            Hobbies += Hobbies == "" ? "Reading" : ", Reading";
        }
        if (expectedData.get("Hobbies").contains("Music")) {
            $("#hobbiesWrapper").$$(".custom-control-label").get(2).click();
            Hobbies += Hobbies == "" ? "Music" : ", Music";
        }

        //Scroll page
        //$("#submit").scrollIntoView(true);

        //Picture
        $("#uploadPicture").uploadFromClasspath(expectedData.get("Picture"));

        //Current Address
        $("#currentAddress").setValue(expectedData.get("Address"));

        //State and City
        $("#state .css-yk16xz-control").click();
        $("#react-select-3-option-0").click(); //.shouldBe(visible)
        stateAndCity = $(".css-1uccc91-singleValue").getText();

        $("#city .css-yk16xz-control").click();
        $("#react-select-4-option-0").click(); //.shouldBe(visible)
        stateAndCity += " " + $$(".css-1uccc91-singleValue").get(1).getText();

        //Submit
        $("#submit").click();


        //Check Student Name: fist name + last name
        System.out.println("Check Student Name:" +
                $$(".table-responsive tbody tr").get(0).$$("td").get(1));
        $$(".table-responsive tbody tr").get(0)
                .$$("td").get(1).shouldHave(text(expectedData.get("Student firstName") +
                        ' ' + expectedData.get("Student lastName")));

        //Check Student Email
        System.out.println("Check Student Emaile:" +
                $$(".table-responsive tbody tr").get(1).$$("td").get(1));
        $$(".table-responsive tbody tr").get(1).
                $$("td").get(1).shouldHave(text(expectedData.get("Student Email")));

        //Check Gender
        System.out.println("Check Gender:" +
                $$(".table-responsive tbody tr").get(2).$$("td").get(1));
        $$(".table-responsive tbody tr").get(2).$$("td").get(1).
                shouldHave(text(gender));

        //Check Mobile
        System.out.println("Check Student Mobile:" +
                $$(".table-responsive tbody tr").get(3).$$("td").get(1));
        $$(".table-responsive tbody tr").get(3).$$("td").get(1).
                shouldHave(text(expectedData.get("Mobile")));

        //Check Date of Birth
        System.out.println("Check Student Date of Birth:" +
                $$(".table-responsive tbody tr").get(4).$$("td").get(1));
        stemp = currentDate.substring(0, 0) + expectedData.get("Checking Date of Birth");
        $$(".table-responsive tbody tr").get(4).$$("td").get(1).
                shouldHave(text(stemp));

        //Check Subjects
        System.out.println("Check Student Subjects:" +
                $$(".table-responsive tbody tr").get(5).$$("td").get(1));
        $$(".table-responsive tbody tr").get(5).$$("td").get(1).
                shouldHave(text(expectedData.get("Subjects")));

        //Check Hobbies
        System.out.println("Check Student Hobbies:" +
                $$(".table-responsive tbody tr").get(6).$$("td").get(1));
        $$(".table-responsive tbody tr").get(6).$$("td").get(1).
                shouldHave(text(Hobbies));

        //Check Picture
        System.out.println("Check Student Picture:" +
                $$(".table-responsive tbody tr").get(7).$$("td").get(1));
        pos = expectedData.get("Picture").lastIndexOf("/") + 1;
        stemp = expectedData.get("Picture").substring(pos);
        $$(".table-responsive tbody tr").get(7).$$("td").get(1).
                shouldHave(text(stemp));

        //Check Current Address
        System.out.println("Check Student Current Address:" +
                $$(".table-responsive tbody tr").get(8).$$("td").get(1));
        $$(".table-responsive tbody tr").get(8).$$("td").get(1).
                shouldHave(text(expectedData.get("Address")));

        //Check State and City
        System.out.println("Check State and City:" +
                $$(".table-responsive tbody tr").get(9).$$("td").get(1));
        $$(".table-responsive tbody tr").get(9).$$("td").get(1).
                shouldHave(text(stateAndCity));

        System.out.println("The test is done!");

        attachmentsAll();
    }
}

