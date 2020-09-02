package command;

import task.Task;

import java.util.ArrayList;

public class ListCommand extends Command{
    protected String commandArr[];
    protected int counter;
    protected ArrayList<Task> tasks;

    public ListCommand(String commandArr [], int counter, ArrayList<Task> tasks){
        this.isExit = false;
    }
    public void printList (){
        System.out.println("Here are the tasks in your list:");
        for(int i = 0 ; i < tasks.size() ; i++){
            System.out.println( (i+1) + ". " + "["+ (tasks).get(i).getStatusIcon() +"] "+commandArr[i]);
        }
        System.out.println("____________________________________________________________");
    }
}
