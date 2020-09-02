import command.ListCommand;
import task.Deadline;
import task.Events;
import task.Task;
import command.ByeCommand;
import task.Todo;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command;
        ArrayList<Task> tasks = new ArrayList<Task>();

        welcomeMessage();

        command = sc.nextLine();

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
                        listCommand(tasks);
                        break;
                    case "todo":
                        toDoCommand(command, tasks);
                        break;
                    case "deadline":
                        deadlineCommand(command,tasks);
                        break;
                    case "event":
                        eventsCommand(command, tasks);
                        break;
                    case "done":
                        doneCommand(command,tasks);
                        break;
                    default:
                        errorCommand(command);
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

    /**
     * Wrong command input
     * @param command
     */
    private static void errorCommand (String command){

        System.out.println("I don't understand " + command + ". Please key in again");
        System.out.println("____________________________________________________________");
    }

    /**
     * Add todo for user
     * @param command
     * @param tasks
     */
    private static void toDoCommand (String command, ArrayList<Task> tasks){
        String commandSplit []  = command.split(" ",2 );
        tasks.add(new Todo(commandSplit[1]));
        System.out.println("Got it. I've added this task: ");
        System.out.println("    [T][" + (tasks).get(tasks.size()-1).getStatusIcon() + "] " +commandSplit[1]) ;
        System.out.println(" Now you have "+ tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    /**
     * Add a task with deadline for user
     * @param command
     * @param tasks
     */
    private static void deadlineCommand (String command, ArrayList<Task> tasks){
        String commandSplit []  = command.split(" ",2 );
        String descDate [] = commandSplit[1].split(" /");
        String deadlineDate [] = descDate[1].split(" ",2);

        tasks.add(new Deadline(descDate[0], deadlineDate[1]));
        System.out.println("Got it. I've added this task: ");
        System.out.println("    "+tasks.get(tasks.size()-1).toString()) ;
        System.out.println("Now you have "+ tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    /**
     * Add an event for user
     * @param command
     * @param tasks
     */
    private static void eventsCommand (String command, ArrayList<Task> tasks){
        String commandSplit []  = command.split(" ",2 );
        String descDate [] = commandSplit[1].split(" /");
        String deadlineDate [] = descDate[1].split(" ",2);

        tasks.add(new Events(descDate[0], deadlineDate[1]));
        System.out.println("Got it. I've added this task: ");
        System.out.println("    " +tasks.get(tasks.size()-1).toString()) ;
        System.out.println("Now you have "+ tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    /**
     * User marked the task as done
     * @param command
     * @param tasks
     */
    private static void doneCommand ( String command, ArrayList<Task> tasks){

        System.out.println("Nice! I've marked this task as done: " );
        int index = Integer.parseInt(command.replaceAll("\\D+",""));
        (tasks.get(index - 1)).markAsDone();
        System.out.println(tasks.get(index-1).toString());
        System.out.println("____________________________________________________________");
    }

    /**
     * Print the list of commands the user have added
     * @param tasks
     */
    private static void listCommand (ArrayList<Task> tasks){
        System.out.println("Here are the tasks in your list:");
        for(int i = 0 ; i < tasks.size() ; i++){
            System.out.println( (i+1) + ". " +" " +tasks.get(i).toString());
        }
        System.out.println("____________________________________________________________");
    }


}
