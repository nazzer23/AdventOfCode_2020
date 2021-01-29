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

            ArrayList<String> strings = new ArrayList<String>();

            while (in.hasNextLine()) {
                String temp = in.nextLine();
                strings.add(temp);
            }

            int correctAmount = 0;
            //#region Part One
            /*for (String s : strings) {
                String[] splitString = s.split(" ");
                String[] minMax = splitString[0].split("-");
                int min = Integer.parseInt(minMax[0]);
                int max = Integer.parseInt(minMax[1]);

                char pointer = splitString[1].charAt(0);

                String searchString = splitString[2];

                int count = 0;
                for(int i=0; i < searchString.length(); i++)
                {    if(searchString.charAt(i) == pointer)
                    count++;
                }

                if((count >= min) && (count <= max)) {
                    correctAmount++;
                }
            }*/
            //#endregion

            //#region Part Two
            for (String s : strings) {
                String[] splitString = s.split(" ");
                String[] poses = splitString[0].split("-");
                int posOne = Integer.parseInt(poses[0]) - 1;
                int posTwo = Integer.parseInt(poses[1]) - 1;

                char pointer = splitString[1].charAt(0);

                String searchString = splitString[2];

                if((searchString.charAt(posOne) == pointer) && (searchString.charAt(posTwo) != pointer)) {
                    correctAmount++;
                }

                if((searchString.charAt(posOne) != pointer) && (searchString.charAt(posTwo) == pointer)) {
                    correctAmount++;
                }

            }
            //#endregion

            System.out.println("Correct Strings:" + correctAmount);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
