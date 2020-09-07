package command;

import exception.DukeException;
import task.Task;

import java.util.ArrayList;

/**
 * Abstract class for commands
 */
public abstract class Command {
    protected boolean isExit;
    protected String command;

    abstract public void run(String command, ArrayList<Task> tasks) throws DukeException;

    /**
     * Signal exit program
     *
     * @return true if user give exit command
     */
    public boolean isExit() {
        return isExit;
    }
}
