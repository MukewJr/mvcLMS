package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void saveTask(Long lessonId, Task task) {
       Lesson lesson=manager.find(Lesson.class,lessonId);
       lesson.addTasks(task);
       task.setLessons(lesson);
       manager.persist(task);
    }

    @Override
    public void updateTask(Long id, Task task) {
      Task task1=manager.find(Task.class,id);
      task1.setTaskName(task.getTaskName());
      task1.setTaskText(task.getTaskText());
      task1.setDeadLine(task.getDeadLine());
      manager.merge(task1);
    }

    @Override
    public Task getTaskById(Long id) {
        return manager.find(Task.class,id);
    }

    @Override
    public List<Task> getAllTasks(Long id) {
        return manager.createQuery("select t from Task t where t.lessons.id=:id").
                setParameter("id",id).getResultList();
    }

    @Override
    public void deleteTaskById(Long id) {
    Task task= manager.find(Task.class,id);
    task.setLessons(null);
    manager.remove(task);
    }
}
