package org.example;

public class Main {

    private static void maxValueInt(){
        System.out.printf("Int max = %d\n", Integer.MAX_VALUE);
    }

    private static void minValueInt(){
        System.out.printf("Int min = %d\n", Integer.MIN_VALUE);
    }

    private static void maxValueLong(){
        System.out.printf("Long max = %d\n", Long.MAX_VALUE);
    }

    private static void minValueLong(){
        System.out.printf("Long min = %d\n", Long.MIN_VALUE);
    }

    private static void maxValueFloat(){
        System.out.println("Float max = " + (Float.MAX_VALUE));
    }

    private static void minValueFloat(){
        System.out.println("Float min = " + (-Float.MAX_VALUE-1));
    }

    private static void maxValueDouble(){
        System.out.println("Double max = " + (Double.MAX_VALUE));
    }

    private static void minValueDouble(){
        System.out.println("Double max = " + (-Double.MAX_VALUE-1));
    }

    private static void minValueChar(){
        System.out.println("Char min = " + (int) (Character.MIN_VALUE));
    }

    private static void maxValueChar(){
        System.out.println("Char max = " + (int) (Character.MAX_VALUE));
    }

    private static void sizeBoolean(){
        System.out.println("In Java, boolean is a separate variable. This is not an analogue of 1 or 0, as, for example, in JavaScript and PHP.");
    }

    private static void maxValueByte(){
        System.out.println("Byte max = " + (Byte.MAX_VALUE));
    }

    private static void minValueByte(){
        System.out.println("Byte min = " + (Byte.MIN_VALUE));
    }

    private static void maxValueShort(){
        System.out.println("Short max = " + (Short.MAX_VALUE));
    }

    private static void minValueShort(){
        System.out.println("Short min = " + (Short.MIN_VALUE));
    }

    private static void sizeString(){
        System.out.println("String length from 0 to " + Integer.MAX_VALUE + " characters");
    }

    private static void sizeArray(){
        System.out.println("Elements in Array can be stored in a list or set at most " + Integer.MAX_VALUE);
    }

    private static void maxMinValuesForPrimitives(){
        minValueChar();
        maxValueChar();
        sizeBoolean();
        minValueByte();
        maxValueByte();
        minValueShort();
        maxValueShort();
        minValueInt();
        maxValueInt();
        minValueLong();
        maxValueLong();
        minValueFloat();
        maxValueFloat();
        minValueDouble();
        maxValueDouble();
        sizeString();
        sizeArray();
    }

    public static void main(String[] args) {
        maxMinValuesForPrimitives();
    }
}