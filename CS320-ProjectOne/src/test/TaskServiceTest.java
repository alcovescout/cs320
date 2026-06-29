package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.Task;
import task.TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

class TaskServiceTest {
    private TaskService testTaskService;

    @BeforeEach
    void setup(){ testTaskService = new TaskService(); }

    @Test
    void getTask() {
        Task task = new Task("1", "MyTask", "This is a task");

        //Test if it throws an exception
        assertDoesNotThrow(() -> testTaskService.getTask("1"));
    }

    @Test
    void addTask() {
        Task task = new Task("1", "MyTask", "This is a task description");

        //Test if it throws an exception
        assertDoesNotThrow(() -> testTaskService.addTask(task));

        //Validate the Task was added by using the Id
        Task testGetTaskById = testTaskService.getTask("1");

        //Test if Task is empty
        assertNotNull(testGetTaskById, "The task should exist in the TaskService map");

        // Test if taskName Matches
        assertEquals("MyTask", testGetTaskById.getTaskName());

        assertEquals("This is a task description", testGetTaskById.getTaskDescription());
        
        /**************************************************************
         * Add the same task Again
         ************************************************************/
        Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
            testTaskService.addTask(task);
        });

    }
    @Test
    void addNullTask() {
    	Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
            testTaskService.addTask(null);
        });
    }

    @Test
    void removeTask() {
        Task task = new Task("1", "MyTask", "This is a task description");

        //Add the task
        testTaskService.addTask(task);

       //Test removing the task
       assertDoesNotThrow(() -> testTaskService.removeTask("1"));

       //Validate task was removed
        assertEquals(null, testTaskService.getTask("1"));
        
        /**************************************************************
         * Remove non-existant task
         ************************************************************/
    	Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
            testTaskService.removeTask("5");
        });

    }

    @Test
    void updateTaskFields() {
        Task task = new Task("1", "MyTask", "This is a task description");

        testTaskService.addTask(task);

        //Update the task fields using the Unique ID
        assertDoesNotThrow(() -> testTaskService.updateTaskFields("1", "NewTask", "My new description"));

        //Get the new entry
        Task getExistingTask = testTaskService.getTask("1");

        //Test if it is empty
        assertNotNull(getExistingTask, "This task should exists");

        //Test Updated Task name
        assertEquals("NewTask", getExistingTask.getTaskName(), "The new task name should match");

        //Test Updated Description
        assertEquals("My new description", getExistingTask.getTaskDescription(), "The new description should match");
    }
    @Test
    void updateNullTaskFields() {
    	Assertions.assertThrows(IllegalArgumentException.class,	() ->  {
            testTaskService.updateTaskFields(null, null, null);
        });
    }
}