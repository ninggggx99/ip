package duke.command;

import duke.exception.MissingDescriptionException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;

/**
 * Command to add todo duke.task
 */
public class ToDoCommand extends Command {
    protected String command;
    protected ArrayList<Task> tasks;
    protected Storage storage;

    /**
     * Constructor for todo duke.task
     *
     * @param command
     * @param tasks
     * @param storage
     */
    public ToDoCommand(String command, ArrayList<Task> tasks, Storage storage) {
        this.isExit = false;
        this.tasks = tasks;
        this.command = command;
        this.storage = storage;
    }

    /**
     * Add a todo duke.task for user
     * @param command
     * @param tasks
     * @param storage
     * @throws MissingDescriptionException
     */
    @Override
    public void run(String command, ArrayList<Task> tasks, Storage storage) throws MissingDescriptionException {
        String commandSplit[] = command.split(" ", 2);

        if (commandSplit.length < 2 || commandSplit[1].isEmpty()) {
            throw new MissingDescriptionException("The description of a todo cannot be empty");
        } else {
            tasks.add(new Todo(commandSplit[1]));
            storage.save(tasks);
            System.out.println("Got it. I've added this duke.task: ");
            System.out.println("    [T][" + (tasks).get(tasks.size() - 1).getStatusIcon() + "] " + commandSplit[1]);
            System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
            System.out.println("____________________________________________________________");
        }
    }

}
