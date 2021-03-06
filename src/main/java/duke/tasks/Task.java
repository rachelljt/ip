package duke.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    protected String taskName;
    protected boolean isDone;
    protected String statusIcon;
    protected String isDoneString;

    /**
     * Initialises a new task.
     *
     * @param taskName Description of task.
     */
    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
        this.statusIcon = "[ ] ";
        this.isDoneString = "0 / ";
    }

    /**
     * Returns the description of the task.
     *
     * @return a String of description of task.
     */
    public String getTaskName() {
        return this.taskName;
    }

    public String getTaskType() {
        return "Task";
    }

    public boolean isEqual(Task task) {
        return this.taskName.equals(task.taskName);
    }

    /**
     * Returns a LocalDateTime object
     *
     * @return a LocalDateTime object
     */
    public LocalDateTime getLocalDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        LocalDateTime dateTime = LocalDateTime.parse("31/12/2030 0000", formatter);
        return dateTime;
    }
    /**
     * Marks the given task as completed.
     */
    public void markAsDone() {
        this.isDone = true;
        this.statusIcon = "[\u2713] ";
        this.isDoneString = "1 / ";

    }

    /**
     * Returns a string of description to be saved in the myDuke.txt.
     *
     * @return A String.
     */
    public String toSave() {
        return this.taskName;
    }

    /**
     * Returns a string of description to be printed out.
     *
     * @return A String.
     */
    public String toString() {
        return statusIcon + this.taskName;
    }
}
