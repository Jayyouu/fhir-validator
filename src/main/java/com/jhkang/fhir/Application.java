package com.jhkang.fhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    // FIXME
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);

//        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Organization.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/PractitionerRole.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Encounter.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Condition.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/DiagnosticReport.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Practitioner.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/ObservationLabResult.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/ObservationFuncResult.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Organization.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/ImagingStudy.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Media.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/Procedure.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/AllergyIntolerance.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/DocumentReference.json").getPath();
////        String filePath = Application.class.getClassLoader().getResource("fhir/resource/TestKCD8CodeSystem.json").getPath();
//
//        FhirValidator validator = new FhirValidator();
//        JsonObject jsonObject = JsonUtil.readFileToObject(filePath);
//        String jsonString = JsonUtil.readObjectToString(jsonObject);
//
//        validator.validateResourceR4(jsonString);
    }
}
