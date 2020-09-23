package duke.command;

import duke.exception.MissingFindDescException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

public class FindCommand extends Command{
    /**
     * Costructor for finding duke.task
     *
     * @param command
     */
    public FindCommand(String command) {
        this.isExit = false;
        this.command = command;
    }
    @Override
    public void run(TaskList tasks, Ui ui, Storage storage) throws MissingFindDescException {
        command = command.trim();
        String commandSplit[] = command.split(" ", 2);

        if (commandSplit.length < 2) {
            throw new MissingFindDescException("Please enter a keyword");
        }

        tasks.find(commandSplit[1]);

    }
}
