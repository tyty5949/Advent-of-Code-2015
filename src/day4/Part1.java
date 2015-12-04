package day4;

import advent.DayInterface;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by tyty5949 on 12/4/15 at 5:30 PM.
 * Project: Advent of Code 2015
 */
public class Part1 implements DayInterface {

    private String input;
    private int answer;

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your code: ");
        input = scanner.nextLine();
    }

    @Override
    public void calculateAnswer() {
        answer = 0;
        try {
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            String hash = "----------";
            int count = 0;
            while (!hash.substring(0, 5).equals("00000")) {
                byte[] bytes = MD5.digest((input + count).getBytes("UTF-8"));
                StringBuilder sb = new StringBuilder(2 * bytes.length);
                for (byte b : bytes) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                hash = sb.toString();
                count++;
            }
            answer = count - 1;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printAnswer() {
        System.out.println("\nThe answer is:" + answer);
        System.out.println("Merry Christmas!");
    }
}
