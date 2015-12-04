package day3;

import advent.DayInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tyty5949 on 12/4/15 at 5:10 PM.
 * Project: Advent of Code 2015
 */
public class Part2 implements DayInterface {

    private String input;
    private int uniqueHouses;

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Santa and Robo-Santas directions: ");
        input = scanner.nextLine();
    }

    @Override
    public void calculateAnswer() {
        uniqueHouses = 0;
        Point santaP = new Point(0, 0);
        Point roboP = new Point(0, 0);
        ArrayList<Point> visitedHouses = new ArrayList<Point>();
        for (int i = 0; i < input.length(); i++) {
            if (!visitedHouses.contains(santaP))
                uniqueHouses++;
            visitedHouses.add(santaP.getLocation());

            if(!visitedHouses.contains(roboP))
                uniqueHouses++;
            visitedHouses.add(roboP.getLocation());

            char c = input.charAt(i);
            if(i % 2 == 1) {
                if (c == '^')
                    roboP.move(roboP.x, roboP.y + 1);
                else if (c == 'v')
                    roboP.move(roboP.x, roboP.y - 1);
                else if (c == '>')
                    roboP.move(roboP.x + 1, roboP.y);
                else if (c == '<')
                    roboP.move(roboP.x - 1, roboP.y);
            } else {
                if (c == '^')
                    santaP.move(santaP.x, santaP.y + 1);
                else if (c == 'v')
                    santaP.move(santaP.x, santaP.y - 1);
                else if (c == '>')
                    santaP.move(santaP.x + 1, santaP.y);
                else if (c == '<')
                    santaP.move(santaP.x - 1, santaP.y);
            }
        }
        if (!visitedHouses.contains(santaP))
            uniqueHouses++;

        if(!visitedHouses.contains(roboP))
            uniqueHouses++;
    }

    @Override
    public void printAnswer() {
        System.out.println("\nSanta and Robo-Santa visited " + uniqueHouses + " houses at least once");
    }
}
