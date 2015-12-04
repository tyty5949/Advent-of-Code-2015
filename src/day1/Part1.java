package day1;

import advent.DayInterface;

import java.util.Scanner;

/**
 * Created by tyty5949 on 12/4/15 at 2:26 PM.
 * Project: Advent of Code 2015
 */
public class Part1 implements DayInterface {

    private String input;
    private int finalPosition;

     @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Santas directions: ");
        input = scanner.nextLine();
    }

    @Override
    public void calculateAnswer() {
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(')
                finalPosition++;
            else if(input.charAt(i) == ')')
                finalPosition--;
        }
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nSanta will end up on floor " + finalPosition);
        System.out.println("Merry Christmas!");
    }
}
