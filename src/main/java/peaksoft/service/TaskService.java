package peaksoft.service;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskService {

    void saveTask(Long lessonId, peaksoft.entity.Task task);

    void updateTask(Long id, peaksoft.entity.Task task);

    peaksoft.entity.Task getTaskById(Long id);

    List<Task> getAllTasks(Long id);

    void deleteTaskById(Long id);
}
