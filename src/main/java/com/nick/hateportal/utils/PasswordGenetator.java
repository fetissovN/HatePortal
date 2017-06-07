package com.nick.hateportal.utils;

import java.util.Random;

public class PasswordGenetator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    private static final String DIGITS = "0123456789";

    public static String getRandomLowerLetter(){
        String ch = null;
        StringBuilder builder = new StringBuilder(LOWER);
        Random random = new Random();
        int i = random.nextInt(builder.length());
        ch = String.valueOf(builder.charAt(i));
        return ch;
    }

    public static String getRandomUpperLetter(){
        String ch = null;
        StringBuilder builder = new StringBuilder(UPPER);
        Random random = new Random();
        int i = random.nextInt(builder.length());
        ch = String.valueOf(builder.charAt(i));
        return ch;
    }

    public static String getRandomDigit(){
        String ch = null;
        Random random = new Random();
        ch = String.valueOf(random.nextInt(10));
        return ch;
    }

    public static String genPass(int size){
        String pass = "";
        for (int i=0;i<size;i++){
            Random random = new Random();
            int n = random.nextInt(3);
            if (n==0){
                pass =pass + getRandomLowerLetter();
            }
            if (n==1){
                pass = pass + getRandomUpperLetter();
            }
            if (n==2){
                pass = pass + getRandomDigit();
            }
        }
        return pass;
    }
}
