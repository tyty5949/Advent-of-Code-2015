package day6;

import advent.DayInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tsh5949 on 12/7/2015.
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
        boolean[][] lights = new boolean[1000][1000];
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
                        lights[x][y] = true;
                    } else if (anInput.contains("turn off")) {
                        lights[x][y] = false;
                    } else if (anInput.contains("toggle")) {
                        lights[x][y] = !lights[x][y];
                    }
                }
            }
        }

        for (boolean[] light : lights) {
            for (int j = 0; j < lights[0].length; j++) {
                if (light[j])
                    answer++;
            }
        }
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nThe answer is: " + answer);
        System.out.println("Merry Christmas!");
    }
}
