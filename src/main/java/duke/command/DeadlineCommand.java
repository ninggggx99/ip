package duke.command;

import duke.exception.MissingDateAndDescriptionException;
import duke.exception.MissingDateException;
import duke.exception.MissingDescriptionException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;


/**
 * Command to add deadline duke.task
 */
public class DeadlineCommand extends Command {

    /**
     * Costructor for deadline duke.task
     *
     * @param command
     */
    public DeadlineCommand(String command) {
        this.isExit = false;
        this.command = command;
    }

    /**
     * Add a duke.task with deadline for user
     *
     * @param tasks
     * @param ui
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
            throw new MissingDateAndDescriptionException("The date and description of a deadline cannot be empty");
        }
        String descDate[] = commandSplit[1].split(" /by");

        if (descDate.length < 2) {
            throw new MissingDateException("The date/description of a deadline cannot be empty");
        }

        String deadlineDate[] = descDate[1].split(" ", 2);
        tasks.addDeadline(descDate[0], deadlineDate[1]);
        storage.save(tasks);
    }
}
