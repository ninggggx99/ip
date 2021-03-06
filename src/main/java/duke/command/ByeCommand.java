package duke.command;

import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;


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
    public void run(TaskList tasks, Ui ui, Storage storage) {
        ui.byeMessage();
    }
}