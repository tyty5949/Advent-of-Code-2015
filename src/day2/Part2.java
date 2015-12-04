package day2;

import advent.DayInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tyty5949 on 12/4/15 at 4:37 PM.
 * Project: Advent of Code 2015
 */
public class Part2 implements DayInterface {

    private ArrayList<String> input;
    private long ribbonNeeded;

    @Override
    public void getInput() {
        input = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dimensions of all of the presents that need to be wrapped. *Then type go on the next line: ");
        do {
            input.add(scanner.nextLine());
        } while (!input.get(input.size() - 1).equals("go"));
        input.remove(input.size() - 1);
    }

    @Override
    public void calculateAnswer() {
        ribbonNeeded = 0;
        for (String anInput : input) {
            String[] s = anInput.split("x");
            int[] dim = new int[3];
            for (int j = 0; j < 3; j++)
                dim[j] = Integer.parseInt(s[j]);

            int[] perimeter = new int[3];
            perimeter[0] = dim[0] + dim[0] + dim[1] + dim[1];
            perimeter[1] = dim[1] + dim[1] + dim[2] + dim[2];
            perimeter[2] = dim[2] + dim[2] + dim[0] + dim[0];

            Arrays.sort(perimeter);

            ribbonNeeded += perimeter[0] + (dim[0] * dim[1] * dim[2]);
        }
    }

    @Override
    public void printAnswer() {
        System.out.println("\nThe elves will need " + ribbonNeeded + " ft of ribbon");
        System.out.println("Merry Christmas!");
    }
}
