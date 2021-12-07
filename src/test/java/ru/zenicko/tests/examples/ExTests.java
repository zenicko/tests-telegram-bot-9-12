package ru.zenicko.examples;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@Tag("example_tests")
@DisplayName("Test suite: Annotations in use")
public class ExTests {

    @Test
    @DisplayName("SeverityLevel.BLOCKER")
    @Feature("testApplyAllure")
    @Story("0")
    @Owner("Pinky")
    @Severity(SeverityLevel.BLOCKER)
    void testApplyAllure0() {
        Assertions.assertTrue(true);
    }

    @Test
    @Disabled("Feature in refactoring")
    @DisplayName("SeverityLevel.CRITICAL")
    @Feature("testApplyAllure")
    @Story("1")
    @Owner("Redd")
    @Severity(SeverityLevel.CRITICAL)
    void testApplyAllure1() {
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("SeverityLevel.TRIVIAL")
    @Feature("testApplyAllure")
    @Story("2")
    @Owner("Redd")
    @Severity(SeverityLevel.TRIVIAL)
    void testApplyAllure2() {
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("SeverityLevel.None")
    @Feature("testApplyAllure")
    @Story("3")
    @Owner("Tommy")
    void testApplyAllure3() {
        Assertions.assertTrue(true);
    }

    @Test
    @Disabled("Feature in refactoring")
    @DisplayName("SeverityLevel.None")
    @Feature("testApplyAllure")
    @Story("4")
    @Owner("Tommy")
    void testApplyAllure4() {
        Assertions.assertTrue(true);
    }
}
