package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.CourseDao;
import peaksoft.entity.Course;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{
    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourses(Long id) {
        return courseDao.getAllCourses(id);
    }

    @Override
    public void saveCourse(Long id, Course course) {
     courseDao.saveCourse(id,course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public void updateCourse(Long id, Course course) {
      courseDao.updateCourse(id, course);
    }

    @Override
    public void deleteCourse(Course course) {
     courseDao.deleteCourse(course);
    }

}
