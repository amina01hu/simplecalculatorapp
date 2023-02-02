package com.example.a1_dps924_aminahussein;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CalculatorBrain extends MainActivity{

    public static ArrayList<String> userClicks = new ArrayList<String>();
    public void push(String value){
        try{
            int newNumber = Integer.parseInt(value);
            if  (userClicks.size() == 0){
                userClicks.add(value);
            }else{
                try{
                    int checkValue = Integer.parseInt(userClicks.get(userClicks.size() - 1));
                    userClicks
                            .set(userClicks.size() - 1, userClicks.get(userClicks.size() - 1)
                                    .concat(value));
                }catch(NumberFormatException e){
                    userClicks.add(value);
                }
            }
        }catch(NumberFormatException e){
            System.out.println("Not a number: " + value);
            userClicks.add(value);
        }
        System.out.println(userClicks.toString());
    }

    public boolean verify(){
        int countO = 0, countL = 0;
        Pattern patternOperators = Pattern.compile("[\\/\\+\\-\\*]");
        Pattern patternLetter = Pattern.compile("\\d+");
        Matcher matcherO = patternOperators.matcher(userClicks.toString());
        Matcher matcherL = patternLetter.matcher(userClicks.toString());
        while(matcherO.find()){
            countO++;
        }
        while(matcherL.find()){
            countL++;
        }
        return countO == 1 && countL == 2;
    }
    public int calculate() throws Exception {
        int indexSplit = 0;
        int returnValue = 0;
        try{
            int value1 = Integer.parseInt(userClicks.get(0));
            int value2 = Integer.parseInt(userClicks.get(2));
            System.out.println(value1 + " " + value2);
            switch (userClicks.get(1)){
                case "+":
                    returnValue = value1 + value2;
                    break;
                case "-":
                    returnValue = value1 - value2;
                    break;
                case"/":
                    returnValue = value1 / value2;
                    break;
                default:
                    returnValue = value1 * value2;
                    break;
            }
        }catch(Exception e){
            throw new Exception("sonething went wrong");
        }
        return returnValue;
    }

    public void clear(){
        userClicks.clear();
    }
}
