package duke.exception;

public class EmptyListException extends DukeException {
    private String errorMessage;

    /**
     * Set the error message of duke.exception
     *
     * @param errorMessage
     */
    public EmptyListException(String errorMessage) {
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
