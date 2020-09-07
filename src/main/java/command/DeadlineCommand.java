package command;

import exception.MissingDateAndDescriptionException;
import exception.MissingDateException;
import exception.MissingDescriptionException;
import task.Deadline;
import task.Task;

import java.util.ArrayList;

/**
 * Command to add deadline task
 */
public class DeadlineCommand extends Command {
    protected String command;
    protected ArrayList<Task> tasks;

    /**
     * Costructor for deadline task
     *
     * @param command
     * @param tasks
     */
    public DeadlineCommand(String command, ArrayList<Task> tasks) {
        this.isExit = false;
        this.tasks = tasks;
        this.command = command;
    }

    /**
     * Add a task with deadline for user
     * @param command
     * @param tasks
     * @throws MissingDescriptionException
     * @throws MissingDateException
     * @throws MissingDateAndDescriptionException
     */
    @Override
    public void run(String command, ArrayList<Task> tasks) throws MissingDescriptionException, MissingDateException, MissingDateAndDescriptionException {
        command = command.trim();
        String commandSplit[] = command.split(" ", 2);

        if (commandSplit.length < 2) {
            throw new MissingDateAndDescriptionException("The date and description of an event cannot be empty");
        }
        String descDate[] = commandSplit[1].split(" /");

        if (descDate[0].isEmpty() || descDate[0].contains("by")) {
            throw new MissingDescriptionException("The description of a deadline cannot be empty");
        } else if (descDate.length < 2) {
            throw new MissingDateException("The date of an event cannot be empty");
        }

        String deadlineDate[] = descDate[1].split(" ", 2);
        tasks.add(new Deadline(descDate[0], deadlineDate[1]));
        System.out.println("Got it. I've added this task: ");
        System.out.println("    " + tasks.get(tasks.size() - 1).toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
}
