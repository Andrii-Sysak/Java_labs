package Functions;

import java.util.Scanner;

public class Value {
    private final Scanner in = new Scanner(System.in);
    public int getInt(String message){
        int choice;
        System.out.print(message + ": ");
        while(true) {
            try {
                choice = in.nextInt();
                in.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Uncorrect");
                in.nextLine();
            }
        }
        return choice;
    }
}
