package com.ofs.training.java.base;

import java.lang.reflect.Method;

public class Javarun {

    public static void main(String[] args) throws Exception {

        String str = args[0];

        Class Javarun = Class.forName(str);

        Method method = Javarun.getDeclaredMethod("main", String[].class);

        String[] variable = { "java.lang.String" };
        method.invoke(null, (Object) variable);

    }

}

