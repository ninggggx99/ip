package exception;

/**
 * Exception when Date and Description of task is not given
 */
public class MissingDateAndDescriptionException extends DukeException {
    private String errorMessage;

    /**
     * Set the error message of exception
     *
     * @param errorMessage
     */
    public MissingDateAndDescriptionException(String errorMessage) {
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
