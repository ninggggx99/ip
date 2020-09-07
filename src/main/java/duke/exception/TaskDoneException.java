package duke.exception;

/**
 * Exception that duke.task is already marked done
 */
public class TaskDoneException extends DukeException {
    private String errorMessage;

    /**
     * Set the error message of duke.exception
     *
     * @param errorMessage
     */
    public TaskDoneException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Format error message
     *
     * @return formatted message
     */
    @Override
    public String toString() {
        return "OOPS!!! " + errorMessage;
    }
}
