package com.Rick_Cavallaro.Week_06;

/*
 * Created by Rick on 10/4/2016.
 */
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static int promptInt() throws Exception{
        System.out.println("Enter an integer:  ");
        String input = scanner.nextLine();
        int intInput = Integer.parseInt(input);
        return intInput;
    }

    public static void main(String[] args) throws Exception{
        int[] values = {1,2,3};
        int which = promptInt();
        System.out.println((values[which]));
    }
}
