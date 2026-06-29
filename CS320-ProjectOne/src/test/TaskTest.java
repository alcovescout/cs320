package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.Task;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    void testTaskClass(){
        Task testTask = new Task("ABC123", "MyTest", "This is a test of my description");
        assertTrue(testTask.getTaskId().equals("ABC123"));
        assertTrue(testTask.getTaskName().equals("MyTest"));
        assertTrue(testTask.getTaskDescription().equals("This is a test of my description"));
    }

    @Test
    void testTaskTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("ABCDEFGIJKLM12345678", "MyTask Name is DUKE 123456789", "My description length is going to be larger than 50 characters");
        });
    }
    @Test
    void testTaskNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, null, null);
        });
    }
}
