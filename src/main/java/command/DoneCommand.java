package command;

import task.Task;

import java.util.ArrayList;

/**
 * Command to mark task as done
 */
public class DoneCommand {
    protected String command;
    protected ArrayList<Task> tasks;

    /**
     * Constructor for mark task as done
     * @param command
     * @param tasks
     */
    public DoneCommand(String command, ArrayList<Task> tasks){
        this.command = command;
        this.tasks = tasks;
    }

    /**
     * User marked the task as done
     */
    public void done(){

        System.out.println("Nice! I've marked this task as done: " );
        int index = Integer.parseInt(command.replaceAll("\\D+",""));
        (tasks.get(index - 1)).markAsDone();
        System.out.println(tasks.get(index-1).toString());
        System.out.println("____________________________________________________________");
    }
}
