package com.siva224513.Array;

public class Area {
    public double calculateArea(double l, double b) {
       
        return l * b;
    }

    public double calculateArea(double a) {
        
        return a * a;
    }

    public double calculateArea(double p,double b, double h) {
        
        return p * b * h;
    }

    public static void main(String[] args) {
        Area c = new Area();
        System.out.println("Area of Rectangle: " +  c.calculateArea(4.0, 6.0));

        System.out.println("Area of Square: " + c.calculateArea(5.0));

        System.out.println("Area of Triangle: " + c.calculateArea(0.5,3.0, 4.0 ));
    }
}

    

