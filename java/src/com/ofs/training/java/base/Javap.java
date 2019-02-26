package com.ofs.training.java.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Javap {

    private static void log(String format, String...vals) {

        System.out.format(format, vals);
        System.out.println();
    }

    private void printClassHeader(Class myClass) {

        log("compiled from \"%s.java\"", myClass.getSimpleName());
    }

    private void printClassDetails(Class myClass) {

        int classMod = myClass.getModifiers();

        log("%s %s %s", parseModifier(classMod), myClass.toString(), getInterfaceDetails(myClass));
    }

    private String parseModifier(int classMod) {

        StringBuilder modifierName = new StringBuilder();
        if (classMod > 0) {

                 if(Modifier.isPrivate(classMod))   { modifierName.append("private ");}
            else if(Modifier.isPublic(classMod))    { modifierName.append("public ");}
            else if(Modifier.isProtected(classMod)) { modifierName.append("protected ");}

                 if (Modifier.isStatic(classMod))       { modifierName.append("static "); }
                 if (Modifier.isAbstract(classMod))     { modifierName.append("abstract "); }
                 if (Modifier.isFinal(classMod))        { modifierName.append("final "); }
                 if (Modifier.isInterface(classMod))    { modifierName.append("interface "); }
                 if (Modifier.isStrict(classMod))       { modifierName.append("strict "); }
                 if (Modifier.isSynchronized(classMod)) { modifierName.append("synchronized "); }
                 if (Modifier.isNative(classMod))       { modifierName.append("native "); }

        }

        return modifierName.toString();

    }

    private String getInterfaceDetails(Class myClass) {

        StringBuilder interfaceName = new StringBuilder();

        Class[] interfaces = myClass.getInterfaces();

        if (interfaces.length > 0) {

            interfaceName.append(" implements ");

            for (Class class1 : interfaces) {
                interfaceName.append(class1.getName()).append(", ");
            }

            interfaceName.replace(interfaceName.length() - 2, interfaceName.length(), "");
        }

        Class superClass = myClass.getSuperclass();

        if (superClass != null) {
            interfaceName.append(" extends").append(" " + superClass.getName());
        }

        return interfaceName.toString();
    }

    private void printClassFields(Class myClass) {

        Field[] fields = myClass.getDeclaredFields();

        for(Field field : fields) {

            StringBuilder fieldName = new StringBuilder();

            int fieldMod = field.getModifiers();
            fieldName.append(parseModifier(fieldMod));

            fieldName.append(field.getType().getTypeName() + " ");

            fieldName.append(field.getName());

            log("%s", fieldName.toString());

        }
    }

    private void printClassConstructors(Class myClass) {

        Constructor[] constructors = myClass.getDeclaredConstructors();

        for(Constructor constructor : constructors) {

            StringBuilder constructorName = new StringBuilder();

            int constructorMod = constructor.getModifiers();
            constructorName.append(parseModifier(constructorMod));

            constructorName.append(constructor.getName() + " (");

            Class[] parameters = constructor.getParameterTypes();

            int parameterCount = constructor.getParameterCount();

            if (parameterCount > 0) {

            for (Class parameter : parameters) {

                constructorName.append(parameter.getTypeName() + ", ");

            }
            constructorName.replace(constructorName.length() - 2, constructorName.length(), "");
            }

            constructorName.append(")");

            log("%s", constructorName.toString());

        }
    }

    private void printClassMethods(Class myClass) {

        Method[] methods = myClass.getDeclaredMethods();

        for(Method method : methods) {

            StringBuilder methodName = new StringBuilder();

            int methodMod = method.getModifiers();
            methodName.append(parseModifier(methodMod));

            methodName.append(method.getReturnType().getTypeName() + " ");

            methodName.append(method.getName() + " (");


            Class[] parameters = method.getParameterTypes();

            int parameterCount = method.getParameterCount();

            if (parameterCount > 0) {

            for (Class parameter : parameters) {

                methodName.append(parameter.getTypeName() + ", ");

            }
            methodName.replace(methodName.length()-2, methodName.length(), "");
            }

            methodName.append(")");

            log("%s", methodName.toString());

        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

        Javap javap = new Javap();

        for(String arg : args) {

            String className = arg;

            Class myClass = Class.forName(className);
            javap.printClassFields(myClass);
            javap.printClassConstructors(myClass);
            javap.printClassMethods(myClass);
        }


    }
}

