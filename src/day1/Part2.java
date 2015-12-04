package day1;

import advent.DayInterface;

import java.util.Scanner;

/**
 * Created by tyty5949 on 12/4/15 at 2:33 PM.
 * Project: Advent of Code 2015
 */
public class Part2 implements DayInterface {

    private String input;
    private int firstTimeInBasement = 0;

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Santas directions: ");
        input = scanner.nextLine();
    }

    @Override
    public void calculateAnswer() {
        int finalPosition = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(')
                finalPosition++;
            else if(input.charAt(i) == ')')
                finalPosition--;

            if(finalPosition == -1) {
                firstTimeInBasement = i + 1;
                i = input.length();
            }
        }
    }

    @Override
    public void printAnswer() {
        System.out.println("\nSanta will enter the basement at position " + firstTimeInBasement);
        System.out.println("Merry Christmas!");
    }
}
