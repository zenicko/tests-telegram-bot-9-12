package ru.zenicko.tests.properties;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Properties;

@Tag("properties")
public class SystemPropertiesTests {

    @Test
    @Tag("get_one_property")
    @DisplayName("Set and get a one parameter to system properties")
    void getSomePropertyTest() {
        String property = System.getProperty("value");
        System.out.println(property);
        System.out.println("sun.arch.data.model " + System.getProperty("sun.arch.data.model"));

        }


    @Test
    @Tag("get_all_properties")
    @DisplayName("Get all system properties")
    void getPropertiesTest() {
        Properties props = System.getProperties();

        String[] strs = props.toString().split(",");
        for (String prop : strs) {
            System.out.println(prop);
        }
    }

    @Test
    @Tag("set_and_get_some_property")
    @DisplayName("Set and get a one parameter to system properties")
    void setAndGetSomePropertyTest(){
        System.setProperty("AAAAA", "Some value");
        System.out.println("AAAAA = " + System.getProperty("AAAAA"));

    }

    @Test
    @DisplayName("Many parameters")
    @Tag("get_many_properties")
    void useParamsForPropertiesTest(){
        String browser = System.getProperty("browser", "Chrome");
        String version = System.getProperty("version", "91");
        String dimension = System.getProperty("dimension", "100x200");
        System.out.println(browser);
        System.out.println(version);
        System.out.println(dimension);
        // gradlew.bat clean many_params -Dbrowser=ghghghgh -Dversion=1000

    }
}
