public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for task
     * @param description
     */
    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    /**
     * Retrieve task's status icon
     * @return icon
     */
    public String getStatusIcon(){
        return (isDone? "\u2713" : "\u2718");
    }

    /**
     * Retrieve task's description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setting the task's description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set isDone to true if task is done
     */
    public void markAsDone(){
        this.isDone = true;
    }
}