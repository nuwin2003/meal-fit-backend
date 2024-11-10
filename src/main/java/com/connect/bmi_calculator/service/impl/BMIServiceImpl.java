package com.connect.bmi_calculator.service.impl;

import com.connect.bmi_calculator.model.BMI;
import com.connect.bmi_calculator.model.State;
import com.connect.bmi_calculator.model.request.ApiRequest;
import com.connect.bmi_calculator.model.response.ApiResponse;
import com.connect.bmi_calculator.service.BMIService;
import com.connect.bmi_calculator.util.Messages;
import com.connect.bmi_calculator.util.RequestStatus;
import com.connect.bmi_calculator.util.ResponseCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BMIServiceImpl implements BMIService {

    @Autowired
    Messages messages;

    private static final Logger logger = LoggerFactory.getLogger(BMIServiceImpl.class);

    @Override
    public ApiResponse calculateBMI(ApiRequest apiRequest) {
        logger.info("BMI Calculate Starts");

        ApiResponse apiResponse = new ApiResponse();
        BMI bmi = new BMI();
        double bmiValue = apiRequest.getWeight() / Math.pow(apiRequest.getHeight(), 2);
        State state = State.fromBmi(bmiValue);
        bmi.setBMIValue(bmiValue);
        bmi.setState(state);

        apiResponse.setBmi(bmi);
        apiResponse.setStatus(RequestStatus.SUCCESS.getStatus());
        apiResponse.setResponseCode(ResponseCodes.SUCCESS);
        apiResponse.setMessage(messages.getMessageForResponseCode(ResponseCodes.BMI_CALCULATION_SUCCESS, null));

        logger.info("BMI Calculate Ends");
        return apiResponse;
    }
}
