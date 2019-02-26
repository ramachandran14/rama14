package com.ofs.training.java.base;

public class Enum {

    enum Rainbow {
    violet,
    indigo,
    blue,
    green,
    yellow,
    orange,
    red;
    }

public static void main(String[] args) {

    Rainbow v = Rainbow.violet;
    Rainbow i = Rainbow.indigo;
    Rainbow b = Rainbow.blue;
    Rainbow g = Rainbow.green;
    Rainbow y = Rainbow.yellow;
    Rainbow o = Rainbow.orange;
    Rainbow r = Rainbow.red;
    System.out.println(g.equals(r));
    System.out.println(g == b);
}
}
