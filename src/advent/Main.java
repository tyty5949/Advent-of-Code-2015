package advent;

import java.math.BigDecimal;

/**
 * Created by tyty5949 on 12/4/15 at 3:52 PM.
 * Project: Advent of Code 2015
 */
public class Main {

    public static void main(String[] args) {
        DayInterface part = new day7.Part1();
        part.getInput();
        System.out.print("\nCalculating...");
        long startTime = System.nanoTime();
        part.calculateAnswer();
        long endTime = System.nanoTime();
        part.printAnswer();
        System.out.println("\n**\nCalculation time: " + (new BigDecimal(Double.toString(((double) (endTime - startTime) / 1000000000.0)))).toPlainString() + " seconds\n**");
    }
}
