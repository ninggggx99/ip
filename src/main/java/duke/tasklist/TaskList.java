package duke.tasklist;

import duke.exception.EmptyListException;
import duke.exception.InvalidTaskIndexException;
import duke.exception.MissingIndexException;
import duke.exception.TaskDoneException;
import duke.task.Deadline;
import duke.task.Events;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Default constructor
     */
    public TaskList (){

    }

    public TaskList(ArrayList<Task> tasks){
        this.tasks = tasks;
    }

    public void printTask(int index){
        Task task = tasks.get(index -1);
        System.out.println(task.toString());
    }
    public Task getTask(int index){
        Task task = tasks.get(index -1);
        return task;
    }

    public ArrayList<Task> getTaskList() {
        return this.tasks;
    }
    /**
     * Print the list of tasks the user have added
     * @throws EmptyListException
     */
    public void printTaskList () throws EmptyListException{
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

    /**
     * Set task as done
     * @param index
     * @throws InvalidTaskIndexException
     * @throws TaskDoneException
     */
    public void setTaskDone(int index)  throws InvalidTaskIndexException, TaskDoneException{
        Task task = tasks.get(index-1);

        if (index > tasks.size() || index < 0) {
            throw new InvalidTaskIndexException("The index is not found!");
        }
        if (task.getStatusIcon() == "Y") {
            throw new TaskDoneException("The duke.task is already marked as done.");
        }

        task.markAsDone();
        System.out.println("Nice! I've marked this duke.task as done: ");
        System.out.println(tasks.get(index - 1).toString());
        System.out.println("____________________________________________________________");
    }

    /**
     * Delete task
     * @param index
     * @throws InvalidTaskIndexException
     */
    public void deleteTask (int index) throws InvalidTaskIndexException{
        Task task = tasks.get(index-1);

        if (index > tasks.size() || index < 0) {
            throw new InvalidTaskIndexException("The index is not found!");
        }
        System.out.println("index: "+ index);
        System.out.println("Noted. I've removed this task: ");
        System.out.println(task.toString());
        tasks.remove(index-1);
        System.out.println("Now you have "+ tasks.size()+" in the list.");
        System.out.println("____________________________________________________________");

    }

    /**
     * Add todo
     * @param description
     */
    public void addTodo (String description){
        tasks.add(new Todo(description));
        System.out.println("Got it. I've added this duke.task: ");
        System.out.println("    " + tasks.get(tasks.size() - 1).toString());
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    /**
     * Add deadline
     * @param description
     * @param deadlineDate
     */
    public void addDeadline (String description, String deadlineDate){

        tasks.add(new Deadline(description, deadlineDate));
        System.out.println("Got it. I've added this duke.task: ");
        System.out.println("    " + tasks.get(tasks.size() - 1).toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");;
    }

    /**
     * Add events
     * @param description
     * @param eventsDate
     */
    public void addEvent (String description, String eventsDate){

        tasks.add(new Events(description, eventsDate));
//        storage.save(tasks);
        System.out.println("Got it. I've added this duke.task: ");
        System.out.println("    " + tasks.get(tasks.size() - 1).toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");;
    }




}
