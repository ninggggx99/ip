package duke.task;

/**
 * Class for events
 */
public class Events extends Task {
    public String dateToFrom;

    /**
     * Constructor for Events
     *
     * @param description
     * @param dateToFrom
     */
    public Events(String description, String dateToFrom) {
        super(description);
        this.dateToFrom = dateToFrom;
    }

    /**
     * Get the range of time for the event
     *
     * @return event date time range
     */
    public String getDateToFrom() {
        return this.dateToFrom;
    }

    /**
     * Set the range of time for the event
     *
     * @return event date time range
     */
    public void setDateToFrom(String dateToFrom) {
        this.dateToFrom = dateToFrom;
    }

    /**
     * Print deadline duke.task String
     *
     * @return print string
     */
    @Override
    public String toString() {
        return "[E][" + super.getStatusIcon() + "]" + " " + super.getDescription() + " (at: " + dateToFrom + ")";
    }
}