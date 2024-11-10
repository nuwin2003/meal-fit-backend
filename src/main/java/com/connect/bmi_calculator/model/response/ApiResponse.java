package com.connect.bmi_calculator.model.response;

import com.connect.bmi_calculator.model.BMI;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse extends Response {
    private BMI bmi;
}
