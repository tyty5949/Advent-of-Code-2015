package day6;

import advent.DayInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tyty5949 on 12/7/15 at 9:19 AM.
 * Project: Advent of Code 2015
 */
public class Part2 implements DayInterface{


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
        int[][] lights = new int[1000][1000];
        for (String anInput : input) {
            String[] s = anInput.split(" ");
            String[] s0;
            String[] s1;
            if(anInput.contains("toggle")) {
                s0 = s[1].split(",");
                s1 = s[3].split(",");
            } else {
                s0 = s[2].split(",");
                s1 = s[4].split(",");
            }
            Point p1 = new Point(Integer.parseInt(s0[0]), Integer.parseInt(s0[1]));
            Point p2 = new Point(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]));
            for(int x = p1.x; x <= p2.x; x++) {
                for(int y = p1.y; y <= p2.y; y++) {
                    if (anInput.contains("turn on")) {
                        lights[x][y] = lights[x][y] + 1;
                    } else if (anInput.contains("turn off")) {
                        if(lights[x][y] - 1 >= 0)
                            lights[x][y] = lights[x][y] - 1;
                    } else if (anInput.contains("toggle")) {
                        lights[x][y] = lights[x][y] + 2;
                    }
                }
            }
        }

        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[0].length; j++) {
                answer += lights[i][j];
            }
        }
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nThe answer is: " + answer);
        System.out.println("Merry Christmas!");
    }
}
