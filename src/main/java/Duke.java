import java.util.*;
public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command;
        String commandArr [] = new String[100];
        int counter = 0;
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


        command = sc.nextLine();

        do{
            System.out.println("____________________________________________________________");
            switch (command){
                case "list" :
                    listCommand(commandArr,counter);
                    break;
                case "blah" :
                    blahCommand();
                    break;
                default :
                    addCommand(command,commandArr,counter);
                    counter++;
                    break;
            }

            command = sc.nextLine();
        }
        while (!command.equalsIgnoreCase("bye"));

        byeCommand();


    }
    public static void addCommand (String command, String commandArr[], int counter){
       commandArr[counter] = command;
       System.out.println("added: " + command);
       System.out.println("____________________________________________________________");
    }
    public static void listCommand (String commandArr [], int counter){
        for(int i = 0 ; i < counter ; i++){
            System.out.println( (i+1) + ". " + commandArr[i]);
        }
        System.out.println("____________________________________________________________");
    }
    public static void blahCommand (){
        System.out.println("blah");
        System.out.println("____________________________________________________________");
    }
    public static void byeCommand (){
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
