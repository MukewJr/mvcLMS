package peaksoft.dao;

import java.util.List;

public interface TaskDao {

    void saveTask(Long lessonId, peaksoft.entity.Task task);

    void updateTask(Long id, peaksoft.entity.Task task);

    peaksoft.entity.Task getTaskById(Long id);

    List<peaksoft.entity.Task> getAllTasks(Long id);

    void deleteTaskById(Long id);
}
