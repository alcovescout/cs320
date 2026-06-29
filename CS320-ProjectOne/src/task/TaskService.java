package task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> taskMap;

    //Constructor
    public TaskService() { this.taskMap = new HashMap<>(); }

    //Getter
    public Task getTask(String taskId){ return taskMap.get(taskId); }

    public void addTask(Task task){
        //Validate if task is not null
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        //Check if taskId exists
        if(taskMap.containsKey(task.getTaskId())){
            throw new IllegalArgumentException("Task already exists with this Id");
        }
        // Add the task into the hash map
        taskMap.put(task.getTaskId(), task);
    }

    //Delete tasks per taskID
    public void removeTask(String taskId){
        if(!taskMap.containsKey(taskId)){
            throw new IllegalArgumentException("Task ID not found, cannot delete.");
        }
        taskMap.remove(taskId);
    }

    //Update task fields per id: Name and Description
    public void updateTaskFields(String taskId, String taskName, String taskDescription){
        Task task = taskMap.get(taskId);
        if(task == null){
            throw new IllegalArgumentException("Task not found");
        }

        task.setTaskName(taskName);
        task.setTaskDescription(taskDescription);
    }

}
