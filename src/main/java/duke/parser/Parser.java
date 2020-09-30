package duke.parser;

import duke.command.ByeCommand;
import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventsCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.command.ToDoCommand;
import duke.exception.InvalidCommandException;

/**
 * Parse commands to the functions
 */
public class Parser {
    /**
     * Contstructor for parser
     */
    public Parser() {

    }

    /**
     * Parse the commands
     *
     * @param command
     * @return
     * @throws InvalidCommandException
     */
    public static Command parse(String command) throws InvalidCommandException {
        command = command.trim();
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
            case "find":
                return new FindCommand(command);
            default:
                throw new InvalidCommandException("No such command. Please key in again");
        }

    }
}
