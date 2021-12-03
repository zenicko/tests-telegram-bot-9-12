package ru.zenicko;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseClass {

    private AllureLifecycle lifeCycle;

    public void attachmentsAll(){
        lifeCycle.addAttachment("Screenshot " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_HH-mm-ss")),
                "image/png","png", Attachments.takeScreenShot());
        lifeCycle.addAttachment("Html source", "text/html", "html", Attachments.getPageSourceBytes());
        lifeCycle.addAttachment("Console log", "text/plain", "txt", Attachments.getConsoleLog());
        Attachments.addVideo();
    }

    @BeforeAll
    static void screenSize() {
        Configuration.startMaximized = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void setLifeCycle() {
        lifeCycle = Allure.getLifecycle();
    }

}
