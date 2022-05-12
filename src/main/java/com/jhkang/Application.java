package com.jhkang;

import com.google.gson.JsonObject;
import com.jhkang.fhir.util.JsonUtil;
import com.jhkang.fhir.validation.NpmValidator;

public class Application {

    // FIXME
    public static void main(String[] args) throws Exception {

//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Organization.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Practitioner.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/PractitionerRole.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Encounter.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Condition.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/DiagnosticReport.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/ObservationLabResult.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/ObservationFuncResult.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Organization.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/ImagingStudy.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Media.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Procedure.json").getPath();
        String filePath = Application.class.getClassLoader().getResource("fhir/resource/AllergyIntolerance.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/DocumentReference.json").getPath();
//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/TestKCD8CodeSystem.json").getPath();

        NpmValidator validator = new NpmValidator();
        JsonObject jsonObject = JsonUtil.readFileToObject(filePath);
        String jsonString = JsonUtil.readObjectToString(jsonObject);

        validator.npm(jsonString);
    }
}
