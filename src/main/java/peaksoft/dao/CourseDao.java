package peaksoft.dao;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourses(Long id);

    void saveCourse(Long id,Course course);

    Course getCourseById(Long id);

    void updateCourse(Long id,Course course);

    void deleteCourse(Course course);
}
