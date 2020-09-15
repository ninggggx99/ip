package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;

import java.util.ArrayList;

/**
 * Abstract class for commands
 */
public abstract class Command {
    protected boolean isExit;
    protected String command;

    abstract public void run(String command, ArrayList<Task> tasks, Storage storage) throws DukeException;

    /**
     * Signal exit program
     *
     * @return true if user give exit duke.command
     */
    public boolean isExit() {
        return isExit;
    }
}
