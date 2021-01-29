package dev.nazzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try {
            File f = new File("input.txt");
            Scanner in = new Scanner(f);

            ArrayList<String> passports = new ArrayList<String>();

            String construct = "";
            while(in.hasNextLine()) {
                String temp = in.nextLine();
                if(!temp.isEmpty()) {
                    construct += temp+" ";
                } else {
                    passports.add(construct);
                    construct = "";
                }
            }

            System.out.println("Total Passports: " + passports.size());
            int validPassports = 0;

            for(String passport : passports) {
                String[] parametersArr = passport.split(" ");
                HashMap<String, String> parameters = new HashMap<>();
                for(String parameter: parametersArr) {
                    String[] params = parameter.split(":");
                    parameters.put(params[0], params[1]);
                }

                String[] requiredParams = {
                        "byr", "iyr","eyr","hgt","hcl","ecl","pid"
                };

                boolean failed = false;
                for(int i = 0; i < requiredParams.length; i++) {
                    if(parameters.get(requiredParams[i]) == null) {
                        failed = true;
                    } else {
                        String parameter = requiredParams[i];
                        String data = parameters.get(parameter);
                        if(parameter.equals("byr")) {
                            int birthYear = Integer.parseInt(data);
                            if(birthYear < 1920 || birthYear > 2002) {
                                failed = true;
                            }
                        }

                        if(parameter.equals("iyr")) {
                            int iyr = Integer.parseInt(data);
                            if(iyr < 2010 || iyr > 2020) {
                                failed = true;
                            }
                        }

                        if(parameter.equals("eyr")) {
                            int eyr = Integer.parseInt(data);
                            if(eyr < 2020 || eyr > 2030) {
                                failed = true;
                            }
                        }

                        if(parameter.equals("hgt")) {
                            Matcher matcher = Pattern.compile("^(\\d+)(\\w+)").matcher(data);
                            if(matcher.find()) {
                                int val = Integer.parseInt(matcher.group(1));
                                if(matcher.group(2).equals("cm")) {
                                    if(val < 150 || val > 193) {
                                        failed = true;
                                    }
                                } else if(matcher.group(2).equals("in")) {
                                    if(val < 59 || val > 76) {
                                        failed = true;
                                    }
                                } else {
                                    failed = true;
                                }
                            } else {
                                failed = true;
                            }
                        }

                        if(parameter.equals("hcl")) {
                            Matcher matcher = Pattern.compile("^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$").matcher(data);
                            if (!matcher.find()) {
                                failed = true;
                            }
                        }

                        if(parameter.equals("ecl")) {
                            boolean found = false;
                            String[] eyeColours = {
                                    "amb","blu","brn","gry","grn","hzl","oth"
                            };
                            for(int a = 0; a < eyeColours.length; a++) {
                                if(eyeColours[a].equals(data)) {
                                    found = true;
                                }
                            }
                            if(!found) {
                                failed = true;
                            }
                        }

                        if(parameter.equals("pid")) {
                            Matcher matcher = Pattern.compile("^([0-9]\\d{8})$").matcher(data);
                            if(matcher.find()) {
                                if(matcher.group(1).length() != 9) {
                                    failed = true;
                                }
                            } else {
                                failed = true;
                            }
                        }
                    }
                }

                if(!failed) {
                    System.out.println("[PASSED] " + passport);
                    validPassports++;
                }


            }

            System.out.println("Valid Passports: " + validPassports);


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
