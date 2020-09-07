package duke.exception;

/**
 * Exception when duke.task index is not in the list
 */
public class InvalidTaskIndexException extends DukeException {
    private String errorMessage;

    /**
     * Set the error message of duke.exception
     *
     * @param errorMessage
     */
    public InvalidTaskIndexException(String errorMessage) {
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
