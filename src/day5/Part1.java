package day5;

import advent.DayInterface;

import java.util.Scanner;

/**
 * Created by tyty5949 on 12/4/15 at 6:03 PM.
 * Project: Advent of Code 2015
 */
public class Part1 implements DayInterface {
    
    private String input;
    private String answer;

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter some data: ");
        input = scanner.nextLine();
    }

    @Override
    public void calculateAnswer() {
        answer = "";
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nThe answer is:" + answer);
        System.out.println("Merry Christmas!");
    }
}
