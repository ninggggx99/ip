package duke.command;

import duke.exception.InvalidTaskIndexException;
import duke.exception.MissingIndexException;
import duke.exception.TaskDoneException;
import duke.storage.Storage;
import duke.task.Task;

import java.util.ArrayList;

/**
 * Command to mark duke.task as done
 */
public class DoneCommand extends Command {
    protected String command;
    protected ArrayList<Task> tasks;
    protected Storage storage;

    /**
     * Constructor for mark duke.task as done
     *
     * @param command
     * @param tasks
     * @param storage
     */
    public DoneCommand(String command, ArrayList<Task> tasks, Storage storage) {
        this.command = command;
        this.tasks = tasks;
        this.storage = storage;
    }

    /**
     * User marked the duke.task as done
     * @param command
     * @param tasks
     * @param storage
     * @throws InvalidTaskIndexException
     * @throws TaskDoneException
     */

    @Override
    public void run(String command, ArrayList<Task> tasks, Storage storage) throws InvalidTaskIndexException, TaskDoneException, MissingIndexException {
        String commandSplit[] = command.split(" ", 2);
        if (commandSplit.length == 1 || commandSplit[1] == " "){
            throw new MissingIndexException("No index given");
        }
        int index = Integer.parseInt(command.replaceAll("\\D+", ""));

        if (index > tasks.size() || index < 0) {
            throw new InvalidTaskIndexException("The index is not found!");
        }
        if (tasks.get(index - 1).getStatusIcon() == "Y") {
            throw new TaskDoneException("The duke.task is already marked as done.");
        }

        (tasks.get(index - 1)).markAsDone();
        storage.save(tasks);
        System.out.println("Nice! I've marked this duke.task as done: ");
        System.out.println(tasks.get(index - 1).toString());
        System.out.println("____________________________________________________________");
    }
}
