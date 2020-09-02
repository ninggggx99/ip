package command;

import task.Task;
import task.Todo;

import java.util.ArrayList;

public class ToDoCommand extends Command{
    protected String command;
    protected ArrayList<Task> tasks;

    /**
     * Constructor for todo task
     * @param command
     * @param tasks
     */
    public ToDoCommand(String command,ArrayList<Task> tasks){
        this.isExit = false;
        this.tasks = tasks;
        this.command = command;
    }
    /**
     * Add a todo task for user
     */
    public void addToDo (){
        String commandSplit []  = command.split(" ",2 );
        tasks.add(new Todo(commandSplit[1]));
        System.out.println("Got it. I've added this task: ");
        System.out.println("    [T][" + (tasks).get(tasks.size()-1).getStatusIcon() + "] " +commandSplit[1]) ;
        System.out.println(" Now you have "+ tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
}
