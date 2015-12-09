package day7;

import advent.DayInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by tyty5949 on 12/8/15 at 9:09 AM.
 * Project: Advent of Code 2015
 */
public class Part2 implements DayInterface {

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

    //a = 16076
    @Override
    public void calculateAnswer() {
        answer = 0;
        HashMap<String, Integer> vars = new HashMap<String, Integer>();
        ArrayList<String> cache = new ArrayList<String>();
        for (String anInput : input) {
            cache.add(anInput);
        }
        for (int i = 0; i < cache.size(); i++) {
            String string = cache.get(i);
            String[] split = cache.get(i).split(" ");
            if (string.matches("(.*)(AND|OR|LSHIFT|RSHIFT)(.*)")) {
                if (split[0].matches("([0-9]+)") && split[2].matches("([0-9]+)")) {
                    int c;
                    if (split[1].equals("AND"))
                        c = Integer.parseInt(split[0]) & Integer.parseInt(split[2]);
                    else if (split[1].equals("OR"))
                        c = Integer.parseInt(split[0]) | Integer.parseInt(split[2]);
                    else if (split[1].equals("LSHIFT"))
                        c = Integer.parseInt(split[0]) << Integer.parseInt(split[2]);
                    else
                        c = Integer.parseInt(split[0]) >> Integer.parseInt(split[2]);
                    if(split[4].equals("b"))
                        vars.put(split[4], 16076);
                    else
                        vars.put(split[4], c);
                    cache.remove(string);
                    i = -1;
                } else if (split[0].matches("([a-z]+)") && split[2].matches("([a-z]+)")) {
                    if (vars.containsKey(split[0]) && vars.containsKey(split[2])) {
                        int c;
                        if (split[1].equals("AND"))
                            c = vars.get(split[0]) & vars.get(split[2]);
                        else if (split[1].equals("OR"))
                            c = vars.get(split[0]) | vars.get(split[2]);
                        else if (split[1].equals("LSHIFT"))
                            c = vars.get(split[0]) << vars.get(split[2]);
                        else
                            c = vars.get(split[0]) >> vars.get(split[2]);
                        if(split[4].equals("b"))
                            vars.put(split[4], 16076);
                        else
                            vars.put(split[4], c);
                        cache.remove(string);
                        i = -1;
                    }
                } else if (split[0].matches("([0-9]+)") && vars.containsKey(split[2])) {
                    int c;
                    if (split[1].equals("AND"))
                        c = Integer.parseInt(split[0]) & vars.get(split[2]);
                    else if (split[1].equals("OR"))
                        c = Integer.parseInt(split[0]) | vars.get(split[2]);
                    else if (split[1].equals("LSHIFT"))
                        c = Integer.parseInt(split[0]) << vars.get(split[2]);
                    else
                        c = Integer.parseInt(split[0]) >> vars.get(split[2]);
                    if(split[4].equals("b"))
                        vars.put(split[4], 16076);
                    else
                        vars.put(split[4], c);
                    cache.remove(string);
                    i = -1;
                } else if (split[2].matches("([0-9]+)") && vars.containsKey(split[0])) {
                    int c;
                    if (split[1].equals("AND"))
                        c = vars.get(split[0]) & Integer.parseInt(split[2]);
                    else if (split[1].equals("OR"))
                        c = vars.get(split[0]) | Integer.parseInt(split[2]);
                    else if (split[1].equals("LSHIFT"))
                        c = vars.get(split[0]) << Integer.parseInt(split[2]);
                    else
                        c = vars.get(split[0]) >> Integer.parseInt(split[2]);
                    if(split[4].equals("b"))
                        vars.put(split[4], 16076);
                    else
                        vars.put(split[4], c);
                    cache.remove(string);
                    i = -1;
                }
            } else if (string.matches("NOT(.*)")) {
                if (split[1].matches("([0-9]+)")) {
                    vars.put(split[3], 65536 + ~Integer.parseInt(split[1]));
                    if(split[3].equals("b"))
                        vars.put(split[3], 16076);
                    cache.remove(string);
                    i = -1;
                } else if (vars.containsKey(split[1])) {
                    vars.put(split[3], 65536 + ~vars.get(split[1]));
                    if(split[3].equals("b"))
                        vars.put(split[3], 16076);
                    cache.remove(string);
                    i = -1;
                }
            } else {
                if (split[0].matches("([0-9]+)")) {
                    vars.put(split[2], Integer.parseInt(split[0]));
                    if(split[2].equals("b"))
                        vars.put(split[2], 16076);
                    cache.remove(string);
                    i = -1;
                } else if (vars.containsKey(split[0])) {
                    vars.put(split[2], vars.get(split[0]));
                    if(split[2].equals("b"))
                        vars.put(split[2], 16076);
                    cache.remove(string);
                    i = -1;
                }
            }
            System.out.println(cache.size());
        }

        System.out.println(vars.toString());
        answer = vars.get("a");
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nThe answer is: " + answer);
        System.out.println("Merry Christmas!");
    }
}
