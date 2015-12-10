package day9;

import advent.DayInterface;

import java.util.*;

/**
 * Created by tyty5949 on 12/9/15 at 11:04 AM.
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
        ArrayList<String> cities = new ArrayList<String>();
        ArrayList<String> paths;
        HashMap<String, Integer> pathDistances = new HashMap<String, Integer>();
        HashMap<String, Integer> distances = new HashMap<String, Integer>();
        for(String anInput : input) {
            String[] s = anInput.split(" = ");
            distances.put(s[0], Integer.parseInt(s[1]));
            String[] s1 = s[0].split(" to ");
            if(!cities.contains(s1[0]))
                cities.add(s1[0]);
            if(!cities.contains(s1[1]))
                cities.add(s1[1]);
        }
        paths = permute(cities);
        for(String path : paths) {
            String[] s = path.split(" -> ");
            int dist = 0;
            for(int i = 0; i < s.length - 1; i++) {
                if(distances.containsKey(s[i] + " to " + s[i + 1]))
                    dist += distances.get(s[i] + " to " + s[i + 1]);
                else
                    dist += distances.get(s[i + 1] + " to " + s[i]);
            }
            pathDistances.put(path, dist);
        }
        String shortest = paths.get(0);
        for(int i = 0; i < pathDistances.size(); i++) {
            if(pathDistances.get(paths.get(i)) < pathDistances.get(shortest))
                shortest = paths.get(i);
        }
        for(String s : paths)
            System.out.println(s + " = " + pathDistances.get(s));
        answer = pathDistances.get(shortest);
    }

    private ArrayList<String> permute(ArrayList<String> items) {
        ArrayList<String> permutations = new ArrayList<String>();
        if(items.size() == 1) {
            permutations.add(items.get(0));
            return permutations;
        }

        for(int i = 0; i < items.size(); i++) {
            ArrayList<String> inner = new ArrayList<String>();
            inner.addAll(items);
            inner.remove(i);
            ArrayList<String> temp = permute(inner);
            for(int j = 0; j < temp.size(); j++)
                permutations.add(items.get(i) + " -> " + temp.get(j));
        }
        return permutations;
    }

    @Override
    public void printAnswer() {
        System.out.println("\n\nThe answer is: " + answer);
        System.out.println("Merry Christmas!");
    }
}
