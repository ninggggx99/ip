package duke.command;

import duke.exception.MissingDateAndDescriptionException;
import duke.exception.MissingDateException;
import duke.exception.MissingDescriptionException;
import duke.storage.Storage;
import duke.task.Events;
import duke.task.Task;

import java.util.ArrayList;

/**
 * Command to add event duke.task
 */
public class EventsCommand extends Command {
    protected String command;
    protected ArrayList<Task> tasks;
    protected Storage storage;

    /**
     * Constructor for events
     *
     * @param command
     * @param tasks
     * @param storage
     */
    public EventsCommand(String command, ArrayList<Task> tasks, Storage storage) {
        this.isExit = false;
        this.tasks = tasks;
        this.command = command;
        this.storage = storage;
    }


    /**
     * Add an event for user
     * @param command
     * @param tasks
     * @param storage
     * @throws MissingDescriptionException
     * @throws MissingDateException
     * @throws MissingDateAndDescriptionException
     */
    @Override
    public void run(String command, ArrayList<Task> tasks, Storage storage) throws MissingDescriptionException, MissingDateException, MissingDateAndDescriptionException {
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
        storage.save(tasks);
        System.out.println("Got it. I've added this duke.task: ");
        System.out.println("    " + tasks.get(tasks.size() - 1).toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
}
