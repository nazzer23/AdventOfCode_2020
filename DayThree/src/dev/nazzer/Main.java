package dev.nazzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            File f = new File("input.txt");
            Scanner in = new Scanner(f);


            while(in.hasNextLine()) {
                String line = in.nextLine();
                lines.add(line);
            }

            int trees = 0;
            int x = 0;
            for(int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                x += 3;
                if(x >= line.length()) {
                    x -= line.length();
                }
                if(line.charAt(x) == '#') {
                    trees++;
                }
                char[] lineChars = line.toCharArray();
                lineChars[x] = 'O';
                line = String.valueOf(lineChars);
                System.out.println(line);
            }
            System.out.println("Trees: " + trees);

            long a = getTrees(1, 1);
            long b = getTrees(3, 1);
            long c = getTrees(5, 1);
            long d = getTrees(7, 1);
            long e = getTrees(1, 2);

            System.out.println(a * b * c * d * e);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    private static int getTrees(int right, int down) {
        int trees = 0;
        int x = 0;
        int y = 0;

        int w = lines.get(0).length();
        int h = lines.size();

        while (true) {
            x += right;
            y += down;
            if (x >= w) {
                x -= w;
            }
            if (y >= h) {
                break;
            }
            if (lines.get(y).charAt(x) == '#') {
                trees++;
            }
        }

        return trees;
    }
}
