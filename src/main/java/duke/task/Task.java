package duke.task;

/**
 * Class for duke.task
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for duke.task
     *
     * @param description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Retrieve duke.task's status icon
     *
     * @return status icon
     */
    public String getStatusIcon() {
        return (isDone ? "Y" : "N");
    }

    /**
     * Retrieve duke.task's description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setting the duke.task's description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set isDone to true if duke.task is done
     */
    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public abstract String toString();
}
