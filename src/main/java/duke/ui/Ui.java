package duke.ui;

import java.util.Scanner;

public class Ui {
    Scanner sc ;

    /**
     * Constructor for Ui
     */
    public Ui(){
        this.sc = new Scanner(System.in);
    }

    /**
     * Welcome Message
     */
    public void welcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke ");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    /**
     * Print goodbye string
     */
    public void byeMessage(){
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    /**
     * Get user input
     */
    public String readCommand(){
        return sc.nextLine();
    }

    /**
     * Print error message
     * @param errormsg
     */
    public void showError(String errormsg){
        System.out.println(errormsg);
    }

    public void showLoadingError (){
        System.out.println("____________________________________________________________");
        System.out.println("File does not exist!");
        System.out.println("____________________________________________________________");
    }
    public void showLine(){
        System.out.println("____________________________________________________________");
    }
}
