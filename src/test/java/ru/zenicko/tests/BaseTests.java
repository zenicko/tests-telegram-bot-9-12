package ru.zenicko.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.zenicko.Attachments;
import ru.zenicko.helpers.ServerConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.String.format;

public class BaseTests {

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
        ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
        String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");
        Configuration.startMaximized = true;
        Configuration.remote = format("https://%s:%s@%s",cfg.username(), cfg.password(), url);

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
