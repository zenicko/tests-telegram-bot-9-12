package ru.zenicko;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.logging.LogType.BROWSER;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PracticeFormTests {

    private AllureLifecycle lifeCycle;

    @BeforeAll
    static void screenSize() {
        Configuration.startMaximized = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//
//        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void setLifeCycle() {
        lifeCycle = Allure.getLifecycle();
    }

    @Test
    @DisplayName("Ya, Jenkins will be with you everywhere!")
    @Feature("Testing the form from https://demoqa.com/automation-practice-form")
    @Story("Using the common pattern")
    @Owner("Zenicko Co")
    void practiceFormTests() {

        //The test data
        String firstName = "Nick",
                lastName = "Ivanov",
                userEmail = "aaa@aa.aa",
                genderRadio = "gender-radio-1",
                userNumber = "9991234567",
                dateOfBirthInput = "5 Nov 2000",
                checkedDateOfBirthInput = "5 November,2000",
                subjectsInput = "Hindi",
                currentAddress = "RU, Moscow, st. Baba Galya, 1",
                fullPath = "D:\\IDEAProjects\\demoqa-tests-9\\src\\test\\resources\\photo_2020-11-17_15-25-27.jpg";
        Boolean hobbiesCheckbox1 = true,
                hobbiesCheckbox2 = true,
                hobbiesCheckbox3 = true;
        //The some variables
        String
                gender = "",
                stemp,
                currentDate = "",
                Hobbies = "",
                stateAndCity = "";
        int pos;
        File cv = new File(fullPath);


        open("https://demoqa.com/automation-practice-form");
        //Name
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        //Email
        $("#userEmail").setValue(userEmail);

        //Gender
        switch (genderRadio) {
            case "gender-radio-1":
                $$(".custom-control-label").get(0).click();
                gender = "Male";
                break;
            case "gender-radio-2":
                $$(".custom-control-label").get(1).click();
                gender = "Female";
                break;
            case "gender-radio-3":
                $$(".custom-control-label").get(2).click();
                gender = "Other";
                break;
            default:
                $$(".custom-control-label").get(0).click();
                gender = "Male";
        }

        //Mobile(10 Digits)
        $("#userNumber").setValue(userNumber);

        //Date of Birth
        $("#dateOfBirthInput").click();
        currentDate = $("#dateOfBirthInput").getAttribute("value");
        System.out.println("currentDate " + currentDate);
        //$("#dateOfBirthInput").clear();
        for (int i = 1; i <= dateOfBirthInput.length(); i++) {
            $("#dateOfBirthInput").sendKeys(Keys.BACK_SPACE);
        }
        $("#dateOfBirthInput").setValue(dateOfBirthInput);

        //Subjects
        $("#subjectsInput").setValue(subjectsInput);
        $("#react-select-2-option-0").click();

        //Hobbies
        if (hobbiesCheckbox1) {
            $("#hobbiesWrapper").$$(".custom-control-label").get(0).click();
            Hobbies = "Sports";
        }
        if (hobbiesCheckbox2) {
            $("#hobbiesWrapper").$$(".custom-control-label").get(1).click();
            Hobbies += Hobbies == "" ? "Reading" : ", Reading";
        }
        if (hobbiesCheckbox3) {
            $("#hobbiesWrapper").$$(".custom-control-label").get(2).click();
            Hobbies += Hobbies == "" ? "Music" : ", Music";
        }

        //Scroll page
        $("#submit").scrollIntoView(true);

        //Picture
        $("#uploadPicture").uploadFile(cv);

        //Current Address
        $("#currentAddress").setValue(currentAddress);

        //State and City
        $("#state .css-yk16xz-control").click();
        $("#react-select-3-option-0").click(); //.shouldBe(visible)
        stateAndCity = $(".css-1uccc91-singleValue").getText();

        $("#city .css-yk16xz-control").click();
        $("#react-select-4-option-0").click(); //.shouldBe(visible)
        stateAndCity += " " + $$(".css-1uccc91-singleValue").get(1).getText();

        lifeCycle.addAttachment("Screenshot", "image/png", "png", takeScreenShot());
        //Submit
        $("#submit").click();

        //Check Student Name: fist name + last name
        System.out.println("Check Student Name:" + $$(".table-responsive tbody tr").get(0).$$("td").get(1));
        $$(".table-responsive tbody tr").get(0).$$("td").get(1).shouldHave(text(firstName + ' ' + lastName));

        //Check Student Email
        System.out.println("Check Student Name:" + $$(".table-responsive tbody tr").get(1).$$("td").get(1));
        $$(".table-responsive tbody tr").get(1).$$("td").get(1).shouldHave(text(userEmail));

        //Check Gender
        System.out.println("Check Student Name:" + $$(".table-responsive tbody tr").get(2).$$("td").get(1));
        $$(".table-responsive tbody tr").get(2).$$("td").get(1).shouldHave(text(gender));

        //Check Mobile
        System.out.println("Check Student Name:" + $$(".table-responsive tbody tr").get(3).$$("td").get(1));
        $$(".table-responsive tbody tr").get(3).$$("td").get(1).shouldHave(text(userNumber));

        //Check Date of Birth
        System.out.println("Check Student Name:" + $$(".table-responsive tbody tr").get(4).$$("td").get(1));
        stemp = currentDate.substring(0, 0) + checkedDateOfBirthInput;
        $$(".table-responsive tbody tr").get(4).$$("td").get(1).shouldHave(text(stemp));

        //Check Subjects
        System.out.println("Check Student Name:" + $$(".table-responsive tbody tr").get(5).$$("td").get(1));
        $$(".table-responsive tbody tr").get(5).$$("td").get(1).shouldHave(text(subjectsInput));

        //Check Hobbies
        System.out.println("Check Student Name:" + $$(".table-responsive tbody tr").get(6).$$("td").get(1));
        $$(".table-responsive tbody tr").get(6).$$("td").get(1).shouldHave(text(Hobbies));

        //Check Picture
        System.out.println("Check Student Name:" + $$(".table-responsive tbody tr").get(7).$$("td").get(1));
        pos = fullPath.lastIndexOf("\\") + 1;
        stemp = fullPath.substring(pos);
        $$(".table-responsive tbody tr").get(7).$$("td").get(1).shouldHave(text(stemp));

        //Check Current Address
        System.out.println("Check Student Name:" + $$(".table-responsive tbody tr").get(8).$$("td").get(1));
        $$(".table-responsive tbody tr").get(8).$$("td").get(1).shouldHave(text(currentAddress));

        //Check State and City
        System.out.println("Check Student Name:" + $$(".table-responsive tbody tr").get(9).$$("td").get(1));
        $$(".table-responsive tbody tr").get(9).$$("td").get(1).shouldHave(text(stateAndCity));

        System.out.println("The test is done!");

        lifeCycle.addAttachment("Screenshot", "image/png", "png", takeScreenShot());
        lifeCycle.addAttachment("Screenshot " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_HH-mm-ss")),
                "image/png",
                "png",
                takeScreenShot());
        lifeCycle.addAttachment("Html source", "text/html", "html", getPageSourceBytes());
        lifeCycle.addAttachment("Console log", "text/plain", "txt", getConsoleLog());
        addVideo();
    }

    private byte[] takeScreenShot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private byte[] getPageSourceBytes() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    private byte[] getConsoleLog() {
        //LogType.BROWSER
        String logs = "";
        for (LogEntry logEntry : WebDriverRunner.getWebDriver().manage().logs().get(BROWSER).getAll()) {
            logs += logEntry.toString() + "\n";
        }

        return logs.getBytes(StandardCharsets.UTF_8);
    }


    //Attach svasenkov

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl(getSessionId())
                + "' type='video/mp4'></video></body></html>";
    }

    public static URL getVideoUrl(String sessionId) {
        String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId + ".mp4";

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }
}

