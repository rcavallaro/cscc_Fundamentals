package com.Rick_Cavallaro.Week_06;

/*
 * Created by Rick on 10/4/2016.
 */
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static int promptInt(String prompt) throws Exception{
        System.out.println(prompt + ":  ");
        String input = scanner.nextLine();
        try{
            int intInput = Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            System.out.println(input + " is not a valid integer.");
            input = scanner.nextLine();
        }
        return intInput;
    }

    private static int promptDouble(String prompt) throws Exception{
        System.out.println(prompt + ":  ");
        String input = scanner.nextLine();
        try{
            double dblInput = Double.parseDouble(input);
        }
        catch (NumberFormatException e){
            System.out.println(input + " is not a valid double.");
            input = scanner.nextLine();
        }
        return dblInput;
    }


    public static void main(String[] args) throws Exception{
        int[] values = {1,2,3};
        int which = promptInt("Enter an integer");
        System.out.println((values[which]));
    }
}
