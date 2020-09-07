package command;

import exception.InvalidTaskIndexException;
import exception.TaskDoneException;
import task.Task;

import java.util.ArrayList;

/**
 * Command to mark task as done
 */
public class DoneCommand extends Command {
    protected String command;
    protected ArrayList<Task> tasks;

    /**
     * Constructor for mark task as done
     *
     * @param command
     * @param tasks
     */
    public DoneCommand(String command, ArrayList<Task> tasks) {
        this.command = command;
        this.tasks = tasks;
    }

    /**
     * User marked the task as done
     * @param command
     * @param tasks
     * @throws InvalidTaskIndexException
     * @throws TaskDoneException
     */

    @Override
    public void run(String command, ArrayList<Task> tasks) throws InvalidTaskIndexException, TaskDoneException {

        int index = Integer.parseInt(command.replaceAll("\\D+", ""));
        if (index > tasks.size()) {
            throw new InvalidTaskIndexException("The index is not found!");
        }
        if (tasks.get(index - 1).getStatusIcon() == "Y") {
            throw new TaskDoneException("The task is already marked as done.");
        }

        (tasks.get(index - 1)).markAsDone();
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(tasks.get(index - 1).toString());
        System.out.println("____________________________________________________________");
    }
}
