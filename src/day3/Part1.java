package day3;

import advent.DayInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tyty5949 on 12/4/15 at 4:51 PM.
 * Project: Advent of Code 2015
 */
public class Part1 implements DayInterface {

    private String input;
    private int uniqueHouses;

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Santas directions: ");
        input = scanner.nextLine();
        System.out.println("");
    }

    @Override
    public void calculateAnswer() {
        uniqueHouses = 0;
        int x = 0;
        int y = 0;
        Point p = new Point(0, 0);
        ArrayList<Point> visitedHouses = new ArrayList<Point>();
        for (int i = 0; i < input.length(); i++) {
            if (!visitedHouses.contains(p))
                uniqueHouses++;
            visitedHouses.add(p);

            char c = input.charAt(i);
            if (c == '^')
                y++;
            else if (c == 'v')
                y--;
            else if (c == '>')
                x++;
            else if (c == '<')
                x--;
            p = new Point(x, y);
        }
        if (!visitedHouses.contains(p))
            uniqueHouses++;
    }

    @Override
    public void printAnswer() {
        System.out.println("\nSanta visited " + uniqueHouses + " houses at least once");
    }
}
