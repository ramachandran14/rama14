package com.ofs.training.java.base;

public class SomethingIswrong {

    public static void main(String[] args) {

        Rectangle myRect = new Rectangle();
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());
    }
}

class Rectangle {

    int width;
    int height;

    int area() {

        int area = width * height;
        return area;
    }
}
