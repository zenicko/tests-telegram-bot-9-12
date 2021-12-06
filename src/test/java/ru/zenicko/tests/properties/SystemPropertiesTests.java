package ru.zenicko.tests.properties;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Properties;

public class SystemPropertiesTests {


    @Test
    void getSomePropertyTest() {
        String property = System.getProperty("value");
        System.out.println(property);
        System.out.println("sun.arch.data.model " + System.getProperty("sun.arch.data.model"));

        Properties props = System.getProperties();

        String[] strs = props.toString().split(",");
        for (String prop : strs) {
            System.out.println(prop);
        }
    }

    @Test
    void getPropertiesTest() {
        Properties props = System.getProperties();

        String[] strs = props.toString().split(",");
        for (String prop : strs) {
            System.out.println(prop);
        }
    }

    @Test
    @DisplayName("One parameter")
    void setAndGetSomePropertyTest(){
        System.setProperty("AAAAA", "Some value");
        System.out.println("AAAAA = " + System.getProperty("AAAAA"));

        Properties props = System.getProperties();

        String[] strs = props.toString().split(",");
        for (String prop : strs) {
            System.out.println(prop);
        }
    }

    @Test
    @DisplayName("Many parameters")
    @Tag("properties")
    void useParamsForPropertiesTest(){
        String browser = System.getProperty("browser", "Chrome");
        String version = System.getProperty("version", "91");
        String dimension = System.getProperty("dimension", "100x200");
        System.out.println(browser);
        System.out.println(version);
        System.out.println(dimension);
        // gradlew.bat clean useParamsForPropertiesTest -Dbrowser=opera -Dversion=99 -Ddimension=100x200
        // gradlew.bat clean many_params -Dbrowser=ghghghgh -Dversion=1000

    }


}
