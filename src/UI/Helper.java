package UI;

import java.util.Scanner;

public class Helper {
    private static Scanner sc = new Scanner(System.in);

    public static String inputStr(String prompt){
        System.out.println(prompt);
        return sc.nextLine();
    }
    public static int inputInt(String prompt){
        System.out.println(prompt);
        return sc.nextInt();
    }


}
