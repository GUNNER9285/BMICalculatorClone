package com.example.bmicalculator.model;

import static com.example.bmicalculator.R.drawable.bmi;

/**
 * Created by GUNNER on 8/10/2560.
 */

public class Person {
    private Double height;
    private Double weight;

    public Person(Double height, Double weight) {
        this.height = height;
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmiValue(){
        return weight/Math.pow(height/100, 2);
    }
    public String getBmiText(){
        Double bmi = getBmiValue();
        String text = "";
        if (bmi < 18.5){
            text = "น้ำหนักน้อยกว่าปกติ";
        }
        else if(bmi < 25){
            text = "น้ำหนักปกติ";
        }
        else if(bmi < 0){
            text = "น้ำหนักมากกว่าปกติ (ท้วม)";
        }
        else {
            text = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }
        return text;
    }
}
