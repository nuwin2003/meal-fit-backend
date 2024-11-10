package com.connect.bmi_calculator.model;

public enum State {
    UNDERWEIGHT(0, 18.5),
    NORMAL_WEIGHT(18.5, 25),
    OVERWEIGHT(25, 30),
    OBESITY_CLASS1(30, 35),
    OBESITY_CLASS2(35, 40),
    EXTREME_OBESITY(40, Double.MAX_VALUE);

    private final double minBmi;
    private final double maxBmi;

    State(double minBmi, double maxBmi) {
        this.minBmi = minBmi;
        this.maxBmi = maxBmi;
    }

    public static State fromBmi(double bmi) {
        for (State state : values()) {
            if (bmi >= state.minBmi && bmi < state.maxBmi) {
                return state;
            }
        }
        throw new IllegalArgumentException("BMI is out of range");
    }
}
