package com.ofs.training.java.base;
abstract class Shape {

    abstract void area();

    void perimeter() {
        System.out.println("perimeter");
    }
}

class Circle extends Shape {

    void area() {
        double area;
        int r = 4;
        area = Math.PI * r * r;
        System.out.println("the area is" + area);
    }

    void perimeter() {
        double perimeter;
        int r = 4;
        perimeter = Math.PI * 2 * r;
        System.out.println("the perimeter is" + perimeter);
    }
}


class Square extends Shape {
    void area() {
        double area;
        int r = 3;
        area = r * r;
        System.out.println("the area is" + area);
    }

    void perimeter() {
        double perimeter;
        int r = 3;
        perimeter = 4 * r;
        System.out.println("the perimeter is" + perimeter);
    }
}


public class MainClass {

    public static void main(String[] args) {

        Shape s = new Circle();
        s.area();
        s.perimeter();

        Shape c = new Square();
        c.area();
        c.perimeter();
    }
}