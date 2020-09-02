package command;

public abstract class Command {
    protected boolean isExit;
    protected String command;

    /**
     * Signal exit program
     * @return true if user give exit command
     */
    public boolean isExit(){
        return  isExit;
    }
}
