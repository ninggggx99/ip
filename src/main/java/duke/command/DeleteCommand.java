package duke.command;

import duke.exception.InvalidTaskIndexException;
import duke.storage.Storage;
import duke.task.Task;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

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
    public void run(TaskList tasks, Ui ui, Storage storage) throws InvalidTaskIndexException {
        int index = Integer.parseInt(command.replaceAll("\\D+", ""));
        tasks.deleteTask(index);
        storage.save(tasks);
    }
}