package com.ofs.training.java.base;

public class Problem {

    static String s;
    class Inner {

        void testMethod() {

        s = "Set from Inner";
        System.out.println(s);

        }
    }

    public static void main(String[] args) {

        //Problem.Inner p = new Problem.Inner();
        Problem.Inner i = new Problem().new Inner();
        i.testMethod();
    }
}
