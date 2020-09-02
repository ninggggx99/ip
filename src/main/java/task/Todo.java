package task;

public class Todo extends Task{
    /**
     * Constructor for todo task
     * @param description
     */
    public Todo(String description){
        super(description);
    }

    /**
     * Print todo task String
     * @return  print string
     */
    @Override
    public String toString(){
        return "[T]["  + super.getStatusIcon() +"]" + " " + super.getDescription();
    }
}