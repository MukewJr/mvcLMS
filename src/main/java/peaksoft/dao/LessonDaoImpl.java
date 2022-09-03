package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LessonDaoImpl implements LessonDao{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
       Course course=manager.find(Course.class,courseId);
       course.addLessons(lesson);
       lesson.setCourses(course);
       manager.persist(course);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return manager.find(Lesson.class,id);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
     Lesson les=manager.find(Lesson.class,id);
     les.setLessonName(lesson.getLessonName());
     les.setVideo(lesson.getVideo());
     manager.merge(les);
    }

    @Override
    public void deleteLessonById(Long id) {
     Lesson lesson=manager.find(Lesson.class,id);
     lesson.setCourses(null);
     manager.remove(lesson);
    }

    @Override
    public List<Lesson> getAllLessons(Long id) {
        return manager.createQuery("select a from Lesson  a where a.courses.courseId=:id", Lesson.class).
        setParameter("id",id).getResultList();
    }
}
