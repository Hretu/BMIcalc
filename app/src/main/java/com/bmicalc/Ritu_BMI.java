package com.bmicalc;

public class Ritu_BMI {
    private double height,weight;

    public Ritu_BMI(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double calcBMI()
    {

        double BMI = weight/(height*height/100);
        return BMI;
    }
}

