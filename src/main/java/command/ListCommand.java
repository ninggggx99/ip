package command;

import task.Task;

import java.util.ArrayList;
/**
 * Command to list task
 */
public class ListCommand extends Command{

    protected ArrayList<Task> tasks;

    /**
     * Constructor for ListCommand
     * @param tasks
     */
    public ListCommand(ArrayList<Task> tasks){
        this.isExit = false;
        this.tasks = tasks;
    }

    /**
     * Print the list of tasks the user have added
     */
    public void printList (){

        if (tasks.size() == 0){
            System.out.println( "There is no task at the moment");
        }else{
            System.out.println("Here are the tasks in your list:");
            for(int i = 0 ; i < tasks.size() ; i++){
                System.out.println( (i+1) + ". " +" " +tasks.get(i).toString());
            }
        }

        System.out.println("____________________________________________________________");
    }
}