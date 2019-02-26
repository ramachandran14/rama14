package com.ofs.training.java.adv.MathDate;

public class Optional {

    public static void main(String[] args) {

       String[] str = new String[4];

       Optional optional = Optional.ofNullable(str[0]);

       if (optional.ofNullable(str[0]) != null) {
           System.out.println();
       }
    }

    private static Optional ofNullable(String string) {
        // TODO Auto-generated method stub
        return null;
    }

}