package dev.nazzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File f = new File("input.txt");
            Scanner in = new Scanner(f);

            ArrayList<Integer> numbers = new ArrayList<Integer>();

            while(in.hasNextLine()) {
                int temp = in.nextInt();
                System.out.println(temp);
                numbers.add(temp);
            }
            //#region Part One
            /*
            for(int a = 0; a < numbers.size() - 1; a++) {
                int num1 = numbers.get(a);
                for(int b = 0; b < numbers.size() - 1; b++) {
                    int num2 = numbers.get(b);
                    if((num1 + num2) == 2020) {
                        int num3 = num1 * num2;
                        System.out.println("Output: " + num3);
                    }
                }
            }
            */
            //#endregion

            //#region Part Two
            for(int a = 0; a < numbers.size() - 1; a++) {
                int num1 = numbers.get(a);
                for(int b = 0; b < numbers.size() - 1; b++) {
                    int num2 = numbers.get(b);
                    for(int c = 0; c < numbers.size() - 1; c++) {
                        int num3 = numbers.get(c);
                        if ((num1 + num2 + num3) == 2020) {
                            int num4 = num1 * num2 * num3;
                            System.out.println("Output: " + num4);
                        }
                    }
                }
            }
            //#endregion

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
