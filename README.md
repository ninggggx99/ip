# Duke 
Duke is an easy-to-use Command Line Interface (CLI) program that acts like a planner for the users.

## What is Duke?
Duke is a Command Line Interface (CLI) planner that allows user to do the functions mention below:
1. Add task
1. List tasks
1. Delete task
1. Mark task as done
1. Find matching task
    
Tasks have 3 main category, namely Todo, Event and Deadline

Duke commands are simple. You can use Duke on any computers if JDK 11 is installed.

## Syntax Guide
Here's an overview of the syntax of each function

### Add Task
Todo does not require any date input<br />
Event and Deadline require a date input in the format of DD/MM/YYYY HHMM
```
todo TASK_NAME
event TASK_NAME /at TASK_DATE
deadline TASK_NAME /by TASK_DATE
```
### List Tasks
List all tasks
```
list
```
### Delete Tasks
Delete task of specified index
```
delete TASK_INDEX
```
### Mark Task as Done
Mark task as done for specified index
```
done TASK_INDEX
```
### Find Task
Find any task with matching keyword
```
find KEYWORD
```
## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   ```

