package duke.command;

import duke.exception.InvalidTaskIndexException;
import duke.task.Task;

import java.util.ArrayList;

/**
 * Command to delete tasks
 */
public class DeleteCommand extends Command {
    protected String command;
    protected ArrayList<Task> tasks;

    /**
     * Constructor for delete duke.task
     *
     * @param command
     * @param tasks
     */
    public DeleteCommand(String command, ArrayList<Task> tasks) {
        this.command = command;
        this.tasks = tasks;
    }

    /**
     * Print delete task done/error
     */
    @Override
    public void run(String command, ArrayList<Task> tasks) throws InvalidTaskIndexException {
        int index = Integer.parseInt(command.replaceAll("\\D+", ""));
        if (index > tasks.size() || index < 0) {
            throw new InvalidTaskIndexException("The index is not found!");
        }
        System.out.println("index: "+ index);
        System.out.println("Noted. I've removed this task: ");
        System.out.println(tasks.get(index - 1).toString());
        tasks.remove(index-1);
        System.out.println("Now you have "+ tasks.size()+" in the list.");
        System.out.println("____________________________________________________________");

    }
}