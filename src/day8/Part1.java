package day8;

import advent.DayInterface;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tyty5949 on 12/9/15 at 8:27 AM.
 * Project: Advent of Code 2015
 */
public class Part1 implements DayInterface {

    private ArrayList<String> input;
    int answer;

    @Override
    public void getInput() {
        input = new ArrayList<String>();
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
        int totalChar = 0;
        int totalMem = 0;
        for (String anInput : input) {
            anInput = anInput.replace("\\", "/");
            System.out.println(anInput);
            totalChar += anInput.length();
            System.out.println(anInput.length());
            anInput = anInput.replaceAll("//", "s");
            anInput = anInput.replaceAll("/\"", "q");
            while(anInput.contains("/x"))
                anInput = anInput.substring(0, anInput.indexOf("/x")) + anInput.substring(anInput.indexOf("/x") + 3, anInput.length());
            anInput = anInput.substring(1, anInput.length() - 1);
            totalMem += anInput.length();
            System.out.println(anInput.length());
            System.out.println(anInput + "\n");
        }
        answer = totalChar - totalMem;
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nThe answer is: " + answer);
        System.out.println("Merry Christmas!");
    }
}
