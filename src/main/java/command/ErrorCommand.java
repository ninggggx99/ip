package command;

/**
 * Print Message when command is not understandable
 */
public class ErrorCommand extends Command{
    protected String command;

    /**
     * Constructor for error
     */
    public ErrorCommand(){
        this.isExit = false;
    }

    /**
     * Print error message
     */
    public void errorMessage (){
        System.out.println("I don't understand. Please key in again.");
        System.out.println("____________________________________________________________");
    }
}
