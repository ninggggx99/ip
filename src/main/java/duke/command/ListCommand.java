package duke.command;

import duke.exception.EmptyListException;
import duke.storage.Storage;
import duke.task.Task;

import java.util.ArrayList;

/**
 * Command to display duke.task
 */
public class ListCommand extends Command {

    protected ArrayList<Task> tasks;
    protected String command;
    protected Storage storage;

    /**
     * Constructor for ListCommand
     * @param command
     * @param tasks
     * @param storage
     */
    public ListCommand(String command, ArrayList<Task> tasks, Storage storage) {
        this.isExit = false;
        this.tasks = tasks;
        this.command = command;
        this.storage = storage;
    }

    /**
     * Print the list of tasks the user have added
     * @param command
     * @param tasks
     * @param storage
     * @throws EmptyListException
     */
    @Override
    public void run(String command, ArrayList<Task> tasks, Storage storage) throws EmptyListException {

        if (tasks.size() == 0) {
            throw new EmptyListException("There is no tasks at the moment!");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + " " + tasks.get(i).toString());
            }
        }

        System.out.println("____________________________________________________________");
    }
}