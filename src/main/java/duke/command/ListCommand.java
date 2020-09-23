package duke.command;

import duke.exception.EmptyListException;
import duke.storage.Storage;
import duke.task.Task;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * Command to display duke.task
 */
public class ListCommand extends Command {


    /**
     * Constructor for ListCommand
     */
    public ListCommand() {
        this.isExit = false;
    }

    /**
     * Print the list of tasks the user have added
     * @param tasks
     * @param ui
     * @param storage
     * @throws EmptyListException
     */
    @Override
    public void run(TaskList tasks, Ui ui, Storage storage) throws EmptyListException {
        tasks.printTaskList();
    }
}