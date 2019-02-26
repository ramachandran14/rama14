package com.ofs.training.java.base;

public class Class2 {

    protected InnerClass1 ic;

    public Class2() {
    ic = new InnerClass1();
    }

    public void displayStrings() {

    System.out.println(ic.getString() + ".");
    System.out.println(ic.getAnotherString() + ".");

    }

    static public void main(String[] args) {

        Class2 c1 = new Class2();
    c1.displayStrings();

    }

    protected class InnerClass1 {

    public String getString() {
        return "InnerClass1: getString invoked";
    }

    public String getAnotherString() {
        return "InnerClass1: getAnotherString invoked";
    }
    }
}
