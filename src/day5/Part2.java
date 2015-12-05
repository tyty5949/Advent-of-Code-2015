package day5;

import advent.DayInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tyty5949 on 12/4/15 at 6:03 PM.
 * Project: Advent of Code 2015
 */
public class Part2 implements DayInterface {

    private ArrayList<String> input;
    private int answer;

    @Override
    public void getInput() {
        input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some data: ");
        do {
            input.add(scanner.nextLine());
        } while (!input.get(input.size() - 1).equals("go"));
        input.remove(input.size() - 1);
    }

    @Override
    public void calculateAnswer() {
        answer = 0;
        for(int i = 0; i < input.size(); i++) {
            boolean nice1 = false;
            boolean nice2 = false;
            String name = input.get(i);

            // Double letters
            boolean foundOne = false;
            char lastLetter = name.charAt(0);
            ArrayList<String> doubles = new ArrayList<>();
            for(int j = 1; j < name.length(); j += 2) {
                char c = name.charAt(j);
                doubles.add(Character.toString(lastLetter) + Character.toString(c));
                if(j + 1 < name.length())
                    lastLetter = name.charAt(j + 1);
            }
            System.out.print(Arrays.toString(doubles.toArray()));
            for(int j = 0; j < doubles.size(); j++) {
                String s = doubles.get(j);
                doubles.remove(j);
                if(doubles.contains(s))
                    foundOne = true;
            }

            if(foundOne)
                nice1 = true;

            // Doubles separated by one
            boolean foundAnother = false;
            for(int j = 0; j < name.length(); j++) {
                char c = name.charAt(j);
                if(j + 2 < name.length()) {
                    if(c == name.charAt(j + 2))
                        foundAnother = true;
                }
            }
            if(foundAnother)
                nice2 = true;

            System.out.println(nice1 + " " + nice2);
            if(nice1 && nice2)
                answer++;
        }
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nThe answer is:" + answer);
        System.out.println("Merry Christmas!");
    }
}
