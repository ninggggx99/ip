package exception;

/**
 * Exception thrown when description missing
 */
public class MissingDescriptionException extends DukeException {
    private String errorMessage;

    /**
     * Set the error message of exception
     *
     * @param errorMessage
     */
    public MissingDescriptionException(String errorMessage) {
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
