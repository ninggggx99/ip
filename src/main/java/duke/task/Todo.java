package duke.task;

/**
 * Class for Todo
 */
public class Todo extends Task {
    /**
     * Constructor for todo duke.task
     *
     * @param description
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Print todo duke.task String
     *
     * @return print string
     */
    @Override
    public String toString() {
        return "[T][" + super.getStatusIcon() + "]" + " " + super.getDescription();
    }
}