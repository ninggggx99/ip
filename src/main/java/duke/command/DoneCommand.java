package duke.command;

import duke.exception.InvalidTaskIndexException;
import duke.exception.MissingIndexException;
import duke.exception.TaskDoneException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * Command to mark duke.task as done
 */
public class DoneCommand extends Command {
    /**
     * Constructor for mark duke.task as done
     *
     * @param command
     */
    public DoneCommand(String command) {
        this.command = command;
    }

    /**
     * User marked the duke.task as done
     * @param tasks
     * @param ui
     * @param storage
     * @throws InvalidTaskIndexException
     * @throws TaskDoneException
     */

    @Override
    public void run(TaskList tasks, Ui ui, Storage storage) throws InvalidTaskIndexException, TaskDoneException, MissingIndexException {
        String commandSplit[] = command.split(" ", 2);

        if (commandSplit.length == 1 || commandSplit[1] == " "){
            throw new MissingIndexException("No index given");
        }
        int index = Integer.parseInt(command.replaceAll("\\D+", ""));
        tasks.setTaskDone(index);
        storage.save(tasks);
    }
}
