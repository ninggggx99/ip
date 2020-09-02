package command;

import task.Deadline;
import task.Task;

import java.util.ArrayList;

public class DeadlineCommand extends Command{
    protected String command;
    protected ArrayList<Task> tasks;

    /**
     * Costructor for deadline task
     * @param command
     * @param tasks
     */
    public DeadlineCommand(String command,ArrayList<Task> tasks){
        this.isExit = false;
        this.tasks = tasks;
        this.command = command;
    }

    /**
     * Add a task with deadline for user
     */
    public void addDeadline (){
        String commandSplit []  = command.split(" ",2 );
        String descDate [] = commandSplit[1].split(" /");
        String deadlineDate [] = descDate[1].split(" ",2);

        tasks.add(new Deadline(descDate[0], deadlineDate[1]));
        System.out.println("Got it. I've added this task: ");
        System.out.println("    "+tasks.get(tasks.size()-1).toString()) ;
        System.out.println("Now you have "+ tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
}
