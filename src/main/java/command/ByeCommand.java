package command;

public class ByeCommand extends Command{
    /**
     * Constructor for bye
     */
    public ByeCommand(){
        this.isExit = true;
    }
    /**
     * Print goodbye string
     */
    public void printBye (){
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}