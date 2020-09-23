package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * Command to end duke.Duke
 */
public class ByeCommand extends Command {
    /**
     * Constructor for bye
     */
    public ByeCommand() {
        this.isExit = true;
    }

    /**
     * Print goodbye string
     */
    @Override
    public void run(TaskList tasks, Ui ui, Storage storage)  {
        ui.byeMessage();
    }
}