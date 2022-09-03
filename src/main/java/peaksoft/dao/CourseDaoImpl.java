package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CourseDaoImpl implements CourseDao{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Course> getAllCourses(Long id) {
        List<Course> courses=manager.createQuery("from Course", Course.class).getResultList();
        return courses;
    }

    @Override
    public void saveCourse(Long id, Course course) {
     manager.persist(course);
    }

    @Override
    public Course getCourseById(long id) {
        return manager.find(Course.class,id);
    }

    @Override
    public void updateCourse(Long id, Course course) {
      manager.merge(course);
    }

    @Override
    public void deleteCourse(Course course) {
        manager.remove(manager.contains(course)?course:manager.merge(course));
    }


//    @Override
//    public List<Course> getAllCourses() {
//        List<Course> courses=manager.createQuery("from Course", Course.class).getResultList();
//        return courses;
//    }
//
//    @Override
//    public void addCourse(Course course) {
//        manager.persist(course);
//
//    }
//
//    @Override
//    public Course getCourseById(long id) {
//        return manager.find(Course.class,id);
//    }
//
//    @Override
//    public void updateCourse(Course course) {
//        manager.merge(course);
//    }
//
//    @Override
//    public void deleteCourse(Course course) {
//        manager.remove(manager.contains(course)?course:manager.merge(course));
//    }
}
