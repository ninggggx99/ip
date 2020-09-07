package command;

import exception.EmptyListException;
import task.Task;

import java.util.ArrayList;

/**
 * Command to display task
 */
public class ListCommand extends Command {

    protected ArrayList<Task> tasks;
    protected String command;

    /**
     * Constructor for ListCommand
     *
     * @param tasks
     */
    public ListCommand(String command, ArrayList<Task> tasks) {
        this.isExit = false;
        this.tasks = tasks;
        this.command = command;
    }

    /**
     * Print the list of tasks the user have added
     * @param command
     * @param tasks
     * @throws EmptyListException
     */
    @Override
    public void run(String command, ArrayList<Task> tasks) throws EmptyListException {

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