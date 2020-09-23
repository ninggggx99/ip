package duke.storage;

import duke.task.Deadline;
import duke.task.Events;
import duke.task.Task;
import duke.task.Todo;
import duke.tasklist.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * To load and store existing/new tasks
 */
public class Storage {
    private String filepath;

    /**
     * constructor for Storage
     *
     * @param filepath
     */
    public Storage(String filepath) {
        this.filepath = filepath;
    }

    /**
     * load existing task in output file
     *
     * @return tasks
     * @throws FileNotFoundException
     */
    public ArrayList<Task> load() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<Task>();
        try {
            String names[] = filepath.split("\\/");
            File directory = new File(names[0]);
            if (directory.exists()){
                File output = new File(filepath);
                output.createNewFile();
                Scanner read = new Scanner(output);
                while (read.hasNextLine()) {
                    String task = read.nextLine();

                    String description;
                    String descWithDate;
                    String date;

                    boolean done;
                    if (task.charAt(4) == 'Y') {
                        done = true;
                    } else {
                        done = false;
                    }

                    char taskType = task.charAt(1);
                    switch (taskType) {
                        case 'T':
                            description = (task.split(" ", 2))[1];
                            tasks.add(new Todo(description));
                            break;
                        case 'E':
                            descWithDate = (task.split(" ", 2))[1];
                            description = (descWithDate.split("\\(at: "))[0];
                            date = (task.split("at: "))[1];
                            date = date.substring(0, date.length() - 1);
                            tasks.add(new Events(description.strip(), date));
                            break;
                        case 'D':
                            descWithDate = (task.split(" ", 2))[1];
                            description = (descWithDate.split("\\(by: "))[0];
                            date = (task.split("by: "))[1];
                            date = date.substring(0, date.length() - 1);
                            tasks.add(new Deadline(description.strip(), date));
                            break;
                        default:
                            break;
                    }
                    if (done == true){
                        tasks.get(tasks.size()-1).markAsDone();
                    }

                }


            }
            else{
                System.out.println("Making directory");
                directory.mkdir();
                File output = new File(filepath);
                output.createNewFile();

            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    /**
     * save all the tasks
     *
     * @param tasks
     */
    public void save(TaskList tasks) {
        try {
            File output = new File(filepath);
            output.createNewFile();
            FileWriter fileWriter = new FileWriter(filepath);
            for(Task task : tasks.getTaskList()){
                fileWriter.write(task.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
