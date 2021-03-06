package duke.tasks;

import java.util.ArrayList;

import duke.exceptions.DukeException;


public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Initialises a new TaskList.
     *
     * @param tasks List of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Initialises a new TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Returns the Task at the specific index.
     *
     * @param num Integer index.
     * @return Task at specific index.
     */
    public Task getTask(int num) {
        return this.tasks.get(num - 1);
    }

    /**
     * Returns the total number of tasks.
     *
     * @return The total number of tasks.
     */
    public int getNumOfTasks() {
        return this.tasks.size();
    }

    /**
     * Returns a List of tasks.
     *
     * @return A list of tasks.
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Adds toDo to list.
     *
     * @param task task.
     * @throws DukeException if Duplicates are present.
     */
    public void add(Task task) throws DukeException {
        for (Task myTask : tasks) {
            if (myTask.isEqual(task)) {
                throw new DukeException("Duplicates are not allowed!");
            }
        }
        tasks.add(task);
    }

    /**
     * Delete task at specific index.
     *
     * @param num Integer index.
     */
    public void delete(int num) {
        tasks.remove(num - 1);
    }

    /**
     * Mark task as completed.
     *
     * @param num Integer index.
     */
    public void markAsDone(int num) {
        Task task = tasks.get(num - 1);
        assert task != null;
        task.markAsDone();
    }

    /**
     * Returns a list of matching tasks.
     *
     * @param keyword Keyword of the task.
     * @return A lists of matching tasks.
     * @throws DukeException If there are no matching tasks.
     */
    public ArrayList<Task> findMatchingTasks(String keyword) throws DukeException {
        ArrayList<Task> newList = new ArrayList<>();
        boolean hasFoundMatchingTask = false;

        for (Task task : tasks) {
            if (task.getTaskName().contains(keyword)) {
                newList.add(task);
                hasFoundMatchingTask = true;
            }
        }

        if (!hasFoundMatchingTask) {
            throw new DukeException("There are no matching tasks in your list!");
        }

        return newList;
    }
}
