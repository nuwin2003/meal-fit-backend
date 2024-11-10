package com.connect.bmi_calculator.service;

import com.connect.bmi_calculator.model.request.ApiRequest;
import com.connect.bmi_calculator.model.response.ApiResponse;

public interface BMIService {
    ApiResponse calculateBMI(ApiRequest apiRequest);
}
