package day10;

import advent.DayInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by tyty5949 on 12/10/15 at 9:04 AM.
 * Project: Advent of Code 2015
 */
public class Part1 implements DayInterface {

    private String input;
    private int time;
    private int answer;

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter some data: ");
        input = scanner.nextLine();
        System.out.print("\nEnter the amount of times: ");
        time = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void calculateAnswer() {
        for(int i = 0; i < time; i++) {
            ArrayList<Character> chars = new ArrayList<Character>();
            ArrayList<Integer> times = new ArrayList<Integer>();
            char lastChar = input.charAt(0);
            int count = 1;
            for (int j = 1; j < input.length(); j++) {
                if(lastChar != input.charAt(j)) {
                    chars.add(lastChar);
                    times.add(count);
                    count = 1;
                }else
                    count++;
                lastChar = input.charAt(j);
            }
            chars.add(lastChar);
            times.add(count);
            input = "";
            for(int j = 0; j < chars.size(); j++)
                input += times.get(j).toString() + chars.get(j).toString();
            System.out.println("number:" + input);
        }
        answer = input.length();
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nThe answer is: " + answer);
        System.out.println("Merry Christmas!");
    }
}
