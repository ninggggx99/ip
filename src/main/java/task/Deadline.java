package task;

public class Deadline extends Task {
    public String by;

    /**
     * Constructor for deadline
     * @param description
     * @param by
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Get deadline
     * @return by (deadline)
     */
    public String getBy(){
        return this.by;
    }

    /**
     * Set deadline
     * @param by (deadline)
     */
    public void setBy(String by){
        this.by = by;
    }

    /**
     * Print deadline task String
     * @return  print string
     */
    @Override
    public String toString(){
        return "[D]["  + super.getStatusIcon() +"]" + " " + super.getDescription() + " (by: " + by + ")";
    }
}