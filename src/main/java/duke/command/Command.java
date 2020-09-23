package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;


/**
 * Abstract class for commands
 */
public abstract class Command {
    protected boolean isExit;
    protected String command;

    abstract public void run(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Signal exit program
     *
     * @return true if user give exit duke.command
     */
    public boolean isExit() {
        return isExit;
    }
}
