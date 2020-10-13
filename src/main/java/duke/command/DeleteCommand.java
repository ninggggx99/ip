package duke.command;

import duke.exception.InvalidTaskIndexException;
import duke.exception.MissingIndexException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;


/**
 * Command to delete tasks
 */
public class DeleteCommand extends Command {

    /**
     * Constructor for delete duke.task
     *
     * @param command
     */
    public DeleteCommand(String command) {
        this.command = command;
    }

    /**
     * Print delete task done/error
     */
    @Override
    public void run(TaskList tasks, Ui ui, Storage storage) throws InvalidTaskIndexException, MissingIndexException {
        String commandSplit[] = command.split(" ", 2);

        if (commandSplit.length == 1 || commandSplit[1] == " "){
            throw new MissingIndexException("No index given");
        }
        int index = Integer.parseInt(commandSplit[1]);
        tasks.deleteTask(index);
        storage.save(tasks);
    }
}