package duke.command;

import duke.exception.MissingDateAndDescriptionException;
import duke.exception.MissingDateException;
import duke.exception.MissingDescriptionException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;


/**
 * Command to add event duke.task
 */
public class EventsCommand extends Command {

    /**
     * Constructor for events
     *
     * @param command
     */
    public EventsCommand(String command) {
        this.isExit = false;
        this.command = command;
    }


    /**
     * Add an event for user
     * @param tasks
     * @param storage
     * @throws MissingDescriptionException
     * @throws MissingDateException
     * @throws MissingDateAndDescriptionException
     */
    @Override
    public void run(TaskList tasks, Ui ui, Storage storage) throws MissingDescriptionException, MissingDateException, MissingDateAndDescriptionException {
        command = command.trim();
        String commandSplit[] = command.split(" ", 2);

        if (commandSplit.length < 2) {
            throw new MissingDateAndDescriptionException("The date and description of an event cannot be empty");
        }

        String descDate[] = commandSplit[1].split(" /at");
        if (descDate.length < 2) {
            throw new MissingDateException("The description/date of an event cannot be empty");
        }

        String eventsDate[] = descDate[1].split(" ", 2);

        tasks.addEvent(descDate[0], eventsDate[1]);
        storage.save(tasks);

    }
}
