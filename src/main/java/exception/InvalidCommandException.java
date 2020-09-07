package exception;

/**
 * Exception thrown when command invalid
 */
public class InvalidCommandException extends DukeException {
    private String errorMessage;

    /**
     * Set the error message of exception
     *
     * @param errorMessage
     */
    public InvalidCommandException(String errorMessage) {
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
