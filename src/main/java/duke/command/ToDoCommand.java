package duke.command;

import duke.exception.MissingDescriptionException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.Todo;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * Command to add todo duke.task
 */
public class ToDoCommand extends Command {
    /**
     * Constructor for todo duke.task
     *
     * @param command
     */
    public ToDoCommand(String command) {
        this.isExit = false;
        this.command = command;
    }

    /**
     * Add a todo duke.task for user
     * @param tasks
     * @param ui
     * @param storage
     * @throws MissingDescriptionException
     */
    @Override
    public void run(TaskList tasks, Ui ui, Storage storage) throws MissingDescriptionException {
        String commandSplit[] = command.split(" ", 2);

        if (commandSplit.length < 2 || commandSplit[1].isEmpty()) {
            throw new MissingDescriptionException("The description of a todo cannot be empty");
        } else {
            tasks.addTodo(commandSplit[1]);
            storage.save(tasks);
        }
    }

}
