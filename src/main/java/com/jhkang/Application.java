package com.jhkang;

import com.google.gson.JsonObject;
import com.jhkang.fhir.util.JsonUtil;
import com.jhkang.fhir.validation.NpmValidator;

public class Application {

    // FIXME
    public static void main(String[] args) throws Exception {

        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Organization.json").getPath();

        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\Organization.json");
        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\Practitioner.json");
        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\PractitionerRole.json");
        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\Encounter.json");
        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\Condition.json");
        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\MedicationRequest.json");
        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\DiagnosticReport.json");
        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\ImagingStudy.json");
        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\Media.json");
        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\Procedure.json");
        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\AllergyIntolerance.json");
        //        Reader reader = new FileReader("C:\\Users\\jhkan\\IdeaProjects\\validator\\src\\main\\resources\\fhir\\resource\\DocumentReference.json");

        NpmValidator validator = new NpmValidator();
        JsonObject jsonObject = JsonUtil.readFileToObject(filePath);
        String jsonString = JsonUtil.readObjectToString(jsonObject);

        validator.npm(jsonString);
    }
}
