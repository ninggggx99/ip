import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command;
        String[] commandArr  = new String[100];
        ArrayList<Task> tasks = new ArrayList<Task>();
        int counter = 0;

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke ");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");


        command = sc.nextLine();

        do{
            System.out.println("____________________________________________________________");
            switch (command){
                case "list" :
                    listCommand(commandArr,counter,tasks);
                    break;
                case "blah" :
                    blahCommand();
                    break;
                default :
                    if (command.substring(0,4).equalsIgnoreCase("done")){
                        doneCommand(commandArr, command,tasks);
                    }else{
                        addCommand(command,commandArr,counter);
                        counter++;
                        tasks.add(new Task(command));
                    }

                    break;
            }

            command = sc.nextLine();
        } while (!command.equalsIgnoreCase("bye"));

        byeCommand();


    }

    /**
     * Add command for user
     * @param command
     * @param commandArr
     * @param counter
     */
    public static void addCommand (String command, String[] commandArr, int counter){
       commandArr[counter] = command;
       System.out.println("added: " + command);
       System.out.println("____________________________________________________________");
    }

    /**
     * User marked the task as done
     * @param commandArr
     * @param command
     * @param tasks
     */
    public static void doneCommand (String[] commandArr, String command, ArrayList<Task> tasks){

        System.out.println("Nice! I've marked this task as done: " );
        int index = Integer.parseInt(command.replaceAll("\\D+",""));
        (tasks.get(index - 1)).markAsDone();
        System.out.println("["+ (tasks).get(index-1).getStatusIcon() +"] " + tasks.get(index-1).getDescription());
        System.out.println("____________________________________________________________");
    }
    /**
     * Print the list of commands the user have added
     * @param commandArr
     * @param counter
     */
    public static void listCommand (String[] commandArr , int counter, ArrayList<Task> tasks){
        System.out.println("Here are the tasks in your list:");
        for(int i = 0 ; i < counter ; i++){
            System.out.println( (i+1) + ". " + "["+ (tasks).get(i).getStatusIcon() +"] "+commandArr[i]);
        }
        System.out.println("____________________________________________________________");
    }

    /**
     * Test case command
     */
    public static void blahCommand (){
        System.out.println("blah");
        System.out.println("____________________________________________________________");
    }

    /**
     * Print when user choose to exit the program
     */
    public static void byeCommand (){
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
