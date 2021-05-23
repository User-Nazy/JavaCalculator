package com.company;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    private int num1;
    private int num2;
    private String operator;


    private int operation(int n1, String op, int n2){
        int res;
        switch (op) {
            case "+":
                res = n1+n2;
                break;
            case "-":
                res = n1-n2;
                break;
            case "*":
                res = n1*n2;
                break;
            case "/":
                res = n1/n2;
                break;
            default:
                throw new AssertionError();
        }
        return res;
    }


    public String result(String text) throws MyException{
        boolean isRomanExp;     // Признак, что числа римские
        Parse parse = new Parse();


        List<String> textLine = Arrays.asList(text.split(" "));


        if (textLine.size()!=3){
            throw new MyException(" -ортосуна пробелдерди коюп иштениз!" +
                    "\n" + " -калькулятор  + , -, *, / белгилери менен гана иштей алат!" +
                    "\n" + " -уч элемент  бере аласыз! мислы: 2 + 2  же V + V  ");
        }


       if (parse.checkOperator(textLine.get(1))){
            operator = textLine.get(1);
        } else {
            throw new MyException(" -калькулятор  '" + textLine.get(1) +
                    "' белгиси менен иштей албайт! " +
                    "  '+, -, *, /' белгилерин бериниз ");
        }


        if (parse.isNumeric(textLine.get(0)) && parse.isNumeric(textLine.get(2))){      //проверяем, что оба числа арабские
            num1 = Integer.parseInt(textLine.get(0));
            num2 = Integer.parseInt(textLine.get(2));
            isRomanExp = false;
        } else if (parse.isRoman(textLine.get(0)) && parse.isRoman(textLine.get(2))){   //проверяем, что оба числа римские
            num1 = parse.romeToArabConvert(textLine.get(0));
            num2 = parse.romeToArabConvert(textLine.get(2));
            isRomanExp = true;
        } else {
            throw new MyException(" эки санды бирдей типте коргозунуз ( 2 + 2  же II + II");
        }


       if (!(num1>=1 && num1<=10) || !(num2>=1 && num2<=10) ){
            throw new MyException(" -калькулятор 1 ден 10 го чейинки сандар менен иштейт ! ");
        }



        int res = operation(num1, operator, num2);


        if (isRomanExp){
            String sign = res < 0 ? "-" : "";
            return sign + parse.arabToRomeConvert(Math.abs(res));
        }


        return String.valueOf(res);
    }

}


