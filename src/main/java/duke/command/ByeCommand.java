package duke.command;

import duke.storage.Storage;
import duke.task.Task;

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
    public void run(String command, ArrayList<Task> tasks, Storage storage) {
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}