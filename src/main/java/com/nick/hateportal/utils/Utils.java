package com.nick.hateportal.utils;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    public String stringToLowerCase(String s){
        String newString = s.toLowerCase();
        return newString;
    }

    public String firstLetterToHighCase(String s){
        String str = stringToLowerCase(s);

        Character firstChar = str.charAt(0);
        Character firstCapitalChar = Character.toUpperCase(firstChar);

        String result = firstCapitalChar + str.substring(1);

        return result;
    }
}
