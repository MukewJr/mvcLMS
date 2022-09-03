package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.TaskDao;
import peaksoft.entity.Task;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public void saveTask(Long lessonId, Task task) {
     taskDao.saveTask(lessonId, task);
    }

    @Override
    public void updateTask(Long id, Task task) {
       taskDao.updateTask(id, task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public List<Task> getAllTasks(Long id) {
        return taskDao.getAllTasks(id);
    }

    @Override
    public void deleteTaskById(Long id) {
    taskDao.deleteTaskById(id);
    }
}
