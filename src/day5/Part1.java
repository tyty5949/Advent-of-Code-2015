package day5;

import advent.DayInterface;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tyty5949 on 12/4/15 at 6:03 PM.
 * Project: Advent of Code 2015
 */
public class Part1 implements DayInterface {
    
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
            boolean nice = true;
            String name = input.get(i);

            // Count vowels
            int vowels = 0;
            for(int j = 0; j < name.length(); j++) {
                char c = name.charAt(j);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    vowels++;
            }
            if(vowels < 3)
                nice = false;

            // Double letters
            boolean foundOne = false;
            char lastLetter = '-';
            for(int j = 0; j < name.length(); j++) {
                char c = name.charAt(j);
                if(c == lastLetter)
                    foundOne = true;
                lastLetter = c;
            }
            if(!foundOne)
                nice = false;

            // These strings
            if(name.contains("ab") || name.contains("cd") || name.contains("pq") || name.contains("xy"))
                nice = false;

            if(nice)
                answer++;
        }
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nThe answer is: " + answer);
        System.out.println("Merry Christmas!");
    }
}
