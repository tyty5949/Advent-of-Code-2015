package day10;

import advent.DayInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by tyty5949 on 12/10/15 at 9:04 AM.
 * Project: Advent of Code 2015
 */
public class Part1 implements DayInterface {

    private String string;
    private int time;
    private int answer;

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter some data: ");
        string = scanner.nextLine();
        System.out.print("\nEnter the amount of times: ");
        time = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void calculateAnswer() {
        char[] temp = string.toCharArray();
        Integer[] input = new Integer[temp.length];
        for(int i = 0; i < temp.length; i++) input[i] = Character.getNumericValue(temp[i]);

        ArrayList<Integer> data;
        for(int i = 0; i < time; i++) {
            data = new ArrayList<>();
            int count = 1;
            for (int j = 0; j < input.length; j++) {
                int c = input[j];
                while(j < input.length - 1 && c == input[j + 1]) {
                    count++;
                    j++;
                }

                data.add(count);
                data.add(c);
                count = 1;
            }
            input = data.toArray(input);
            System.out.println("Finished iteration=" + (i + 1));
            System.out.println(Arrays.toString(input));
        }
        answer = input.length;
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nThe answer is: " + answer);
        System.out.println("Merry Christmas!");
    }
}
