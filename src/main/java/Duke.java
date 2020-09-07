import command.ByeCommand;
import command.Command;
import command.DeadlineCommand;
import command.DoneCommand;
import command.EventsCommand;
import command.ListCommand;
import command.ToDoCommand;

import exception.DukeException;
import exception.InvalidCommandException;
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
        boolean isExit = false;

        while (!isExit) {
            try {
                Command commandType = runCommand(command, tasks);
                commandType.run(command, tasks);
                isExit = commandType.isExit();
            } catch (DukeException e) {
                System.out.println(e);
            }
            if (isExit == false) {
                command = sc.nextLine();
            }
        }
    }

    /**
     * check which command to run
     * @param command
     * @param tasks
     * @return Command function
     * @throws InvalidCommandException
     */
    private static Command runCommand(String command, ArrayList<Task> tasks) throws InvalidCommandException {

        String commandSplit[] = command.split(" ", 2);


        switch (commandSplit[0]) {
            case "list":
                return new ListCommand(command, tasks);
            case "todo":
                return new ToDoCommand(command, tasks);
            case "deadline":
                return new DeadlineCommand(command, tasks);
            case "event":
                return new EventsCommand(command, tasks);
            case "done":
                return new DoneCommand(command, tasks);
            case "bye":
                return new ByeCommand();
            default:
                throw new InvalidCommandException("No such command. Please key in again");
        }

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
