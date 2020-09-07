package command;

import exception.MissingDateAndDescriptionException;
import exception.MissingDateException;
import exception.MissingDescriptionException;
import task.Events;
import task.Task;

import java.util.ArrayList;

/**
 * Command to add event task
 */
public class EventsCommand extends Command {
    protected String command;
    protected ArrayList<Task> tasks;

    /**
     * Constructor for events
     *
     * @param command
     * @param tasks
     */
    public EventsCommand(String command, ArrayList<Task> tasks) {
        this.isExit = false;
        this.tasks = tasks;
        this.command = command;
    }


    /**
     * Add an event for user
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
        if (descDate[0].isEmpty() || descDate[0].contains("at")) {
            throw new MissingDescriptionException("The description of an event cannot be empty");
        } else if (descDate.length < 2) {
            throw new MissingDateException("The date of an event cannot be empty");
        }

        String eventsDate[] = descDate[1].split(" ", 2);

        tasks.add(new Events(descDate[0], eventsDate[1]));
        System.out.println("Got it. I've added this task: ");
        System.out.println("    " + tasks.get(tasks.size() - 1).toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
}
