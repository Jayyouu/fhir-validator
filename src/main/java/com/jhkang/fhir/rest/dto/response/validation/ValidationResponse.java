package com.jhkang.fhir.rest.dto.response.validation;

import ca.uhn.fhir.validation.ResultSeverityEnum;
import ca.uhn.fhir.validation.SingleValidationMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ValidationResponse {

    private int myLocationCol;
    private int myLocationLine;
    private String myLocationString;
    private String myMessage;
    private ResultSeverityEnum mySeverity;

    @Builder
    public ValidationResponse(int myLocationCol, int myLocationLine, String myLocationString, String myMessage, ResultSeverityEnum mySeverity) {
        this.myLocationCol = myLocationCol;
        this.myLocationLine = myLocationLine;
        this.myLocationString = myLocationString;
        this.myMessage = myMessage;
        this.mySeverity = mySeverity;
    }

// DO NOT USE
//    public static ValidationResponse from(SingleValidationMessage singleValidationMessage) {
//        return ValidationResponse.builder()
//                .myLocationCol(singleValidationMessage.getLocationCol())
//                .myLocationLine(singleValidationMessage.getLocationLine())
//                .myLocationString(singleValidationMessage.getLocationString())
//                .myMessage(singleValidationMessage.getMessage())
//                .mySeverity(singleValidationMessage.getSeverity())
//                .build();
//    }

    public static List<ValidationResponse> fromList(List<SingleValidationMessage> singleValidationMessages) {
        List<ValidationResponse> validationResponses = new ArrayList<>();

        singleValidationMessages.forEach(singleValidationMessage -> validationResponses.add(
                ValidationResponse.builder()
                        .myLocationCol(singleValidationMessage.getLocationCol())
                        .myLocationLine(singleValidationMessage.getLocationLine())
                        .myLocationString(singleValidationMessage.getLocationString())
                        .myMessage(singleValidationMessage.getMessage())
                        .mySeverity(singleValidationMessage.getSeverity())
                        .build()
        ));
        return validationResponses;
    }
}
