package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        do {
            try{

                BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

                    String calcString = bReader.readLine();

                Calculator  calculator = new Calculator();
                String result = calculator.result(calcString);
                System.out.println("Жообу: " + result);
            }
            catch(MyException | IOException e){
                }
            } while (true);

        }

    }

