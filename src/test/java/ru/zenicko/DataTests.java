package ru.zenicko;

import java.util.HashMap;
import java.util.Map;

public class DataTests {
    Map<String, String> valueFields = new HashMap <String, String>();

    public Map<String, String> getDataForForm(){

        String firstName = "Nick",
                lastName = "Ivanov",
                userEmail = "aaa@aa.aa",
                gender = "gender-radio-1",
                userNumber = "9991234567",
                dateOfBirthInput = "5 Nov 2000",
                checkedDateOfBirthInput = "5 November,2000",
                subjectsInput = "Hindi",
                hobbies = "Reading",
                currentAddress = "RU, Moscow, st. Baba Galya, 1",
                fullPath = "img/photo_2020-11-17_15-25-27.jpg",
                state = "NCR",
                city = "Delhi";

        valueFields.put("Student firstName", firstName);
        valueFields.put("Student lastName", lastName);
        valueFields.put("Student Email", userEmail);
        valueFields.put("Gender", gender);
        valueFields.put("Mobile", userNumber);
        valueFields.put("Date of Birth", dateOfBirthInput);
        valueFields.put("Checking Date of Birth", checkedDateOfBirthInput);
        valueFields.put("Subjects", subjectsInput);
        valueFields.put("Hobbies", hobbies);
        valueFields.put("Picture", fullPath);
        valueFields.put("Address", currentAddress);
        valueFields.put("State", state);
        valueFields.put("City", city);

        return valueFields;
    }
}
