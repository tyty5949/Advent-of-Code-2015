package day5;

import advent.DayInterface;

import javax.lang.model.type.ArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        for (String anInput : input) {
            char lastLetter = '1', secondLastLetter = '1';
            boolean containsDoubleLetter = false, containsDoublePair = false;
            HashMap<String, Integer> pairs = new HashMap<String, Integer>();
            for(int i = 0; i < anInput.length(); i++) {
                char letter = anInput.charAt(i);

                if(secondLastLetter == letter)
                    containsDoubleLetter = true;

                String pair = Character.toString(lastLetter) + Character.toString(letter);
                if(!(pairs.containsKey(pair))) {
                    pairs.put(pair, i);
                } else if (pairs.get(pair) <= (i - 2)) {
                    containsDoublePair = true;
                }

                secondLastLetter  = lastLetter;
                lastLetter = letter;
            }
            if(containsDoubleLetter && containsDoublePair)
                answer++;
        }
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nThe answer is:" + answer);
        System.out.println("Merry Christmas!");
    }
}
