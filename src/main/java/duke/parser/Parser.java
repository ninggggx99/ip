package duke.parser;

import duke.command.*;
import duke.exception.InvalidCommandException;
import duke.storage.Storage;
import duke.task.Task;

import java.util.ArrayList;

public class Parser {

    public Parser(){

    }

    public static Command parse(String command) throws InvalidCommandException {

        String commandSplit[] = command.split(" ", 2);


        switch (commandSplit[0]) {
            case "list":
                return new ListCommand();
            case "todo":
                return new ToDoCommand(command);
            case "deadline":
                return new DeadlineCommand(command);
            case "event":
                return new EventsCommand(command);
            case "done":
                return new DoneCommand(command);
            case "delete":
                return new DeleteCommand(command);
            case "bye":
                return new ByeCommand();
            default:
                throw new InvalidCommandException("No such command. Please key in again");
        }

    }
}
