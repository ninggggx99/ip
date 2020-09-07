package command;

import exception.MissingDescriptionException;
import task.Task;
import task.Todo;

import java.util.ArrayList;

/**
 * Command to add todo task
 */
public class ToDoCommand extends Command {
    protected String command;
    protected ArrayList<Task> tasks;

    /**
     * Constructor for todo task
     *
     * @param command
     * @param tasks
     */
    public ToDoCommand(String command, ArrayList<Task> tasks) {
        this.isExit = false;
        this.tasks = tasks;
        this.command = command;
    }

    /**
     * Add a todo task for user
     * @param command
     * @param tasks
     * @throws MissingDescriptionException
     */
    @Override
    public void run(String command, ArrayList<Task> tasks) throws MissingDescriptionException {
        String commandSplit[] = command.split(" ", 2);

        if (commandSplit.length < 2 || commandSplit[1].isEmpty()) {
            throw new MissingDescriptionException("The description of a todo cannot be empty");
        } else {
            tasks.add(new Todo(commandSplit[1]));
            System.out.println("Got it. I've added this task: ");
            System.out.println("    [T][" + (tasks).get(tasks.size() - 1).getStatusIcon() + "] " + commandSplit[1]);
            System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
            System.out.println("____________________________________________________________");
        }
    }

}
