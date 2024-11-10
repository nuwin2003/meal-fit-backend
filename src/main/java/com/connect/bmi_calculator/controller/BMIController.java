package com.connect.bmi_calculator.controller;

import com.connect.bmi_calculator.model.request.ApiRequest;
import com.connect.bmi_calculator.model.response.ApiResponse;
import com.connect.bmi_calculator.service.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/bmi")
public class BMIController {

    @Autowired
    BMIService bmiService;

    @PostMapping("/calculate")
    public ApiResponse calculateBMI(@RequestBody ApiRequest apiRequest){
        return bmiService.calculateBMI(apiRequest);
    }
}
