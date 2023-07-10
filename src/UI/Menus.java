package UI;

import DatabaseConnect.DatabaseConnect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menus {
    protected Scanner sc = new Scanner(System.in);

    protected static DatabaseConnect database = new DatabaseConnect();

    protected String inputStr(String Prompt){
        System.out.println(Prompt);
        return sc.nextLine();
    }

    protected int inputInt(String Prompt){
        System.out.println(Prompt);
        return sc.nextInt();
    }

    protected void displayMenu(HashMap<String, Runnable> h){
        int index = 1;
        for(String f : h.keySet()){
            System.out.printf("%d) %s\n", index, f);
            index++;
        }
        int choice = inputInt("\nYour Choice - ") - 1;
        while(choice > h.keySet().size() - 1){
            choice = inputInt(String.format("\nRetry (Between 1 and %s)Your Choice - ", h.keySet().size())) - 1;
        }
        h.get(new ArrayList<>(h.keySet()).get(choice)).run();
    }

}
