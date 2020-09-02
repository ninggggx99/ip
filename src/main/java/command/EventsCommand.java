package command;

import task.Events;
import task.Task;

import java.util.ArrayList;

public class EventsCommand extends Command{
    protected String command;
    protected ArrayList<Task> tasks;

    /**
     * Constructor for events
     * @param command
     * @param tasks
     */
    public EventsCommand(String command,ArrayList<Task> tasks){
        this.isExit = false;
        this.tasks = tasks;
        this.command = command;
    }
    /**
     * Add an event for user
     */
    public void addEvents (){
        String commandSplit []  = command.split(" ",2 );
        String descDate [] = commandSplit[1].split(" /");
        String eventsDate [] = descDate[1].split(" ",2);

        tasks.add(new Events(descDate[0], eventsDate[1]));
        System.out.println("Got it. I've added this task: ");
        System.out.println("    " +tasks.get(tasks.size()-1).toString()) ;
        System.out.println("Now you have "+ tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
}
