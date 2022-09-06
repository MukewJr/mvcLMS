package peaksoft.service;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses(Long id);

    void saveCourse(Long id,Course course);

    Course getCourseById(Long id);

    void updateCourse(Long id,Course course);

    void deleteCourse(Course course);
}
