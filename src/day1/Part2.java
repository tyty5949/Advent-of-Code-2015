package day1;

import java.util.Scanner;

/**
 * Created by tyty5949 on 12/4/15 at 2:33 PM.
 * Project: Advent of Code 2015
 */
public class Part2 {

    public static void main(String[] args) {
        int finalPosition = 0;
        int firstTimeInBasement = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Santas directions: ");
        String input = scanner.nextLine();
        System.out.print("\nCalculating");
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(')
                finalPosition++;
            else if(input.charAt(i) == ')')
                finalPosition--;
            System.out.print(".");
            if(finalPosition == -1) {
                firstTimeInBasement = i + 1;
                i = input.length();
            }
        }
        System.out.println("\n\nSanta will enter the basement at position " + firstTimeInBasement);
        System.out.println("Merry Christmas!");
    }
}
