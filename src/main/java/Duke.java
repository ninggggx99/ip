import command.*;
import task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command;
        ArrayList<Task> tasks = new ArrayList<Task>();

        welcomeMessage();

        command = sc.nextLine();

        runCommand(sc, command, tasks);


    }

    private static void runCommand(Scanner sc, String command, ArrayList<Task> tasks) {
        do{
            System.out.println("____________________________________________________________");
            String commandSplit []= command.split(" ",2);

            if (command.equalsIgnoreCase("bye")){
                new ByeCommand().printBye();
                break;
            }
            else{
                switch (commandSplit[0]){
                    case "list":
                        new ListCommand(tasks).printList();
                        break;
                    case "todo":
                        new ToDoCommand(command, tasks).addToDo();
                        break;
                    case "deadline":
                        new DeadlineCommand(command, tasks).addDeadline();
                        break;
                    case "event":
                        new EventsCommand(command, tasks).addEvents();
                        break;
                    case "done":
                        new DoneCommand(command, tasks).done();
                        break;
                    default:
                        new ErrorCommand().errorMessage();
                        break;
                }
            }

            command = sc.nextLine();
        }
        while (!command.equalsIgnoreCase("bye"));

        new ByeCommand().printBye();
    }

    /**
     * Welcome Message
     */
    private static void welcomeMessage() {
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

}
