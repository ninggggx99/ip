package duke;

import duke.command.ByeCommand;
import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventsCommand;
import duke.command.ListCommand;
import duke.command.ToDoCommand;
import duke.exception.DukeException;
import duke.exception.InvalidCommandException;
import duke.storage.Storage;
import duke.task.Task;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command;
        ArrayList<Task> tasks;
        Storage storage = new Storage(System.getProperty("user.dir")+"\\data\\output.txt");
        try {
            tasks = storage.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            tasks = new ArrayList<Task>();
        }


        welcomeMessage();

        command = sc.nextLine();
        boolean isExit = false;

        while (!isExit) {
            try {
                Command commandType = runCommand(command, tasks,storage);
                commandType.run(command, tasks, storage);
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
     * check which duke.command to run
     * @param command
     * @param tasks
     * @param storage 
     * @return Command function
     * @throws InvalidCommandException
     */
    private static Command runCommand(String command, ArrayList<Task> tasks, Storage storage) throws InvalidCommandException {

        String commandSplit[] = command.split(" ", 2);


        switch (commandSplit[0]) {
            case "list":
                return new ListCommand(command, tasks, storage);
            case "todo":
                return new ToDoCommand(command, tasks,storage);
            case "deadline":
                return new DeadlineCommand(command, tasks, storage);
            case "event":
                return new EventsCommand(command, tasks, storage);
            case "done":
                return new DoneCommand(command, tasks, storage);
            case "delete":
                return new DeleteCommand(command,tasks, storage);
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
